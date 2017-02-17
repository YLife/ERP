package com.yl.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		//����ͼ��
    	int width = 200;
    	int height = 60;
    	BufferedImage img = new BufferedImage(width, height,
    			BufferedImage.TYPE_INT_RGB);
    	int r, g, b, x, y;
    	//����
    	Graphics gic = img.getGraphics();
    	//�����α���
    	r = (int) (Math.random() * 256);
    	g = (int) (Math.random() * 256);
    	b = (int) (Math.random() * 256);
    	gic.setColor(new Color(r, g, b));
    	gic.fillRect(0, 0, width, height);
    	//��500�����ŵ�
    	for (int i = 0; i < 500; i++) {
    		r = (int) (Math.random() * 256);
    		g = (int) (Math.random() * 256);
    		b = (int) (Math.random() * 256);
    		x = (int) (Math.random() * width);
    		y = (int) (Math.random() * height);
    		gic.setColor(new Color(r, g, b));
    		gic.fillRect(x, y, 2, 2);
    	}
    	//д��
    	String strings = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    	String code = "";
    	for (int i = 0; i < 4; i++) {
    		int num = (int) (Math.random() * strings.length());
    		code += strings.charAt(num);
    	}
   		r = (int) (Math.random() * 256);
   		g = (int) (Math.random() * 256);
   		b = (int) (Math.random() * 256);
   		gic.setColor(new Color(r, g, b));
   		gic.setFont(new Font("Arial", Font.BOLD, 40));
   		gic.drawString(code, 50, 45);
    	//ʹ��session��ס�ַ�
    	session.setAttribute("code", code);
    	//�ͷ���Դ
    	gic.dispose();
    	//����ͼ��
    	ImageIO.write(img, "jpg", response.getOutputStream());
	}

}
