class Message{
    User sender, reciever;
    String content;
    boolean is_read;
    void setAsRead(){}
    MessageNotification createNotification(){return new MessageNotification();}
}
