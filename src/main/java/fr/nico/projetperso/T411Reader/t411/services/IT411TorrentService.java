package fr.nico.projetperso.T411Reader.t411.services;

import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import fr.nico.projetperso.T411Reader.t411.model.ListeTorrent;

public interface IT411TorrentService {
	public HttpEntity<String>  authAndPrepareHeaders(HttpHeaders http) throws IOException;
	public void download(String id) throws IOException;
	public ListeTorrent list(String keyword, String limit)throws IOException;
}
