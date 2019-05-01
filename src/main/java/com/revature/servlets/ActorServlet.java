package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Actor;
import com.revature.services.ActorService;

public class ActorServlet extends DefaultServlet {

	ActorService actorService = new ActorService();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// Creating ObjectMapper (Jackson class)
		ObjectMapper om = new ObjectMapper();
		//              Converting JSON string in inputStream to a Java Object
		Actor actor = om.readValue(request.getInputStream(), Actor.class);
		actorService.createActor(actor);
		//Converting Java object to JSON string
		om.writeValue(response.getOutputStream(), actor);
	}
}
