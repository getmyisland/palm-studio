package getmyisland.fx;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class NavigationBar {
	public static JPanel getNavbar() {
		JPanel navBar = new JPanel();
		navBar.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 20));
		
		/**
		 * The Button used to navigate to the home page
		 */
		JButton homeButton = new JButton("Home");
		homeButton.setContentAreaFilled(false);
		homeButton.setBorderPainted(false);
		homeButton.setFocusPainted(false);
		
		/**
		 * The Button used to navigate to the movie page
		 */
		JButton movieButton = new JButton("Movies");
		movieButton.setContentAreaFilled(false);
		movieButton.setBorderPainted(false);
		movieButton.setFocusPainted(false);
		
		/**
		 * The Button used to navigate to the series page
		 */
		JButton seriesButton = new JButton("Series");
		seriesButton.setContentAreaFilled(false);
		seriesButton.setBorderPainted(false);
		seriesButton.setFocusPainted(false);
		
		/**
		 * The Button used to navigate to the search page
		 */
		JButton searchButton = new JButton("Search");
		searchButton.setContentAreaFilled(false);
		searchButton.setBorderPainted(false);
		searchButton.setFocusPainted(false);
		
		ArrayList<JButton> allButtons = new ArrayList<>();
		allButtons.add(homeButton);
		allButtons.add(movieButton);
		allButtons.add(seriesButton);
		allButtons.add(searchButton);
		
		homeButton.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        PalmStudio.instance.setPanelVisible(PalmStudio.instance.homePanel);
		        changeActiveNavButton(allButtons, homeButton);
		    }
		});
		
		movieButton.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	PalmStudio.instance.setPanelVisible(PalmStudio.instance.moviePanel);
		        changeActiveNavButton(allButtons, movieButton);
		    }
		});
		
		seriesButton.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	PalmStudio.instance.setPanelVisible(PalmStudio.instance.seriesPanel);
		        changeActiveNavButton(allButtons, seriesButton);
		    }
		});
		
		searchButton.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	PalmStudio.instance.setPanelVisible(PalmStudio.instance.searchPanel);
		        changeActiveNavButton(allButtons, searchButton);
		    }
		});
		
		changeActiveNavButton(allButtons, homeButton);
		
		navBar.add(homeButton);
		navBar.add(movieButton);
		navBar.add(seriesButton);
		navBar.add(searchButton);
		
		return navBar;
	}
	
	private final static void changeActiveNavButton(ArrayList<JButton> allButtons, JButton whichButton) {
		// Paint all buttons to the standard color
		for(JButton button : allButtons) {
			button.setForeground(Color.WHITE);
		}
		
		whichButton.setForeground(new Color(0, 204, 58)); // Color uses RGB values
	}
}
