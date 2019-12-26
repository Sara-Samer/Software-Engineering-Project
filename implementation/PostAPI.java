
public class PostAPI{
	public static Post createPost(User author, String content, Privacy privacy){
		
	}
	
	public static Post createPagePost(User author, String content, Privacy privacy, Page page){
    	
    }
    
    
	public static Post createGroupPost(User author, String content, Privacy privacy, Group group){
    	
    }
    
	public static Ad createAd(PremiumUser user, String header, String[] headerlines, String description){
    	
    }
    
	public static Post[] pollPosts(User user){
    	
    }
    
	public static Post[] pollPosts(Group group){
    	
    }
    
	public static Post[] pollPosts(Page page){
    	
    }
    
	public static Post[] findPostByHashtags(HashTag[] hashtags){
    	
    }
}