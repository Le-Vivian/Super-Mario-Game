package View;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class MainFrame {
int mapNum =1;
Boolean multiplayer = false;
private GamePanel panel ;
JFrame frame;
	public MainFrame(int mapNum, Boolean multiplayer ) {
		this.mapNum = mapNum;
		this.multiplayer = multiplayer;
		JLayeredPane pane = new JLayeredPane();
		UIElements ui = new UIElements();
		panel = new GamePanel(ui,mapNum,multiplayer);

        pane.setLayout(null);
        pane.setPreferredSize(new Dimension(760,576));

		 frame  = new JFrame("Mario Bros Overworld 1-1 recreation by Justin Charette and Thi Thanh Van Le");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(new Dimension(760,576));
		frame.setLayout(new FlowLayout());

		pane.add(panel, JLayeredPane.DEFAULT_LAYER);
	
		pane.add(ui, JLayeredPane.DRAG_LAYER);
		frame.add(pane);
		
		panel.startGameThread();
		
		frame.pack();
		frame.setLocationRelativeTo(null); // must be called after pack to work
		
		frame.setVisible(true);
		
		
		
	}
	public GamePanel  getFrame() {
		return panel;
	}
	
	
	public void turnoffScreen(Boolean b) {
		if (b == true) {
			frame.dispose();
		}
	}
	
	
	
	
	
}
