/**
 * 
 */
package edu.cvtc.web.search.impl;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import edu.cvtc.web.comparators.SortBy;
import edu.cvtc.web.comparators.directorComparator;
import edu.cvtc.web.comparators.genreComparator;
import edu.cvtc.web.comparators.leadActorComparator;
import edu.cvtc.web.comparators.lengthComparator;
import edu.cvtc.web.comparators.titleComparator;
import edu.cvtc.web.dao.MoviesDao;
import edu.cvtc.web.dao.impl.MoviesDaoImpl;
import edu.cvtc.web.exceptions.MovieSearchException;
import edu.cvtc.web.model.Movie;
import edu.cvtc.web.predice.MovieDirectorPredicate;
import edu.cvtc.web.predice.MovieNamePredicate;
import edu.cvtc.web.search.MovieSearch;

/**
 * @author Eric Goettl
 *
 */
public class MovieSearchImpl implements MovieSearch {

	private static final String EXCEPTION_MESSAGE = "List of movies could not be retrieve from the database.";
	
	private List<Movie> retrieveMovies() throws Exception {
		final MoviesDao moviesDao = new MoviesDaoImpl();
		return moviesDao.retrieveMovies();
	}
	
	@Override
	public List<Movie> findMovieByTitle(final String title) throws MovieSearchException {
		try{
			final MoviesDao moviesDao = new MoviesDaoImpl();
			final List<Movie> movies = moviesDao.retrieveMovies();
			return Lists.newArrayList(Collections2.filter(movies,new MovieNamePredicate(title)));
		} catch(final Exception e){
			e.printStackTrace();
			throw new MovieSearchException(EXCEPTION_MESSAGE);
		}
	}
	
	
	@Override
	public List<Movie> findMovieByDirector(String director) throws MovieSearchException {
		try{
			final MoviesDao moviesDao = new MoviesDaoImpl();
			final List<Movie> movies = moviesDao.retrieveMovies();
			return Lists.newArrayList(Collections2.filter(movies, new MovieDirectorPredicate(director)));
		} catch(final Exception e){
			e.printStackTrace();
			throw new MovieSearchException(EXCEPTION_MESSAGE);
		}
		
	}	
	@Override
	public List<Movie> retrieveMovies(String sortType) throws MovieSearchException {
		try {
			final List<Movie> movies = retrieveMovies();
			if(null != sortType) {
				sortMovies(movies, sortType);
			}
			return movies;
		} catch(final Exception e) {
			e.printStackTrace();
			throw new MovieSearchException(EXCEPTION_MESSAGE);
		}	
	}

	private void sortMovies(List<Movie> movies, String sortType) {
		
		switch(sortType) {
		case SortBy.TITLE:
			Collections.sort(movies, new titleComparator());
			break;
		case SortBy.LENGTH_IN_MINUTES:
			Collections.sort(movies, new lengthComparator());
			break;
		case SortBy.GENRE:
			Collections.sort(movies, new genreComparator());
			break;
		case SortBy.LEAD_ACTOR:
			Collections.sort(movies, new leadActorComparator());
			break;
		case SortBy.DIRECTOR:
			Collections.sort(movies, new directorComparator());
			break;
		default:
			break;
		}
	}

}
