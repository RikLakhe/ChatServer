package chatserver15.edu.lfa.chatserver.command;

import java.io.IOException; 


public class ExitCommand extends ChatCommand{

	
	@Override
	public void execute(String[] tokens) throws IOException {
		output.println("Do you want to exit? [y/n] : ");
		String choice = input.readLine();
		if(choice.equalsIgnoreCase("y")){
			handler.removeClient(client);
			System.exit(0);
		}
		
		
		
		}
	
}
