package pageObjects;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PriceFilterSlider {
	
	WebDriver driver;
	By filter = By.cssSelector("button[type='submit']");
	By to = By.xpath("//span[@class='to']");
	By from = By.xpath("//span[@class='from']");
	By sliderLeft = By.xpath("//div[@class='price_slider ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content']//span[1]");
	By sliderRight = By.xpath("//div[@class='price_slider ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content']//span[2]");	
	
	public PriceFilterSlider(WebDriver driver) {
		this.driver =  driver;
	}
		
	public void priceFilter(int rangeStart, int rangeEnd) {
		
		int maxPrice = Integer.parseInt(driver.findElement(to).getText().substring(1));
		int minPrice = Integer.parseInt(driver.findElement(from).getText().substring(1));
				
		WebElement maxSlider = driver.findElement(sliderRight);
		WebElement minSlider = driver.findElement(sliderLeft);

		if (rangeStart > minPrice) {
			for (int i = 0; i < rangeStart - minPrice; i++) {
				minSlider.sendKeys(Keys.ARROW_RIGHT);
			}
		}
		
		if (rangeEnd < maxPrice) {
			for (int i = 0; i < maxPrice - rangeEnd; i++) {
				maxSlider.sendKeys(Keys.ARROW_LEFT);
			}
		}
				
	}
	
	public void clickFilterButton() {
		
		driver.findElement(filter).click();
	}
	
	public void verifyBooksPrice(int rangeStart, int rangeEnd) {
		List<WebElement> priceTags = driver.findElements(By.xpath("//span[contains(@class,'woocommerce-Price-amount amount')]"));
		
		float price;
		for (WebElement element : priceTags) {
			WebElement parent = (WebElement) ((JavascriptExecutor) driver).executeScript(
                    "return arguments[0].parentNode;", element);
			if(!"del".equals(parent.getTagName())) {
				price = Float.parseFloat(element.getText().substring(1));
				assertTrue(price >= rangeStart && price <= rangeEnd);
			}
		}
	}
	

}
