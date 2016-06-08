package fr.nico.projetperso.T411Reader.common.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.nico.projetperso.T411Reader.t411.model.UserAuthentification;

public class AuthentificationHelper {

	@Autowired
	public static ObjectMapper objectMapper;
	
	/**
	 * @param auth
	 * @throws IOException 
	 * @throws Exception
	 */
	public static void initTokenFromT411(PasswordAuthentication auth) throws IOException {
		URL url = new URL("http://api.t411.ch/auth");
		StringBuilder urlParameters = new StringBuilder()
					.append("username=") 
					.append(auth.getUserName())
					.append("&password=")
					.append(String.valueOf(auth.getPassword()));
		
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		ConnectionHelper util = ConnectionHelper.getInstance();
		String response = util.sendRequest(connection,"POST", urlParameters.toString()).toString();
        UserAuthentification u = objectMapper.readValue(response.toString(), UserAuthentification.class);
		if(u.getToken() == null || u.getToken().isEmpty())
			throw new AuthenticationException("Pas de token");
		
		util.setToken(u.getToken());
	}
	
}
