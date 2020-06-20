package com.qa.client;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {

	
	public void get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient =     HttpClients.createDefault(); //http get request connection
		HttpGet httpget = new HttpGet(url); //http get request connection
		CloseableHttpResponse closeablehttpresponse =   httpClient.execute(httpget); //hit the GET url and get response
		int statuscode =    closeablehttpresponse.getStatusLine().getStatusCode(); //get status code
		System.out.println("Status Code : " +statuscode ); //print the status code
		
		String responseString =   EntityUtils.toString(closeablehttpresponse.getEntity(), "UTF-8");  //json response
		JSONObject responseJson = new JSONObject(responseString);
		 System.out.println("Response JSON : " +responseJson );
	
	}
	
}
