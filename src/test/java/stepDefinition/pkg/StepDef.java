package stepDefinition.pkg;

import java.io.File;
import java.io.IOException;
import java.util.logging.LogManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.pkg.Checkout;
import pageObject.pkg.LoginPage;
import pageObject.pkg.Product;
import utilitiesCommon.pkg.ReadConfig;

public class StepDef extends BaseClass {

public WebDriver driver;

//@Before(@Tagname) ---- For conditional hooks
@Before()
public void beforeEachScenario() throws IOException {
	
	System.out.println("Before each scenario");
	log = org.apache.logging.log4j.LogManager.getLogger("StepDef");
	ReadConfig readCfg = new ReadConfig();
	String browser = readCfg.GetBrowser();
	switch (browser.toLowerCase()){
	case "chrome" :
		driver = new ChromeDriver();
		break;
	case "firefox" :
		driver = new FirefoxDriver();
		break;
	case "msedge" :	
		driver = new EdgeDriver();
		break;
	default:
		driver = null;
		break;
	}
	
	log.info("Chrome Browser initialized");

	}

	/*
	 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
	 * driver.manage().window().maximize();
	 */


//@After(@Sanity) --- For conditional hooks
@After()
public void afterEachScenario() {
	System.out.println("After each scenario");
	driver.close();
	log.info("Chrome Browser closed");
}

@AfterStep
public void addScreenShot(Scenario scenario) {
	byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	 scenario.attach(screenshot,"image/png",scenario.getName());
	
}

/*
 * @AfterStep public void addScreenShotFile(Scenario scenario) throws
 * IOException { File srcFile = ((TakesScreenshot)
 * driver).getScreenshotAs(OutputType.FILE); FileUtils.copyFile(srcFile, new
 * File (scenario.getName()+"./SeleniumScreenshots/Screen.png"));
 * 
 * }
 */

@Given("Open chrome browser")
public void open_chrome_browser() {
	/*
	 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
	 * driver.manage().window().maximize();
	 */
	loginpg = new LoginPage(driver);
	prodSelect = new Product(driver);
	checker = new Checkout(driver);
	log.info("Chrome Browser Opened");
	}

@Given("Search the Url in Browser as {string}")
public void search_the_url_in_browser_as(String url) {
  driver.get(url);
  log.info("URL searched in Browser");
}

@Given("Verify the title of page as {string}")
public void verify_the_title_of_page_as(String expectedTitle) {
	String actualTitle;
	actualTitle = driver.getTitle();
	if (expectedTitle.equals(actualTitle)) {
		Assert.assertTrue(true);
		log.info("Page title is a match");
	}
	else {
		Assert.assertTrue(false);
		log.error("Page title is not a match");

	}
}

@When("Enter the emailaddress as {string} and password as {string}")
public void enter_the_emailaddress_as_and_password_as(String username, String password) {
	loginpg.enterUserName(username);
    loginpg.enterPassword(password);
    log.info("Succesfully entered the credentials");
}

@When("Click on the Login Button")
public void click_on_the_login_button() {
  loginpg.loginClick();
  log.info("Clicked on login button");
}

/*--------------------------Products Page and Basket -----------------------------------------------*/

@When("Add the products to basket")
public void add_the_products_to_basket() {
 prodSelect.selectBasicProducts();
	}

@When("Navigate to basket page")
public void navigate_to_basket_page() {
    prodSelect.navigateToBasket();
}

@Then("Remove the products from basket")
public void remove_the_products_from_basket() {
    prodSelect.removeProducts();
}

@Then("Navigate to Products page via Continue Shopping option")
public void navigate_to_products_page_via_continue_shopping_option() {
    prodSelect.navigatetoconShopping();
}


/*--------------------------Checkout and Final page -----------------------------------------------*/

@When("Navigate to Checkout page")
public void navigate_to_checkout_page() {
    checker.checkoutFinal();
}

@When("Fill the Checkout details with name as {string} lastname as {string} and zipcode as {string}")
public void fill_the_checkout_details_with_name_as_lastname_as_and_zipcode_as(String fname, String lsname, String zcode) {
     checker.checkoutPageDetails(fname, lsname, zcode);
}

@When("Navigate to Final Checkout page")
public void navigate_to_final_checkout_page() {
    checker.finalCheckout();
}

@Then("Click on Final button")
public void click_on_final_button() {
   checker.finishClick();
}

@Then("Valida the success message as {string}")
public void valida_the_success_message_as(String finalMsg) {
    checker.validateFinalMsg(finalMsg);
}


}
