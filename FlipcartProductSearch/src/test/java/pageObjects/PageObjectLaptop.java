package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectLaptop {
	WebDriver driver;

	By searchbar = By.xpath("//input[@name='q']");
	By searchButton = By.xpath("//button[@class='L0Z3Pu']");
	By processorType = By.xpath("//div[contains(text(), 'Core i5')]");
	By brandHeader = By.xpath("//div[@class='_2gmUFU _3V8rao'][normalize-space()='Brand']");
	By brandName = By.xpath("//div[@title='DELL']//input[@type='checkbox']");
	By laptopTypeHeader = By.xpath("//div[@class='_2gmUFU _3V8rao'][normalize-space()='Type']");
	By laptopType = By.xpath("//div[contains(text(), 'Thin and Light Laptop')]");
	By laptop = By.xpath("//body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/a[1]");

	public PageObjectLaptop(WebDriver driver) {
		this.driver = driver;
	}

	public void searchLaptops(String searchStr) {
		driver.findElement(searchbar).sendKeys(searchStr);
		driver.findElement(searchButton).click();
	}

	public void selectProcessor() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(processorType)).click();		
	}

	public void selectBrand() throws InterruptedException {

		WebElement brandHeader = driver.findElement(this.brandHeader);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", brandHeader);
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", brandHeader);
		 Thread.sleep(2000);

		WebElement brandName = driver.findElement(this.brandName);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", brandName);
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", brandName);
	}

	public void selectType() throws InterruptedException {
		WebElement type = driver.findElement(laptopTypeHeader);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", type);
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", type);

		WebElement thinLaptop = driver.findElement(laptopType);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", thinLaptop);
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", thinLaptop);
	}

	public void openLaptopDetailsPage() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(laptop).click();
	}
}
