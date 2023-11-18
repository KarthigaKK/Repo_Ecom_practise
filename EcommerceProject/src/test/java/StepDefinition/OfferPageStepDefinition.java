package StepDefinition;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.LandingPage;
import PageObjects.OfferPage;
import PageObjects.PageObjectManager;
import Utilities.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OfferPageStepDefinition {

	//WebDriver driver;//We need to share the state of driver from Landing page to offer page if we create again driver=ChromeDriver() new browser instance created.
	String offerPageItem;
	//String landingPageItem;//we need to share this variable from landing page achieved using pico container
	
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	
	public OfferPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;//this refer to current class variable
	}
	@Then("User searched for {string} short name in offer page")
	public void user_searched_for_short_name_in_offer_page(String shortName) throws InterruptedException {
		
     	OfferPage op=testContextSetup.pageObjectManager.getOfferPage();
		op.clickTopDeal();
		testContextSetup.genericUtils.SwitchWindowToChild();
		//testContextSetup.driver.findElement(By.cssSelector("#search-field")).sendKeys(shortName);
		//testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText()
		// driver.findElement(By.cssSelector("#search-field")).click();
		//OfferPage op=new OfferPage(testContextSetup.driver);
		
		//pageObjectManager=new PageObjectManager(testContextSetup.driver);
		
		op.setItemName(shortName);
		offerPageItem = op.getDisplayedItem();
		System.out.println("Product name extracted from offer page:" + offerPageItem);
		Thread.sleep(5000);
	}

	@Then("Validate product name in offer page matches with landing page")
	public void validate_product_name_in_offer_page_matches_with_landing_page() {
		Assert.assertEquals(testContextSetup.landingPageItem, offerPageItem);
	}


}
