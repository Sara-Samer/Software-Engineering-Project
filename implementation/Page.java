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
    public void savePageInfo(Page pageInfo) { }
    public void addAdmin(User user) { }
    
    //setters
    public void setPageName(String pageName) { this.pageName = pageName; }
    public void setDescription(String description) {this.description = description; }
    public void setAddress(String address) {this.address = address; }
    public void setphoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber; }
    public void setPicture(BufferedImage picture) {this.picture = picture; }
    public void setAdmind(User[] admins) {this.admins = admins; }
    public void setFollowers(User[] followers) { this.followers = followers; }
    
    //getters
    public String getPageName() { return pageName; }
    public String getDescription(){ return description;}
    public String getAddress() { return address;}
    public String getPhoneNumber() {return phoneNumber; }
    public BufferedImage getPicture() {return picture; }
    public User[] getAdmins() { return admins; }
    public User[] getFollowers() { return followers; }
}
