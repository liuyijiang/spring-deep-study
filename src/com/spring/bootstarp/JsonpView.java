package com.spring.bootstarp;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import com.alibaba.fastjson.JSON;

public class JsonpView  extends AbstractView {

	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
			//将model中的数据转换为JSON格式
			//得到JSONP的callback函数名称
			String callback = request.getParameter("callback");
			//将数据填充到callback，并回调
			StringBuffer buf = new StringBuffer();
			buf.append(callback);
			buf.append("(");
			buf.append(JSON.toJSON(model).toString());
			buf.append(");");
			response.setContentType("text/plain; charset=UTF-8");
			response.getOutputStream().write(buf.toString().getBytes());
			response.getOutputStream().flush();
			}
	
}
