import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserAPITest{
	UserAPI userAPI;
	@DataProvider(name = "testLogin")
	  public static Object[][] testLogIn(){
		  return new Object[][] {{"ss.titanic199@gmail.com", "pass", "SaraSamer"}, {"***@gmail.com", "----", "whatever"}, {"", "", null}, {"@gmail.com", "pass", null}};
	  }
	  
	  @Test(dataProvider = "testLogin")
	  public void logIn(String email, String password, String expectedToken) {
		  userAPI = new UserAPI();
		  Assert.assertEquals(userAPI.login(email, password), expectedToken);
	  }
}