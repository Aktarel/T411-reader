package fr.nico.projetperso.T411Reader.util;

import com.turn.ttorrent.common.Torrent;

import fr.nico.projetperso.T411Reader.model.TorrentTracking;

public class TorrentTools {

	public static TorrentTracking map(Torrent t){
		TorrentTracking tracking = new TorrentTracking();
		tracking.setComment(t.getComment());
		tracking.setCreatedBy(t.getCreatedBy());
		tracking.setSize(t.getSize());
		return tracking;
	}
	
}
