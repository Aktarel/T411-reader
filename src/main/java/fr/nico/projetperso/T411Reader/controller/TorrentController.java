package fr.nico.projetperso.T411Reader.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.nico.projetperso.T411Reader.manager.TorrentTrackerManager;
import fr.nico.projetperso.T411Reader.model.TorrentTracking;

@RestController
public class TorrentController {

	@Autowired
	public TorrentTrackerManager manager;
	
	@RequestMapping(value = "/torrents/track", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TorrentTracking>> trackProgress()
			throws  IOException {
		return new ResponseEntity<>(manager.status(), HttpStatus.OK);
	}
	
}
