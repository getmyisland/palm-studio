package getmyisland.core;

public class Episode {
	/** A episode file should be named like this: S01E01_A_new_beginning */
	
	/** The number of the season in which the episode takes place */
	private final int seasonNumber;
	
	/** The number of the episode inside of a season */
	private final int episodeNumber;
	
	/** The name of the episode */
	private final String episodeName;
	
	/**
	 * 
	 * @param seasonNumber
	 * @param episodeNumber
	 * @param episodeName
	 */
	public Episode(final int seasonNumber, final int episodeNumber, final String episodeName) {
		this.seasonNumber = seasonNumber;
		this.episodeNumber = episodeNumber;
		this.episodeName = episodeName;
	}
}
