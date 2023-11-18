import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TravelHomePage {
	
	WebDriver driver;
	By sectionElement=	By.id("traveller-home");
	
	/*
	 * public NavigationBar getNavigationBar() { return new NavigationBar(); }
	 */
	
	public FoorterNav getFooterNavigationBar()
	{
		return new FoorterNav(driver,sectionElement);
	}

}
