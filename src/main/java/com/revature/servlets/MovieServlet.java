package com.revature.servlets;

import java.io.IOException;
import java.time.Duration;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import com.revature.beans.Movie;
import com.revature.services.MovieService;

/*
 * Servlet Inheritance Hierarchy
 *--------------------------------
 *	Servlet (Interface)
 *	GenericServlet (Used for general network communication)
 *	HttpServlet (Used for general HTTP communication)
 *	DefaultServlet (Tomcat implementation of HttpServlet)
 */

/* What is a lifecycle?
 * ----------------------
 * Is generally a set of methods or functions that define important stages in
 * some components lifecycle, that we can generally override to insert our own
 * functionality during these stages.
 */

/* Servlet Lifecycle
 * -------------------------------
 * 1. init - Is called when the servlet is initialized. By default, this is when
 * 			first request is sent to this servlet. It is called only once.
 * 2. service - Is called once for every request routed to this servlet, allowing it to handle
 * 			the response.
 * 3. destroy - Is called when the container is shutting down or the servlet has expired in some way.
 * 			It is called only once.
 */

/*
 * Init
 * There are two init methods, one with no parameters and one with a ServletConfig parameter.
 * The ServletConfig init is called first, and used to configure the servlet based on configuration
 * largely provided in the web.xml document. It then calls the no-param init method, which is where
 * we would inject our own functionality.
 */

public class MovieServlet extends DefaultServlet {

	MovieService movieService = new MovieService();
	
//	
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		System.out.println("MovieServlet is initializing with ServletConfig");
//		super.init(config);
//	}

	@Override
	public void init() {
		System.out.println("MovieServlet is initializing");
	}

	/*
	 * Lifecycle method called everytime a request is routed to this servlet.
	 * Responsible for handling requests.
	 * 
	 *  Service in an HttpServlet is already implemented and delegates to other handling methods.
	 *  Handling methods are based on HTTP methods (post get delete put)
	 *  1. doGet
	 *  2. doPost
	 *  3. doPut
	 *  4. doDelete
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Service being called");
		super.service(req, resp);
	}

	@Override
	/**
	 * Do get used to get information
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
				throws ServletException, IOException {
		System.out.println("doGet being called");
		System.out.println(req.getRequestURI());
		System.out.println(req.getRequestURL());
		System.out.println(req.getPathInfo());
		int id = Integer.parseInt(req.getPathInfo().split("/")[1]);
		Optional<Movie> movie = movieService.getMovie(id);
		
		if(movie.isPresent()) {
			resp.getWriter().write(movie.get().toString());
		} else {
			resp.setStatus(404);
		}
	
	}
	
	@Override
	/**
	 * POST - Create a new resource on the server
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
		System.out.println("doPost being called");
		
		String title = req.getParameter("title");
		Duration duration = Duration.parse(req.getParameter("duration"));
		String genre = req.getParameter("genre");
		
		Movie movie = new Movie(0, title, duration, genre);
		movieService.createMovie(movie);
		// write the movie back with it now having an id
		resp.getWriter().write(movie.toString());
	}
}
