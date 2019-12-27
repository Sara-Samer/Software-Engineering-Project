class Message{
    private User sender;
    private String content;
    private boolean is_read;
    public void setAsRead(){}
    public MessageNotification createNotification(){return new MessageNotification();}
}
