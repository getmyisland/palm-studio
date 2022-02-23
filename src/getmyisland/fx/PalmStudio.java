package getmyisland.fx;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import getmyisland.core.MovieController;

public class PalmStudio {
	public static PalmStudio instance;

	/** The main frame this application runs on */
	private final JFrame frame;

	/** The NavigationBar component at the top of the app */
	private final JPanel navigationPanel;

	/** The movie component at the center of the app */
	public final JPanel homePanel;

	/** The movie component at the center of the app */
	public JPanel moviePanel;

	/** The series component at the center of the app */
	public JPanel seriesPanel;

	/** The movie component at the center of the app */
	public final JPanel searchPanel;

	public final JPanel settingsPanel;

	/**
	 * This class is the base structure of the program.
	 */
	public PalmStudio() {
		if (instance == null) {
			instance = this;
		}

		frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setBackground(new Color(32, 32, 32));

		// Search for movies
		MovieController.listMovies(MovieController.movieRoot);
		
		navigationPanel = NavigationBar.createNavigationBar();
		//frame.add(navigationPanel, BorderLayout.PAGE_START);
		frame.getContentPane().add(navigationPanel, BorderLayout.PAGE_START);
		
		homePanel = HomePanel.createHomePanel();
		//frame.add(homePanel, BorderLayout.CENTER);
		frame.getContentPane().add(homePanel, BorderLayout.CENTER);

		moviePanel = MoviePanel.createMoviePanel(1);
		seriesPanel = SeriesPanel.createSeriesPanel();
		searchPanel = SearchPanel.createSearchPanel();
		settingsPanel = SettingsPanel.getSettingsPanel();

		frame.setPreferredSize(new Dimension(1920, 1080));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Palm Studio");
		frame.pack();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
	}

	public void setPanelVisible(JPanel whichPanel) {
		// Remove all components
		frame.getContentPane().removeAll();

		// Add the navbar again
		frame.getContentPane().add(navigationPanel, BorderLayout.PAGE_START);
		if(whichPanel == moviePanel) {
			//frame.add(new JScrollPane(moviePanel), BorderLayout.CENTER);
			JScrollPane scrollPane = new JScrollPane(moviePanel);
			scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
			scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
			scrollPane.getVerticalScrollBar().setUnitIncrement(22);
			
			frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
			frame.revalidate();
			frame.repaint();
			return;
		}
		
		frame.getContentPane().add(whichPanel, BorderLayout.CENTER);
		//frame.add(whichPanel, BorderLayout.CENTER);
		frame.revalidate();
		frame.repaint();
	}
}