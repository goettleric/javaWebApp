package edu.cvtc.web.dao;

import java.util.List;

import edu.cvtc.web.model.Movie;

/**
 * @author Eric Goettl
 *
 */
public interface MoviesDao {

	void populate(String filePath)  throws Exception;
	void insertMovies(Movie movie) throws Exception;
	List<Movie> retrieveMovies() throws Exception;
	void deleteMovie(String movieTitle) throws Exception;
}
