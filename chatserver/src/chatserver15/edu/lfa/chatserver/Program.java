package chatserver15.edu.lfa.chatserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import chatserver15.edu.lfa.chatserver.userDAO.UserDAO;
import chatserver15.edu.lfa.chatserver.userDAO.impl.UserDAOImpl;
import chatserver15.edu.lfa.chatserver.util.ClientHandler;
import chatserver15.edu.lfa.chatserver.util.ClientListener;

public class Program {

	public static void main(String[] args) {
		
		int port = 1000;
		try{
			ServerSocket server = new ServerSocket(port);
			System.out.println("Server is running at "+ port);
			ClientHandler handler = new ClientHandler(new UserDAOImpl());
			while(true){
				Socket socket = server.accept();
				System.out.println("Connection detected from "+ socket.getInetAddress().getHostAddress());
				ClientListener listener = new ClientListener(socket,handler);
				listener.start();
				
				
				
			}
		}catch (IOException ioe){
			System.out.println(ioe.getMessage());
		}
		
		
		
		
		

	}

}
