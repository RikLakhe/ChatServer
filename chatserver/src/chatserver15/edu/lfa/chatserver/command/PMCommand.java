package chatserver15.edu.lfa.chatserver.command;

import java.io.IOException; 
import java.io.PrintStream;

import chatserver15.edu.lfa.chatserver.util.Client;

public class PMCommand extends ChatCommand{

	
	@Override
	public void execute(String[] tokens) throws IOException {
		if(tokens.length> 2){
			Client buddy = handler.getByUserName(tokens[1]); 
			if(buddy != null){
				PrintStream out = new PrintStream(buddy.getSocket().getOutputStream());
				out.println("(PM ) "+ client.getUser().getUserName() + "sent you personal message > "+ tokens[2]);
				
			}else{
				output.println(tokens[1] + " user name not found! ");
			}
		}else{
			output.println("Error!! not enough parameters !!");
		}
	}
	
}
