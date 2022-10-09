package stepDefinitions;

import org.openqa.selenium.WebDriver;

import pageObjects.DriverManager;
import pageObjects.PageObjectManager;
import utils.PageObjectUtils;

//Class used for Dependency Injection into Step Definition classes
public class TestContext {

	WebDriver driver;
	PageObjectManager pageObjectManager;
	PageObjectUtils pageObjectUtils;
	DriverManager driverManager;
	
	public TestContext() {
		driverManager = new DriverManager();
		driver = driverManager.getDriver();
		pageObjectUtils = new PageObjectUtils(driver);
		pageObjectManager = new PageObjectManager(driver);
	}
}
