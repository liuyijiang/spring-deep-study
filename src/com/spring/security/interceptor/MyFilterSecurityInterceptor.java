package com.spring.security.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

public class MyFilterSecurityInterceptor extends AbstractSecurityInterceptor
		implements Filter {

	private FilterInvocationSecurityMetadataSource securityMetadataSource;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println(11111);
		 FilterInvocation fi = new FilterInvocation(request, response, chain);
	        invoke(fi);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public Class<?> getSecureObjectClass() {
		// TODO Auto-generated method stub
		return FilterInvocation.class;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		// TODO Auto-generated method stub
		return this.securityMetadataSource;
	}

	public void invoke(FilterInvocation fi) throws IOException,
			ServletException {
		InterceptorStatusToken token = super.beforeInvocation(fi);
		try {
			fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
		} finally {
			super.afterInvocation(token, null);
		}
	}

}
