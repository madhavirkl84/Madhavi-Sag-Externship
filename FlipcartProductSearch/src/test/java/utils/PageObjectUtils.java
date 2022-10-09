package utils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObjectUtils {

	WebDriver driver;

	public PageObjectUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void openLandingPage() {
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		assertNotNull(driver.findElement(By.xpath("//a[contains(text(), 'New to Flipkart? Create an account')]")));
	}

	public void closePopup() {
		driver.findElement(By.xpath("//button[contains(text(),'✕')]")).click();
	}

	public void moveToChildWindow() {
		String mainWindow = driver.getWindowHandle();
		Set<String> openedWindows = driver.getWindowHandles();
		Iterator<String> iterator = openedWindows.iterator();

		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			
			if (!mainWindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
			}
		}
	}

	public void checkPincode() throws InterruptedException {
		moveToChildWindow();
		By pincode = By.xpath("//input[@id='pincodeInputId']");
		driver.findElement(pincode).sendKeys("560087");

		By check = By.xpath("//span[@class='_2P_LDn']");
		driver.findElement(check).click();
	}

	public void addToCart() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='_1p3MFP dTTu2M']//li[1]")).click();
	}
}
