class FriendRequest extends Notification{
    private User receiver;
    private User sender;
    private boolean response;
    public FriendRequest(User sender , User receiver){
    	this.receiver = receiver;
    	this.sender = sender;
    }
    public boolean getResponse() {
    	return response;
    }
    public void setResponse(boolean response) {
    	//this.response = response;
    	if(response == true)
    		this.response = accept();
    	else
    		this.response = reject();
    }
    public boolean accept(){
    	receiver.removeFromFriendRequests(sender);
    	receiver.addToFriendsList(sender);
    	sender.addToFriendsList(receiver);
    	return true;
    }
    public boolean reject(){
    	receiver.removeFromFriendRequests(sender);
    	return false;
    }
    
}