package chatserver15.edu.lfa.chatserver.userDAO;

import java.util.List;

import chatserver15.edu.lfa.chatserver.entity.User;

public interface UserDAO {
	List<User> getAll();
	User getbyID(int id);
	User getbyChatName(String chatName);
	boolean insert(User user);
	int getInsertId();
	boolean isUserNameExist(String userName);
	boolean isChatNameTaken(String chatName);
}
