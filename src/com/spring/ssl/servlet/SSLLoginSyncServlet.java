package com.spring.ssl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SSLLoginSyncServlet
 */
@WebServlet("/SSLLoginSyncServlet")
public class SSLLoginSyncServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SSLLoginSyncServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("name");
		String psw = request.getParameter("psw");
		System.out.println(str + "*****" + psw);
		//response.sendRedirect("/ssllogin/ok.jsp");  一般方式
		//ajax 方式
		System.out.println("get");
		response.setContentType("text/plain");// 1.设置返回响应的类型
		//2. 01 一定要注意：要包括jsoncallback参数，不然回调函数不执行。
		//2. 02 返回的数据一定要是严格符合json格式 ，不然回调函数不执行。
		response.getWriter().write( request.getParameter("jsoncallback") + "({isAuth:'"+str+"',psw:'"+psw+"',resetnum:'"+200+"'})" );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
