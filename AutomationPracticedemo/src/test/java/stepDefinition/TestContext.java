package stepDefinition;

import org.openqa.selenium.WebDriver;
import driverManger.DriverManager;
import pageObjects.PageobjectManager;
import utils.PageObjectUtils;


//Class used for Dependency Injection into Step Definition classes
public class TestContext {
	WebDriver driver;
	PageobjectManager pageObjectManager;
	PageObjectUtils pageObjectUtils;
	DriverManager driverManager;
	
	public TestContext() {
		driverManager = new DriverManager();
		driver = driverManager.getDriver();
		pageObjectManager = new PageobjectManager(driver);
		pageObjectUtils = new PageObjectUtils(driver);
		
	}
			


}
