package getmyisland.fx;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SettingsPanel {
	private static final JPanel settingsPanel = new JPanel();
	private static final JPanel contentPanel = new JPanel();
	
	private static final JLabel sortOrderLabel = new JLabel("Order by: ");
	private static final JComboBox<String> sortOrderBox = new JComboBox<>();
	
	private static final JLabel selectMoviePathLabel = new JLabel("Movie folder Path: ");
	private static final JTextField moviePath = new JTextField();
	private static final JLabel currentMoviePathLabel = new JLabel("Current Movie Path: ");
	private static final JLabel currentMoviePath = new JLabel("");
	
	private static final JLabel selectSeriesPathLabel = new JLabel("Series folder Path: ");
	private static final JTextField seriesPath = new JTextField();
	private static final JLabel currentSeriesPathLabel = new JLabel("Current Series Path: ");
	private static final JLabel currentSeriesPath = new JLabel("");
	
	private static final JTextField searchField = new JTextField();
	private static final JButton submitSearch = new JButton("Search");
	
	private static final JButton saveButton = new JButton("Save and Reload");
	
	public static JPanel getSettingsPanel() {
		settingsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		settingsPanel.setBackground(new Color(32, 32, 32));

		contentPanel.setLayout(new GridBagLayout());
		contentPanel.setBackground(new Color(32, 32, 32));
		contentPanel.setBorder((new EmptyBorder(50, 50, 50, 50)));
		
		GridBagConstraints c = new GridBagConstraints();
		
		/** Sort Order Settings */
		
		sortOrderLabel.setForeground(Color.WHITE);
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0,0,30,80);
		c.anchor = GridBagConstraints.LINE_START;
		contentPanel.add(sortOrderLabel, c);
		
		sortOrderBox.addItem(new String("Name Ascending"));
		sortOrderBox.addItem(new String("Name Descending"));
		sortOrderBox.addItem(new String("Year Ascending"));
		sortOrderBox.addItem(new String("Year Descending"));
		c.gridx = 1;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		contentPanel.add(sortOrderBox, c);
		
		/** Movie Path Settings */
		
		selectMoviePathLabel.setForeground(Color.WHITE);
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(0,0,15,80);
		c.anchor = GridBagConstraints.LINE_START;
		contentPanel.add(selectMoviePathLabel, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LINE_START;
		contentPanel.add(moviePath, c);
		
		currentMoviePathLabel.setForeground(Color.WHITE);
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(0,0,30,80);
		c.anchor = GridBagConstraints.LINE_START;
		contentPanel.add(currentMoviePathLabel, c);
		
		currentMoviePath.setForeground(Color.WHITE);
		c.gridx = 1;
		c.gridy = 2;
		c.anchor = GridBagConstraints.LINE_START;
		contentPanel.add(currentMoviePath, c);
		
		/** Series Path Settings */
		
		selectSeriesPathLabel.setForeground(Color.WHITE);
		c.gridx = 0;
		c.gridy = 3;
		c.insets = new Insets(0,0,15,80);
		c.anchor = GridBagConstraints.LINE_START;
		contentPanel.add(selectSeriesPathLabel, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 3;
		c.anchor = GridBagConstraints.LINE_START;
		contentPanel.add(seriesPath, c);
		
		currentSeriesPathLabel.setForeground(Color.WHITE);
		c.gridx = 0;
		c.gridy = 4;
		c.insets = new Insets(0,0,30,80);
		c.anchor = GridBagConstraints.LINE_START;
		contentPanel.add(currentSeriesPathLabel, c);
		
		currentSeriesPath.setForeground(Color.WHITE);
		c.gridx = 1;
		c.gridy = 4;
		c.anchor = GridBagConstraints.LINE_START;
		contentPanel.add(currentSeriesPath, c);
		
		/** Search Field */
		
		submitSearch.setFocusPainted(false);
		submitSearch.setRolloverEnabled(false);
		submitSearch.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	System.out.println("You searched for " + searchField.getText());
		    	PalmStudio.instance.search(searchField.getText());
		    	searchField.setText("");
		    }
		});
		c.gridx = 0;
		c.gridy = 5;
		c.insets = new Insets(0,0,30,80);
		c.anchor = GridBagConstraints.LINE_START;
		contentPanel.add(submitSearch, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 5;
		c.anchor = GridBagConstraints.LINE_START;
		contentPanel.add(searchField, c);
		
		/** Save and Reload Button */
		
		saveButton.setFocusPainted(false);
		saveButton.setRolloverEnabled(false);
		saveButton.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	System.out.println("You searched for " + searchField.getText());
		    	PalmStudio.instance.search(searchField.getText());
		    	searchField.setText("");
		    }
		});
		c.gridx = 0;
		c.gridy = 6;
		c.insets = new Insets(0,0,0,50);
		c.anchor = GridBagConstraints.LINE_START;
		contentPanel.add(saveButton, c);
		
		settingsPanel.add(contentPanel);

		return settingsPanel;
	}
	
	public static void setSortOrderBoxIndex(int selectedIndex) {
		sortOrderBox.setSelectedIndex(selectedIndex);
	}
	
	public static int getSortOrderBoxIndex() {
		return sortOrderBox.getSelectedIndex();
	}
	
	public static void setCurrentMoviePathLabel(String currentMoviePathString) {
		currentMoviePath.setText(currentMoviePathString);
	}
	
	public static String getCurrentMoviePathLabelText() {
		return currentMoviePath.getText();
	}
	
	public static JTextField getMoviePathTextField() {
		return moviePath;
	}
	
	public static void setCurrentSeriesPathLabel(String currentSeriesPathString) {
		currentSeriesPath.setText(currentSeriesPathString);
	}
	
	public static String getCurrentSeriesPathLabelText() {
		return currentSeriesPath.getText();
	}
	
	public static JTextField getSeriesPathTextField() {
		return seriesPath;
	}
}
