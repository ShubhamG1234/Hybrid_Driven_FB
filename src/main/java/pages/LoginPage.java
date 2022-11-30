package pages;

	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	
	import base.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(name = "email")
	WebElement username;

	@FindBy(id = "pass")
	WebElement password;

	@FindBy(name = "login")
	WebElement login;

	@FindBy(xpath = "//img[contains(@class, 'fb_logo _8ilh img')]")
	WebElement facebookLogo;

	// initializing the page object
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateFaceBookImage() {
		return facebookLogo.isDisplayed();
	}

	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		login.submit();

		return new HomePage();
	}
	public HomePage loginMultipleAccounts(String un, String pass) {
		// TODO Auto-generated method stub
		username.sendKeys(un);
        password.sendKeys(pass);
        login.submit();
        return new HomePage();
		
	}

}
