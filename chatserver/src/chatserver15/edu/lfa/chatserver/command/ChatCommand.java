package chatserver15.edu.lfa.chatserver.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import chatserver15.edu.lfa.chatserver.util.Client;
import chatserver15.edu.lfa.chatserver.util.ClientHandler;

public abstract class ChatCommand {
protected Client client;
protected ClientHandler handler;
protected PrintStream output;
protected BufferedReader input;



public PrintStream getOutputStream() {
	return output;
}



public void setOutputStream(PrintStream output) {
	this.output = output;
}



public void ChatCommand(Client client) {
	this.client = client;
}



public Client getClient() {
	return client;
}



public void setClient(Client client) {
	this.client = client;
}



public ClientHandler getHandler() {
	return handler;
}



public void setHandler(ClientHandler handler) {
	this.handler = handler;
}

public abstract void execute(String[] tokens) throws IOException;
}
