package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PageObjectSlidecheck;
import utils.PageObjectUtils;

public class ReadMoreFunctionality {
	
	TestContext context;
	PageObjectUtils pageObjectUtils;
	PageObjectSlidecheck slideCheck;	 
	 
	//Dependency Injection through Constructor
	public ReadMoreFunctionality(TestContext context) {
		
		this.context = context;
		this.pageObjectUtils = this.context.pageObjectUtils;
		this.slideCheck = this.context.pageObjectManager.getHomeSlider();
		
	}
	
	@Given("Open automationtesting page for item read more")
	public void open_automationtesting_page_for_item_read_more() {
		pageObjectUtils.openLandingPage();
	}
 
	@When("Click on Shop Menu for item read more")
	public void click_on_shop_menu_for_item_read_more() throws Throwable {
			slideCheck.clickShop();
	}

	@Then("Click on read more button in home page")
	public void click_on_read_more_button_in_home_page() throws Throwable{
		context.pageObjectManager.getReadMoreFun().checkOutofStock();	    
	}

	@Then("Read More option indicates the Out Of Stock.") 
	public void read_more_option_indicates_the_out_of_stock() throws Throwable{
		context.pageObjectManager.getReadMoreFun().productOutofStock();
	  }

	@Then("User cannot add the product which has read more option as it was out of stock.")
	public void user_cannot_add_the_product_which_has_read_more_option_as_it_was_out_of_stock()throws Throwable {
		context.pageObjectManager.getReadMoreFun().productOutofStock(); 
	}

}
