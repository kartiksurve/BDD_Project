package pageObject.pkg;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Checkout {

	WebDriver ldriver ;

	public Checkout(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id="checkout")
	WebElement checkoutpage;
	
	@FindBy(id="first-name")
	WebElement checkFiName;
	
	@FindBy(id="last-name")
	WebElement checkLaName;
	
	@FindBy(id="postal-code")
	WebElement checkPoCode;
	
	@FindBy(id="continue")
	WebElement finalPage;
	
	@FindBy(id="finish")
	WebElement finishButton;
	
	@FindBy(xpath="//h2[@class='complete-header']")
	WebElement finalMessage;
	
	
	public void checkoutFinal() {
		checkoutpage.click();
	}
	
	public void checkoutPageDetails(String chname,String chlastName,String chZipcode) {
		checkFiName.sendKeys(chname);
		checkLaName.sendKeys(chlastName);
		checkPoCode.sendKeys(chZipcode);
	}
	
	public void finalCheckout() {
		finalPage.click();
	}
	
	public void finishClick() {
		finishButton.click();
	}
	
	public void validateFinalMsg(String expectedMsg) { 
		String actualMsg = finalMessage.getText();
		if (expectedMsg.equals(actualMsg)) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(false);
		}
	}
}
