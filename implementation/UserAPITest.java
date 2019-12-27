import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.*;

public class UserAPITest {
	/*
	 * A method created to unit test Login()
	 */
	@BeforeTest(enabled = true)
	public void addUsersInDataBase() {
		User user1 = new User("first", "last", "pass", "mail", "birth", true, "", null);
		User user2 = new User("Sara", "Samer", "123", "***@gmail.com", "9/1", false, "", null);
		User user3 = new User("Ahmed", "Wessam", "141414", "bad@boy.com", "24/8", true, "", null);
		User user4 = new User("Salma", "Essam", "252525", "my.com", "27/8", false, "", null);
		Database db;
		db = Database.getInstance();
		db.addUser(user1);
		db.addUser(user2);
		db.addUser(user3);
		db.addUser(user4);
	}

	@DataProvider(name = "testSignUp")
	public static Object[][] testSignUp() {
		User user1 = new User("first", "last", "pass", "mail", "birth", true, "", null);
		User user2 = new User("Sara", "Samer", "123", "***@gmail.com", "9/1", false, "", null);
		User user3 = new User("Ahmed", "Wessam", "141414", "bad@boy.com", "24/8", true, "", null);
		User user4 = new User("Salma", "Essam", "252525", "my.com", "27/8", false, "", null);
		return new Object[][] { { "first", "last", "pass", "mail", "birth", true, null, user1 },
				{ "Sara", "Samer", "123", "***@gmail.com", "9/1", false, null, user2 },
				{ "Ahmed", "Wessam", "141414", "bad@boy.com", "24/8", true, null, user3 },
				{ "Salma", "Essam", "252525", "my.com", "27/8", false, null, user4 } };
	}

	@Test(dataProvider = "testSignUp", enabled = false)
	public void signUp(String firstname, String lastname, String password, String email, String birthdate,
			boolean is_male, Country country, User expectedUser) throws Exception {
		User user = UserAPI.signup(firstname, lastname, email, password, birthdate, is_male, country);
		Assert.assertEquals(user.firstname, expectedUser.firstname);
		Assert.assertEquals(user.lastname, expectedUser.lastname);
		Assert.assertEquals(user.email, expectedUser.email);
		Assert.assertEquals(user.password, expectedUser.password);
		Assert.assertEquals(user.birthdate, expectedUser.birthdate);
		Assert.assertEquals(user.is_male, expectedUser.is_male);
		Assert.assertEquals(user.country, expectedUser.country);
	}

	@DataProvider(name = "testSignUpException")
	public static Object[][] testSignUpException() {
		/*
		 * Cases that would causes the function to throw exception
		 */
		return new Object[][] { { "", "last", "pass", "mail", "birth", true, null },
				{ "Sara", "Samer", "", "***@gmail.com", "9/1", false, null },
				{ "Ahmed", "Wessam", "141414", "", "24/8", true, null } };
	}

	@Test(dataProvider = "testSignUpException", enabled = false, expectedExceptions = Exception.class)
	public void signUpException(String firstname, String lastname, String password, String email, String birthdate,
			boolean is_male, Country country) throws Exception {
		User user = UserAPI.signup(firstname, lastname, email, password, birthdate, is_male, country);
		Assert.assertEquals(user.firstname, "");
		Assert.assertEquals(user.email, "");
		Assert.assertEquals(user.password, "");
	}

	@DataProvider(name = "testLogin")
	public static Object[][] testLogIn() {
		return new Object[][] { { "my.com", "pass", null }, { "my.com", "252525", "SalmaEssam" },
				{ "bad@boy.com", "141414", "AhmedWessam" }, { "***@gmail.com", "123", "SaraSamer" }, { "", "", null },
				{ "mail", "123", null } };
	}

	@Test(dataProvider = "testLogin", enabled = false)
	public void logIn(String email, String password, String expectedToken) {
		Assert.assertEquals(UserAPI.login(email, password), expectedToken);
	}

