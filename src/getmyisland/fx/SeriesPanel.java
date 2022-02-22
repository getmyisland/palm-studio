package getmyisland.fx;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SeriesPanel {
	public static JPanel createSeriesPanel() {
		JPanel seriesPanel = new JPanel();
		
		seriesPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		seriesPanel.setBackground(new Color(32, 32, 32));
		
		JLabel temp = new JLabel("Series !!!");
		seriesPanel.add(temp);
		
		return seriesPanel;
	}
}
