package fr.nico.projetperso.T411Reader.helper;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;

import fr.nico.projetperso.T411Reader.service.ResponseService;

public class ConnectionUtil {

	private String token;

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	private static ConnectionUtil instance;
	
	public static ConnectionUtil getInstance(String token){
		if(instance == null){
			instance = new ConnectionUtil(token);
		}
		return instance;
		
	}
	public static ConnectionUtil getInstance(){
		if(instance == null){
			instance = new ConnectionUtil();
		}
		
		return instance;
	}
	
	private ConnectionUtil(String token) {
		this.token = token;
	}
	private ConnectionUtil() {
	}
	
	public ResponseService sendRequest(HttpURLConnection connection, String method, String urlParameters) throws Exception{
			connection.setRequestMethod(method);
		    connection.setRequestProperty("Content-Type", 
		        "application/x-www-form-urlencoded");
		    if(token != null && !token.isEmpty()){
		    	connection.setRequestProperty("Authorization", token);
		    }
		    
		    connection.setRequestProperty("Content-Language", "en-US");  
		    connection.setUseCaches(false);
		    connection.setDoOutput(true);
		    if("POST".equals(method)){
		    connection.setRequestProperty("Content-Length", 
		    		Integer.toString(urlParameters.getBytes().length));
		    	DataOutputStream wr = new DataOutputStream (
		            connection.getOutputStream());
		    	wr.writeBytes(urlParameters);
		    	wr.close();
		    }
		   
     return new ResponseService(connection);
	}
}
