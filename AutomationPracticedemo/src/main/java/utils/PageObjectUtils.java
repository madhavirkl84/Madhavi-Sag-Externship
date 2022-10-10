package utils;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

//import static org.junit.Assert.assertNotNull;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObjectUtils {
	
	WebDriver driver;
	
	public PageObjectUtils(WebDriver driver) {
		
		this.driver = driver;	
		
	}
	
	public void openLandingPage() {
		driver.get(" https://practice.automationtesting.in/test-cases");
		driver.manage().window().maximize();
	
	}
	
 public void moveToChildwindow() {
	 
	 String mainWindow = driver.getWindowHandle();
	 Set<String> openWindows =driver.getWindowHandles();
	 Iterator<String> iterator = openWindows.iterator();
	 
	 while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			
			if (!mainWindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
			}
		}
 }
 
 public void waitTillElementgetsLoaded() {
	 
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
 } 
}
