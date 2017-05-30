package chatserver15.edu.lfa.chatserver.userDAO.impl;

import java.util.ArrayList;
import java.util.List;

import chatserver15.edu.lfa.chatserver.entity.User;
import chatserver15.edu.lfa.chatserver.userDAO.UserDAO;

public class UserDAOImpl implements UserDAO{
private List<User> userList = new ArrayList<>();
	@Override
	public List<User> getAll() {
		 return userList;
	}

	@Override
	public User getbyID(int id) {
		
		for(User us: userList){
			if(us.getId() == id){
				return us;
			}
		}
		
		return null;
	}

	@Override
	public User getbyChatName(String chatName) {
		for(User u: userList){
			if(u.getChatName() == chatName){
				return u;
			}
		}
		return null;
	}

	@Override
	public boolean insert(User user) {
		return userList.add(user);
	}

	@Override
	public int getInsertId() {
		int size = userList.size();
		return (size == 0)?1:userList.get(size-1 ).getId()+1;
	}

	@Override
	public boolean isUserNameExist(String userName) {
		for(User u : userList){
			if(u.getUserName().equalsIgnoreCase(userName)){
				return true;
			}
			
		}
		return false;
	}

	@Override
	public boolean isChatNameTaken(String chatName) {
		for(User u : userList){
		if(u.getChatName().equalsIgnoreCase(chatName)){
			return true;
		}
		
	}
	return false;
	}

}
