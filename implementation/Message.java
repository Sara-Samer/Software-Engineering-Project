class Message{
    User sender;
    String content;
    boolean is_read;
    void setAsRead(){}
    MessageNotification createNotification(){return new MessageNotification();}
}
