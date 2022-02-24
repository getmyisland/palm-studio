package getmyisland.core;

import java.io.File;
import java.util.ArrayList;

public class MovieController {
	/** The folder where all movies are located */
	public static final File movieRoot = new File("D:\\Movies");

	private static ArrayList<Movie> foundMovies = new ArrayList<>();

	// Searches for movie files
	public static void listMovies(final File root) {
		if(!root.exists()) {
			return;
		}
		
		final File[] childs = root.listFiles((dir, name) -> dir.isDirectory() || name.toLowerCase().endsWith(".mp4"));

		// Return if there are no files
		if (childs.length == 0) {
			return;
		}

		for (final File child : childs) {
			if (child.isDirectory()) {
				listMovies(child);
			} else if (child.getName().toLowerCase().endsWith(".mp4") || child.getName().toLowerCase().endsWith(".mkv")) { // Check if the file ends with .mp4 which means
																			// its a movie
				String tempName = child.getName().split("\\.")[0]; // Splits the name and the .mp4 at the end
				String releaseYear = tempName.substring(tempName.length() - 4); // The last 4 letters are always the
																				// release year
				String movieName = tempName.substring(0, tempName.length() - 5); // Remove the last 5 letters
				movieName = movieName.replaceAll("_", " ");
				foundMovies.add(new Movie(movieName, releaseYear, tempName + ".jpg", child.getAbsolutePath()));
			}
		}
	}

	public static ArrayList<Movie> getMovieList() {
		return foundMovies;
	}
}