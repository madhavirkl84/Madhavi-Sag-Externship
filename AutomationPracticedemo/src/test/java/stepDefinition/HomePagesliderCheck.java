package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PageObjectSlidecheck;
import utils.PageObjectUtils;

public class HomePagesliderCheck {
	TestContext context; 
	PageObjectUtils pageObjectUtils;
	PageObjectSlidecheck slideCheck;
	
	//Dependency Injection through Constructor
	public HomePagesliderCheck(TestContext context) {
		
		this.context = context;
		this.pageObjectUtils = this.context.pageObjectUtils;
		this.slideCheck = this.context.pageObjectManager.getHomeSlider();
	}
	
	@Given("^Open the browser$") 
	    public void open_the_browser() throws Throwable {
		pageObjectUtils.openLandingPage();
	       
	    }

	 
	    @When("^Click on Shop Menu$")
	    public void click_on_shop_menu() throws Throwable {
	    	slideCheck.clickShop();
	     
	    }

	    @Then("^Test whether the Home page has Three Sliders only$")
	    public void test_whether_the_home_page_has_three_sliders_only() throws Throwable {
	    	slideCheck.homeslider();
	    }

	    
	    @And("^Now click on Home menu button$")
	    public void now_click_on_home_menu_button() throws Throwable {
	        slideCheck.homepage();
	        
	        
	    }
	    
	
}

