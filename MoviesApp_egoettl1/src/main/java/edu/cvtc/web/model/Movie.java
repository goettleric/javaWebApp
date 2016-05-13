/**
 * 
 */
package edu.cvtc.web.model;

/**
 * @author Eric Goettl
 *
 */
public class Movie {
	private String title;
	private String releaseDate;
	private Integer lengthInMinutes;
	private String genre;
	private String leadActor;
	private String director;
	private String pictureLink;

	public Movie(String title, String releaseDate, Integer lengthInMinutes, String genre, String leadActor,
			String director, String pictureLink) {
		this.title = title;
		this.releaseDate = releaseDate;
		this.lengthInMinutes = lengthInMinutes;
		this.genre = genre;
		this.leadActor = leadActor;
		this.director = director;
		this.pictureLink = pictureLink;
	}

	public String getTitle() {
		return title;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public Integer getLengthInMinutes() {
		return lengthInMinutes;
	}
	
	public String getGenre() {
		return genre;
	}

	public String getLeadActor() {
		return leadActor;
	}

	public String getDirector() {
		return director;
	}

	public String getPictureLink() {
		return pictureLink;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", releaseDate=" + releaseDate + ", lengthInMinutes=" + lengthInMinutes
				+ ", genre=" + genre + ", leadActor=" + leadActor + ", director=" + director + ", pictureLink="
				+ pictureLink + "]";
	}

	
	
	
	
}
