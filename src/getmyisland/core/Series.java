package getmyisland.core;

import java.util.ArrayList;
import java.util.Comparator;

public class Series implements Comparable<Series> {
	/** A series folder should be named like this: Game_Of_Thrones_20112019 */

	/** The name of the movie */
	private final String name;

	/** The year in which the series was started */
	private final String startYear;
	
	/** The year in which the series has ended */
	private final String endYear;

	/** The name that is used for the image cover */
	private final String pathToCoverImage;

	private int seasonNumber;

	private final ArrayList<Episode> episodeList = new ArrayList<>();

	/**
	 * 
	 * @param name
	 * @param releasedYears
	 * @param pathToCoverImage
	 */
	public Series(final String name, final String startYear, final String endYear, final String pathToCoverImage,
			final int seasonNumber) {
		this.name = name;
		this.startYear = startYear;
		this.endYear = endYear;
		this.pathToCoverImage = pathToCoverImage;
		this.seasonNumber = seasonNumber;
	}

	/** Get the name of the series */
	public String getName() {
		return this.name;
	}

	/** Get the start year of the series */
	public String getStartYear() {
		return this.startYear;
	}
	
	/** Get the end year of the series */
	public String getEndYear() {
		return this.endYear;
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
		return Comparator.comparing(Series::getName).thenComparing(Series::getEndYear).compare(this, s);
	}

}
