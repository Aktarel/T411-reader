package fr.nico.projetperso.T411Reader.controller;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.nico.projetperso.T411Reader.helper.AuthentificationHelper;
import fr.nico.projetperso.T411Reader.helper.ConnectionUtil;
import fr.nico.projetperso.T411Reader.model.ListeTorrent;
import fr.nico.projetperso.T411Reader.service.ResponseService;

@RestController
public class TorrentController {

	@Value("${t411.username}")
	private String username;
	
	@Value("${t411.password}")
	private char[] password;
	
	@RequestMapping(value="/torrent/{limit}/{motClef}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ListeTorrent> list(@PathVariable String motClef, @PathVariable String limit) throws Exception{
		AuthentificationHelper.initTokenFromT411(new PasswordAuthentication(username, password)); 
		ResponseService s = ConnectionUtil.getInstance().sendRequest(
					(HttpURLConnection)new URL(constructURL(motClef,limit)).openConnection(),"GET","");
		ObjectMapper m = new ObjectMapper();
		ListeTorrent l = m.readValue(s.getResponse(),ListeTorrent.class);
		ResponseEntity<ListeTorrent> t = new ResponseEntity<ListeTorrent>(l, HttpStatus.OK);
		return t;
	}

	/**
	 * @param motClef
	 * @returns
	 * @throws UnsupportedEncodingException 
	 */
	private String constructURL(String motClef, String limit) throws UnsupportedEncodingException {

		StringBuilder sb = new StringBuilder("http://api.t411.ch/torrents/search/")
				.append(URLEncoder.encode(motClef, "UTF-8"))
				.append("?limit=")
				.append(limit);
		return sb.toString();
	}
}
