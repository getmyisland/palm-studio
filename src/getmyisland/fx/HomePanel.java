package getmyisland.fx;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePanel {
	public static JPanel createHomePanel() {
		JPanel homePanel = new JPanel();
		
		homePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		homePanel.setBackground(new Color(32, 32, 32));
		
		JLabel temp = new JLabel("Home !!!");
		homePanel.add(temp);
		
		return homePanel;
	}
}
