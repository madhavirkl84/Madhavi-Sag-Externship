package pageObjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopSaleFunctionality {
	
	WebDriver driver;
	By productOnSale = By.xpath("(//span[@class='onsale'][normalize-space()='Sale!'])[1]");
	By oldPrice = By.xpath("//del//span[@class='woocommerce-Price-amount amount']");
	By salePrice = By.xpath("//ins//span[@class='woocommerce-Price-amount amount']");
	
	public WebElement getOldPriceElement() {
		return driver.findElement(oldPrice);
	}
	
	public WebElement getSalePriceElement() {
		return driver.findElement(salePrice);
	}
	
	public ShopSaleFunctionality(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getSaleProduct() throws InterruptedException{
		Thread.sleep(500);
		driver.findElement(productOnSale).click();
	}
	
	public void verifyOldAndSalePrice() {
		assertTrue(getOldPriceElement().getText() != null);
		assertTrue(getSalePriceElement().getText() != null);
	}

}
