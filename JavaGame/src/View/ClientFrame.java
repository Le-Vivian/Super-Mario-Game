package View;


	import java.awt.Color;
	import java.awt.Dimension;
	import java.awt.FlowLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JCheckBox;
	import javax.swing.JComboBox;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.JScrollPane;
	import javax.swing.JTextArea;
	import javax.swing.JTextField;

	public class ClientFrame extends JPanel implements ActionListener{
		// instance var
		
		private int mapNum =1;
		private String protocol = "a new User has connected ";
		private String[] mapOptions = { "map 1", "map 2" };
		private JComboBox comboBox = new JComboBox(mapOptions); 
		private int Score =-1;
		
		// booleans for flags
		public Boolean timeToSend = false;
		public Boolean timeToRecieve = false;
		private Boolean timeToConnect = false;
		private Boolean timeToDisconect = false;
		private Boolean singlePLayer = false;
		private Boolean multiplayer = false;
		
		// parameters to be passed around 
		private String username = " ";
		private String host = " ";
		private int portNum =0;
		
		
		public JFrame frame;
	
		JTextField userNameTextField ;
		JButton connectButton ;
		JButton EndSessionButton ;
		JButton newGameButton ;
		JButton sendGameButton ;
		JButton selectGameButton ;
		JButton recieveGameButton ;
		JButton playGameButton ;
		JCheckBox exitWhenNoConnectionBox ;
		JTextField ServerStatusTextField ;
		public JTextArea serverStatusTextArea;
		JTextField ServerTextField ;
		JTextField portNumTextField  ;
		
		
		
		public ClientFrame(){
			// inner componentns Creation
			userNameTextField  = new JTextField();
			ServerTextField  = new JTextField();
			portNumTextField  = new JTextField();
			connectButton = new JButton("connect");
			EndSessionButton = new JButton("End");
			newGameButton = new JButton("new game");
			sendGameButton = new JButton("send game");
			selectGameButton = new JButton("select map");
			recieveGameButton  = new JButton("recieve game");
			playGameButton  = new JButton("Single player");
			
			ImageIcon BackgroundImage = new ImageIcon("images/marioImage.jpg");
			
			
			//scroll pane ------------------------------------------ 
			serverStatusTextArea = new JTextArea(100, 1);
			serverStatusTextArea.setLineWrap(true);
			serverStatusTextArea.setWrapStyleWord(true);
			serverStatusTextArea.setEditable(false);
			JScrollPane scrollPane = new JScrollPane(serverStatusTextArea); 
			scrollPane.setPreferredSize(new Dimension(600,110));
	//-------------------------------------------------------------------------------------		
			//jLabel creation
			JLabel imageLabel = new JLabel();
			JLabel ButtonsLabel = new JLabel();
			JLabel resultsLabel = new JLabel();
			JLabel usernameText = new JLabel();
			JLabel serverText = new JLabel();
			JLabel portNumberText = new JLabel();
		
			
			

			usernameText.setText("Username :");
			usernameText.setPreferredSize(new Dimension(80,50));
			usernameText.setOpaque(true);
			
			serverText.setText("Server :");
			serverText.setPreferredSize(new Dimension(60,50));
			serverText.setOpaque(true);
			
			portNumberText.setText("Port :");
			portNumberText.setPreferredSize(new Dimension(60,50));
			portNumberText.setOpaque(true);
			
			
			
		
			
			imageLabel.setIcon(BackgroundImage); 
			imageLabel.setPreferredSize(new Dimension(650,200));
			imageLabel.setLayout(new FlowLayout());
			imageLabel.setOpaque(true);
			
		
			ButtonsLabel.setPreferredSize(new Dimension(650,175));
			ButtonsLabel.setLayout(new FlowLayout(FlowLayout.LEADING,10,10));
			ButtonsLabel.setOpaque(true);
			
			
			resultsLabel.setPreferredSize(new Dimension(650,130));
			resultsLabel.setLayout(new FlowLayout());
			resultsLabel.setOpaque(true);
	//------------------------------------------------------------------------
			//textFields
			userNameTextField .addActionListener(this); 
			userNameTextField .setPreferredSize(new Dimension(100,50));
			
			ServerTextField.addActionListener(this); 
			ServerTextField.setPreferredSize(new Dimension(100,50));
			
			portNumTextField .addActionListener(this); 
			portNumTextField .setPreferredSize(new Dimension(100,50));
			 
			//  j buttons -------------------------------------------------------------------------------------------------------------------------
			
		 
			EndSessionButton.addActionListener(this);
			EndSessionButton.setPreferredSize(new Dimension(80,50));
			EndSessionButton.setFocusable(false);
			
			connectButton.addActionListener(this);
			connectButton.setPreferredSize(new Dimension(80,50));
			connectButton.setFocusable(false);
			
			newGameButton.addActionListener(this);
			newGameButton.setPreferredSize(new Dimension(95,50));
			newGameButton.setFocusable(false);
			
			sendGameButton.addActionListener(this);
			sendGameButton.setPreferredSize(new Dimension(100,50));
			//sendGameButton.setFocusable(false);
			
			selectGameButton.addActionListener(this);
			selectGameButton.setPreferredSize(new Dimension(100,50));
			selectGameButton.setFocusable(false);
			
			recieveGameButton.addActionListener(this);
			recieveGameButton.setPreferredSize(new Dimension(120,50));
			recieveGameButton.setFocusable(false);
			
			playGameButton .addActionListener(this);
			playGameButton .setPreferredSize(new Dimension(95,50));
			playGameButton .setFocusable(false);
			
			
		//--------------------------------------------------------------------------
			
			// adding componets to labels
			resultsLabel.add(scrollPane );
			ButtonsLabel.add(usernameText);
			ButtonsLabel.add(userNameTextField );
			ButtonsLabel.add(serverText);
			ButtonsLabel.add(ServerTextField);
			ButtonsLabel.add(portNumberText);
			ButtonsLabel.add(portNumTextField);
		
			ButtonsLabel.add(EndSessionButton);
			ButtonsLabel.add(connectButton);
			ButtonsLabel.add(newGameButton);
			ButtonsLabel.add(sendGameButton);
			ButtonsLabel.add(selectGameButton);
			ButtonsLabel.add(recieveGameButton);
			ButtonsLabel.add(playGameButton);
			
			
			
			
			// -------------------------------------------------------------------------------------------------
			//jframe methods
			 frame = new JFrame();
			frame.setTitle("Client "); 
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false); 
			frame.add(imageLabel);
			frame.add(ButtonsLabel);
			frame.add(resultsLabel);
			frame.setSize(700,600);  
				
			frame.setVisible(true); 
			frame.setLayout(new FlowLayout(FlowLayout.LEADING,10,10));
			
			
			
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == recieveGameButton) {
				
				if(timeToConnect == true) {
				setMessage("#4");
				this.timeToSend = true;
					
					serverStatusTextArea.setText(serverStatusTextArea.getText()+ " \n waiting for map num , current map set to " + getMapNum() );
					//this.timeToRecieve = true;
				}
				
			}
			
			if(e.getSource() == sendGameButton ) {
				// makes it that only if a connection is made you can send map
				
				
				if(timeToConnect == true) {
		//		System.out.println( getMessage());
				//this.timeToRecieve = false;
				serverStatusTextArea.setText(serverStatusTextArea.getText()+ " \n you have sent map num " + getMapNum() );
				setMessage( "#2 " +getUsername() +" "+getMapNum() );
			   
		      
				this.timeToSend = true;
			
		

	}			
			}
			
			
			
			
			
		if (e.getSource() ==selectGameButton ) {
			
		
		JOptionPane.showMessageDialog(null, comboBox, "Select map",JOptionPane.QUESTION_MESSAGE);
		 
		String answer = (String) comboBox.getSelectedItem(); 
		
		if(answer.equals("map 1")) {
			setMapNum(1);
			serverStatusTextArea.setText(serverStatusTextArea.getText()+ " \n Map set to map 1");
			
		}
		if(answer.equals("map 2")) {
			setMapNum(2);
			serverStatusTextArea.setText(serverStatusTextArea.getText()+ " \n Map set to map 2");
		}
	
//			 
			
		}
		
		if(e.getSource() == EndSessionButton) {
			setMessage("#5");
			this.timeToSend = true;
			timeToDisconect = true;
			
			
		}
		if(e.getSource() == connectButton) {
			
			username = userNameTextField.getText();
			host =  ServerTextField.getText();
			portNum = Integer.parseInt(portNumTextField.getText()) ;
			
			serverStatusTextArea.setText(serverStatusTextArea.getText()+ " \n you have connected to the server");
			timeToSend = true;
			timeToConnect = true;
			
			
			
		}
		
		if(e.getSource() == playGameButton) {
		
		
			singlePLayer = true;
		
		}
		
		if(e.getSource( ) == newGameButton) {
			multiplayer = true;
		}
		
	
		
		
		

		
		
			
		}// end of actionEvent


		public int getMapNum() {
			return mapNum;
		}


		public void setMapNum(int mapNum) {
			this.mapNum = mapNum;
		}


		public String getMessage() {
			return protocol;
		}
		
		public void setMessage(String s ) {
			this.protocol = s;
		}


		public Boolean getTimeToSend() {
			return timeToSend;
		}


		public void setTimeToSend(Boolean timeToSend) {
			this.timeToSend = timeToSend;
		}
		
		public JFrame getFrame() {
			return frame;
		}
		
		public int getScore() {
			return Score;
		}
		public void setScore(int i ) {
			this.Score =i;
		}


		public Boolean getTimeToConnect() {
			return timeToConnect;
		}


		public void setTimeToConnect(Boolean timeToConnect) {
			this.timeToConnect = timeToConnect;
		}


		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		public String getHost() {
			return host;
		}


		public void setHost(String host) {
			this.host = host;
		}


		public int getPortNum() {
			return portNum;
		}


		public void setPortNum(int portNum) {
			this.portNum = portNum;
		}


		public Boolean getTimeToDisconect() {
			return timeToDisconect;
		}


		public Boolean getSinglePLayer() {
			return singlePLayer;
		}


		public void setSinglePLayer(Boolean singlePLayer) {
			this.singlePLayer = singlePLayer;
		}
		
		public Boolean getTimeToRecieve() {
			return timeToRecieve;
		}
		
		public void setTimeToRecieve(Boolean b) {
			 timeToRecieve = b;
		}
		
		public Boolean getMultiplayer() {
			return  multiplayer;
		}
		
		public void setTimeToDosconect(Boolean b) {
			this.timeToDisconect = b;
			
			
		}
		
	}

	
	
	
	
	
	

