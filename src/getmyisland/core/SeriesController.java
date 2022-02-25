package getmyisland.core;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeriesController {
	/** The folder where all series are located */
	public static final File seriesRoot = new File("D:\\Series");

	private static ArrayList<Series> foundSeries = new ArrayList<>();

	// Searches for movie files
	public static void listSeries(final File root) {
		if (!root.exists()) {
			System.out.println("The root file doesn't exist");
			return;
		}

		final File[] childs = root.listFiles((dir, name) -> dir.isDirectory() || name.toLowerCase().endsWith(".mp4"));

		// Return if there are no files
		if (childs.length == 0) {
			return;
		}

		for (final File child : childs) {
			if (child.isDirectory()) {
				// If its a directory then the directory is the head of the series
				listEpisodes(child);
			}
		}
	}

	private static void listEpisodes(final File root) {
		if (!root.exists()) {
			System.out.println("The root file doesn't exist");
			return;
		}

		final File[] childs = root.listFiles((dir, name) -> dir.isDirectory() || name.toLowerCase().endsWith(".mp4"));

		// Return if there are no files
		if (childs.length == 0) {
			return;
		}

		// Create a series
		String seriesName = root.getName().substring(0, root.getName().length() - 9); // Remove the last 9 letters which
																						// are the releaseYears
		seriesName = seriesName.replaceAll("_", " ");

		String seriesReleaseYears = root.getName().substring(root.getName().length() - 8); // Get the last 4 digits
																							// which are the
																							// releaseYears
		String startYear = seriesReleaseYears.substring(0, (seriesReleaseYears.length() / 2));
		String endYear = seriesReleaseYears.substring((seriesReleaseYears.length() / 2));

		String pathToSeriesCoverImage = root.getAbsolutePath() + "\\" + root.getName() + ".jpg";

		Series tempSeries = new Series(seriesName, startYear, endYear, pathToSeriesCoverImage, 0);

		List<Integer> seasonNumbers = new ArrayList<Integer>();

		for (final File child : childs) {
			// Check if the file ends with .mp4 which means its an episode
			if (child.getName().toLowerCase().endsWith(".mp4") || child.getName().toLowerCase().endsWith(".mkv")) {

				String tempName = child.getName().split("\\.")[0]; // Splits the name and the .mp4 at the end

				String episodeName = tempName.substring(7, tempName.length()); // The last 4 letters are always the
																				// release year
				episodeName = episodeName.replaceAll("_", " ");

				String seasonNumberString = tempName.substring(1, 3); // The second and third letter are always the
																		// season number
				int seasonNumber = Integer.parseInt(seasonNumberString);
				seasonNumbers.add(seasonNumber);

				String episodeNumberString = tempName.substring(4, 6); // The second and third letter are always the
																		// season number
				int episodeNumber = Integer.parseInt(episodeNumberString);

				tempSeries.episodeList.add(new Episode(seasonNumber, episodeNumber, episodeName));
			}
		}

		if (seasonNumbers.size() > 0) {
			tempSeries.setSeasonNumber(Collections.max(seasonNumbers));
		}

		foundSeries.add(tempSeries);
	}

	public static ArrayList<Series> getSeriesList() {
		return foundSeries;
	}
}
