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


import java.io.*; 
import java.net.*;
import java.util.*;
import javax.swing.JOptionPane;

public class TCPClient { 
	public static void main(String argv[]) throws  Exception {
		
	String sentence, sentence2; 
	String modifiedSentence; 

	BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
	BufferedReader inFromUser2 = new BufferedReader(new InputStreamReader(System.in));
	
	Socket clientSocket = new Socket("192.168.1.2", 8905); //CHANGE TO IP ADDRESS FROM "hostname", randomize server
	DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream()); 
	BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 
	
	sentence=JOptionPane.showInputDialog ("Enter your user name");
	sentence2=JOptionPane.showInputDialog ("Enter your password");
	String newsentence=sentence + '-' + sentence2;
	JOptionPane.showMessageDialog (null, newsentence);
	outToServer.writeBytes(newsentence); 
	modifiedSentence = inFromServer.readLine(); 
	JOptionPane.showMessageDialog (null, "FROM SERVER:");
	JOptionPane.showMessageDialog (null, modifiedSentence); 

	clientSocket.close(); 
	
}

}
