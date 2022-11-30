package pages;

	
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	
	import base.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(xpath = "//span[contains(text(), 'Shubham Gole')]")

	WebElement userNameLabel;

	@FindBy(xpath = "//div[@class ='j83agx80 l9j0dhe7']")
	WebElement dropDownLink;

	@FindBy(xpath = "//span[contains(text(),'Log Out')]")
	WebElement logout;

	@FindBy(xpath = "//span[contains(text(), 'Groups')]")
	WebElement groupsLink;

	@FindBy(xpath = "(//span[@class='x1lliihq x6ikm8r x10wlt62 x1n2onr6'])[7]")
	WebElement yourProfile;

	@FindBy(xpath = "//a[@aria-label='Home']")
	WebElement home;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();

	}

	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}

	public HomePage click_home() {
		home.click();
		return new HomePage();
	}

	public LoginPage checkOnLogout() {
		yourProfile.click();
		logout.click();
		return new LoginPage();
	}

}