package com.http;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;

/**
 * 使用httpclent下载音乐文件
 */
public class TestDownload {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public static void main(String[] args) throws ClientProtocolException, IOException {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		httpclient.getParams()
			.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 30 * 1000)
			.setParameter(CoreConnectionPNames.SO_TIMEOUT, 10 * 60 * 1000);
		HttpGet httpget = new HttpGet("http://zhangmenshiting.baidu.com/data2/music/57130474/73007331387137661320.mp3?xcode=af3c0c2801bbd6971ac1521da990c7db63b36c39b34dad89");

		
//		for (Entry<String, String> entry : head.entrySet()) {
//			httpget.addHeader(entry.getKey(), entry.getValue());
//		}
	    HttpResponse response = httpclient.execute(httpget);
	    HttpEntity entity = response.getEntity();
	    long contentLength = entity.getContentLength();
		System.out.println("length: {} type: {}"+contentLength+ entity.getContentType());
	    InputStream in = entity.getContent();
	    //new File("D:\\httpdowmload").mkdirs();
	    OutputStream out = new FileOutputStream("D:\\httpbaidu\\t2t.mp3");
	    byte[] bs = new byte[5 * 1024];
	    int len = 0;  
	    int total = 0;
	    int lastShowLen = -10000000;
	    try {
			while ((len = in.read(bs)) != -1) {  
				out.write(bs, 0, len);
				total += len;
				if (total - lastShowLen > 1024 * 1024) {
					lastShowLen = total;
					System.out.println("#downloading 正在下载 {}k {} "+(total / 1024));
				}
			}
		} finally {
			out.close();
		}
	    if (total != contentLength) {
	    	System.out.println("error");
	    }
	   System.out.println(total);

	}

}
