package edu.cvtc.web.comparators;

import java.util.Comparator;

import edu.cvtc.web.model.Movie;

/**
 * @author Eric Goettl
 *
 */
public class genreComparator implements Comparator<Movie> {
	@Override
	public int compare(Movie m1, Movie m2) {
		return m1.getGenre().compareTo(m2.getGenre());
	}
}
