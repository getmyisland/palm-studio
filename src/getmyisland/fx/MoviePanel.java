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
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import getmyisland.core.Movie;
import getmyisland.core.MovieController;

public class MoviePanel {
	/**
	 * Creates the movie panel and lists all the available movies.
	 * 
	 * @param whichSortingAlgorithm <br>
	 *                              0 = Sorts after Name ascending (A-Z) <br>
	 *                              1 = Sorts after Name descending (Z-A) <br>
	 *                              2 = Sorts after Release Year ascending (1-9)
	 *                              <br>
	 *                              3 = Sorts after Release Year descending (9-1)
	 *                              <br>
	 * @return {@link JPanel}
	 */
	public static JPanel createMoviePanel(int whichSortingAlgorithm) {
		JPanel parentMoviePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 25));
		JPanel contentPanel = new JPanel(new GridLayout(0, 1));
		JPanel moviePanel = new JPanel(new GridLayout(0, 9, 8, 5));

		parentMoviePanel.setBackground(new Color(32, 32, 32));
		contentPanel.setBackground(new Color(32, 32, 32));
		moviePanel.setBackground(new Color(32, 32, 32));

		if (whichSortingAlgorithm < 0 || whichSortingAlgorithm > 3) {
			whichSortingAlgorithm = 0; // 0 is the default sorting algorithm == name ascending
		}

		final List<Movie> sortedMovieList;

		switch (whichSortingAlgorithm) {
		case 0:
			sortedMovieList = getListSortedNameAscending();
			break;
		case 1:
			sortedMovieList = getListSortedNameDescending();
			break;
		case 2:
			sortedMovieList = getListSortedReleaseYearAscending();
			break;
		case 3:
			sortedMovieList = getListSortedReleaseYearDescending();
			break;
		default:
			sortedMovieList = getListSortedNameAscending();
		}

		for (final Movie movie : sortedMovieList) {
			// Get the image and scale it down
			File imageFile = null;
			BufferedImage movieCover = null;

			try {
				imageFile = new File(movie.getImageName());

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
					movieButton.setForeground(new Color(114, 188, 212));
				}

				public void mouseExited(java.awt.event.MouseEvent evt) {
					movieButton.setForeground(Color.WHITE);
				}
			});

			moviePanel.add(movieButton);
		}

		contentPanel.add(moviePanel);
		parentMoviePanel.add(contentPanel);

		return parentMoviePanel;
	}

	/**
	 * Resizes the image to the target size.
	 * 
	 * @param originalImage
	 * @param targetWidth
	 * @param targetHeight
	 * @return
	 * @throws IOException
	 */
	private static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight)
			throws IOException {
		Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
		BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
		outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
		return outputImage;
	}

	/**
	 * Sorts the found movies after Name in Ascending Order.
	 * 
	 * @return a list of {@link Movie}
	 */
	private static List<Movie> getListSortedNameAscending() {
		return MovieController.getMovieList().stream().sorted(Comparator.comparing(Movie::getName))
				.collect(Collectors.toList());
	}

	/**
	 * Sorts the found movies after Name in Descending Order.
	 * 
	 * @return a list of {@link Movie}
	 */
	private static List<Movie> getListSortedNameDescending() {
		return MovieController.getMovieList().stream().sorted(Comparator.comparing(Movie::getName).reversed())
				.collect(Collectors.toList());
	}

	/**
	 * Sorts the found movies after Release Year in Ascending Order.
	 * 
	 * @return a list of {@link Movie}
	 */
	private static List<Movie> getListSortedReleaseYearAscending() {
		return MovieController.getMovieList().stream().sorted(Comparator.comparing(Movie::getReleaseYear))
				.collect(Collectors.toList());
	}

	/**
	 * Sorts the found movies after Release Year in Descending Order.
	 * 
	 * @return a list of {@link Movie}
	 */
	private static List<Movie> getListSortedReleaseYearDescending() {
		return MovieController.getMovieList().stream().sorted(Comparator.comparing(Movie::getReleaseYear).reversed())
				.collect(Collectors.toList());
	}
}
