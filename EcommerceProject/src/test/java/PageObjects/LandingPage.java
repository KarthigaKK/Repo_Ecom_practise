package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.TestContextSetup;

public class LandingPage {
	
	public WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By searchLP=By.xpath("//input[@placeholder='Search for Vegetables and Fruits']");
	private By itemName=By.cssSelector("h4.product-name");
	private By itemLocation=By.xpath("//img[@alt='Tomato - 1 Kg']");
	
	//action methods
	public void searchItem(String name)
	{
		driver.findElement(searchLP).sendKeys(name);
	}
	
	//testContextSetup.driver.findElement(By.cssSelector("h4.product-name")).getText()
	
	public String getItemText()
	{
		return driver.findElement(itemName).getText();
	}
	
	//testContextSetup.driver.findElement(By.xpath("//img[@alt='Tomato - 1 Kg']"))
	
	public WebElement searchedItem()
	{
		return driver.findElement(itemLocation);
	}

}
