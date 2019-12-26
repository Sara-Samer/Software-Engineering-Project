import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Database{
	ArrayList<User> users = new ArrayList<User>();
	Map<String , User> userToken = new HashMap<String , User>();
	Map<User , String> reverseUserToken = new HashMap<User , String>();
    private static Database instance = null;

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
	public void reverseMap(){
		reverseUserToken.clear();
		ArrayList<String> tmp = new ArrayList<String>(userToken.keySet());
		for(int i = 0 ; i < tmp.size() ; i++) 
			reverseUserToken.put(userToken.get(tmp.get(i)), tmp.get(i));
	}
	public String getUserToken(User user) {
		reverseMap();
		String token = "";
		if(reverseUserToken.containsKey(user)) {
			token = reverseUserToken.get(user);
		}
		else {
			byte[] array = new byte[10];
		    new Random().nextBytes(array);
		    token = new String(array, Charset.forName("UTF-8"));
			userToken.put(token, user);
			reverseUserToken.put(user, token);
		}
		return token;
	}
    public static Database getInstance(){
        if(instance == null)
            instance = new Database();
        return instance;
    }
}
