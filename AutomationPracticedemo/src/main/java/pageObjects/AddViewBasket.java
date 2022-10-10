package pageObjects;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.datatable.DataTable;

public class AddViewBasket {
  WebDriver driver ;
  
  By addToBasket =By.xpath("(//a[@rel='nofollow'][normalize-space()='Add to basket'])[1]");
  By viewBasket = By.xpath("//a[normalize-space()='View Basket']");
  By subTotal = By.xpath("//td[@data-title='Subtotal']//span[@class='woocommerce-Price-amount amount']");
  By totalPrice = By.xpath("//strong//span[@class='woocommerce-Price-amount amount']");
  By checkOut = By.xpath("//a[normalize-space()='Proceed to Checkout']");
  By billingDetails = By.xpath("//h3[normalize-space()='Billing Details']");
  By additionalDetails = By.xpath("//h3[normalize-space()='Additional Information']");
  By orderDetails = By.xpath("//h3[@id='order_review_heading']");
  By bankTransfer = By.xpath("//input[@id='payment_method_bacs']");
  By checkPay = By.xpath("//input[@id='payment_method_cheque']");
  By codPay = By.xpath("//input[@id='payment_method_cod']");
  By payPal = By.xpath("//input[@id='payment_method_ppec_paypal']");
  
  By firstName = By.xpath("//input[@id='billing_first_name']");
  By lastName = By.xpath("//input[@id='billing_last_name']");
  By companyName = By.xpath("//input[@id='billing_company']");
  By email = By.xpath("//input[@id='billing_email']");
  By phoneNo = By.xpath("//input[@id='billing_phone']");
  By country = By.xpath("id=select2-chosen-1");
  By address = By.xpath("//input[@id='billing_address_1']");
  By address2 = By.xpath("//input[@id='billing_address_2']");
  By city = By.xpath("//input[@id='billing_city']");
  By state= By.xpath("//input[@id='billing_state']");
  By pincode = By.xpath("//input[@id='billing_postcode']");
  By additionalComment = By.xpath("//textarea[@id='order_comments']");
  By placeOrder = By.xpath("//input[@id='place_order']");
  By orderDetail= By.xpath("//h2[normalize-space()='Order Details']");
  
  public AddViewBasket(WebDriver driver) {
	  this.driver= driver;  
	  
  }
  
  public void clickAddBasket() {
	  driver.findElement(addToBasket).click();
	  try {
		Thread.sleep(500);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
  
  public void clickViewBasket() {
	  driver.findElement(viewBasket).click();
 }
  
 public void checkTotalSubTotal() {
	 String total = driver.findElement(totalPrice).getText();
	 String subTotalPrice = driver.findElement(subTotal).getText();
	 float priceTotal = Float.valueOf(total.substring(1));
	 float priceSubTotal = Float.valueOf(subTotalPrice.substring(1));
	 assertTrue(priceSubTotal > 0);
	 assertTrue(priceTotal > 0);
 }
  
 public void proceedCheckOut(){
	 
	 driver.findElement(checkOut).click();
 }
  
 public void checkOrderBillingAdditionalDetails() {
	 
	 assertTrue(driver.findElement(additionalDetails).getText().contains("Additional Information"));
	 assertTrue(driver.findElement(billingDetails).getText().contains("Billing Details"));
	 assertTrue(driver.findElement(orderDetails).getText().contains("Your order"));
	 //assertTrue(driver.findElement(bankTransfer).getText().contains("Direct Bank Transfer"));
	 //assertTrue(driver.findElement(checkPay).getText().contains("Check Payments"));
	 //assertTrue(driver.findElement(codPay).getText().contains("Cash on Delivery"));
	 //assertTrue(driver.findElement(payPal).getText().contains("PayPal Express Checkout"));
 }
 
 public void fillForm(DataTable data) {
	 	
	 
		List<Map<String,String>> dataMap = data.asMaps(String.class,String.class);
		String firstName = dataMap.get(0).get("firstName");
		String lastName = dataMap.get(0).get("lastName");
		String companyName = dataMap.get(0).get("companyName");
		String email = dataMap.get(0).get("emailAddress");
		String phone = dataMap.get(0).get("phone no");
		String country = dataMap.get(0).get("country");
		String address = dataMap.get(0).get("address");
		String address2 = dataMap.get(0).get("address2");
		String city = dataMap.get(0).get("city");
		String state = dataMap.get(0).get("state");
		String pincode = dataMap.get(0).get("pincode");
		String additionalComment = dataMap.get(0).get("additionalComment");
		
		driver.findElement(this.firstName).sendKeys(firstName);
		driver.findElement(this.lastName).sendKeys(lastName);
		driver.findElement(this.companyName).sendKeys(companyName);
		driver.findElement(this.email).sendKeys(email);
		driver.findElement(this.phoneNo).sendKeys(phone);
	 	driver.findElement(By.xpath("//div[@id='s2id_billing_country']")).click();
	 	Select bCountry = new Select(driver.findElement(By.name("billing_country")));
		bCountry.selectByVisibleText(country);
		
		driver.findElement(By.xpath("//input[@id='s2id_autogen1_search']")).sendKeys(Keys.ESCAPE);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(this.address).sendKeys(address);
		driver.findElement(this.address2).sendKeys(address2);
		driver.findElement(this.city).sendKeys(city);
	 	WebElement e = driver.findElement(By.xpath("//body/div[1]"));
		((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView();", e);		
		e.click();
	 	List<WebElement> lis = driver.findElements(By.xpath("//body[1]/div[5]/ul[1]"));
	 	for (WebElement element : lis) {
	 		System.out.println(element.getText());
	 	}
	 	

		driver.findElement(this.pincode).sendKeys(pincode);
		driver.findElement(this.additionalComment).sendKeys(additionalComment);
		}
public void clickPlaceOrder() {
	driver.findElement(placeOrder).click();
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public void orderConfirmation() {
	
	assertTrue(driver.findElement(orderDetail).getText().contains("Order Details"));
}
}
