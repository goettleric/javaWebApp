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
 * Servlet implementation class DeleteMovieController
 */
@WebServlet("/DeleteMovie")
public class DeleteMovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String target = null;
		
		try {
			final String movieTitle = request.getParameter("title");
			
			if(null != movieTitle && !movieTitle.isEmpty()) {
				final MoviesDao moviesDao = new MoviesDaoImpl();
				final List<Movie>movies = moviesDao.retrieveMovies();
			
				for(Movie movie: movies) {
					if(movie.getTitle().toString().equalsIgnoreCase(movieTitle)) {
						moviesDao.deleteMovie(movieTitle);				
						request.setAttribute("success", "You have removed the movie " + movieTitle + " from the database.");
						target = "success.jsp";
						
					}else{
						request.setAttribute("error", "No movie with the name " + movieTitle + " was in the database.");
						target = "error.jsp";
					}
				}
			} else {
				request.setAttribute("error", "A title is required to delete the movie.");
				target = "error.jsp";
			}
		} catch(final Exception e) {
			e.getMessage();
			request.setAttribute("error","Sorry, something went wrong while deleting your movie to the database.");
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
