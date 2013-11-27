package com.spring.restfull.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.spring.restfull.client.baidumap.BaiduMapUtil;

public class TestMap {
  
	private HttpClient httpclient = new DefaultHttpClient();

	public void getDataWithOutParm(String url) {
		try {
			HttpGet httpget = new HttpGet(url);
			System.out.println("executing request " + httpget.getURI() + "");
			HttpResponse response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String value = EntityUtils.toString(entity);
				System.out.println(value);
				if(value != null){
					BaiduMapUtil util = new BaiduMapUtil();
					String address = util.getBaiduFormattedAddress(value);
					System.out.println(address);
				}
			}
			httpget.abort();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
	}
	
	public static void main(String[] args) {
		TestMap t = new TestMap();
		t.getDataWithOutParm("http://api.map.baidu.com/geocoder/v2/?ak=25b649ac2a75ac31477bfe806d4912e1&callback=renderReverse&location=38.983424,96.322987&output=json&pois=0");
	}
	
}
