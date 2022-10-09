package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

//Manager class for initializing driver once
public class DriverManager {

	public WebDriver driver;

	public WebDriver getDriver() {
		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(new ChromeOptions());
		}

		return driver;
	}

	public void close() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
