package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMain  {
	

	
	Socket socket = null;
	InputStreamReader inputStream = null; // to get inputs from the user in characters
	OutputStreamWriter outputStream = null; // to send information to the server
	BufferedReader bufferRead = null; // used to make the input more efficient by sending all the data once the buffer is full
    BufferedWriter bufferWrite = null; // used to make the output more efficient by sending all the data once the buffer is full
    ServerSocket serverSocket = null; // special socket needed for servers
	int socketNum = 0;
	String message = " ";
	static String username = " ";
	static int mapNum =0;
	serverFrame frame;
	int score=-1;
	
	public ServerMain(serverFrame frame) {
		
	this.frame = frame;
		
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
	
	public void closeConnections () throws IOException {
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
