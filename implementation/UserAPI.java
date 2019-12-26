class UserAPI{
    static User signup(String name, String password, String birthdate, boolean is_male, Country country){return new User();}
    static User login(String email, String password){return new User();}
    static User getUserByToken(String token){return new User();}
    static User[] findUsersByName(String name){return new User[0];}
    static User findUserByEmail(String email){return new User();}
    static PremiumUser upgradeUser(User user, PaymentAccount account){return new PremiumUser();}
    static boolean updateUserPassword(User user, String new_password){return false;}
    static boolean addFriend(User sender, User reciever){return false;}
}
