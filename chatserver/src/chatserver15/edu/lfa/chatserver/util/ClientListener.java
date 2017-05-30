package chatserver15.edu.lfa.chatserver.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Date;

import chatserver15.edu.lfa.chatserver.command.ChatCommand;
import chatserver15.edu.lfa.chatserver.command.ChatCommandFactory;
import chatserver15.edu.lfa.chatserver.constant.SystemConstant;
import chatserver15.edu.lfa.chatserver.entity.User;
import chatserver15.edu.lfa.chatserver.userDAO.UserDAO;

public class ClientListener extends Thread {
	private Socket socket;
	private ClientHandler handler;
	private BufferedReader input;
	private PrintStream out;
	private Client client;

	public ClientListener(Socket socket, ClientHandler handler) throws IOException {
		this.socket = socket;
		this.handler = handler;
		input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintStream(socket.getOutputStream());
	}

	@Override
	public void run() {
		try {
			while(true){
			mainMenu();
			}
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}

	}

	// login to entry once and client handle

	private void login() throws IOException {

		out.println("Please Login :");
		while (true) {
			out.println("Enter your Chat Name :");
			String chatName = input.readLine();
			out.println("Enter your Password :");
			String password = input.readLine();
			client = handler.login(chatName, password);
			if (client != null) {
				System.out.println(chatName + " has signed");
				broadcastMessage(client.getUser().getUserName() + " has logged in ! ");
				out.println("Thank you " + chatName);
				break;
			} else {
				out.println("Invalid User Name / Password !");
				
			}
		}

		
	}

	// broadcast message to all the client
	private void broadcastMessage(String msg) throws IOException {
		for (Client c : handler.getAll()) {
			if (!c.equals(client)) {

				PrintStream ps = new PrintStream(c.getSocket().getOutputStream());
				ps.println(msg);
			}
		}
	}

	private void register() throws IOException {
		client = new Client();
		User user = new User();
		out.println("Registration");
		while (true) {
			out.println("Enter User Name :");

			String uName = input.readLine();

			if (!handler.getUserDAO().isUserNameExist(uName)) {
				user.setId(handler.getUserDAO().getInsertId());
				user.setUserName(uName);
				break;
			} else {
				out.println("User Name already Exists!");
			}
		}
		while (true) {
			out.println("Enter Chat Name :");
			String cName = input.readLine();
			if (!handler.getUserDAO().isChatNameTaken(cName)) {

				user.setChatName(cName);
				break;
			} else {
				out.println("Chat Name already Taken!");
			}
		}

		out.println("Enter password :");
		user.setPassword(input.readLine());
		user.setStatus(true);
		handler.getUserDAO().insert(user);
		client.setUser(user);
		client.setSocket(socket);
		handler.addClient(client);

		File file = new File("users/" + user.getUserName());
		if (!file.isDirectory()) {
			file.mkdir();
		}
	}

	private void logOut() throws IOException {
		out.println(client.getUser().getUserName() + " do you want to logout ? [y/n]");
		String choice2 = input.readLine();
		if (choice2.equalsIgnoreCase("y")) {
			handler.removeClient(client);
			interrupt();
		}
	}

	private void exit() throws IOException {
		out.println(client.getUser().getUserName() + " do you want to exit ? [y/n]");
		String choice2 = input.readLine();
		if (choice2.equalsIgnoreCase("y")) {
			handler.removeClient(client);
			System.exit(0);
		}
	}
	
	private void mainMenu() throws IOException{
		out.println("welcome to lfa server");
		out.println("Current system at server is " + new Date().toString());
		while (true) {

			out.println("1. Register \r\n" + "2. login\r\n" + "Enter either 1 or 2 : ");
			String choice = input.readLine();
			if (choice.equals("1")) {
				register();
			} 
			else 
			{
				login();
			}
			
			while (!isInterrupted()) {
				out.println("(Me) >");
				String line = input.readLine();
				String[] tokens = line.split(SystemConstant.CHATSEPERATOR);
				ChatCommand cmd = ChatCommandFactory.get(tokens[0].toUpperCase());
				if (cmd != null) {
					cmd.setClient(client);
					cmd.setHandler(handler);
					cmd.setOutputStream(out);
					cmd.execute(tokens);

				} 
				else if(tokens[0].equalsIgnoreCase("logout")){
					logOut();
				}
				else if(tokens[0].equalsIgnoreCase("exit")){
					exit();
				}
				
				else {

					broadcastMessage(client.getUser().getUserName() + " says > " + line);
				}
			}

		}
	}
}
