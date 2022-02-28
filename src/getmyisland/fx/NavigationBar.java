package getmyisland.fx;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class NavigationBar {
	private static ArrayList<JButton> allButtons = new ArrayList<>();

	private static JButton homeButton;
	private static JButton movieButton;
	private static JButton seriesButton;
	public static JButton searchButton;
	private static JButton settingsButton;
	
	public static JPanel createNavigationBar() {
		JPanel navBar = new JPanel();
		navBar.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 20));
		navBar.setBackground(new Color(25, 25, 25));

		/**
		 * The Button used to navigate to the home page
		 */
		homeButton = new JButton("Home");
		homeButton.setContentAreaFilled(false);
		homeButton.setBorderPainted(false);
		homeButton.setFocusPainted(false);

		/**
		 * The Button used to navigate to the movie page
		 */
		movieButton = new JButton("Movies");
		movieButton.setContentAreaFilled(false);
		movieButton.setBorderPainted(false);
		movieButton.setFocusPainted(false);

		/**
		 * The Button used to navigate to the series page
		 */
		seriesButton = new JButton("Series");
		seriesButton.setContentAreaFilled(false);
		seriesButton.setBorderPainted(false);
		seriesButton.setFocusPainted(false);

		/**
		 * The Button used to navigate to the search page
		 */
		searchButton = new JButton("Search Result");
		searchButton.setContentAreaFilled(false);
		searchButton.setBorderPainted(false);
		searchButton.setFocusPainted(false);

		/**
		 * The Button used to navigate to the settings page
		 */
		settingsButton = new JButton("Settings");
		settingsButton.setContentAreaFilled(false);
		settingsButton.setBorderPainted(false);
		settingsButton.setFocusPainted(false);

		allButtons.add(homeButton);
		allButtons.add(movieButton);
		allButtons.add(seriesButton);
		allButtons.add(searchButton);
		allButtons.add(settingsButton);

		homeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PalmStudio.instance.setCenterPanelVisible(PalmStudio.instance.homePanel);
				changeActiveNavButton(homeButton);
			}
		});

		movieButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PalmStudio.instance.setCenterPanelVisible(PalmStudio.instance.moviePanel);
				changeActiveNavButton(movieButton);
			}
		});

		seriesButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PalmStudio.instance.setCenterPanelVisible(PalmStudio.instance.seriesPanel);
				changeActiveNavButton(seriesButton);
			}
		});

		searchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PalmStudio.instance.setCenterPanelVisible(PalmStudio.instance.searchPanel);
				changeActiveNavButton(searchButton);
			}
		});

		settingsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PalmStudio.instance.setCenterPanelVisible(PalmStudio.instance.settingsPanel);
				changeActiveNavButton(settingsButton);
			}
		});

		// Set the current active button
		changeActiveNavButton(homeButton);

		// Add all the buttons to the navbar
		navBar.add(homeButton);
		navBar.add(movieButton);
		navBar.add(seriesButton);
		navBar.add(searchButton);
		navBar.add(settingsButton);

		return navBar;
	}

	public final static void changeActiveNavButton(JButton whichButton) {
		// Paint all buttons to the standard color
		for (JButton button : allButtons) {
			button.setForeground(Color.WHITE);
		}

		// whichButton.setForeground(new Color(0, 204, 58)); // Light green
		// whichButton.setForeground(new Color(114,188,212)); // Light blue
		whichButton.setForeground(new Color(229, 9, 20)); // Red
	}
}
