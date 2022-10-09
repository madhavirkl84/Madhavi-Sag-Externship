package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObjectMobile {
	WebDriver driver ;
	
	By searchbar = By.xpath("//input[@name='q']");
	By searchButton = By.xpath("//button[@class='L0Z3Pu']");
	By mobileName = By.xpath("//div[contains(text(), 'POCO')]");
	By ram = By.xpath("//div[contains(text(), '4 GB')]");
	By rating = By.xpath("//div[contains(text(), '4★ & above')]");
	By mobile = By.xpath("//body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/a[1]");
	
	public PageObjectMobile(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void searchMobile(String searchStr) {
		driver.findElement(searchbar).sendKeys(searchStr);
    	driver.findElement(searchButton).click();
		
	}
	
	public void selectBrandRamRatings() throws InterruptedException {
		
		Thread.sleep(2000);
    	driver.findElement(mobileName).click();
    	Thread.sleep(2000);
    	driver.findElement(ram).click();
    	Thread.sleep(2000);
    	driver.findElement(rating).click();
    	
		
	}
	public void openMobileDetailsPage() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(mobile).click();
	}
	
	

}
