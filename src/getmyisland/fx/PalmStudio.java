package getmyisland.fx;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PalmStudio {
	public static PalmStudio instance;
	
	/** The main frame this application runs on */
	private final JFrame frame;
	
	/** The NavigationBar component at the top of the app  */
	private JPanel navigationPanel;
	
	/** The movie component at the center of the app */
	private JPanel moviePanel;
	
	/** The series component at the center of the app */
	private JPanel seriesPanel;
	
	/**
	 * This class is the base structure of the program.
	 */
	public PalmStudio() {
		if(instance == null) {
			instance = this;
		}
		
		frame = new JFrame();
		frame.setLayout(new BorderLayout());

		navigationPanel = NavigationBar.getNavbar();
		frame.add(navigationPanel, BorderLayout.PAGE_START);
		
		moviePanel = MoviePanel.getMoviePanel();
		moviePanel.setVisible(true);
		frame.add(moviePanel, BorderLayout.CENTER);
		
		seriesPanel = SeriesPanel.getSeriesPanel();
		seriesPanel.setVisible(false);
		frame.add(seriesPanel, BorderLayout.CENTER);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Palm Studio");
		frame.pack();
		frame.setVisible(true);
	}
	
	public void setMoviePanelVisible() {
		seriesPanel.setVisible(false);
		moviePanel.setVisible(true);
	}
	
	public void setSeriesPanelVisible() {
		moviePanel.setVisible(false);
		seriesPanel.setVisible(true);
	}
}