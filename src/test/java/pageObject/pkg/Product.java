package pageObject.pkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product {
	
	WebDriver ldriver ;

	public Product(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id="add-to-cart-sauce-labs-fleece-jacket")
	WebElement fleeceJkt;
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	WebElement backpack;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement basketLink;
	
	@FindBy(id="remove-sauce-labs-backpack")
	WebElement remove1;
	
	@FindBy(id="remove-sauce-labs-fleece-jacket")
	WebElement remove2;
	
	@FindBy(id="continue-shopping")
	WebElement conShop;
	
	public void selectBasicProducts() {
		fleeceJkt.click();
		backpack.click();
	}
	
	public void navigateToBasket() {
		basketLink.click();
	}
	
	public void removeProducts() {
		remove1.click();
		remove2.click();
	}
	
	public void navigatetoconShopping() {
		conShop.click();
	}
}
