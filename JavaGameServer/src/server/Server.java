package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;



// each client must be a tread

public class Server  {
	
	static serverFrame frame;
    static ServerMain server;
	static ServerSocket serverSocket;
	//Socket socket;
    private static ArrayList<ConnectionHandler> clients = new ArrayList<>();
	private static ArrayList<String> scoreBank = new ArrayList<>();
	
	

	public static void main(String[] args) throws IOException  {
		Boolean flag = false;
		 frame = new serverFrame();
	     server = new ServerMain(frame);
		String messageFromClientFlagToSeeIfItChanges = " ";
do { // outer do while Loop to manage when the entire thing is ready to close
	
		do { // inner do to check if it's time to make a server socket
			
			
			// check if the user closes before making a server
			if(frame.getTimeToClose()== true) {
				 server.closeConnections();
				 frame.getFrame().dispose();
				 System.exit(0);
			}		
			
		System.out.print(" ");
		 
		 flag = frame.getTimeToConnect();
		 
		} while (flag == false);
		
		// new additions -----------------------------------------------------
		
		if(serverSocket == null ) {
			serverSocket = new ServerSocket(frame.getPortNum());	
		}
		
		

		
		
		while(frame.getTimeToClose()== false) {
		
	if(frame.noMoreConnection == false) {
		Socket	client = serverSocket.accept();
		ConnectionHandler handler = new ConnectionHandler(client,frame);
		clients.add(handler);
		frame.passConnectionHandler(handler);
		Thread clientThread = new Thread(handler);
		
		 clientThread.start();
			}
	
	if (clients.get(0) == null) {
		frame.timeToClose = true;
	
		 
		 }
	
	else {
		
	
		
	}
	

		
	}
		
		

	
			
		
		
		
} while(frame.getTimeToClose()== false);

// server.closeConnections();
 frame.getFrame().dispose();

	} // end of main





		
	

	
	
} // end of class
