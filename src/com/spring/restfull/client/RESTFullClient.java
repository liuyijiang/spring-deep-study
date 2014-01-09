package com.spring.restfull.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.restfull.service.request.ResendRequest;

public class RESTFullClient {

	public void getData(){
		GetMethodAction get = new GetMethodAction();
		get.getDataWithOutParm("http://localhost:8080/springdeepstudy/getData");
		
		PostMethodAction post = new PostMethodAction();
		ResendRequest req = new ResendRequest();
		req.setEndTime("2012-12-12");
		req.setStartTime("2013-21-22");
		req.setType(22);
		post.getDataWithParm("http://localhost:8080/springdeepstudy/getDataParm", req);
//		
//		PutMethodAction put = new PutMethodAction();
//		put.putDataWithParm("http://localhost:8080/springdeepstudy/putDataParm", req);
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		//spring 集成
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-httpclient.xml");
//		HttpClient httpclient = (HttpClient)ctx.getBean("httpclient");
//		RESTFullClient rest = new RESTFullClient();
//		long startTime=System.currentTimeMillis();   //获取开始时间  
//		for(int i=0;i<3000;i++){
//			rest.test1(httpclient);
//		}
//		long endTime=System.currentTimeMillis(); //获取结束时间  
//		System.out.println("程序运行时间： "+(endTime - startTime)+"ns");  
//		long startTime2=System.currentTimeMillis();   //获取开始时间  
//		for(int i=0;i<3000;i++){
//			rest.test2();
//		}
//		long endTime2=System.currentTimeMillis(); //获取结束时间  
//		System.out.println("程序运行时间： "+(endTime2 - startTime2)+"ns");  
		RESTFullClient rest = new RESTFullClient();
	    rest.getData();
	}
   
	public void test1(HttpClient httpclient){
		try {
			HttpGet httpget = new HttpGet("http://localhost:8080/springdeepstudy/getData");
			HttpResponse response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				//System.out.println(EntityUtils.toString(entity));
			}
			httpget.abort();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//httpclient.getConnectionManager().shutdown();
		}
	}
	
	public void test2(){
		HttpClient httpclient = new DefaultHttpClient();
		try {
			HttpGet httpget = new HttpGet("http://localhost:8080/springdeepstudy/getData");
			HttpResponse response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				//System.out.println(EntityUtils.toString(entity));
			}
			httpget.abort();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
	}
}
