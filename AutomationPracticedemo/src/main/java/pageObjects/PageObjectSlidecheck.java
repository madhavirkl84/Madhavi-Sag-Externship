package pageObjects;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.PageObjectUtils;

public class PageObjectSlidecheck {
	PageObjectUtils pageUtils;
	
	WebDriver driver;
	By shoplink = By.xpath("//a[normalize-space()='Shop']");
	By homeLink = By.linkText("Home");	
	By navigation = By.xpath("//nav[@class='woocommerce-breadcrumb']");
	
	public PageObjectSlidecheck(WebDriver driver) {
		this.driver = driver;
		pageUtils = new PageObjectUtils(driver);
		
	}
	
	public WebElement getNav() {
		
		return driver.findElement(navigation);
	}
	
	public void clickShop() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(shoplink).click();
		
		
	}
	
	public void homepage() throws InterruptedException {
		pageUtils.moveToChildwindow();
		Thread.sleep(600);
		driver.findElement(homeLink).click();
	}
	
	public void homeslider() {
		
		WebElement image;
		

		WebElement arrow = driver.findElement(By.xpath("//div[@id='n2-ss-6-arrow-next']//img[@alt='Arrow']"));

		List<String> images = new ArrayList<>();
		String imgAltString;
		int i = 1;
		while (true) {
			
			try {
				image = driver.findElement(By.xpath("(//img[@class='n2-ss-slide-background-image n2-ss-slide-fill n2-ow'])[" + i + "]"));				
			} catch (org.openqa.selenium.NoSuchElementException ex) {
				break;
			}
			
			imgAltString = image.getAttribute("alt");
			if (!images.contains(imgAltString)) {
				images.add(imgAltString);
				arrow.click();
				i++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}				
					
			} else {
				break;
			}
		}
		assertTrue(3 == images.size());
		
		
		
		
	}
}