	@DataProvider(name = "upgradeUser")
	public Object[][] testUpgradeUser() {
		User user1 = new User("first", "last", "pass", "mail", "birth", true, "", null);
		PaymentAccount user1PaymentAccount = new PaymentAccount("123456", "first last");

		User user2 = new User("Sara", "Samer", "123", "***@gmail.com", "9/1", false, "", null);
		PaymentAccount user2PaymentAccount = new PaymentAccount("141516", "Sara Samer");

		User user3 = new User("Ahmed", "Wessam", "141414", "bad@boy.com", "24/8", true, "", null);
		PaymentAccount user3PaymentAccount = new PaymentAccount("Saraaa", "Ahmed Wessam");

		User user4 = new User("Salma", "Essam", "252525", "my.com", "27/8", false, "", null);
		PaymentAccount user4PaymentAccount = new PaymentAccount("102030", "Salma Essam");

		return new Object[][] { { user1, user1PaymentAccount, new PremiumUser(user1, user1PaymentAccount) },
				{ user2, user2PaymentAccount, new PremiumUser(user2, user2PaymentAccount) },
				{ user3, user3PaymentAccount, new PremiumUser(user3, user3PaymentAccount) },
				{ user4, user4PaymentAccount, new PremiumUser(user4, user4PaymentAccount) }, };
	}

	@Test(dataProvider = "upgradeUser", enabled = false)
	public void upgradeUser(User user, PaymentAccount paymentAccount, PremiumUser ExpectedPremiumUser)
			throws Exception {
		PremiumUser premiumUser = UserAPI.upgradeUser(user, paymentAccount);
		PaymentAccount userPaymentAccount = premiumUser.getPaymentAccount();
		PaymentAccount expectedPaymentAccount = ExpectedPremiumUser.getPaymentAccount();

		Assert.assertEquals(userPaymentAccount.getCreditCardNumber(), expectedPaymentAccount.getCreditCardNumber());
		Assert.assertEquals(userPaymentAccount.getHolderName(), expectedPaymentAccount.getHolderName());
	}

	@DataProvider(name = "upgradeUserException")
	public Object[][] testUpgradeUserException() {
		User user1 = new User("first", "", "pass", "", "birth", true, "", null);
		PaymentAccount user1PaymentAccount = new PaymentAccount("123456", " last");

		User user2 = new User("Sara", "Samer", "123", "***@gmail.com", "9/1", false, "", null);
		PaymentAccount user2PaymentAccount = new PaymentAccount("141516", "Sara ");

		User user3 = new User("Ahmed", "Wessam", "141414", "bad@boy.com", "24/8", true, "", null);
		PaymentAccount user3PaymentAccount = new PaymentAccount("Sara", "Ahmed Wessam");

		User user4 = new User("Salma", "Essam", "252525", "my.com", "27/8", false, "", null);
		PaymentAccount user4PaymentAccount = new PaymentAccount("1020312321310", "Salma ");

		return new Object[][] { { user1, user1PaymentAccount, new PremiumUser(user1, user1PaymentAccount) },
				{ user2, user2PaymentAccount, new PremiumUser(user2, user2PaymentAccount) },
				{ user3, user3PaymentAccount, new PremiumUser(user3, user3PaymentAccount) },
				{ user4, user4PaymentAccount, new PremiumUser(user4, user4PaymentAccount) }, };
	}

	@Test(dataProvider = "upgradeUserException", enabled = false, expectedExceptions = Exception.class)
	public void upgradeUserException(User user, PaymentAccount paymentAccount, PremiumUser ExpectedPremiumUser)
			throws Exception {
		UserAPI.upgradeUser(user, paymentAccount);
	}
	 
	@DataProvider(name = "friendRequest")
	public Object[][] testFriendRequest(){
		Database db = Database.getInstance();
		return new Object[][]{
			{db.getUserByToken("SaraSamer"), db.getUserByToken("AhmedWessam"), true},
			{db.getUserByToken("SaraSamer"), db.getUserByToken("AhmedWessam"), false},
			{db.getUserByToken("SalmaEssam"), new User() , false},
			{db.getUserByToken("firstlast"), db.getUserByToken("SalmaEssam") , true},
		};
	}
	
	@Test(dataProvider = "friendRequest", enabled = true)
	public void friendRequest(User sender, User reciever, boolean expected){
		Assert.assertEquals(UserAPI.addFriend(sender, reciever), expected);
	}
}