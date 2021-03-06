package com.yl.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Controller implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
		FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;//如果处理HTTP请求，并且需要访问诸如getHeader或getCookies等在ServletRequest中无法得到的方法，就要把此request对象构造成HttpServletRequest
		HttpServletResponse response = (HttpServletResponse)arg1;
		String currentURL = request.getRequestURI();//取得根目录所对应的绝对路径:
		String targetURL = currentURL.substring(currentURL.indexOf("/", 1), currentURL.length());  //截取到当前文件名用于比较
		HttpSession session = request.getSession();
		String empName = (String) session.getAttribute("empName");
		if (!"/login.jsp".equals(targetURL) && empName == null) {//判断当前页是否是重定向以后的登录页面页面，如果是就不做session的判断，防止出现死循环
			response.sendRedirect(request.getContextPath() + "/login.jsp");//如果session为空表示用户没有登录就重定向到login.jsp页面
		}
		//加入filter链继续向下执行
		chain.doFilter(request, response);//.调用FilterChain对象的doFilter方法。Filter接口的doFilter方法取一个FilterChain对象作为它的一个参数。在调用此对象的doFilter方法时，激活下一个相关的过滤器。如果没有另一个过滤器与servlet或JSP页面关联，则servlet或JSP页面被激活。
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
