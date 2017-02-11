package com.yl.servlet;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yl.biz.ClientBiz;
import com.yl.biz.impl.ClientBizImpl;
import com.yl.entity.Client;

public class DoClientAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientBiz biz = new ClientBizImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String clientComp = request.getParameter("clientComp");
		String clientName = request.getParameter("clientName");
		String clientPhone = request.getParameter("clientPhone");
		String clientAdd = request.getParameter("clientAdd");
		String clientBack = request.getParameter("clientBack");
		Date clientDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		try {
			clientDate = sdf.parse(sdf.format(clientDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Client client = new Client(0, clientName, clientComp, clientPhone, clientAdd, clientBack, clientDate);
		int row = biz.save(client);
		if (row > 0) {
			response.getWriter().print("<script>alert('Ìí¼Ó³É¹¦ £¡');window.location.href='ClientServlet';</script>");
		}
	}

}
