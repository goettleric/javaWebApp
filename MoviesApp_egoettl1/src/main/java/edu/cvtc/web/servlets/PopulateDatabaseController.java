package edu.cvtc.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cvtc.web.dao.MoviesDao;
import edu.cvtc.web.dao.impl.MoviesDaoImpl;
import edu.cvtc.web.util.MovieUtility;

/**
 * Servlet implementation class PopulateDatabaseController
 */
@WebServlet("/PopulateDatabase")
public class PopulateDatabaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String target = null;
		
		try{
			final MoviesDao moviesDao = new MoviesDaoImpl();
			final String filePath = getServletContext().getRealPath(MovieUtility.INPUT_FILE);
			
			moviesDao.populate(filePath);
			
			request.setAttribute("success", "Success, the database has been populated using the spreadsheet.");
			target = "success.jsp";
		} catch (final Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Sorry, there was a problem populating the database.");
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
