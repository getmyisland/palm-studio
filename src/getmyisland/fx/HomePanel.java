package getmyisland.fx;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import getmyisland.core.MovieController;
import getmyisland.core.SeriesController;


public class HomePanel {
	private static JPanel homePanel;
	
	private static JLabel countLabel;
	
	public static JPanel createHomePanel() {
		homePanel = new JPanel();
		
		homePanel.setLayout(new GridBagLayout());
		homePanel.setBackground(new Color(32, 32, 32));
		
		countLabel = new JLabel();
		countLabel.setForeground(Color.WHITE);
		countLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 32));
		countLabel.setText("Welcome to Palm Studio!" + " " + "You have " + MovieController.getMovieList().size() + " Movies and " + SeriesController.getSeriesList().size() + " Series!");
		
		homePanel.add(countLabel);
		
		return homePanel;
	}
}
