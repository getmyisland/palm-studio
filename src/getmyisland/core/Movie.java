package getmyisland.core;

public class Movie implements Comparable<Movie> {
	/** The name of the movie */
	private final String name;
	
	/** The year in which the movie was released */
	private final String releasedYear;
	
	/** The name that is used for the image cover */
	private final String imageName;
	
	/** The path to the movie */
	private final String pathToMovie;
	
	/**
	 * Constructor to create a movie component
	 * 
	 * @param name
	 * @param releasedYear
	 */
	public Movie(final String name, final String releasedYear, final String imageName, final String pathToMovie) {
		this.name = name;
		this.releasedYear = releasedYear;
		this.imageName = imageName;
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
	public String getImageName() {
		return this.imageName;
	}
	
	/** Get the path to the movie */
	public String getMoviePath() {
		return this.pathToMovie;
	}

	@Override
	public int compareTo(Movie m) {
		if(getName() == null || m.getName() == null) {
			return 0;
		}
		
		return getName().compareTo(m.getName());
	}
}
