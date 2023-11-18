package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage {
	
	WebDriver driver;
	
	public OfferPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//testContextSetup.driver.findElement(By.cssSelector("#search-field")).sendKeys(shortName)
	
	private By searchField=By.cssSelector("#search-field");
	private By OfferItem=By.cssSelector("tr td:nth-child(1)");
	private By clickTopDeal=By.xpath("//a[normalize-space()='Top Deals']");
	//Action Methods
	
	public void setItemName(String name)
	{
		driver.findElement(searchField).sendKeys(name);
	}
	
	//testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText()
	
	public String getDisplayedItem()
	{
		return driver.findElement(OfferItem).getText();
	}
	
	//testContextSetup.driver.findElement(By.xpath("//a[normalize-space()='Top Deals']")).click();
	
	public void clickTopDeal()
	{
		driver.findElement(clickTopDeal).click();
	}

}
