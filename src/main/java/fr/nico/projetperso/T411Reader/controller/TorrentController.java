package fr.nico.projetperso.T411Reader.controller;

import java.net.PasswordAuthentication;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.nico.projetperso.T411Reader.helper.AuthentificationHelper;
import fr.nico.projetperso.T411Reader.helper.ConnectionUtil;
import fr.nico.projetperso.T411Reader.helper.URLHelper;
import fr.nico.projetperso.T411Reader.model.ListeTorrent;

@RestController
public class TorrentController {

	private RestOperations restTemplate;
	
	@Value("${t411.username}")
	private String username;
	
	@Value("${t411.password}")
	private char[] password;

	@Value("${torrent.downloaded.folder}")
	private String TORRENT_FOLDER;
	
	public TorrentController() throws Exception {
    	this.restTemplate = new RestTemplate();
	}
	
	
	@RequestMapping(value="/torrent/{limit}/{motClef}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ListeTorrent> list(@PathVariable String motClef, @PathVariable String limit) throws Exception{
		HttpEntity entity = authenticate(new HttpHeaders());
		ResponseEntity<String> t =  restTemplate.exchange(URLHelper.constructSearchListUrl(motClef, limit),HttpMethod.GET, entity, String.class);
		ObjectMapper o = new ObjectMapper();
		ListeTorrent l = o.readValue(t.getBody(),ListeTorrent.class);
		return new ResponseEntity<>(l,HttpStatus.OK);
	}

	@RequestMapping(value="/torrent/download/{id}",method=RequestMethod.GET)
	public ResponseEntity download(@PathVariable String id) throws Exception{
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
		HttpEntity entity = authenticate(headers);
		ResponseEntity<byte[]> t =  restTemplate.exchange(URLHelper.constructDownloadUrl(id),HttpMethod.GET, entity, byte[].class);
	    Files.write(Paths.get( TORRENT_FOLDER + "/" + id + ".torrent" ), t.getBody() );
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	private HttpEntity<String> authenticate(HttpHeaders headers) throws Exception{
		AuthentificationHelper.initTokenFromT411(new PasswordAuthentication(username, password));
		headers.set("Authorization",ConnectionUtil.getInstance().getToken());
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return new HttpEntity<String>("parameters", headers);
	}

	
}
