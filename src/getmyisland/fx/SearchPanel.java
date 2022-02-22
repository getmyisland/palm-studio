package getmyisland.fx;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SearchPanel {
	public static JPanel createSearchPanel() {
		JPanel searchPanel = new JPanel();
		
		searchPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		searchPanel.setBackground(new Color(32, 32, 32));
		
		JLabel temp = new JLabel("Search !!!");
		searchPanel.add(temp);
		
		return searchPanel;
	}
}
