package getmyisland.core;

import java.io.File;

public class MovieController {
	/** The folder where all movies are located */
	private final File movieRoot = new File("D:\\Movies");
	
	// Searches for movie files
	public static void listMovies(final File root) {
		final File[] childs = root.listFiles((dir, name) -> dir.isDirectory() || name.toLowerCase().endsWith(".mp4"));
		
		// Return if there are no files
		if(childs.length == 0) {
			return;
		}
		
		for(final File child : childs) {
			if(child.isDirectory()) {
				listMovies(child);
			} else if(child.getName().toLowerCase().endsWith(".mp4")) { // Check if the file ends with .mp4
				System.out.println(child.getName());
			}
		}
	}
}