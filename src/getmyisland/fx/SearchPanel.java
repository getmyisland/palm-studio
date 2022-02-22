package getmyisland.fx;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SearchPanel {
	public static JPanel getSearchPanel() {
		JPanel searchPanel = new JPanel();
		
		searchPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		JLabel temp = new JLabel("Search !!!");
		searchPanel.add(temp);
		
		return searchPanel;
	}
}
