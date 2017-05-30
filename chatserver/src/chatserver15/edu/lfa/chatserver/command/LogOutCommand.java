package chatserver15.edu.lfa.chatserver.command;

import java.io.IOException; 


public class LogOutCommand extends ChatCommand{

	
	@Override
	public void execute(String[] tokens) throws IOException {
		output.println("Do you want to logout? [y/n] : ");
		String choice = input.readLine();
		if(choice.equalsIgnoreCase("y")){
			handler.removeClient(client);
			
		}
		
		
		
		}
	
}
