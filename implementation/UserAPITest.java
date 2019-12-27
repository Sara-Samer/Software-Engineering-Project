import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.*;

public class UserAPITest{
	
	@DataProvider(name = "testSignUp")
	  public static Object[][] testSignUp(){
		  User user1 = new User("first","last","pass", "mail", "birth", true, "" , null);
		  User user2 = new User("Sara","Samer","123", "***@gmail.com", "9/1", false, "" , null);
		  User user3 = new User("Ahmed","Wessam","141414", "bad@boy.com", "24/8", true, "" , null);
		  User user4 = new User("Salma","Essam","252525", "my.com", "27/8", false, "" , null);
		  return new Object[][] {
			  {"first","last","pass", "mail","birth",true,null, user1},
			  {"Sara","Samer","123", "***@gmail.com", "9/1", false, null, user2},
			  {"Ahmed","Wessam","141414", "bad@boy.com", "24/8", true,null, user3},
			  {"Salma","Essam","252525", "my.com", "27/8", false,null, user4}
		  };
	  }
	  @Test(dataProvider = "testSignUp", enabled = false)
	  public void signUp (String firstname, String lastname, String password, String email, String birthdate, boolean is_male, Country country, User expectedUser) throws Exception{
		  User user = UserAPI.signup(firstname, lastname, email, password, birthdate, is_male, country);
		  Assert.assertEquals(user.firstname, expectedUser.firstname);
		  Assert.assertEquals(user.lastname, expectedUser.lastname);
		  Assert.assertEquals(user.email, expectedUser.email);
		  Assert.assertEquals(user.password, expectedUser.password);
		  Assert.assertEquals(user.birthdate, expectedUser.birthdate);
		  Assert.assertEquals(user.is_male, expectedUser.is_male);
		  Assert.assertEquals(user.country, expectedUser.country);
	  }
	@DataProvider(name = "testLogin")
	  public static Object[][] testLogIn(){
		  return new Object[][] {
			 {"my.com", "pass", null},
			 {"my.com", "252525", "SalmaEssam"}, 
			 {"bad@boy.com", "141414", "AhmedWessam"}, 
			 {"***@gmail.com", "123", "SaraSamer"}, 
			 {"", "", null}, 
			 {"mail", "123", null}
		  };
	  }
	  
	  @Test(dataProvider = "testLogin", enabled = true)
	  public void logIn(String email, String password, String expectedToken) {
		  Assert.assertEquals(UserAPI.login(email, password), expectedToken);
	  }
	  /*
	   * A method created to unit test Login()
	   */
	  @BeforeTest(enabled = false)
	  public void addUsersInDataBase(){
		  System.out.println("Called!!");
		  User user1 = new User("first","last","pass", "mail", "birth", true, "" , null);
			User user2 = new User("Sara","Samer","123", "***@gmail.com", "9/1", false, "" , null);
			User user3 = new User("Ahmed","Wessam","141414", "bad@boy.com", "24/8", true, "" , null);
			User user4 = new User("Salma","Essam","252525", "my.com", "27/8", false, "" , null);
			Database db;
			db = Database.getInstance();
			db.addUser(user1);
			db.addUser(user2);
			db.addUser(user3);
			db.addUser(user4);
	  }
	  
}