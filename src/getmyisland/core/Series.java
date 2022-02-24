package getmyisland.core;

import java.util.ArrayList;
import java.util.Comparator;

public class Series implements Comparable<Series> {
	/** A series folder should be named like this: Game_Of_Thrones_20112019 */

	/** The name of the movie */
	private final String name;

	/** The year in which the movie was released */
	private final String releasedYears;

	/** The name that is used for the image cover */
	private final String pathToCoverImage;

	private int seasonNumber;

	public final ArrayList<Episode> episodeList = new ArrayList<>();

	/**
	 * 
	 * @param name
	 * @param releasedYears
	 * @param pathToCoverImage
	 */
	public Series(final String name, final String releasedYears, final String pathToCoverImage,
			final int seasonNumber) {
		this.name = name;
		this.releasedYears = releasedYears;
		this.pathToCoverImage = pathToCoverImage;
		this.seasonNumber = seasonNumber;
	}

	/** Get the name of the series */
	public String getName() {
		return this.name;
	}

	/** Get the release years of the series */
	public String getReleaseYears() {
		return this.releasedYears;
	}

	/** Get the name of the image cover */
	public String getPathToCoverImage() {
		return this.pathToCoverImage;
	}

	public int getSeasonNumber() {
		return this.seasonNumber;
	}
	
	public void setSeasonNumber(int number) {
		seasonNumber = number;
	}
	
	public ArrayList<Episode> getEpisodes() {
		return this.episodeList;
	}

	@Override
	public int compareTo(Series s) {
		return Comparator.comparing(Series::getName).thenComparing(Series::getReleaseYears).compare(this, s);
	}

}
