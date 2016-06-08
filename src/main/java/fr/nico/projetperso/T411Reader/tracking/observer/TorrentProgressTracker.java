package fr.nico.projetperso.T411Reader.tracking.observer;

import java.util.Observable;
import java.util.Observer;

import com.turn.ttorrent.client.Client;
import com.turn.ttorrent.client.SharedTorrent;

import fr.nico.projetperso.T411Reader.common.util.FormatUtils;
import fr.nico.projetperso.T411Reader.tracking.modele.TorrentTracking;

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
		torrent = map(c.getTorrent());
	}
	

	private static TorrentTracking map(SharedTorrent t){
		TorrentTracking tracking = new TorrentTracking();
		tracking.setComment(t.getComment());
		tracking.setSize(FormatUtils.fileSizeToString(t.getSize()));
		tracking.setLeft(FormatUtils.fileSizeToString(t.getLeft()));
		tracking.setName(t.getName());
		tracking.setFinished(t.isFinished());
		return tracking;
	}
	
	/**
	 * @return
	 */
	public TorrentTracking getTorrent() {
		return torrent;
	}
	

}
