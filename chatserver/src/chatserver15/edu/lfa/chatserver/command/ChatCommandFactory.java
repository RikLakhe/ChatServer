package chatserver15.edu.lfa.chatserver.command;

import java.util.HashMap;

public class ChatCommandFactory {
	private static HashMap<String , ChatCommand> commands = initCommands();
	
	private static HashMap<String , ChatCommand> initCommands(){
		HashMap<String ,ChatCommand> cmds = new HashMap<>();
		cmds.put("LIST", new ListCommand());
		cmds.put("PM", new PMCommand() );
//		cmds.put("LOGOUT", new LogOutCommand());
//		cmds.put("EXIT", new ExitCommand());
		return cmds;
	}
	
	public static ChatCommand get(String param){
		return(commands.containsKey(param))?commands.get(param):null;
	}
}
