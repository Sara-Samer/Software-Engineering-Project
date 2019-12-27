class FriendRequest extends Notification{
    private User friend;
    private User sender;
    private boolean response;
    public FriendRequest(User sender , User friend){
    	this.friend = friend;
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
    	friend.removeFromFriendRequests(sender);
    	friend.addToFriendsList(sender);
    	sender.addToFriendsList(friend);
    	setResponse(true);
    	return true;
    }
    public boolean reject(){
    	friend.removeFromFriendRequests(sender);
    	setResponse(false);
    	return false;
    }
    
}