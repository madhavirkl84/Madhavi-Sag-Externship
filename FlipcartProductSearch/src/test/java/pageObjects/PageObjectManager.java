package pageObjects;

import org.openqa.selenium.WebDriver;

//Manager class for getting the page object models
public class PageObjectManager {

	WebDriver driver;
	PageObjectLaptop laptopPage;
	PageObjectMobile mobilePage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public PageObjectLaptop getLaptopPage() {
		laptopPage = new PageObjectLaptop(driver);
		return laptopPage;
	}

	public PageObjectMobile getMobilePage() {
		mobilePage = new PageObjectMobile(driver);
		return mobilePage;
	}

}
