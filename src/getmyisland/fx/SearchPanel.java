package getmyisland.fx;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import getmyisland.core.Movie;
import getmyisland.core.MovieController;
import getmyisland.core.Series;
import getmyisland.core.SeriesController;

public class SearchPanel {
	public static JPanel createSearchPanel(String searchString) {
		JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 25));
		searchPanel.setBackground(new Color(32, 32, 32));

		searchPanel.add(addSearch(searchString));

		return searchPanel;
	}

	public static JPanel addSearch(String search) {
		if (search.isEmpty() || search.isBlank()) {
			JPanel searchContentPanel = new JPanel();
			searchContentPanel.setBackground(new Color(32, 32, 32));

			return searchContentPanel;
		}

		JPanel searchContentPanel = new JPanel(new GridLayout(0, 9, 8, 5));
		searchContentPanel.setBackground(new Color(32, 32, 32));

		final List<Movie> foundMovies = new ArrayList<>();
		final List<Series> foundSeries = new ArrayList<>();

		for (Movie movie : getSortedMovieList()) {
			if (movie.getName().toLowerCase().contains(search.toLowerCase())) {
				foundMovies.add(movie);
			}
		}

		for (Series series : getSortedSeriesList()) {
			if (series.getName().toLowerCase().contains(search.toLowerCase())) {
				foundSeries.add(series);
			}
		}

		if (foundMovies.size() != 0) {
			for (final Movie movie : foundMovies) {
				// Get the image and scale it down
				File imageFile = null;
				BufferedImage movieCover = null;

				try {
					imageFile = new File(movie.getPathToCoverImage());

					if (imageFile.exists() && !imageFile.isDirectory()) {
						BufferedImage movieCoverUnscaled = ImageIO.read(imageFile);
						movieCover = resizeImage(movieCoverUnscaled, 150, 210);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

				if (movieCover == null) {
					// Create an empty gray image if there is no movie cover for the image
					System.out.println("No movie cover found for " + movie.getName());

					movieCover = new BufferedImage(150, 200, BufferedImage.TYPE_INT_RGB);
					Graphics2D g2d = (Graphics2D) movieCover.getGraphics();
					g2d.setColor(Color.GRAY);
					g2d.fillRect(0, 0, movieCover.getWidth(), movieCover.getHeight());
				}

				// Create button and change settings
				JButton movieButton = new JButton(movie.getName(), new ImageIcon(movieCover));
				movieButton.setMargin(new Insets(0, 0, 0, 0));
				movieButton.setPreferredSize(new Dimension(180, 250));
				movieButton.setForeground(Color.WHITE);
				movieButton.setContentAreaFilled(false);
				movieButton.setBorderPainted(false);
				movieButton.setFocusPainted(false);
				movieButton.setHorizontalTextPosition(JButton.CENTER);
				movieButton.setVerticalTextPosition(JButton.BOTTOM);

				// Set a tooltip for the movie
				movieButton.setToolTipText(
						"<html> " + movie.getName() + "<br> Released in " + movie.getReleaseYear() + "</html>");

				// Add an event to the button
				movieButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							Desktop.getDesktop().open(new File(movie.getMoviePath()));
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				});

				movieButton.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseEntered(java.awt.event.MouseEvent evt) {
						movieButton.setForeground(new Color(229, 9, 20));
					}

					public void mouseExited(java.awt.event.MouseEvent evt) {
						movieButton.setForeground(Color.WHITE);
					}
				});

				searchContentPanel.add(movieButton);
			}
		}

		if (foundSeries.size() != 0) {
			for (final Series series : foundSeries) {
				// Get the image and scale it down
				File imageFile = null;
				BufferedImage seriesCover = null;

				try {
					imageFile = new File(series.getPathToCoverImage());

					if (imageFile.exists() && !imageFile.isDirectory()) {
						BufferedImage movieCoverUnscaled = ImageIO.read(imageFile);
						seriesCover = resizeImage(movieCoverUnscaled, 150, 210);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

				if (seriesCover == null) {
					// Create an empty gray image if there is no movie cover for the image
					System.out.println("No series cover found for " + series.getName());

					seriesCover = new BufferedImage(150, 200, BufferedImage.TYPE_INT_RGB);
					Graphics2D g2d = (Graphics2D) seriesCover.getGraphics();
					g2d.setColor(Color.GRAY);
					g2d.fillRect(0, 0, seriesCover.getWidth(), seriesCover.getHeight());
				}

				// Create button and change settings
				JButton seriesButton = new JButton(series.getName(), new ImageIcon(seriesCover));
				seriesButton.setMargin(new Insets(0, 0, 0, 0));
				seriesButton.setPreferredSize(new Dimension(180, 250));
				seriesButton.setForeground(Color.WHITE);
				seriesButton.setContentAreaFilled(false);
				seriesButton.setBorderPainted(false);
				seriesButton.setFocusPainted(false);
				seriesButton.setHorizontalTextPosition(JButton.CENTER);
				seriesButton.setVerticalTextPosition(JButton.BOTTOM);

				// Set a tooltip for the movie
				seriesButton.setToolTipText("<html> " + series.getName() + "<br>" + series.getSeasonNumber()
						+ " Season(s)" + "<br>" + series.getEpisodes().size() + " Episode(s)" + "<br> Released in "
						+ series.getStartYear() + "-" + series.getEndYear() + "</html>");

				// Add an event to the button
				seriesButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						PalmStudio.instance.inspectSeries(series);
					}
				});

				seriesButton.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseEntered(java.awt.event.MouseEvent evt) {
						seriesButton.setForeground(new Color(229, 9, 20));
					}

					public void mouseExited(java.awt.event.MouseEvent evt) {
						seriesButton.setForeground(Color.WHITE);
					}
				});

				searchContentPanel.add(seriesButton);
			}
		}

		if (foundSeries.size() == 0 && foundMovies.size() == 0) {
			JLabel nothingFoundLabel = new JLabel("No Movies or Series found with this name");
			nothingFoundLabel.setForeground(Color.WHITE);
			searchContentPanel.add(nothingFoundLabel);
		}

		return searchContentPanel;
	}

	private static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight)
			throws IOException {
		Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
		BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
		outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
		return outputImage;
	}

	private static List<Movie> getSortedMovieList() {
		return MovieController.getMovieList().stream().sorted(Comparator.comparing(Movie::getName))
				.collect(Collectors.toList());
	}

	private static List<Series> getSortedSeriesList() {
		return SeriesController.getSeriesList().stream().sorted(Comparator.comparing(Series::getName))
				.collect(Collectors.toList());
	}
}
