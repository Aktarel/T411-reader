package fr.nico.projetperso.T411Reader.common.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.turn.ttorrent.client.SharedTorrent;

import fr.nico.projetperso.T411Reader.tracking.modele.TorrentTracking;

public class FormatUtils {
	
	public static String fileSizeToString(long octetSize){
		StringBuilder s = new StringBuilder();
		double bytes = octetSize;
		double kilobytes = (bytes / 1024);
		double megabytes = (kilobytes / 1024);
		double gigabytes = (megabytes / 1024);
		
		if(bytes > 1000000000){
			s.append(new BigDecimal(gigabytes).setScale(2, RoundingMode.FLOOR));
			s.append("GO");
		}
		else if(bytes > 1000000){
			s.append(new BigDecimal(megabytes).setScale(1, RoundingMode.FLOOR));
			s.append("MO");
		}
		else if(bytes > 1000){
			s.append(new BigDecimal(kilobytes).setScale(1, RoundingMode.FLOOR));
			s.append("KO");
		}
		return s.toString();
	}
	
}
