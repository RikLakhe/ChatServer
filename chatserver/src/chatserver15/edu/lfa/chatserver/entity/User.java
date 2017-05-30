package chatserver15.edu.lfa.chatserver.entity;

public class User {
private int id;
private String userName;
private String chatName;
private String password;
private boolean status;
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(int id, String userName, String chatName, String password, boolean status) {
	super();
	this.id = id;
	this.userName = userName;
	this.chatName = chatName;
	this.password = password;
	this.status = status;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getChatName() {
	return chatName.toString();
}
public void setChatName(String chatName) {
	this.chatName = chatName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public boolean isStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}





}
