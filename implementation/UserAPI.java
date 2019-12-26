class UserAPI{
    static User signup(String firstname, String lastname, String email, String password, String birthdate, boolean is_male, Country country) throws Exception{

        Database db = Database.getInstance();
        if(db.getUserByEmail(email) != null)
            throw new Exception("Email exists");
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

    static String login(String email, String password){
        Database db = Database.getInstance();
        User u = db.getUserByEmail(email);
        if(u != null && u.password.equals(password)){
            return db.getUserToken(u);
        }
        return null;
    }

    static User getUserByToken(String token){
        Database db = Database.getInstance();
        return db.getUserByToken(token);
    }

    static User[] findUsersByName(String name){return new User[0];}
    static User findUserByEmail(String email){return new User();}
    static PremiumUser upgradeUser(User user, PaymentAccount account) throws Exception{
        Database db = Database.getInstance();
        if(account.creditCardNumber.length() != 16)
            throw new Exception("Credit card number is incorrect");
        if(account.holderName.equals(user.firstname + ' ' + user.lastname))
            throw new Exception("You are not the holder of this card");
        PremiumUser pu = new PremiumUser(user);
        pu.account = account;
        db.addPremiumUser(pu);
        return pu;
    }
    static boolean updateUserPassword(User user, String new_password){return false;}
    static boolean addFriend(User sender, User reciever){return false;}
}
