package fr.nico.projetperso.T411Reader.observer;

import java.util.Observable;
import java.util.Observer;

import com.turn.ttorrent.client.Client;
import com.turn.ttorrent.common.Torrent;

import fr.nico.projetperso.T411Reader.model.TorrentTracking;
import fr.nico.projetperso.T411Reader.util.TorrentTools;

/**
 * @author Akta
 *
 */
public class TorrentProgressTracker implements Observer {

	private TorrentTracking torrent;
	
	/**
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(Observable o, Object data) {
		Client c = (Client) o;
		torrent = TorrentTools.map(c.getTorrent());
	}
	
	/**
	 * @return
	 */
	public TorrentTracking getTorrent() {
		return torrent;
	}
	

}
