package chatserver15.edu.lfa.chatserver.util;

import java.util.ArrayList;
import java.util.List;

import chatserver15.edu.lfa.chatserver.entity.User;
import chatserver15.edu.lfa.chatserver.userDAO.UserDAO;

public class ClientHandler {
	
private List<Client> clients = new ArrayList<>();
private UserDAO userDAO;

public ClientHandler(UserDAO userDAO){
	this.userDAO=userDAO;
}
public void addClient(Client c){
	clients.add(c);
}
public List<Client> getAll(){
	return clients;
	
}

public UserDAO getUserDAO(){
	return userDAO;
}

public Client getByUserName(String userName){
	for(Client c: clients){
		if(c.getUser().getUserName().equalsIgnoreCase(userName)){
			return c;
		}
	}return null;
}

public void removeClient(Client c){
	clients.remove(c);
}

public Client login(String chatName, String password){
	for(Client c: clients){
		User user=c.getUser();
		if(user.getChatName().equalsIgnoreCase(chatName)&&user.getPassword().equals(password)){
			return c;
		}
	}return null;
}
}
