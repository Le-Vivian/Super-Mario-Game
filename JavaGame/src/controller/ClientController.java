package controller;

import Model.ClientModel;
import View.ClientFrame;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientController {
	public ClientModel client;
	public ClientFrame frame;
	
	public ClientController (ClientFrame frame, ClientModel client) {
		this.frame = frame;
		this.client = client;
		
		//frame = new ClientFrame();
	   // client = new ClientModel(frame);
		
	}
	
	public void controll () throws IOException {
	do { // outer do to cover exit
		do { // inner do to cover time to initiate connection

			if (frame.getTimeToDisconect() == true ) {
				
				client.timeToDisconect();
				frame.getFrame().dispose();
				System.exit(0);
				
			}
			
			if(frame.getSinglePLayer() == true) {
			
				frame.getFrame().dispose();
				return;
			}
		

			System.out.print(" ");
			frame.getTimeToConnect();
			

		} while (frame.getTimeToConnect() == false);

		// initiates
		// connection-------------------------------------------------------------------
		
	if(frame.getTimeToDisconect() == false) {
		try {
			
			client.timeToConnect(frame.getPortNum(), frame.getHost(), frame.getUsername());
		} catch (IOException e) {

			e.printStackTrace();
		}
		// -------------------------------------------------------------------
	}	
		
		
while(true) {
	System.out.println(" ");
	
	if(frame.getMultiplayer()== true) {
		return;
	}

	
//	if(frame.getTimeToDisconect() == true) {
//		break;
//	}

     if(frame.getTimeToSend()== true) {
    	
		try {
			

		client.sendMessage(frame.getMessage());
				
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
 	
 	if(frame.getTimeToDisconect() == true) {
 		break;
 	}
     
     if(frame.getTimeToRecieve() == true) {
    	 
    	 client.revieveMessage(); // gets the new message from user
    	 frame.getTimeToDisconect();
     }
     
     

		
	
} // loop to  try to make a new connection // exits when time to close is == true



	} while (frame.getTimeToDisconect() == false);

	client.timeToDisconect();
	frame.getFrame().dispose();
	System.exit(0);

} // end of main
}// end of class


