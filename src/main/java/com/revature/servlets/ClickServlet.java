package com.revature.servlets;

import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlets.DefaultServlet;

public class ClickServlet extends DefaultServlet {
	
	@Override
	public void init() {
		System.out.println("ClickServlet is initializing");
		System.out.println("Init param of name: " + this.getInitParameter("name"));
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Cookie[] cookies = req.getCookies();
		
		Optional<Cookie> count = cookies == null ? Optional.empty() : Arrays.asList(cookies).stream()
			.filter(c -> c.getName().equals("count"))
			.findFirst();
		
		if(count.isPresent()) {
			// Increment the value and write it to the response
			Cookie countCookie = count.get();
			int value = Integer.parseInt(countCookie.getValue());
			value++;
			resp.addCookie(new Cookie("count", String.valueOf(value)));
			resp.getWriter().write(String.valueOf(value));
			
		} else {
			// Create a new cookie and write 1 
			Cookie cookie = new Cookie("count", "1");
			resp.addCookie(cookie);
			resp.getWriter().write(String.valueOf(1));
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
				throws IOException, ServletException {
		HttpSession session = req.getSession(true);
		Integer count = (Integer) session.getAttribute("count");
		count = count == null ? 0 : count;
		count++;
		session.setAttribute("count", count);
		resp.getWriter().write(String.valueOf(count));	
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) 
				throws IOException, ServletException {
		
		Reader reader = req.getReader();
		char[] buffer = new char[20];
		int read;
		while((read = reader.read(buffer)) != -1) {
			System.out.print(new String(buffer).substring(0, read));
		}
		
	}
	
}
