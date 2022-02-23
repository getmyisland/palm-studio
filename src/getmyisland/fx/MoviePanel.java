package getmyisland.fx;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
import javax.swing.JScrollPane;

import getmyisland.core.Movie;
import getmyisland.core.MovieController;

public class MoviePanel {
	public static JPanel createMoviePanel() throws IOException {
		JPanel parentMoviePanel = new JPanel(new FlowLayout());
		JPanel moviePanel = new JPanel(new GridLayout(0, 10, 3, 5));
		parentMoviePanel.add(moviePanel);
		
		parentMoviePanel.setBackground(new Color(32, 32, 32));
		moviePanel.setBackground(new Color(32, 32, 32));

		MovieController.listMovies(MovieController.movieRoot);

		// Sort the list
		final List<Movie> sortedMovieList = MovieController.getMovieList().stream()
				.sorted(Comparator.comparing(Movie::getName)).collect(Collectors.toList());

		/*
		 * Sort the list in reverse order
		 * 
		 * List<Movie> reversedSortedMovieList = MovieController.getMovieList().stream()
		 * .sorted(Comparator.comparing(Movie::getName).reversed())
		 * .collect(Collectors.toList());
		 */

		final File root = new File("");

		for (final Movie movie : sortedMovieList) {
			File imageFile = new File(root.getAbsolutePath() + "\\src\\images\\" + movie.getImageName());

			BufferedImage movieCover = null;
			
			if (imageFile.exists()) {
				movieCover = ImageIO.read(imageFile);
			} else {
				movieCover = ImageIO.read(new File(root.getAbsolutePath() + "\\src\\images\\temp.jpg"));
			}
			
			JButton movieButton = new JButton(movie.getName(), new ImageIcon(movieCover));
			movieButton.setMargin(new Insets(0, 0, 0, 0));
			movieButton.setForeground(Color.WHITE);
			movieButton.setContentAreaFilled(false);
			movieButton.setBorderPainted(false);
			movieButton.setFocusPainted(false);
			movieButton.setHorizontalTextPosition(JButton.CENTER);
			movieButton.setVerticalTextPosition(JButton.BOTTOM);
			
			movieButton.addActionListener(new ActionListener() {

			    @Override
			    public void actionPerformed(ActionEvent e) {
			    	System.out.println("You tried to play " + movie.getName());
			    }
			});
			
			moviePanel.add(movieButton);
		}

		return parentMoviePanel;
	}
}
