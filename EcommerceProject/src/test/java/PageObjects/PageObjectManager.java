package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	LandingPage landingPage;
	OfferPage offerPage;
	WebDriver driver;
	public PageObjectManager(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public LandingPage getLandingPage()
	{
		landingPage=new LandingPage(driver);
		return landingPage;
	}
	
	public OfferPage getOfferPage()
	{
		offerPage=new OfferPage(driver);
		return offerPage;
	}
	
}
