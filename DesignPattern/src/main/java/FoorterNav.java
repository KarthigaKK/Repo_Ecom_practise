import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FoorterNav extends AbstractComponent{

	WebDriver driver;

By flights=By.cssSelector("[title='Flights']");

//When selenium executes search flight , scope is restricted only to footer elements

public FoorterNav(WebDriver driver, By sectionElement) {
	//when u inherit the parent class u should invoke parent class constructor from child class
	super(driver,sectionElement);
}

public void selectFlight()
{
	//customized findelement
	findElement(flights);
	//driver.findElement(flights).click();
}
}
