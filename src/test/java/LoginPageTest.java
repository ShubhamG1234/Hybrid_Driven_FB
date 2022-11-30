
	import org.apache.log4j.Logger;
	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;
	
	import base.BaseClass;
	import pages.HomePage;
	import pages.LoginPage;
	import utilities.Test_utility;
	
public class LoginPageTest extends BaseClass {
	LoginPage loginPage;
	HomePage homePage;
	Test_utility testUtil;
	String sheetName = "test_data";
	Logger log = Logger.getLogger(LoginPageTest.class);

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.info("------------Starting test cases execution---------");
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Facebook – log in or sign up");
	}

	@Test(priority = 2)
	public void faceBookLogoImageTest() {
		boolean flag = loginPage.validateFaceBookImage();
		Assert.assertTrue(flag);
	}

	@DataProvider
	public Object[][] getLoginTestData() {
		Object data[][] = Test_utility.getTestData(sheetName);
		return data;
	}

	@Test(dataProvider = "getLoginTestData")
	public void multipleLoginTest(String userName, String password) throws InterruptedException {
		homePage = loginPage.loginMultipleAccounts(userName, password);
		Thread.sleep(3000);
		log.info("login successful with username: " + userName);
	}

	@Test(priority = 3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("login successful with username and Password");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("browser is closed");

	}
}
