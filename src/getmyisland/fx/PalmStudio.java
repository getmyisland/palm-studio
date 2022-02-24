package getmyisland.fx;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import javax.swing.JFileChooser;
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
	public JPanel searchPanel;

	/** The settings component at the center of the app */
	public final JPanel settingsPanel;

	/** The projects document file path in the default document directory */
	private final String projectDocumentFilePath = new JFileChooser().getFileSystemView().getDefaultDirectory().toString() + "/GetMyIsland/PalmStudio";
	private final File propFolder = new File(projectDocumentFilePath);
	
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

		settingsPanel = SettingsPanel.getSettingsPanel();
		
		readFromProperties();
		
		// Search for movies
		MovieController.listMovies(MovieController.movieRoot);

		navigationPanel = NavigationBar.createNavigationBar();
		frame.getContentPane().add(navigationPanel, BorderLayout.PAGE_START);

		homePanel = HomePanel.createHomePanel();
		frame.getContentPane().add(homePanel, BorderLayout.CENTER);

		moviePanel = MoviePanel.createMoviePanel(SettingsPanel.getSortOrderBoxIndex());
		seriesPanel = SeriesPanel.createSeriesPanel();
		searchPanel = SearchPanel.createSearchPanel();

		frame.setPreferredSize(new Dimension(1920, 1080));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Palm Studio");
		frame.pack();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
	}

	/**
	 * Removes all center content and sets {@code whichPanel} as the center panel.
	 * 
	 * @param whichPanel
	 */
	public void setCenterPanelVisible(JPanel whichPanel) {
		// Remove all components
		frame.getContentPane().removeAll();

		// Add the navbar again
		frame.getContentPane().add(navigationPanel, BorderLayout.PAGE_START);

		if (whichPanel == moviePanel) {
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
		frame.revalidate();
		frame.repaint();
	}

	public void reloadProgram() {
		moviePanel = MoviePanel.createMoviePanel(SettingsPanel.getSortOrderBoxIndex());
		seriesPanel = SeriesPanel.createSeriesPanel();
		searchPanel = SearchPanel.createSearchPanel();

		frame.revalidate();
		frame.repaint();
	}

	private void readFromProperties() {
		System.out.println("Reading properties.");
		Properties prop = new Properties();
		
		propFolder.mkdir(); // Check if the directory exists if not create it
		final File propFile = new File(propFolder + "/user.properties"); // The properties file
		
		if(!propFile.exists()) {
			createDefaultProperties(propFile);
		}
		
		try(FileInputStream inputStream = new FileInputStream(propFile)) {
			prop.load(inputStream); // Load the input stream
			
			SettingsPanel.setSortOrderBoxIndex(Integer.parseInt(prop.getProperty("SortOrderIndex")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void createDefaultProperties(final File propFile) {
		System.out.println("Creating a file with the default settings.");
		
		Properties prop = new Properties();
		
		try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(propFile), StandardCharsets.UTF_8)) {
			prop.setProperty("SortOrderIndex", "0"); // Set it to zero the default value
			
			prop.store(writer, null); // Store the properties in a file
			readFromProperties();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void saveToProperties() {
		System.out.println("Saving settings to properties.");
		Properties prop = new Properties();
		
		propFolder.mkdir(); // Check if the directory exists if not create it
		final File propFile = new File(propFolder + "/user.properties"); // The properties file
		
		try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(propFile), StandardCharsets.UTF_8)) {
			prop.setProperty("SortOrderIndex", Integer.toString(SettingsPanel.getSortOrderBoxIndex()));
			
			prop.store(writer, null); // Store the properties in a file
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}