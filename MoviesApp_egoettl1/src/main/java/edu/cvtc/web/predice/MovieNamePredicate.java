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
public class MovieNamePredicate implements Predicate<Movie> {

	private String title;
	public MovieNamePredicate(final String title) {
		this.title = title;
	}
	
	@Override
	public boolean apply(final Movie movie) {
		return movie.getTitle().equalsIgnoreCase(title);
	}

}
