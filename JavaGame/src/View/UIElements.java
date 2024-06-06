package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.EventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Font;


/**
 * main class to manage the ui elements which will be used in a jlayered pane , will be upgreaded to make the features function
 * @author 
 *
 */
public class UIElements extends JPanel  implements ActionListener{ //implements ActionListener
	
	int lifes = 3;
	int score = 0;
	int time = 0;
	
	
	
	JLabel label1 = new JLabel("<html>life<br> " + lifes +"</html>");
	JLabel label2 = new JLabel("<html>Clock<br>05:00</html>");
	JLabel label3 = new JLabel("<html>Score<br>" + score + "</html>");
	JSlider volume = new JSlider();
	JButton button1 = new JButton("Pause");
	JButton button2 = new JButton("Start");
	JButton button3 = new JButton("Exit");
	JButton button4 = new JButton("How to play");

	Font f  = new Font("MV Boli",  Font.BOLD, 20);

	int elapsedTime = 300000;
    int seconds = 0;
    int minutes = 05;
	String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
	
    
    Timer clock = new Timer(1000, new ActionListener() {
		public void actionPerformed(ActionEvent e){
			elapsedTime -= 1000;
			minutes = (elapsedTime/60000)%60;
			seconds = (elapsedTime/1000)%60;
			String seconds_string = String.format("%02d", seconds);
    		String minutes_string = String.format("%02d", minutes);
			label2.setText(minutes_string+":"+seconds_string);
		}
		
	});

	/**
	 * constructor which sets all the porperties of the ui elements
	 */
	public UIElements(){
		
		
		
		button1.setBounds(550,5,100,50);
		button2.setBounds(450,5,100,50);
		button3.setBounds(650,5,100,50);
		button4.setBounds(290,5,150,50);


		button1.setContentAreaFilled( false );
		button1.setBorder( null );
		button2.setContentAreaFilled( false );
		button2.setBorder( null );
		button3.setContentAreaFilled( false );
		button3.setBorder( null );
		button4.setContentAreaFilled( false );
		button4.setBorder( null );

		button1.setFont(f);
		button2.setFont(f);
		button3.setFont(f);
		button4.setFont(f);
		button1.setForeground(Color.BLACK);
		button2.setForeground(Color.BLACK);
		button3.setForeground(Color.BLACK);
		button4.setForeground(Color.BLACK);
		


		button1.addActionListener(this);
        button2.addActionListener(this);
	    button3.addActionListener(this);
		button4.addActionListener(this);

		volume.setOpaque(true);
		volume.setOrientation(SwingConstants.HORIZONTAL);
		volume.setBounds(10,500,200,50);
		
		label1.setOpaque(false);
		label2.setOpaque(false);
		label3.setOpaque(false);
		
		label1.setBounds(10,5,100,50);
		label2.setBounds(550,5,100,50);
		label3.setBounds(150,5,100,50);

		label1.setFont(f);
		label2.setFont(f);
		label3.setFont(f);
		label2.setText(minutes_string+":"+seconds_string);
		
		button1.setFocusable(false);
		button2.setFocusable(false);
		button3.setFocusable(false);
		button4.setFocusable(false);
		volume.setFocusable(false);
		

		this.setBackground(new Color(0,0,0,0));
		this.setBounds(0,0,760,576);
		this.setLayout(null);
		this.setOpaque(false);

	
		this.add(label1);
		this.add(label2);
		this.add(label3);
		//this.add(volume);
	     //this.add(button1);
		//this.add(button2);
		//this.add(button3);
		this.add(button4);
		clock.start();
		

	}

	public void actionPerformed(ActionEvent e) {
	
		
		
		if(e.getSource()==button1) {
			clock.stop();
		   }
		   else if(e.getSource()==button2) {
			clock.start();;
		   }
		   else if(e.getSource()==button3) {
			clock.stop();
			elapsedTime = 300000;
			seconds = 0;
			minutes = 05;
			String seconds_string = String.format("%02d", seconds);
    		String minutes_string = String.format("%02d", minutes);
			label2.setText(minutes_string+":"+seconds_string);
		   }
		   else if(e.getSource()==button4) {
			InstructionWindow iw = new InstructionWindow(this);
			
			
		   }
		

		}
	
	public int getScore() {
		return score;
	}
	
	public int getLives() {
		return lifes;
	}
	
	public int getTimeInSeconds() {
		return (minutes * 60) + seconds;
	}
	
	
	public void changeScore(int score) {
		this.score = score;
		label3.setText("<html>Score<br>" + score + "</html>");
	}
	
	public void changeLives(int lives) {
		this.lifes = lives;
		label1.setText("<html>life<br> " + lifes +"</html>");
	}
	
		  
    }

	