package getmyisland.fx;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class NavigationBar {
	public static JPanel getNavbar() {
		JPanel navBar = new JPanel();
		navBar.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		JButton movieButton = new JButton("Movies");
		movieButton.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        PalmStudio.instance.setMoviePanelVisible();
		    }
		});
		
		JButton seriesButton = new JButton("Series");
		seriesButton.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        PalmStudio.instance.setSeriesPanelVisible();
		    }
		});
		
		navBar.add(movieButton);
		navBar.add(seriesButton);
		
		return navBar;
	}
}
