package getmyisland.core;

import java.util.Comparator;

public class Movie implements Comparable<Movie> {
	/** A movie file should be named like this: The_Dark_Knight_2009 */
	
	/** The name of the movie */
	private final String name;
	
	/** The year in which the movie was released */
	private final String releasedYear;
	
	/** The name that is used for the image cover */
	private final String pathToCoverImage;
	
	/** The path to the movie */
	private final String pathToMovie;
	
	public Movie(final String name, final String releasedYear, final String pathToCoverImage, final String pathToMovie) {
		this.name = name;
		this.releasedYear = releasedYear;
		this.pathToCoverImage = pathToCoverImage;
		this.pathToMovie = pathToMovie;
	}
	
	/** Get the name of the movie */
	public String getName() {
		return this.name;
	}
	
	/** Get the release year of the movie */
	public String getReleaseYear() {
		return this.releasedYear;
	}
	
	/** Get the name of the image cover */
	public String getPathToCoverImage() {
		return this.pathToCoverImage;
	}
	
	/** Get the path to the movie */
	public String getMoviePath() {
		return this.pathToMovie;
	}
	
	@Override
	public int compareTo(Movie m){
	    return Comparator.comparing(Movie::getName)
	              .thenComparing(Movie::getReleaseYear)
	              .compare(this, m);
	}
}
