package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameCompleteWindow implements ActionListener {

  
	JButton startOverButton;
	JButton quit;
	JLabel bottonsLabel;
	JLabel scoreLabel;
	JFrame frame;
	int score =0;
	UIElements elements;
	Boolean multiplayer= false;
	
	
	public  GameCompleteWindow ( UIElements elements, Boolean multiplayer) {
		
		this.elements = elements;
		this.multiplayer = multiplayer;
		score = elements.getScore() + (elements.getTimeInSeconds() * 10) + elements.getLives()* 100;
		
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
        scoreLabel.setText("<html>Congratulations For beating the game your final score is " + score + "<br> current score :  " +elements.getScore() + " +" + "<br> current lives * 100: " +  elements.getLives() * 100 + "  +<br> every remaining second * 10 :  " +elements.getTimeInSeconds() * 10 +"</html>" );
       
        
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

	
	
	


