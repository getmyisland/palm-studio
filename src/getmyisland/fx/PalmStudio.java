package getmyisland.fx;

import javax.swing.JFrame;

public class PalmStudio {
	private final JFrame frame;
	
	/**
	 * This class is the base structure of the program.
	 */
	public PalmStudio() {
		frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Palm Studio");
		frame.pack();
		frame.setVisible(true);
	}
}