package getmyisland.fx;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MoviePanel {
	public static JPanel getMoviePanel() {
		JPanel moviePanel = new JPanel();
		
		moviePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		JLabel temp = new JLabel("Movies !!!");
		moviePanel.add(temp);
		
		return moviePanel;
	}
}
