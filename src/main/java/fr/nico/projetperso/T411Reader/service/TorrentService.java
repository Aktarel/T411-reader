package fr.nico.projetperso.T411Reader.service;

import java.io.IOException;
import java.net.PasswordAuthentication;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.nico.projetperso.T411Reader.helper.AuthentificationHelper;
import fr.nico.projetperso.T411Reader.helper.URLHelper;
import fr.nico.projetperso.T411Reader.manager.TorrentTrackerManager;
import fr.nico.projetperso.T411Reader.model.ListeTorrent;
import fr.nico.projetperso.T411Reader.util.ConnectionUtil;

/**
 * Torrent service layer
 * @author Akta
 * @date 22/05/2016
 * @version 0.1
 */
@Service
public class TorrentService {

	@Value("${t411.username}")
	private String username;

	@Value("${t411.password}")
	private char[] password;

	@Value("${torrent.file.folder}")
	private String TORRENT_FILE_FOLDER;

	@Value("${torrent.finished.folder}")
	private String TORRENT_FINISHED_FOLDER;
	
	@Autowired
	private TorrentClient client;
	
	/**
	 * Template
	 */
	private RestOperations restTemplate;
	

	/**
	 * Constructuer
	 */
	public TorrentService() {
		restTemplate = new RestTemplate();
	
	}
	
	public void download(String idTorrent) throws IOException {
	
		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<Void> httpStatus = new ResponseEntity<Void>(HttpStatus.OK);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
		HttpEntity entity = null;
		try {
			entity = authAndPrepareHeaders(headers);
		} catch (AuthenticationException e) {
			throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
		}

		ResponseEntity<byte[]> t = restTemplate.exchange(URLHelper.constructDownloadUrl(idTorrent), HttpMethod.GET, entity,
				byte[].class);

		// T411 ne gère pas les code retour 4xx
		// Hack pour déterminer que le body ne contient pas de fichier
		boolean isNotFound = t.getBody().length < 150;
		try {
			if (!isNotFound){
				Files.write(Paths.get(TORRENT_FILE_FOLDER + "/" + idTorrent + ".torrent"), t.getBody());
				client.download(idTorrent);
			}
			else{
				throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
			}
		} catch (IOException e) {
			throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NoSuchAlgorithmException e) {
			throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * @param keyword
	 * @param limit
	 * @return ListeTorrent : torrent list
	 * @throws IOException
	 */
	public ListeTorrent list(String keyword, String limit) throws IOException{
		HttpEntity entity = null;
		ResponseEntity httpStatus = new ResponseEntity<Void>(HttpStatus.OK);
		try {
			entity = authAndPrepareHeaders(new HttpHeaders());
		} catch (AuthenticationException e) {
			throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
		}
		ResponseEntity<String> t = restTemplate.exchange(URLHelper.constructSearchListUrl(keyword, limit),
				HttpMethod.GET, entity, String.class);
		ObjectMapper o = new ObjectMapper();
		ListeTorrent l = o.readValue(t.getBody(), ListeTorrent.class);
		return l;
	}
	
	/**
	 * auth get token and add header Authorization with t411 token
	 * @param headers
	 * @return
	 * @throws IOException
	 */
	private HttpEntity<String> authAndPrepareHeaders(HttpHeaders headers) throws IOException  {
		AuthentificationHelper.initTokenFromT411(new PasswordAuthentication(username, password));
		headers.set("Authorization", ConnectionUtil.getInstance().getToken());
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return new HttpEntity<String>("parameters", headers);
	}
}
