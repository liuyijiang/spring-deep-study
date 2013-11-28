package com.spring.restfull.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

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
					JSONObject obj = JSON.parseObject(value);
					System.out.println(obj);
					JSONArray a = obj.getJSONArray("results");
					String str = a.getJSONObject(0).getString("formatted_address");
//					BaiduMapUtil util = new BaiduMapUtil();
//					String address = util.getBaiduFormattedAddress(value);
//					System.out.println(address);
					System.out.println(1);
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
		t.getDataWithOutParm("http://maps.googleapis.com/maps/api/geocode/json?&language=zh-cn&latlng=30.54066172,104.0695318&sensor=true");
	}
	
}
