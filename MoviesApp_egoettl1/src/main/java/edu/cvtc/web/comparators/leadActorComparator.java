package edu.cvtc.web.comparators;

import java.util.Comparator;

import edu.cvtc.web.model.Movie;

/**
 * @author Eric Goettl
 *
 */
public class leadActorComparator implements Comparator<Movie> {
	@Override
	public int compare(Movie m1, Movie m2) {
		return m1.getLeadActor().compareTo(m2.getLeadActor());
	}
}
