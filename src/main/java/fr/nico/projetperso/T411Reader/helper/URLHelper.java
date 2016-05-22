package fr.nico.projetperso.T411Reader.helper;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Value;

public class URLHelper {

	private static String BASED_URL = "http://api.t411.ch/torrents/";
	
	/**
	 * @param keyword
	 * @returns full constructed url
	 */
	public static String constructSearchListUrl(String keyword, String limit)  {

		StringBuilder sb = null;
		try {
			sb = new StringBuilder(BASED_URL)
					.append("search/")
					.append(URLEncoder.encode(keyword, "UTF-8"))
					.append("?limit=")
					.append(limit);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	/**
	 * @param idTorrent
	 * @returns full constructed url
	 */
	public static String constructDownloadUrl(String idTorrent)  {
		StringBuilder sb = new StringBuilder(BASED_URL)
				.append("download/")
				.append(idTorrent);
		return sb.toString();
	}
	
}
