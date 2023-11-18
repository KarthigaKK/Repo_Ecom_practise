package Utilities;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import PageObjects.OfferPage;

public class GenericUtils {
	private static final String testContextSetup = null;
	WebDriver driver;;
	public GenericUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void SwitchWindowToChild()
	{
		//OfferPage op=new OfferPage(testContextSetup.driver);
		//testContextSetup.driver.findElement(By.xpath("//a[normalize-space()='Top Deals']")).click();

		//pageObjectManager=new PageObjectManager(testContextSetup.driver);
		
		Set<String> windowids = driver.getWindowHandles();
		Iterator<String> it = windowids.iterator();

		while (it.hasNext()) {
			String parentwindow = it.next();
			String childWindow = it.next();
			driver.switchTo().window(childWindow);
		}
	}

}
