package chatserver15.edu.lfa.chatserver.util;

import java.net.Socket;

import chatserver15.edu.lfa.chatserver.entity.User;

public class Client { 
	private Socket socket;
	private User user;
	
	public Client() {
	}


	public Client(User user, Socket socket) {
		this.user = user;
		this.socket = socket;
	}

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Socket getSocket() {
		return socket;
	}


	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
	
	
	
	
}
