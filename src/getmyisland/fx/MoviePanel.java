package getmyisland.fx;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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

public class MoviePanel {
	public static JPanel createMoviePanel() {
		JPanel moviePanel = new JPanel();
		
		GridLayout layout = new GridLayout(0, 6);
		layout.setHgap(5);
		layout.setVgap(5);
		moviePanel.setLayout(layout);
		moviePanel.setBackground(new Color(32, 32, 32));
		
		MovieController.listMovies(MovieController.movieRoot);

		// Sort the list
		final List<Movie> sortedMovieList = MovieController.getMovieList().stream()
				  .sorted(Comparator.comparing(Movie::getName))
				  .collect(Collectors.toList());
		
		/*
		 * Sort the list in reverse order
		 * 
		List<Movie> reversedSortedMovieList = MovieController.getMovieList().stream()
				  .sorted(Comparator.comparing(Movie::getName).reversed())
				  .collect(Collectors.toList());
		*/
		
		final File root = new File("");
		System.out.println(root.getAbsolutePath() + "\\src\\images\\temp.jpg");
		for(final Movie movie : sortedMovieList) {
			JLabel picLabel = new JLabel();
			
			try {
				File imageFile = new File(root.getAbsolutePath() + "\\src\\images\\" + movie.getImageName());
				
				if(imageFile.exists()) {
					BufferedImage movieCover = ImageIO.read(imageFile);
					picLabel = new JLabel(new ImageIcon(movieCover));
				} else {
					BufferedImage movieCover = ImageIO.read(new File(root.getAbsolutePath() + "\\src\\images\\temp.jpg"));
					picLabel = new JLabel(new ImageIcon(movieCover));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			JLabel movieName = new JLabel(movie.getName());
			movieName.setForeground(Color.WHITE);;
			
			JButton movieButton = new JButton();
			movieButton.setLayout(new GridLayout(0, 1));
			//movieButton.setContentAreaFilled(false);
			//movieButton.setBorderPainted(false);
			//movieButton.setFocusPainted(false);
			
			movieButton.add(picLabel);
			movieButton.add(movieName);
			
			moviePanel.add(movieButton);
		}
		
		return moviePanel;
	}
}
