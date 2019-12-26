class MessageAPI {
    static boolean sendMessage(User sender, User reciever, String content){return false;}
    static boolean sendMessage(User sender, User[] recievers, String content){return false;}
    static Message[] getMessages(User user){return new Message[0];}
}
