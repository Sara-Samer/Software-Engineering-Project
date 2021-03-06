import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Database{
	private static ArrayList<User> users = new ArrayList<User>();
	private static ArrayList<PremiumUser> pUsers= new ArrayList<PremiumUser>(); 
	private static Map<String , User> userToken = new HashMap<String , User>();
	private static Map<User , String> reverseUserToken = new HashMap<User , String>();
    private static Database instance = null;
    
    public ArrayList<User> getUsers(){return this.users;}
    public ArrayList<PremiumUser> getPremiumUsers(){return this.pUsers;}
    
	public void addUser(User user){
		users.add(user);
		this.getUserToken(user);
	}
	
	public void removeUser(User user) {
		users.remove(user);
	}
	
	public void addPremiumUser(PremiumUser pUser) {
		pUsers.add(pUser);
	}

	public User getUserByEmail(String mail){
		int index = -1;
		for(int i = 0; i < users.size(); ++i){
			String email = users.get(i).email;
			if(email.equals(mail))
				index = i;
		}
		return index == -1? null : users.get(index);
	}
	public User getUserByToken(String token) {
		return userToken.containsKey(token) ? userToken.get(token) : null;
	}
	public String getUserToken(User user) {
		String token = "";
		if(reverseUserToken.containsKey(user)) {
			token = reverseUserToken.get(user);
		}
		else {
		    token = user.firstname + user.lastname;
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
