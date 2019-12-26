import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Database{
	ArrayList<User> users = new ArrayList<User>();
	Map<String , User> userToken = new HashMap<String , User>();
	public void addUser(User user){
		users.add(user);
	}

	public User getUserByEmail(String mail){
		int index = users.indexOf(mail);
		return index == -1? null : users.get(index);
	}
	public User getUserByToken(String token) {
		return userToken.containsKey(token) ? userToken.get(token) : null;
	}
}
