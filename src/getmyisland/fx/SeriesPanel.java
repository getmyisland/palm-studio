package getmyisland.fx;

import java.awt.Color;
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
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import getmyisland.core.Series;
import getmyisland.core.SeriesController;

public class SeriesPanel {
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
	public static JPanel createSeriesPanel(int whichSortingAlgorithm) {
		JPanel parentSeriesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 25));
		JPanel contentPanel = new JPanel(new GridLayout(0, 1));
		JPanel seriesPanel = new JPanel(new GridLayout(0, 9, 8, 5));

		parentSeriesPanel.setBackground(new Color(32, 32, 32));
		contentPanel.setBackground(new Color(32, 32, 32));
		seriesPanel.setBackground(new Color(32, 32, 32));

		if (whichSortingAlgorithm < 0 || whichSortingAlgorithm > 3) {
			whichSortingAlgorithm = 0; // 0 is the default sorting algorithm == name ascending
		}

		final List<Series> sortedSeriesList;

		switch (whichSortingAlgorithm) {
		case 0:
			sortedSeriesList = getListSortedNameAscending();
			break;
		case 1:
			sortedSeriesList = getListSortedNameDescending();
			break;
		case 2:
			sortedSeriesList = getListSortedReleaseYearAscending();
			break;
		case 3:
			sortedSeriesList = getListSortedReleaseYearDescending();
			break;
		default:
			sortedSeriesList = getListSortedNameAscending();
		}

		for (final Series series : sortedSeriesList) {
			// Get the image and scale it down
			File imageFile = null;
			BufferedImage movieCover = null;

			try {
				imageFile = new File(series.getPathToCoverImage());

				if (imageFile.exists() && !imageFile.isDirectory()) {
					BufferedImage movieCoverUnscaled = ImageIO.read(imageFile);
					movieCover = resizeImage(movieCoverUnscaled, 150, 210);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (movieCover == null) {
				// Create an empty gray image if there is no movie cover for the image
				System.out.println("No series cover found for " + series.getName());

				movieCover = new BufferedImage(150, 200, BufferedImage.TYPE_INT_RGB);
				Graphics2D g2d = (Graphics2D) movieCover.getGraphics();
				g2d.setColor(Color.GRAY);
				g2d.fillRect(0, 0, movieCover.getWidth(), movieCover.getHeight());
			}

			// Create button and change settings
			JButton seriesButton = new JButton(series.getName(), new ImageIcon(movieCover));
			seriesButton.setMargin(new Insets(0, 0, 0, 0));
			seriesButton.setPreferredSize(new Dimension(180, 250));
			seriesButton.setForeground(Color.WHITE);
			seriesButton.setContentAreaFilled(false);
			seriesButton.setBorderPainted(false);
			seriesButton.setFocusPainted(false);
			seriesButton.setHorizontalTextPosition(JButton.CENTER);
			seriesButton.setVerticalTextPosition(JButton.BOTTOM);

			// Set a tooltip for the movie
			String startYear = series.getReleaseYears().substring(0, (series.getReleaseYears().length() / 2));
			String endYear = series.getReleaseYears().substring((series.getReleaseYears().length() / 2));
			seriesButton.setToolTipText("<html> " + series.getName() + "<br>" + series.getSeasonNumber() + " Season(s)" + "<br>" + series.episodeList.size() + " Episode(s)" + "<br> Released in " + startYear + "-" + endYear + "</html>");

			// Add an event to the button
			seriesButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Open a new window where all the episodes are listed
				}
			});

			seriesButton.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent evt) {
					seriesButton.setForeground(new Color(114, 188, 212));
				}

				public void mouseExited(java.awt.event.MouseEvent evt) {
					seriesButton.setForeground(Color.WHITE);
				}
			});

			seriesPanel.add(seriesButton);
		}

		contentPanel.add(seriesPanel);
		parentSeriesPanel.add(contentPanel);

		return parentSeriesPanel;
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
	 * Sorts the found series after Name in Ascending Order.
	 * 
	 * @return a list of {@link Series}
	 */
	private static List<Series> getListSortedNameAscending() {
		return SeriesController.getSeriesList().stream().sorted(Comparator.comparing(Series::getName))
				.collect(Collectors.toList());
	}

	/**
	 * Sorts the found series after Name in Descending Order.
	 * 
	 * @return a list of {@link Series}
	 */
	private static List<Series> getListSortedNameDescending() {
		return SeriesController.getSeriesList().stream().sorted(Comparator.comparing(Series::getName).reversed())
				.collect(Collectors.toList());
	}

	/**
	 * Sorts the found series after Release Year in Ascending Order.
	 * 
	 * @return a list of {@link Series}
	 */
	private static List<Series> getListSortedReleaseYearAscending() {
		return SeriesController.getSeriesList().stream().sorted(Comparator.comparing(Series::getReleaseYears))
				.collect(Collectors.toList());
	}

	/**
	 * Sorts the found series after Release Year in Descending Order.
	 * 
	 * @return a list of {@link Series}
	 */
	private static List<Series> getListSortedReleaseYearDescending() {
		return SeriesController.getSeriesList().stream()
				.sorted(Comparator.comparing(Series::getReleaseYears).reversed()).collect(Collectors.toList());
	}
}
