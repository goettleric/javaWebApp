package edu.cvtc.web.dao.impl;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.cvtc.web.dao.MoviesDao;
import edu.cvtc.web.model.Movie;
import edu.cvtc.web.util.DBUtility;
import edu.cvtc.web.util.MovieUtility;

/**
 * @author Eric Goettl
 *
 */
public class MoviesDaoImpl implements MoviesDao {

	private static final String DROP_TABLE_MOVIE = "drop table if exists movie";
	private static final String CREATE_TABLE_MOVIE = "create table movie(id integer primary key autoincrement, title text, releaseDate text, lengthInMinutes integer, genre text, leadActor text, director text, pictureLink text)";
	private static final String SELECT_ALL_MOVIE = "select * from movie";
	
	@Override
	public void populate(String filePath) throws Exception{
		final Connection connection = DBUtility.createDbConnection();
		final Statement statement = connection.createStatement();
		
		try {
	
		statement.setQueryTimeout(DBUtility.TIMEOUT);
		statement.executeUpdate(DROP_TABLE_MOVIE);
		statement.executeUpdate(CREATE_TABLE_MOVIE);
		
			final File inputFile = new File(filePath);
			final List<Movie> movies = MovieUtility.retrieveMoviesFromFile(inputFile);
			
			for(final Movie movie: movies) {
				final String insertValues= "insert into movie(title, releaseDate, lengthInMinutes, genre, leadActor, director, pictureLink) values ('"
						+ movie.getTitle() +"', '"
							+ movie.getReleaseDate() +"', '"
								+ movie.getLengthInMinutes()+"', '"
									+ movie.getGenre() +"', '"
										+ movie.getLeadActor()+"', '"
											+ movie.getDirector()+"', '"
												+ movie.getPictureLink() +"');";
			System.out.println(insertValues);
			statement.executeUpdate(insertValues);
			}
		} finally {
			DBUtility.closeDbConnection(connection, statement);
		}
	}


	@Override
	public void insertMovies(Movie movie) throws Exception {
		Connection connection = null;
		PreparedStatement insertStatement = null;
		
		try{
			connection = DBUtility.createDbConnection();
			final String insertValues = "insert into movie (title, releaseDate, lengthInMinutes, "
					+ "genre, leadActor, director, pictureLink) values (?,?,?,?,?,?,?)";
			insertStatement = connection.prepareStatement(insertValues);
			insertStatement.setString(1, movie.getTitle());
			insertStatement.setString(2, movie.getReleaseDate());
			insertStatement.setInt(3, movie.getLengthInMinutes());
			insertStatement.setString(4, movie.getGenre());
			insertStatement.setString(5, movie.getLeadActor());
			insertStatement.setString(6, movie.getDirector());
			insertStatement.setString(7, movie.getPictureLink());
			
			insertStatement.setQueryTimeout(DBUtility.TIMEOUT);
			insertStatement.executeUpdate();
		} finally {
			DBUtility.closeDbConnection(connection, insertStatement);
		}

	}

	@Override
	public List<Movie> retrieveMovies() throws Exception {
		final List<Movie> movies = new ArrayList<>();
		final Connection connection = DBUtility.createDbConnection();
		final Statement statement = connection.createStatement();
		
		try{
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			final ResultSet resultSet = statement.executeQuery(SELECT_ALL_MOVIE);
			
			while(resultSet.next()) {
				final String title = resultSet.getString("title");
				final String releaseDate = resultSet.getString("releaseDate");
				final int lengthInMinutes = resultSet.getInt("lengthInMinutes");
				final String genre = resultSet.getString("genre");
				final String leadActor = resultSet.getString("leadActor");
				final String director = resultSet.getString("director");
				final String pictureLink = resultSet.getString("pictureLink");
				final Movie movie = new Movie(title, releaseDate, lengthInMinutes, genre, leadActor, director, pictureLink);
				movies.add(movie);	
			}
		}finally {
			DBUtility.closeDbConnection(connection, statement);
		}
		return movies;
		
	}


	@Override
	public void deleteMovie(String movieTitle) throws Exception {
		Connection connection = null;
		PreparedStatement deleteStatement = null;
		
		try{
			connection = DBUtility.createDbConnection();
			final String deleteValues = "delete from movie where title = ?";
			deleteStatement = connection.prepareStatement(deleteValues);
			deleteStatement.setString(1, movieTitle.toString());
			deleteStatement.setQueryTimeout(DBUtility.TIMEOUT);
			deleteStatement.executeUpdate();
		} finally {
			DBUtility.closeDbConnection(connection, deleteStatement);
		}
	}
}
