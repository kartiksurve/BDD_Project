package pageObject.pkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

WebDriver ldriver ;

public LoginPage(WebDriver rdriver) {
	
	ldriver = rdriver;
	PageFactory.initElements(rdriver, this);
}

	@FindBy(id="user-name")
	WebElement  username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement loginbtn;
	
	public void enterUserName(String userKey) {
		username.clear();
		username.sendKeys(userKey);
	}
	
	
	public void enterPassword(String passKey) {
		password.clear();
		password.sendKeys(passKey);
	}

	public void loginClick()
{
	loginbtn.click();	
}
	

	}
