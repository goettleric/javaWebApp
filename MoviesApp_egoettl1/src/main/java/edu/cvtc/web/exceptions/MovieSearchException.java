package edu.cvtc.web.exceptions;

/**
 * @author Eric Goettl
 *
 */
public class MovieSearchException extends Exception {

	private static final long serialVersionUID = -6368563131702234205L;

	public MovieSearchException(final String message) throws MovieSearchException{
		super(message);
	}
}
