package getmyisland.fx;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MoviePanel {
	public static JPanel getMoviePanel() {
		JPanel moviePanel = new JPanel();
		
		moviePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		moviePanel.setBackground(new Color(32, 32, 32));
		
		JLabel temp = new JLabel("Movies !!!");
		moviePanel.add(temp);
		
		return moviePanel;
	}
}
