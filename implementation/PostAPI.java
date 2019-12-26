
public class PostAPI{
	public static Post createPost(User author, String content, Privacy privacy){
		Post post = null;
		return post;
	}
	
	public static Post createPagePost(User author, String content, Privacy privacy, Page page){
    	return null;
    }
    
    
	public static Post createGroupPost(User author, String content, Privacy privacy, Group group){
    	return null;
    }
    
	public static Ad createAd(PremiumUser user, String header, String[] headerlines, String description){
		return null;
    }
    
	public static Post[] pollPosts(User user){
		return null;
    }
    
	public static Post[] pollPosts(Group group){
		return null;
    }
    
	public static Post[] pollPosts(Page page){
		return null;
    }
    
	public static Post[] findPostByHashtags(Hashtag[] hashtags){
		return null;
    }
}