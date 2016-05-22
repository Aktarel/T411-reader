package fr.nico.projetperso.T411Reader.service;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.util.Observable;
import java.util.Observer;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.turn.ttorrent.client.Client;
import com.turn.ttorrent.client.SharedTorrent;
import com.turn.ttorrent.tracker.TrackedTorrent;
import com.turn.ttorrent.tracker.Tracker;

import fr.nico.projetperso.T411Reader.manager.TorrentTrackerManager;
import fr.nico.projetperso.T411Reader.observer.TorrentProgressTracker;

@Component
public class TorrentClient {

	@Autowired
	private TorrentTrackerManager manager;

	@Value("${torrent.file.folder}")
	private String TORRENT_FILE_FOLDER;

	@Value("${torrent.finished.folder}")
	private String TORRENT_FINISHED_FOLDER;
	
	/**
	 * @param idTorrent
	 * @throws UnknownHostException
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	public void download(String idTorrent) throws UnknownHostException, NoSuchAlgorithmException, IOException{
		Client client = new Client(
			  InetAddress.getLocalHost(),
			  SharedTorrent.fromFile(
			    new File(TORRENT_FILE_FOLDER + "/" + idTorrent + ".torrent"),
			    new File(TORRENT_FINISHED_FOLDER)));
		
		Observer progressTorrentTracker = new TorrentProgressTracker();
		manager.addObserver(progressTorrentTracker);
		client.addObserver(progressTorrentTracker);
		client.download();
		
	}
	
}
