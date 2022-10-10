package pageObjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopProductCategoryObj {
	
	WebDriver driver ;
	
	static final String ANDROID = "Android";
	static final String HTML = "HTML";
	static final String JS = "JavaScript";
	static final String SELENIUM = "selenium";
	
	By productCateAndroid = By.linkText(ANDROID);
	By productCateHTML = By.linkText(HTML);
	By productCateJavaScript = By.linkText(JS);
	By productCateSelenium = By.linkText(SELENIUM);
	By catetegory = By.xpath("//nav[@class='woocommerce-breadcrumb']");
		
	public ShopProductCategoryObj(WebDriver driver) {
		
		this.driver = driver;	
		
	}
	
	public WebElement getCategory() {
		
		return driver.findElement(catetegory);
	}
	
	public void selectProductCategory(String productName) {
		
		if (productName.equalsIgnoreCase(ANDROID)) {
			driver.findElement(productCateAndroid).click();
			
			assertTrue(getCategory().getText().contains(ANDROID));
		} else if (productName.equalsIgnoreCase(HTML)) {
			driver.findElement(productCateHTML).click();
			assertTrue(getCategory().getText().contains(HTML));
		} else if (productName.equalsIgnoreCase(JS)) {
			driver.findElement(productCateJavaScript).click();
			assertTrue(getCategory().getText().contains(JS));
		} else if (productName.equalsIgnoreCase(SELENIUM)) {
			driver.findElement(productCateSelenium).click();
			assertTrue(getCategory().getText().contains(SELENIUM));
		}
		
	}
	
	public void verifyProductCategory(String productName) {
		assertTrue(getCategory().getText().contains(productName));
		
	}
	
	
	
	

}
