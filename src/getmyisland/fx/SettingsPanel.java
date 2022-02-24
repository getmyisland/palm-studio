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
import javax.swing.border.EmptyBorder;

public class SettingsPanel {
	private static final JPanel settingsPanel = new JPanel();
	
	private static final JLabel sortOrderLabel = new JLabel("Order by ");
	private static final JComboBox<String> sortOrderBox = new JComboBox<>();
	
	private static final JButton saveButton = new JButton("Save");
	private static final JButton reloadButton = new JButton("Reload");
	
	public static JPanel getSettingsPanel() {
		settingsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		settingsPanel.setBackground(new Color(32, 32, 32));

		JPanel contentPanel = new JPanel(new GridBagLayout());
		contentPanel.setBackground(new Color(32, 32, 32));
		contentPanel.setBorder((new EmptyBorder(50, 50, 50, 50)));
		
		GridBagConstraints c = new GridBagConstraints();
		
		// Components to add: save button (save files to properties file), movie and series folder
		// locations and labels that tell the location

		sortOrderLabel.setForeground(Color.WHITE);
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0,0,10,50);
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
		
		saveButton.setFocusPainted(false);
		saveButton.setRolloverEnabled(false);
		saveButton.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	PalmStudio.instance.saveToProperties();
		    }
		});
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(10,0,0,10);
		c.anchor = GridBagConstraints.LINE_START;
		contentPanel.add(saveButton, c);
		
		reloadButton.setFocusPainted(false);
		reloadButton.setRolloverEnabled(false);
		reloadButton.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	PalmStudio.instance.reloadProgram();
		    }
		});
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(10,0,0,10);
		c.anchor = GridBagConstraints.LINE_START;
		contentPanel.add(reloadButton, c);
		
		settingsPanel.add(contentPanel);

		return settingsPanel;
	}
	
	public static void setSortOrderBoxIndex(int selectedIndex) {
		sortOrderBox.setSelectedIndex(selectedIndex);
	}
	
	public static int getSortOrderBoxIndex() {
		return sortOrderBox.getSelectedIndex();
	}
}
