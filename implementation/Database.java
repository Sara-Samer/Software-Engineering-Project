import java.util.ArrayList;
class Database{
	ArrayList<User> users = new ArrayList<User>();
	public void addUser(User user){
		users.add(user);
	}
	public User getUserByEmail(String mail){
		int index = users.indexOf(mail);
		return index == -1? null : users.get(index);
	}
}
