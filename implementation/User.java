import java.util.ArrayList;

class User {
    String firstname, lastname, password, email;
    Country country;
    String birthdate;
    boolean is_male;
    String profile_picture_url;
    private ArrayList<User> friendsList = new ArrayList<User>();
    private ArrayList<User> friendRequests = new ArrayList<User>();
    public User(){}
    public User(String firstname, String lastname, String password, String email, String birthdate, boolean is_male, String profile_pic, Country country){
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.birthdate = birthdate;
        this.country = country;
        this.is_male = is_male;
        this.profile_picture_url = profile_pic;
    }
    public User(User u){
        this.firstname = u.firstname;
        this.lastname = u.lastname;
        this.password = u.password;
        this.email = u.email;
        this.birthdate = u.birthdate;
        this.country = u.country;
        this.is_male = u.is_male;
        this.profile_picture_url = u.profile_picture_url;
    }
    public ArrayList<User> getFriendsList(){return friendsList;}
    public ArrayList<User> getFriendRequests(){return friendRequests;}
    public void addToFriendRequests(User user){friendRequests.add(user);}
    public void removeFromFriendRequests(User user) {friendRequests.remove(user);}
    public void addToFriendsList(User user){friendsList.add(user);}
    public void removeFromFriendsList(User user) {friendsList.remove(user);}
    public Notification[] getNotifications(){return new Notification[0];}
    public String getLoginToken(){return "";};
    public boolean updatePassword(String new_password){return false;}
}
