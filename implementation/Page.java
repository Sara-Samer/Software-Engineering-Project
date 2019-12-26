import java.awt.image.BufferedImage;

public class Page {
	private String pageName;
	private String description;
	private String address;
	private String phoneNumber;
	private BufferedImage picture;
	private User[] admins;
	private User[] followers;
	public Page() {}
	public Page(String pageName , String description , String address , String phoneNumber , 
			BufferedImage picture , User[] admins , User[] followers) {
		this.pageName = pageName;
		this.description = description;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.picture = picture;
		this.admins = admins;
		this.followers = followers;
	}
	public void savePageInfo(Page pageInfo) {
		
	}
	public User addAdmin(User user) {
		
	}
}
