package getmyisland.core;

public class Episode {
	/** A episode file should be named like this: S01E01_A_new_beginning */

	/** The number of the season in which the episode takes place */
	private final int seasonNumber;

	/** The number of the episode inside of a season */
	private final int episodeNumber;

	/** The name of the episode */
	private final String episodeName;

	/** The filepath on the local filesystem */
	private final String episodeFilePath;

	/**
	 * 
	 * @param seasonNumber
	 * @param episodeNumber
	 * @param episodeName
	 */
	public Episode(final int seasonNumber, final int episodeNumber, final String episodeName,
			final String episodeFilePath) {
		this.seasonNumber = seasonNumber;
		this.episodeNumber = episodeNumber;
		this.episodeName = episodeName;
		this.episodeFilePath = episodeFilePath;
	}

	public final int getSeasonNumber() {
		return this.seasonNumber;
	}

	public final int getEpisodeNumber() {
		return this.episodeNumber;
	}

	public final String getEpisodeName() {
		return this.episodeName;
	}
	
	public final String getEpisodeFilePath() {
		return this.episodeFilePath;
	}
}
