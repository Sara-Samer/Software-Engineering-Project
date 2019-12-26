import java.awt.image.BufferedImage;

public class  GroupAPI{
	public static Group createGroup(String name, BufferedImage photo, String description, Privacy privacy, User admin){
		return new Group();		
	}
	public static Group[] findGroupByName(String name) {
		return new Group[0];
	}
	public static Boolean joinGroup(User user, Group group) {
		return true;
	}
}