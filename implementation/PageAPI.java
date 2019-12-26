import java.awt.image.BufferedImage;

public class PageAPI {
	public PageAPI() {}
	public Page createPage(User admin , String name , String description , String address , String phoneNumber , BufferedImage image) {
		Page page = new Page();
		return page;
	}
	public boolean followPage(User user , Page page) {
		return true;
	}
	public Page findPageByName(String name) {
		Page page = new Page();
		return page;
	}
}
