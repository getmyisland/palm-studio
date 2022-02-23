package getmyisland.fx;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

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

	/** An arraylist that holds every panel */
	private ArrayList<JPanel> allPanels = new ArrayList<JPanel>();

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

		navigationPanel = NavigationBar.createNavigationBar();
		frame.add(navigationPanel, BorderLayout.PAGE_START);
		
		homePanel = HomePanel.createHomePanel();
		frame.add(homePanel, BorderLayout.CENTER);

		moviePanel = MoviePanel.createMoviePanel();
		seriesPanel = SeriesPanel.createSeriesPanel();
		searchPanel = SearchPanel.createSearchPanel();
		settingsPanel = SettingsPanel.getSettingsPanel();
		
		allPanels.add(homePanel);
		allPanels.add(moviePanel);
		allPanels.add(seriesPanel);
		allPanels.add(searchPanel);
		allPanels.add(settingsPanel);

		frame.setPreferredSize(new Dimension(1920, 1080));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Palm Studio");
		frame.pack();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
	}

	public void setPanelVisible(JPanel whichPanel) {
		for (JPanel panel : allPanels) {
			frame.remove(panel);
		}

		frame.add(whichPanel, BorderLayout.CENTER);
		frame.revalidate();
		frame.repaint();
	}
}