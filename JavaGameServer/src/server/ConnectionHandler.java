package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

public class ConnectionHandler implements Runnable {

	
	// objects
	Socket socket;
	InputStreamReader inputStream;
	OutputStreamWriter outputStream ; 
	BufferedReader bufferRead ;  
	BufferedWriter bufferWrite ; 
	serverFrame frame;
	Boolean timeToClose = false;
	//ServerMain server;
	
	
	// Variables
	private static ArrayList<String> scoreBank = new ArrayList<>();
	static int count;
	//static int socketCount = 0;
	static String message = " ";
	static String username = " ";
	static int mapNum =0;
	int score=-1;

	
	public ConnectionHandler(Socket socket,serverFrame frame) throws IOException{
	this.frame = frame;
	this.socket = socket;
	inputStream = new InputStreamReader(socket.getInputStream()); // passing the socket to the input stream
	outputStream = new OutputStreamWriter(socket.getOutputStream()); // passing the socket to the output stream
	bufferRead = new BufferedReader(inputStream);   // passing input stream to buffer
	bufferWrite = new BufferedWriter(outputStream); // passing output stream to buffer
	}
	
	
	@Override
	public void run() {
		
		
		
		while(frame.getTimeToClose()== false) {
			
			
			String messageFromClient = null;
			try {
				messageFromClient = getMessage();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			} 
			
			

			
			
				try {
					
					readProtocol(messageFromClient);
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
				if(timeToClose == true) {
					break;
				}
				
				
			}
		
	
		
		
		if (socket != null) {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	   if (inputStream != null) {
		   try {
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	   if (outputStream != null) {
		   try {
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	   if (bufferRead != null) {
		   try {
			bufferRead.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	   if (bufferWrite !=null) {
		   try {
			bufferWrite.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	  
	//frame.getFrame().dispose();
		
	}
	
	
	
	
	
	public String getMessage() throws IOException  {
		message = bufferRead.readLine();
		setMessage(message);
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void sendMessage(String message) throws IOException {
		bufferWrite.write(message);
		bufferWrite.newLine();
		bufferWrite.flush(); 
		
	}
	

	
	
	
	public void readProtocol(String message) throws IOException {
	
		// do an if that checks if the first word is the and then not to run the rest of the protocol parsing
	Scanner scan = new Scanner(message);
	
	String protocolFlag = scan.next();
	
	System.out.println(protocolFlag);
	
	
	switch(protocolFlag) {
	case "#1":
		String tempUsername = scan.next();
		if(tempUsername.equals(username)) {}
		else {
		 frame.serverStatusTextArea.setText(frame.serverStatusTextArea.getText() + "\n the user " + tempUsername + " has connected to the server ");
		 username = tempUsername;
		}
		sendMessage("#0");
		 break;
	case "#2" :
		 username = scan.next();
		 int TempMapNum = Integer.parseInt(scan.next());
		 if(TempMapNum ==mapNum) {
			 sendMessage("#2 " + username+" "+mapNum); 
			}
		 else {
			 frame.serverStatusTextArea.setText(frame.serverStatusTextArea.getText() + "\n the user " + username + " has set the map number to " + TempMapNum);
			 mapNum= TempMapNum;
			 //sendMessage("#2 " + username+" "+mapNum); 
			sendMessage("#0");
			
			
			
			
		 }
		
	  break;
	  
	case "#3":
		tempUsername = scan.next();
		int tempScore = Integer.parseInt(scan.next());
		if(tempUsername.equals(username) && tempScore == score) {
			sendMessage("#0");
		}
		else {
			username = tempUsername;
			score = tempScore;
			String string = username + " " + score;
			scoreBank.add(string) ;
			
			
		
			
			 frame.serverStatusTextArea.setText(frame.serverStatusTextArea.getText() + "\n the user " + username + " has finished the game with a high Score of " + tempScore);
			 sendMessage("#0");
		}
		break;
		
	case "#4" : // requesting a map
		sendMessage("#2 " + username + " "+ mapNum);
		
		
		break;
		
	case "#5": // time to clsoe
		
		frame.serverStatusTextArea.setText(frame.serverStatusTextArea.getText() + "\n the user " + username + " has disconected ");
		timeToClose = true;
//		sendMessage("#3");
		
		//timeToDisconect();
		 
		//timeToClose = true;
		
		
		socket.close();
		
		
		break;
	
	
	}
	
	

		
		
	}
	
	
	public void timeToDisconect() throws IOException {
		if (socket != null) {
			socket.close();
		}
	
	   if (inputStream != null) {
		   inputStream.close();
	   }
	   if (outputStream != null) {
		   outputStream.close();
	   }
	   if (bufferRead != null) {
		   bufferRead.close();
	   }
	   if (bufferWrite !=null) {
		   bufferWrite.close();
	   }	
		
		
		
	
		
	
	}


public ArrayList getScoreBank() {
	return scoreBank;
}
public int getCount() {
	return count;
}

			
			
			
			
		
	
		
		

	}


