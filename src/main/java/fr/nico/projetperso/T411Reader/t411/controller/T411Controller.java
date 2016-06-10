package fr.nico.projetperso.T411Reader.t411.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.nico.projetperso.T411Reader.t411.model.ListeTorrent;
import fr.nico.projetperso.T411Reader.t411.services.impl.T411TorrentService;

@RestController
@RequestMapping("/t411")
public class T411Controller {

	@Autowired
	private T411TorrentService services;
	
	@RequestMapping(value = "/torrent/{limit}/{motClef}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ListeTorrent> list(@PathVariable String motClef, @PathVariable String limit)
			throws  IOException {
		ListeTorrent l = services.list(motClef, limit);
		return new ResponseEntity<>(l, HttpStatus.OK);
	}

	@RequestMapping(value = "/torrent/download/{id}", method = RequestMethod.POST)
	public ResponseEntity<Void> download(@PathVariable String id) throws IOException {
		services.download(id);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}


}
