class FriendRequest extends Notification{
    private User friend;
    private User sender;
    boolean response;
    FriendRequest(User sender , User friend){
    	this.friend = friend;
    	this.sender = sender;
    }
    boolean getResponse() {
    	return response;
    }
    void setResponse(boolean response) {this.response = response;}
    boolean accept(){
    	friend.removeFromFriendRequests(sender);
    	friend.addToFriendsList(sender);
    	sender.addToFriendsList(friend);
    	setResponse(true);
    	return true;
    }
    boolean reject(){
    	friend.removeFromFriendRequests(sender);
    	setResponse(false);
    	return false;
    }
    
}