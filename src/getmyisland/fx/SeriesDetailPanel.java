package getmyisland.fx;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import getmyisland.core.Episode;
import getmyisland.core.Series;

public class SeriesDetailPanel {
	public static JPanel createSeriesDetailPanel(Series series) {
		JPanel seriesDetailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 25, 25));
		seriesDetailPanel.setBackground(new Color(32, 32, 32));
		JPanel contentPanel = new JPanel(new GridBagLayout());
		contentPanel.setBackground(new Color(32, 32, 32));
		GridBagConstraints c = new GridBagConstraints();

		JLabel seriesTitleLabel = new JLabel(series.getName());
		seriesTitleLabel.setForeground(Color.WHITE);
		seriesTitleLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 24));
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0, 0, 30, 0);
		c.anchor = GridBagConstraints.LINE_START;
		contentPanel.add(seriesTitleLabel, c);
		
		int rowCount = 0;
		
		// Go trough each season
		for (int i = 1; i <= series.getSeasonNumber(); i++) {
			rowCount = i * 2;
			
			JLabel seasonLabel = new JLabel("Season " + (i) + ":");
			seasonLabel.setForeground(Color.WHITE);
			c.gridx = 0;
			c.gridy = rowCount - 1;
			c.insets = new Insets(0, 0, 20, 0);
			c.anchor = GridBagConstraints.LINE_START;
			contentPanel.add(seasonLabel, c);
			
			JPanel seasonPanel = new JPanel(new GridLayout(0, 5, 5, 5));
			seasonPanel.setBackground(new Color(32, 32, 32));
			
			int episodeNumber = 1;
			
			// Go trough each episode
			for(Episode episode : series.getEpisodes()) {
				if(episode.getSeasonNumber() == i) {
					// Episode is in the current season
					if(episode.getEpisodeNumber() == episodeNumber) {
						JButton episodeButton = new JButton(episode.getEpisodeNumber() + ": " + episode.getEpisodeName());
						episodeButton.setFocusPainted(false);
						episodeButton.setRolloverEnabled(false);
						episodeButton.setForeground(Color.BLACK);
						episodeButton.setHorizontalAlignment(SwingConstants.LEFT);
						episodeButton.setPreferredSize(new Dimension(225, 25));
						episodeButton.addActionListener(new ActionListener() {
						    @Override
						    public void actionPerformed(ActionEvent e) {
						    	try {
									Desktop.getDesktop().open(new File(episode.getEpisodeFilePath()));
								} catch (IOException e1) {
									e1.printStackTrace();
								}
						    }
						});
						episodeButton.setToolTipText(episode.getEpisodeName());
						
						episodeNumber++;
						seasonPanel.add(episodeButton);
					}
				}
			}
			
			c.gridx = 0;
			c.gridy = rowCount;
			c.insets = new Insets(0, 0, 20, 0);
			c.anchor = GridBagConstraints.LINE_START;
			contentPanel.add(seasonPanel, c);
		}

		seriesDetailPanel.add(contentPanel);
		return seriesDetailPanel;
	}
}
