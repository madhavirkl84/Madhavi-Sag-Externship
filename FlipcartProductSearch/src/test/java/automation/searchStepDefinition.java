package automation;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class searchStepDefinition {
	private WebDriver driver ;
	   @Given("^User is on Flipkart home page$")
	    public void user_is_on_flipkart_home_page() throws Throwable {
		    WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(new ChromeOptions());
			driver.get("https://www.flipkart.com");
			driver.manage().window().maximize(); 
		   
	    }

	    @When("^close the login popup$")
	    public void close_the_login_popup() throws Throwable {
	    	
	  driver.findElement(By.xpath("//button[contains(text(),'✕')]")).click();
	    	
	   //driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
	    	
	    }

	    @Then("^search for laptop using searchbar$")
	    public void search_for_laptop_using_searchbar() throws Throwable {
	    	
	    	By searchbar = By.xpath("//input[@name='q']");
	    	driver.findElement(searchbar).sendKeys("Laptop");
	    	By searchButton = By.xpath("//button[@class='L0Z3Pu']");
	    	driver.findElement(searchButton).click();
	    	
	    }
 
	    @Then("^select PROCESSOR$")
	    public void select_processor() throws Throwable {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(), 'Core i5')]"))).click();
	      	System.out.println("line 4");
	    }

	    @Then("^select BRAND$")
	    public void select_brand() throws Throwable {
	    	JavascriptExecutor js = (JavascriptExecutor) driver; // Scrolling using JavascriptExecutor
	    	js.executeScript("window.scrollBy(0,1500)");// Scroll Down to file upload button (+ve)

	    	WebElement element = driver.findElement(By.xpath("//div[@class='_2gmUFU _3V8rao'][normalize-space()='Brand']"));
	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	    	Thread.sleep(500); 
	    	((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
	    	//Thread.sleep(2000);
	    		    	
	    	WebElement element2 = driver.findElement(By.xpath("//div[@class='_3879cV'][normalize-space()='DELL']"));
	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
	    	Thread.sleep(500); 
	    	((JavascriptExecutor)driver).executeScript("arguments[0].click();", element2);

	    }

	    @Then("^select TYPE$")
	    public void select_type() throws Throwable {
	    	WebElement type = driver.findElement(By.xpath("//div[@class='_2gmUFU _3V8rao'][normalize-space()='Type']"));
	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", type);
	    	Thread.sleep(500); 
	    	((JavascriptExecutor)driver).executeScript("arguments[0].click();", type);
	    	
	    	WebElement thinLaptop = driver.findElement(By.xpath("//div[contains(text(), 'Thin and Light Laptop')]"));
	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", thinLaptop);
	    	Thread.sleep(500); 
	    	((JavascriptExecutor)driver).executeScript("arguments[0].click();", thinLaptop);
	    	
	    	
	    	
	    	System.out.println("line 6");
	    }

	    @Then("^select the laptop open in new page$")
	    public void select_the_laptop_open_in_new_page() throws Throwable {
	    	
	    	Thread.sleep(500);
	    	driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/a[1]")).click();
	    	System.out.println("line 7");
	    }
	    
	    @Then("^Add pincode for laptop before adding it to cart$")
        public void Add_pincode_for_laptop_before_adding_it_to_cart()throws Throwable {
  	
        	moveToChildWindow();
        	Thread.sleep(500);
        	By pincode = By.xpath("//input[@id='pincodeInputId']");
        	driver.findElement(pincode).sendKeys("560087");
        	
        	By check = By.xpath("//span[@class='_2P_LDn']");
        	driver.findElement(check).click();
        }

	    @Then("^Add to cart the selected item$")
	    public void add_to_cart_the_selected_item() throws Throwable {
	    	
	    	System.out.println(driver.getTitle());
	    	Thread.sleep(500);
	    	//moveToChildWindow();
	    	System.out.println(driver.getTitle());
	    	Thread.sleep(2000);
	    	driver.findElement(By.xpath("//div[@class='_1p3MFP dTTu2M']//li[1]")).click();
	    	
	    	System.out.println("line 11");  
	    }
	    
		public void moveToChildWindow() {
			String mainWindow = driver.getWindowHandle();
			Set<String> openedWindows = driver.getWindowHandles();
			Iterator<String> iterator = openedWindows.iterator();

			// Here we will check if child window has other child windows and will fetch the
			// heading of the child window
			while (iterator.hasNext()) {
				String ChildWindow = iterator.next();
				System.out.println(ChildWindow);
				if (!mainWindow.equalsIgnoreCase(ChildWindow)) {
					driver.switchTo().window(ChildWindow);
				}
			}
		}


	    
	      @Given("^User is on flipkart landing page$")
	         public void user_is_on_flipkart_landing_page() throws Throwable {
	    	  WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(new ChromeOptions());
				driver.get("https://www.flipkart.com");
				driver.manage().window().maximize();
	        }

	        @When("^Close the login popupM$")
	        public void close_the_login_popupm() throws Throwable {
	        	driver.findElement(By.xpath("//button[contains(text(),'✕')]")).click();
	        }

	        @Then("^search for mobles using searchbar$")
	        public void search_for_mobles_using_searchbar() throws Throwable {
	        	By searchbar = By.xpath("//input[@name='q']");
	        	driver.findElement(searchbar).sendKeys("mobile");
	        	By searchButton = By.xpath("//button[@class='L0Z3Pu']");
	        	driver.findElement(searchButton).click();
	        }

	        @Then("^select brand, RAM and ratings$")
	        public void select_brand_ram_and_ratings() throws Throwable {
	        	
	        	Thread.sleep(2000);
	        	driver.findElement(By.xpath("//div[contains(text(), 'POCO')]")).click();
	        	Thread.sleep(2000);
	        	driver.findElement(By.xpath("//div[contains(text(), '4 GB')]")).click();
	        	Thread.sleep(2000);
	        	driver.findElement(By.xpath("//div[contains(text(), '4★ & above')]")).click();
	        	System.out.println("line 15"); 
	        }

	        @Then("^select the mobile open in new page$")
	        public void select_the_mobile_open_in_new_page()throws Throwable {
	        	
	        	Thread.sleep(2000);
	        	driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/a[1]")).click();
	        	System.out.println("line 16");
	        }
	        
	        @Then("^Add pincode before adding it to cart$")
	        public void Add_pincode_before_adding_it_to_cart()throws Throwable {
      	
	        	moveToChildWindow();
	        	Thread.sleep(500);
	        	By pincode = By.xpath("//input[@id='pincodeInputId']");
	        	driver.findElement(pincode).sendKeys("560087");
	        	
	        	By check = By.xpath("//span[@class='_2P_LDn']");
	        	driver.findElement(check).click();
	        }

	        @Then("^Add to cart the selected mobile$")
	        public void add_to_cart_the_selected_mobile() throws Throwable {
	        	
	        	//moveToChildWindow();
	        	Thread.sleep(2000);
	        	driver.findElement(By.xpath("//div[@class='_1p3MFP dTTu2M']//li[1]")).click();	        	
	        	System.out.println("line 17");
	        }

		
}
