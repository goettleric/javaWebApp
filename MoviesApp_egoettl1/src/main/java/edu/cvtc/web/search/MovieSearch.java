/**
 * 
 */
package edu.cvtc.web.search;

import java.util.List;

import edu.cvtc.web.exceptions.MovieSearchException;
import edu.cvtc.web.model.Movie;

/**
 * @author Eric Goettl
 *
 */
public interface MovieSearch {

	List<Movie> findMovieByTitle(String title) throws MovieSearchException;
	List<Movie> retrieveMovies(String sortType) throws MovieSearchException;
	List<Movie> findMovieByDirector(String director) throws MovieSearchException;
}
