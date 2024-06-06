package server;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class serverFrame extends JPanel implements ActionListener{
	
	Boolean noMoreConnection = false;
	ConnectionHandler handler;

	static String protocol ;
	Boolean timeToConnect = false;
	Boolean timeToClose = false;
	int portNum = 0;

	
	JTextField portTextField ;
	JButton connectButton ;
	JButton EndSessionButton ;
	JButton ResultsButton ;
	JCheckBox noMoreConnections ;
	JTextField ServerStatusTextField ;
	JTextArea serverStatusTextArea;
	JFrame frame;
	
	
	public serverFrame(){
		// inner componentns Creation
		portTextField = new JTextField();
		connectButton = new JButton("connect");
		EndSessionButton = new JButton("End");
		ResultsButton = new JButton("results");
		noMoreConnections  = new JCheckBox() ;
		ImageIcon BackgroundImage = new ImageIcon("C:/eclipse workspace/JavaGameServer/bin/images/bowserImage.jpg");
		//idle = ImageIO.read(new File("C:/eclipse workspace/JavaGame/bin/sprites/player/mario_idle.gif"));
		
		
		noMoreConnections.addActionListener(this);
		serverStatusTextArea = new JTextArea(100, 1);
		serverStatusTextArea.setLineWrap(true);
		serverStatusTextArea.setWrapStyleWord(true);
		serverStatusTextArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(serverStatusTextArea); 
		scrollPane.setPreferredSize(new Dimension(600,110));
		
		
		JLabel imageLabel = new JLabel();
		JLabel ButtonsLabel = new JLabel();
		JLabel resultsLabel = new JLabel();
		JLabel portNumberText = new JLabel();
		JLabel disconetIfNoUsersText = new JLabel();

		portNumberText.setText("Port Number :");
		portNumberText.setPreferredSize(new Dimension(80,50));
		portNumberText.setOpaque(true);
		
		 disconetIfNoUsersText.setText("No more connections:");
		 disconetIfNoUsersText.setLayout(new FlowLayout(FlowLayout.LEADING,90,14));
		 disconetIfNoUsersText.setPreferredSize(new Dimension(120,50));
		 disconetIfNoUsersText.setOpaque(true);
		 disconetIfNoUsersText.add( noMoreConnections);
		
		imageLabel.setIcon(BackgroundImage); 
		imageLabel.setPreferredSize(new Dimension(650,200));
		imageLabel.setLayout(new FlowLayout());
		imageLabel.setOpaque(true);
		
		
		ButtonsLabel.setPreferredSize(new Dimension(650,100));
		ButtonsLabel.setLayout(new FlowLayout(FlowLayout.LEADING,10,10));
		ButtonsLabel.setOpaque(true);
		
		
		resultsLabel.setPreferredSize(new Dimension(650,130));
		resultsLabel.setLayout(new FlowLayout());
		resultsLabel.setOpaque(true);
		
		portTextField.addActionListener(this); 
		portTextField.setPreferredSize(new Dimension(100,50));
		
	
	
		
		
		connectButton.addActionListener(this);
		connectButton.setPreferredSize(new Dimension(100,50));
		connectButton.setFocusable(false);
		
		EndSessionButton.addActionListener(this);
		EndSessionButton.setPreferredSize(new Dimension(90,50));
		EndSessionButton.setFocusable(false);
		
		ResultsButton.addActionListener(this);
		ResultsButton.setPreferredSize(new Dimension(100,50));
		ResultsButton.setFocusable(false);
		
		resultsLabel.add(scrollPane );
		ButtonsLabel.add(portNumberText);
		ButtonsLabel.add(portTextField);
		ButtonsLabel.add(connectButton);
		ButtonsLabel.add(ResultsButton);
		ButtonsLabel.add( disconetIfNoUsersText);
		ButtonsLabel.add(EndSessionButton);
		
		
		
		 frame = new JFrame();
		frame.setTitle("Server "); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false); 
		frame.add(imageLabel);
		frame.add(ButtonsLabel);
		frame.add(resultsLabel);
		frame.setSize(700,500);  
			
		frame.setVisible(true); 
		frame.setLayout(new FlowLayout(FlowLayout.LEADING,10,10));
		
		
		
	}


	public String getMessage() {
		return protocol;
	}
	public void setMessage(String message) {
		this.protocol = message;
	}
	

	public Boolean getTimeToConnect() {
		return timeToConnect;
	}


	public void setTimeToConnect(Boolean b ) {
		this.timeToConnect = b;
	}
	
	public int getPortNum() {
		return portNum;
	}
	public Boolean getTimeToClose() {
		return  timeToClose;
	}


	public void setportNum(int num) {
		this.portNum = num;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	if(e.getSource() == connectButton) {
		
		serverStatusTextArea.setText(serverStatusTextArea.getText() + "\n you have created a server at port num " + portTextField.getText());
		portNum = Integer.parseInt(portTextField.getText()) ;
		timeToConnect = true;
	}
	
	if(e.getSource() == EndSessionButton) {
		
		
		System.exit(0);
		
		
		
	}
	
	if( e.getSource()  == noMoreConnections) {
		
		
		noMoreConnection = true;
		
		
		
	}
	if(e.getSource() == ResultsButton) {
		if(handler.getScoreBank().get(0) == null) {
		
			serverStatusTextArea.setText(serverStatusTextArea.getText() + "\n there are no scores to print ");
			
		}
		else {
		
			String s = " ";
			for(int i = 0 ;i <handler.getScoreBank().size(); i++) {
				
				
				if(handler.getScoreBank().get(i) == null) {
					break;
				}
				else {
					s = s + "\n " + handler.getScoreBank().get(i);
					
				}
			}
			serverStatusTextArea.setText(s);
		}
		
	}
	
		
	}
	public Boolean getNoMoeConnection( ) {
		return noMoreConnection;
	}
	
	public void passConnectionHandler(ConnectionHandler handler) {
		this.handler = handler;
	}
	
	
	
	
	
}
