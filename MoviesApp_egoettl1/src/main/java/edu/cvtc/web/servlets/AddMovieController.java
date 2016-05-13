package edu.cvtc.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cvtc.web.dao.MoviesDao;
import edu.cvtc.web.dao.impl.MoviesDaoImpl;
import edu.cvtc.web.model.Movie;

/**
 * Author: Eric Goettl
 * 
 * Servlet implementation class AddMovieController
 */
@WebServlet("/addMovie")
public class AddMovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String target = null;
		
		try{
				
			final String title = request.getParameter("title");
			final String releaseDate = request.getParameter("releaseDate");
			final Integer lengthInMinutes = Integer.parseInt(request.getParameter("lengthInMinutes"));
			final String genre = request.getParameter("genre");
			final String leadActor = request.getParameter("leadActor");
			final String director = request.getParameter("director");
			final String pictureLink = request.getParameter("pictureLink");
			boolean movieFound = false;
			
			if(null != title && !title.isEmpty()
				&& null != releaseDate && !releaseDate.isEmpty()
				&& null != lengthInMinutes && lengthInMinutes > 0
				&& null != genre && !genre.isEmpty()
				&& null != leadActor && !leadActor.isEmpty()
				&& null != director && !director.isEmpty()
				&& null != pictureLink && !pictureLink.isEmpty()) {
				
				final Movie newMovie = new Movie(title, releaseDate, lengthInMinutes, genre, leadActor, director, pictureLink);
				final MoviesDao moviesDao = new MoviesDaoImpl();
			
				final List<Movie>movies = moviesDao.retrieveMovies();
				
				for(Movie movie: movies) {
					if(movie.getTitle().toString().equalsIgnoreCase(title)) {
						movieFound = true;
					}
				}
				
				if(movieFound) {
					request.setAttribute("error", "That movie already exists in the database");
					target = "error.jsp";
				}else{
					moviesDao.insertMovies(newMovie);
					request.setAttribute("success", "Thank you.  The movie " + title + " and it's related information was added to the database.");
					target = "success.jsp";
				}
				
			} else {
				request.setAttribute("error", "All fields and information are needed to successfully add a movie to the database.");
				target = "error.jsp";
			}
		} catch(final Exception e) {
			e.getMessage();
			request.setAttribute("error","Sorry, something went wrong while trying to add your movie to the database.");
			target = "error.jsp";
		}
		request.getRequestDispatcher(target).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
