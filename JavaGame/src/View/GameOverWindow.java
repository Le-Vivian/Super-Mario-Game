package View;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameOverWindow implements ActionListener {


	JButton startOverButton;
	JButton quit;
	JLabel bottonsLabel;
	JLabel scoreLabel;
	JFrame frame;
	int score =0;
	UIElements elements;
	Boolean multiplayer = false;;
	
	public  GameOverWindow ( UIElements elements,Boolean multiplayer) {
		this.multiplayer = multiplayer;
		this.elements = elements;
		score = elements.getScore();
		
		frame = new JFrame();
		scoreLabel = new JLabel();
		bottonsLabel = new JLabel();
		startOverButton = new JButton("Start over");
		quit = new JButton("quit");
		
		
		quit.setPreferredSize(new Dimension(100,50));
		quit.addActionListener(this);
        quit.setFocusable(false);
    	
        startOverButton.setPreferredSize(new Dimension(100,50));
  
        startOverButton.addActionListener(this);
        startOverButton.setFocusable(false);
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(420,420);
		frame.setLayout(new FlowLayout(FlowLayout.LEADING,10,10));
        frame.setVisible(true);
        
        
       
    	
        scoreLabel.setPreferredSize(new Dimension(350,200));
       // scoreLabel.setLayout(new FlowLayout());
        scoreLabel.setOpaque(true);
        scoreLabel.setText("Sorry you ran out of lives your current score is " + elements.getScore() );
       
        
        bottonsLabel.setPreferredSize(new Dimension(350,150));
        bottonsLabel.setLayout(new FlowLayout());
        bottonsLabel.setOpaque(true);
        
        
       // bottonsLabel.add(startOverButton);
        bottonsLabel.add(quit);
        
        frame.add(scoreLabel);
        frame.add(bottonsLabel);
        
        
        
     
		
	}
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == quit) {
			if(multiplayer == false) {
				System.exit(0);
				}
			else {
				this.frame.setVisible(false);
			}
		}
		
     
		
	}

}

	
	
	


