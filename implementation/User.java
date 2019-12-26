class User {
    String firstname, lastname, password, email;
    Country country;
    String birthdate;
    boolean is_male;
    String profile_picture_url;

    User[] getFriendsList(){return new User[0];}
    Notification[] getNotifications(){return new Notification[0];}
    String getLoginToken(){return "";};
    boolean updatePassword(String new_password){return false;}
}
