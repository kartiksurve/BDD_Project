package pageObject.pkg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepDefinition.pkg.BaseClass;

public class LoginPage {

WebDriver ldriver ;

WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(15));

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
		wait.until(ExpectedConditions.elementToBeClickable(username));
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