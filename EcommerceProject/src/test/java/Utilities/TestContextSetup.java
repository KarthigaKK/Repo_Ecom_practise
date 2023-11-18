package Utilities;

import org.openqa.selenium.WebDriver;

import PageObjects.PageObjectManager;

public class TestContextSetup {

	public WebDriver driver;
	public String landingPageItem;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	
	public TestContextSetup()
	{
		testBase=new TestBase();
		genericUtils=new GenericUtils(testBase.WebDriverManager());
		 pageObjectManager=new PageObjectManager(testBase.WebDriverManager());
	}
}
