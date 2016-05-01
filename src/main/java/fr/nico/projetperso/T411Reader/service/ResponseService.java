package fr.nico.projetperso.T411Reader.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class ResponseService {

	private StringBuilder response;

	public ResponseService(HttpURLConnection connection) throws IOException {
		  //Get Response  
        InputStream is = connection.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        response = new StringBuilder();
        String line;
        while((line = rd.readLine()) != null) {
          response.append(line);
          response.append('\r');
        }
        rd.close();
	}
	
	public String getResponse(){
		return this.response.toString();
	}
	
}
