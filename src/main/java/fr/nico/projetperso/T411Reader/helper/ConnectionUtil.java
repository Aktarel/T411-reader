package fr.nico.projetperso.T411Reader.helper;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;

public class ConnectionUtil {

	private String token;

	private static ConnectionUtil instance;
	
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public static ConnectionUtil getInstance(String token) {
		if (instance == null) {
			instance = new ConnectionUtil(token);
		}
		return instance;

	}

	public static ConnectionUtil getInstance() {
		if (instance == null) {
			instance = new ConnectionUtil();
		}

		return instance;
	}

	private ConnectionUtil(String token) {
		this.token = token;
	}

	private ConnectionUtil() {
	}

	public StringBuilder sendRequest(HttpURLConnection connection, String method, String urlParameters) throws IOException {
		connection.setRequestMethod(method);
		if (token != null && !token.isEmpty()) {
			connection.setRequestProperty("Authorization", token);
		}

		connection.setRequestProperty("Content-Language", "en-US");
		connection.setUseCaches(false);
		connection.setDoOutput(true);
		connection.setRequestProperty("Content-Length", Integer.toString(urlParameters.getBytes().length));
		try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
			wr.writeBytes(urlParameters);
		}

		return getResponse(connection);
	}

	/**
	 * @param connection
	 * @return
	 * @throws IOException
	 */
	private StringBuilder getResponse(HttpURLConnection connection) throws IOException {
		InputStream is = connection.getInputStream();
		StringBuilder response;
		try (BufferedReader rd = new BufferedReader(new InputStreamReader(is))) {
			response = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
		}
		return response;
	}
}
