package edu.cvtc.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cvtc.web.exceptions.MovieSearchException;
import edu.cvtc.web.model.Movie;
import edu.cvtc.web.search.MovieSearch;
import edu.cvtc.web.search.impl.MovieSearchImpl;

/**
 * Servlet implementation class ViewMoviesController
 */
@WebServlet("/ViewMovies")
public class MovieViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String target = null;
		
		try{
			final MovieSearch movieSearch = new MovieSearchImpl();
			final String sortType = request.getParameter("sortType");
			final List<Movie> movies = movieSearch.retrieveMovies(sortType);
			
			request.setAttribute("movies", movies);
			target = "ViewMovies.jsp";
		}catch (final MovieSearchException e) {
			e.printStackTrace();
			request.setAttribute("error", "Sorry, there was a problem accessing the database.");
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
