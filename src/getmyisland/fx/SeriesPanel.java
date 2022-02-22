package getmyisland.fx;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SeriesPanel {
	public static JPanel getSeriesPanel() {
		JPanel seriesPanel = new JPanel();
		
		seriesPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		JLabel temp = new JLabel("Series !!!");
		seriesPanel.add(temp);
		
		return seriesPanel;
	}
}
