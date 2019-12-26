import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
class Database{
	ArrayList<User> users = new ArrayList<User>();
	Map<String , User> UserToken = new HashMap<String , User>();
	public void addUser(User user){
		users.add(user);
	}
	
}
