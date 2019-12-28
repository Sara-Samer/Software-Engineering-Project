class UserAPI{
    public static User signup(String firstname, String lastname, String email, String password, String birthdate, boolean is_male, Country country) throws Exception{

        Database db = Database.getInstance();
        if(db.getUserByEmail(email) != null)
        	throw new Exception("Email exists");
        if(email.trim().length() == 0)
            throw new Exception("Email cannot be empty");
        if(firstname.trim().length() == 0)
            throw new Exception("Firstname cannot be empty");
        if(password.trim().length() == 0)
            throw new Exception("Password cannot be empty");
        User user = new User();
        user.firstname = firstname;
        user.lastname = lastname;
        user.email = email;
        user.password = password;
        user.birthdate = birthdate;
        user.is_male = is_male;
        user.country = country;
        db.addUser(user);
        return user;
    }

    public static String login(String email, String password){
        Database db = Database.getInstance();
        User u = db.getUserByEmail(email);
        if(u != null && u.password.equals(password)){
            return db.getUserToken(u);
        }
        return null;
    }

    public static User getUserByToken(String token){
        Database db = Database.getInstance();
        return db.getUserByToken(token);
    }

    public static User[] findUsersByName(String name){return new User[0];}
    public static User findUserByEmail(String email){return new User();}
    public static PremiumUser upgradeUser(User user, PaymentAccount account) throws Exception{
        Database db = Database.getInstance();
        if(account.getCreditCardNumber().length() != 6)
            throw new Exception("Credit card number is incorrect");
        if(!account.getHolderName().equals(user.firstname + ' ' + user.lastname))
            throw new Exception("You are not the holder of this card");
        PremiumUser pu = new PremiumUser(user);
        pu.setPaymentAccount(account);
        db.addPremiumUser(pu);
        db.removeUser(user);
        return pu;
    }
    public static boolean updateUserPassword(User user, String new_password){return false;}
    public static boolean addFriend(User sender, User reciever){
    	Database db = Database.getInstance();
    	if(sender.getFriendsList().contains(reciever) || reciever.getFriendRequests().contains(sender))
    		return false;
    	if(sender.getFriendRequests().contains(reciever) || reciever.getFriendRequests().contains(sender))
    		return false;
    	if(!db.getUsers().contains(reciever) && !db.getPremiumUsers().contains(reciever))
    		return false;
    	reciever.addToFriendRequests(sender);
    	FriendRequest friendRequest = new FriendRequest(sender , reciever);
    	return true;//friendRequest.getResponse();
    }
}
