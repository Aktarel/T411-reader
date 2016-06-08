package fr.nico.projetperso.T411Reader.tracking.modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import fr.nico.projetperso.T411Reader.tracking.observer.TorrentProgressTracker;

/**
 * @author Akta
 *
 */
@Component
public class TorrentTrackerManager {

	private List<Observer> obs ;
	
	@PostConstruct
	private void init(){
		obs = new ArrayList<>();
	}
	
	/**
	 * @param o
	 */
	public void addObserver(Observer o){
		obs.add(o);
	}
	
	/**
	 * @return list torrent
	 */
	public List<TorrentTracking> status(){
		List<TorrentTracking> list = new ArrayList<TorrentTracking>();
		for(Observer o : obs){
			TorrentProgressTracker tracker = (TorrentProgressTracker) o;
			list.add(tracker.getTorrent());
		}
		return list;
	}
}
