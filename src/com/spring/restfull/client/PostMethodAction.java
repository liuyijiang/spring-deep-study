package com.spring.restfull.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.spring.restfull.service.request.ResendRequest;
import com.spring.restfull.service.vo.UserVO;

public class PostMethodAction {

	private HttpClient httpclient = new DefaultHttpClient();
	
	//fastjosn
	public void getDataWithParm(String url,ResendRequest req) {
		try {
			//JSONObject jb = JSONObject.fromObject(req);
			String str = JSON.toJSONString(req);
			StringEntity s = new StringEntity(str);
			s.setContentEncoding("UTF-8");
			s.setContentType("application/json");
			HttpPost httppost = new HttpPost(url);
			httppost.setEntity(s);
			System.out.println("executing request " + httppost.getURI() + " with parm");
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String text = EntityUtils.toString(entity);
				UserVO vo = (UserVO)JSON.parseObject(text, UserVO.class);
				System.out.println(vo.getId()+"**"+vo.getName());
			}
			httppost.abort();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
	}
	
}
