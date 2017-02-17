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
		HttpServletRequest request = (HttpServletRequest)arg0;//�������HTTP���󣬲�����Ҫ��������getHeader��getCookies����ServletRequest���޷��õ��ķ�������Ҫ�Ѵ�request�������HttpServletRequest
		HttpServletResponse response = (HttpServletResponse)arg1;
		String currentURL = request.getRequestURI();//ȡ�ø�Ŀ¼����Ӧ�ľ���·��:
		String targetURL = currentURL.substring(currentURL.indexOf("/", 1), currentURL.length());  //��ȡ����ǰ�ļ������ڱȽ�
		HttpSession session = request.getSession();
		String empName = (String) session.getAttribute("empName");
		if (!"/login.jsp".equals(targetURL) && empName == null) {//�жϵ�ǰҳ�Ƿ����ض����Ժ�ĵ�¼ҳ��ҳ�棬����ǾͲ���session���жϣ���ֹ������ѭ��
			response.sendRedirect(request.getContextPath() + "/login.jsp");//���sessionΪ�ձ�ʾ�û�û�е�¼���ض���login.jspҳ��
		}
		//����filter����������ִ��
		chain.doFilter(request, response);//.����FilterChain�����doFilter������Filter�ӿڵ�doFilter����ȡһ��FilterChain������Ϊ����һ���������ڵ��ô˶����doFilter����ʱ��������һ����صĹ����������û����һ����������servlet��JSPҳ���������servlet��JSPҳ�汻���
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
