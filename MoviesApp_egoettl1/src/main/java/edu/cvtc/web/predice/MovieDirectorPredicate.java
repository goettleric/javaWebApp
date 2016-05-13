/**
 * 
 */
package edu.cvtc.web.predice;

import com.google.common.base.Predicate;

import edu.cvtc.web.model.Movie;

/**
 * @author Eric Goettl
 *
 */
public class MovieDirectorPredicate implements Predicate<Movie> {

	private String director;
	public MovieDirectorPredicate(final String director) {
		this.director = director;
	}
	@Override
	public boolean apply(final Movie movie) {
		return movie.getDirector().equalsIgnoreCase(director);
	}
	
	
}
