package getmyisland.fx;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class NavigationBar {
	public static JPanel getNavbar() {
		JPanel navBar = new JPanel();
		navBar.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 20));
		
		JButton movieButton = new JButton("Movies");
		movieButton.setContentAreaFilled(false);
		movieButton.setBorderPainted(false);
		movieButton.setFocusPainted(false);
		
		JButton seriesButton = new JButton("Series");
		seriesButton.setContentAreaFilled(false);
		seriesButton.setBorderPainted(false);
		seriesButton.setFocusPainted(false);
		
		ArrayList<JButton> allButtons = new ArrayList<>();
		allButtons.add(movieButton);
		allButtons.add(seriesButton);
		
		movieButton.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        PalmStudio.instance.setMoviePanelVisible();
		        changeActiveNavButton(allButtons, movieButton);
		    }
		});
		
		seriesButton.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        PalmStudio.instance.setSeriesPanelVisible();
		        changeActiveNavButton(allButtons, seriesButton);
		    }
		});
		
		changeActiveNavButton(allButtons, movieButton);
		
		navBar.add(movieButton);
		navBar.add(seriesButton);
		
		return navBar;
	}
	
	private final static void changeActiveNavButton(ArrayList<JButton> allButtons, JButton whichButton) {
		for(JButton button : allButtons) {
			button.setForeground(Color.WHITE);
		}
		
		whichButton.setForeground(new Color(0, 204, 58)); // Color uses RGB values
	}
}
