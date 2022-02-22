package getmyisland.core;

public class Movie {
	/** The name of the movie */
	private final String name;
	
	/** The year in which the movie was released */
	private final String releasedYear;
	
	/**
	 * Constructor to create a movie component
	 * 
	 * @param name
	 * @param releasedYear
	 */
	public Movie(final String name, final String releasedYear) {
		this.name = name;
		this.releasedYear = releasedYear;
	}
	
	/** Get the name of the movie */
	public String getName() {
		return this.name;
	}
	
	/** Get the release year of the movie */
	public String getReleaseYear() {
		return this.releasedYear;
	}
}
