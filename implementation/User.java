import java.util.ArrayList;

class User {
    String firstname, lastname, password, email;
    Country country;
    String birthdate;
    boolean is_male;
    String profile_picture_url;
    ArrayList<User> friendsList = new ArrayList<User>();
    ArrayList<User> friendRequests = new ArrayList<User>();
    User(){}
    User(String firstname, String lastname, String password, String email, String birthdate, boolean is_male, String profile_pic, Country country){
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.birthdate = birthdate;
        this.country = country;
        this.is_male = is_male;
        this.profile_picture_url = profile_pic;
    }
    User(User u){
        this.firstname = u.firstname;
        this.lastname = u.lastname;
        this.password = u.password;
        this.email = u.email;
        this.birthdate = u.birthdate;
        this.country = u.country;
        this.is_male = u.is_male;
        this.profile_picture_url = u.profile_picture_url;
    }
    ArrayList<User> getFriendsList(){return friendsList;}
    ArrayList<User> getFriendRequests(){return friendRequests;}
    void addToFriendRequests(User user){friendRequests.add(user);}
    void removeFromFriendRequests(User user) {friendRequests.remove(user);}
    void addToFriendsList(User user){friendsList.add(user);}
    void removeFromFriendsList(User user) {friendsList.remove(user);}
    Notification[] getNotifications(){return new Notification[0];}
    String getLoginToken(){return "";};
    boolean updatePassword(String new_password){return false;}
}
