package getmyisland.fx;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SettingsPanel {
	public static JPanel getSettingsPanel() {
		JPanel settingsPanel = new JPanel();
		
		settingsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		settingsPanel.setBackground(new Color(32, 32, 32));
		
		JLabel temp = new JLabel("Settings !!!");
		settingsPanel.add(temp);
		
		return settingsPanel;
	}
}
