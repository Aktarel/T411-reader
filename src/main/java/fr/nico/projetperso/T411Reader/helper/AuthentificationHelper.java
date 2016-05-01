package fr.nico.projetperso.T411Reader.helper;

import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.nico.projetperso.T411Reader.model.UserAuthentification;

public class AuthentificationHelper {

	public static void initTokenFromT411(PasswordAuthentication auth) throws Exception{
		URL url = new URL("http://api.t411.ch/auth");
		StringBuilder urlParameters = new StringBuilder()
					.append("username=") 
					.append(auth.getUserName())
					.append("&password=")
					.append(String.valueOf(auth.getPassword()));
		
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		ConnectionUtil util = ConnectionUtil.getInstance();
		String response = util.sendRequest(connection,"POST", urlParameters.toString()).getResponse();
        ObjectMapper o = new ObjectMapper();
        UserAuthentification u = o.readValue(response.toString(), UserAuthentification.class);
		if(u.getToken() == null || u.getToken().isEmpty())
			throw new Exception("Pas de token");
		
		util.setToken(u.getToken());
	}
	
}
