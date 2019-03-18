/*Reference: Chapter 2.7 & 2.8 of the text

Write two simple socket programs: one for a server that verifies login name and password 
(encryption not required) for a client and notifies all active clients (including the new comer) 
an updated list of active clients; the other for a client to request login, where a successful 
login should bring the client  (as well as other active clients) a list of all the active 
clients of the system. You may implement a command language interface or graphical user 
interface. You may debug/demo your programs on the same computer.

This is a group project. Each group may have up to 2 group members. A group with more than 2 group
members will result in 0 credits. You may choose to complete the project all by yourself without any partner. Doing so will not bring you
extra credit.

What should be included in your submission?
* Project report with screenshots of resultant displays
* Source code (the .java file, NOT the .class file as the instructor will compile your source code for test drive!)

Grading:

Report      20%
Demo        40%
Source codes     40%
All GUI        5%
*/


import  java.io.*; 
import  java.net.*;
import java.util.*;
import javax.swing.JOptionPane;

public class TCPServer {

	public static void main(String argv[]) throws Exception{ 
		
		String clientSentence; 
		String []temp=new String [2];
		String delim = "[-]";
		ServerSocket welcomeSocket = new ServerSocket (8905);
		int n=0;
		
		while (true) { 
			Socket connectionSocket = welcomeSocket.accept(); 
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream())); 
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			clientSentence = inFromClient.readLine(); 
			temp=clientSentence.split(delim); 
			
			
			outToClient.writeBytes("NEW USER: " + temp[1]);
			

		} 

	} 
	
}
