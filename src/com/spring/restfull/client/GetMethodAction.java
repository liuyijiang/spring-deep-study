package com.spring.restfull.client;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
/**
 * 
 * @author Administrator
 *
 */
public class GetMethodAction {
    
	private HttpClient httpclient = new DefaultHttpClient();

	public void getDataWithOutParm(String url) {
		try {
			HttpGet httpget = new HttpGet(url);
			System.out.println("executing request " + httpget.getURI() + "");
			HttpResponse response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				System.out.println(EntityUtils.toString(entity));
			}
			httpget.abort();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
	}
	

}
