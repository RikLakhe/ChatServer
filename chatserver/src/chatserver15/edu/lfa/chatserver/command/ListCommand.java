package chatserver15.edu.lfa.chatserver.command;

import java.io.IOException; 
import java.io.PrintStream;

import chatserver15.edu.lfa.chatserver.util.Client;

public class ListCommand extends ChatCommand{

	
	@Override
	public void execute(String[] tokens) throws IOException {
		StringBuilder content = new StringBuilder();
		for(Client c : handler.getAll()){
			
			content.append(c.getUser().getUserName()).append("\r\n");
		}
		PrintStream out = new PrintStream(client.getSocket().getOutputStream());
		out.println(content.toString());
		
		
		
		
		}
	
}
