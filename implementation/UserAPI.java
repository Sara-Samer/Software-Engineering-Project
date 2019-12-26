class UserAPI{
    static User signup(String firstname, String lastname, String email, String password, String birthdate, boolean is_male, Country country) throws Exception{
        Database db = new Database();
        if(db.getUserByEmail(email) != null)
            throw new Exception("Email exists");
        if(firstname.trim().length() == 0)
            throw new Exception("Firstname cannot be empty");
        if(password.trim().length() == 0)
            throw new Exception("Password cannot be empty");
        User user = new User();
        user.firstname = firstname;
        user.lastname = lastname;
        user.password = password;
        user.birthdate = birthdate;
        user.is_male = is_male;
        user.country = country;
        db.addUser(user);
        return user;
    }

    static User login(String email, String password){return new User();}
    static User getUserByToken(String token){return new User();}
    static User[] findUsersByName(String name){return new User[0];}
    static User findUserByEmail(String email){return new User();}
    static PremiumUser upgradeUser(User user, PaymentAccount account){return new PremiumUser();}
    static boolean updateUserPassword(User user, String new_password){return false;}
    static boolean addFriend(User sender, User reciever){return false;}
}
