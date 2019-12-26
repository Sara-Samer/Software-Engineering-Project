import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserAPITest{
	@DataProvider(name = "testLogin")
	  public static Object[][] testLogIn(){
		  return new Object[][] {{"ss.titanic199@gmail.com", "pass", "SaraSamer"},
			  					 {"***@gmail.com", "----", "whatever"}, 
			  					 {"", "", null}, 
			  					 {"@gmail.com", "pass", null}};
	  }
	  
	  @Test(dataProvider = "testLogin")
	  public void logIn(String email, String password, String expectedToken) {
		  Assert.assertEquals(UserAPI.login(email, password), expectedToken);
	  }
	  @DataProvider(name = "testSignUp")
	  public static Object[][] testSignUp(){
		  User user1 = new User("first","last","pass", "mail", "birth", true, "" , null);
		  User user2 = new User("Sara","Samer","123", "***@gmail.com", "9/1", false, "" , null);
		  User user3 = new User("Ahmed","Wessam","141414", "bad@boy.com", "24/8", true, "" , null);
		  User user3 = new User("Salme","Essam","252525", "my.com", "27/8", false, "" , null);
		  return new Object[][] {
			  {"first","last","pass", "mail","birthday",true,null, user1},
			  {"Sara","Samer","123", "***@gmail.com", "9/1", false, null, user1},
			  {"Ahmed","Wessam","141414", "bad@boy.com", "24/8", true,null, user1},
			  {"Salme","Essam","252525", "my.com", "27/8", false,null, user1}
		  };
	  }
	  @Test(dataProvider = "testSignUp")
	  public void signUp (String firstname, String lastname, String email, String password, String birthdate, boolean is_male, Country country, User expectedUser) throws Exception{
		  User user = UserAPI.signup(firstname, lastname, email, password, birthdate, is_male, country);
		  Assert.assertEquals(user.firstname, expectedUser.firstname);
		  Assert.assertEquals(user.lastname, expectedUser.lastname);
		  Assert.assertEquals(user.email, expectedUser.email);
		  Assert.assertEquals(user.password, expectedUser.password);
		  Assert.assertEquals(user.birthdate, expectedUser.birthdate);
		  Assert.assertEquals(user.is_male, expectedUser.is_male);
		  Assert.assertEquals(user.country, expectedUser.country);
	  }
	  
	  
}