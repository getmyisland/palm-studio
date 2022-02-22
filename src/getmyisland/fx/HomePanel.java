package getmyisland.fx;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePanel {
	public static JPanel getHomePanel() {
		JPanel homePanel = new JPanel();
		
		homePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		JLabel temp = new JLabel("Home !!!");
		homePanel.add(temp);
		
		return homePanel;
	}
}
