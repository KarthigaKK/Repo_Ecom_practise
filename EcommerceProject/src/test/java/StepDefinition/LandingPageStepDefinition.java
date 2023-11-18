package StepDefinition;

import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;//Selenium java
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;////Selenium java

import PageObjects.LandingPage;
import PageObjects.PageObjectManager;
import Utilities.TestContextSetup;
import io.cucumber.java.en.Given;//cucumber-java
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;//webdrivermanager

public class LandingPageStepDefinition {

	WebDriver driver;
	String offerPageItem;
	String landingPageItem;
	TestContextSetup testContextSetup;
	//PageObjectManager pageObjectManager;
	
	public LandingPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;//this refer to current class variable
	}

	@Given("User is on Greencart landing page")
	public void user_is_on_greencart_landing_page() {
		// Set up the wWebDriverManager for chrome driver
		//testContextSetup.testBase.WebDriverManager();
		Assert.assertEquals(testContextSetup.testBase.WebDriverManager().getTitle(), "GreenKart - veg and fruits kart");

	}

	@When("User searched with short name {string} and extracted actual name of product")
	public void user_searched_with_short_name_and_extracted_actual_name_of_product(String item) throws InterruptedException {
		//testContextSetup.driver.findElement(By.xpath("//input[@placeholder='Search for Vegetables and Fruits']")).sendKeys(item);
		//testContextSetup.driver.findElement(By.xpath("//button[@type='submit']")).click();
		//LandingPage lp=new LandingPage(testContextSetup.driver);
		//pageObjectManager=new PageObjectManager(testContextSetup.driver);
		LandingPage lp=testContextSetup.pageObjectManager.getLandingPage();
		
		lp.searchItem(item);
		Thread.sleep(7000);
		testContextSetup.landingPageItem = lp.getItemText().split("-")[0].trim();
		Thread.sleep(7000);
		System.out.println("Product name extracted from home page:" + landingPageItem);

		WebElement itemPresent = lp.searchedItem();

		Boolean itemDisplayed = itemPresent.isDisplayed();
		if (itemDisplayed) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
	}



}
