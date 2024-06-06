package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import View.ClientFrame;

public class ClientModel {



	

		Socket socket = null;
		InputStreamReader inputStream = null;
		OutputStreamWriter outputStream = null;
		BufferedReader bufferRead = null;
		BufferedWriter bufferWrite = null;
		ClientFrame frame;
		
		String host = " ";
		int port = 0;
		String userName = " ";
		String otherConnectionsUserName = " ";
		int mapNum = 0;
		String protocol = " ";
	
		
		
		
//		public String getsavedMapProtocol() {
//			return protocolMapNum;
//		}
		
		
		public ClientModel (ClientFrame frame) {
			this.frame = frame;
		}
		
		
		public void timeToConnect(int portNum, String Host,String userName) throws IOException {
			this.userName = userName;
			
			try {
				if(socket == null ) {
				socket = new Socket(Host,portNum);
				}
			} catch (UnknownHostException e) {
			
				e.printStackTrace();
			} catch (IOException e) {
			
				e.printStackTrace();
			}

			
			inputStream = new InputStreamReader(socket.getInputStream()); // passing the socket to the input
																			// stream
			outputStream = new OutputStreamWriter(socket.getOutputStream()); // passing the socket to the output
																				// stream

			bufferRead = new BufferedReader(inputStream); // passing input stream to buffer
			bufferWrite = new BufferedWriter(outputStream); // passing output stream to buffer
			frame.setMessage("#1 " + this.userName );
			sendMessage(frame.getMessage());
		}
		
		
		public void sendMessage(String message) throws IOException {
		
			
			
			bufferWrite.write(message); 
			bufferWrite.newLine(); 
									
			bufferWrite.flush();
			
			if(!message.equals("#5")) {
			
			protocol = bufferRead.readLine();
			readProtocol(protocol);
			}
			else {
				timeToDisconect();
			}
		}
		
		public void revieveMessage( ) throws IOException {
			protocol = bufferRead.readLine();
			readProtocol(protocol);
		
			
			
		}
		public void readProtocol(String message) {
		
			
			// do an if that checks if the first word is the and then not to run the rest of the protocol parsing
		Scanner scan = new Scanner(message);
		
		String protocolFlag = scan.next();
		
		
		switch(protocolFlag) {
		
		case "#0": // means message recieved
			//System.out.println("hi");
			frame.timeToSend = false;
			break;
		case "#1":
			String tempUsername = scan.next();
			if(tempUsername.equals(otherConnectionsUserName )) {}
			else {
			 frame.serverStatusTextArea.setText(frame.serverStatusTextArea.getText() + "\n the user " + tempUsername + " has connected to the server ");
			 otherConnectionsUserName  = tempUsername;
			}
			 break;
		case "#2" :
			String tempUsername2 = scan.next();
			 int TempMapNum = Integer.parseInt(scan.next());
			  mapNum = frame.getMapNum();
			
			 
			 if(TempMapNum ==frame.getMapNum() && tempUsername2.equals(otherConnectionsUserName) ) { break;}
			 else {
				 frame.serverStatusTextArea.setText(frame.serverStatusTextArea.getText() + "\n the user " + tempUsername2 + " has set the map number to " +  TempMapNum ); 
				 mapNum= TempMapNum;
				 otherConnectionsUserName   = tempUsername2;
				
				 
				 frame.setMapNum(TempMapNum);
				 frame.timeToSend = false;
			 
			 }	
		  break;
		  
		case "#3":
			//frame.setTimeToDosconect(true); ;
			
			
			
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
	}

		
		


	
	
	

