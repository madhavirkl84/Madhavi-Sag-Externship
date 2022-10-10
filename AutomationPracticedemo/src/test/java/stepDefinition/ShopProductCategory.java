package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PageObjectSlidecheck;
import utils.PageObjectUtils;

public class ShopProductCategory {
	
	TestContext context;
	PageObjectUtils pageObjectUtils;
	PageObjectSlidecheck slideCheck;	 
	 
	//Dependency Injection through Constructor
	public ShopProductCategory(TestContext context) {
		
		this.context = context;
		this.pageObjectUtils = this.context.pageObjectUtils;
		this.slideCheck = this.context.pageObjectManager.getHomeSlider();
		
	}
	
	@Given("Open automationtesting page for product category")
	public void open_automationtesting_page_for_product_category() {
		pageObjectUtils.openLandingPage();
	    
	}

	@When("Click on Shop Menu for product category")
	public void click_on_shop_menu_for_product_category() throws Throwable {
		
		slideCheck.clickShop();
	   
	}

	@Then("Click any of the product links available in the {string}") 
	public void click_any_of_the_product_links_available_in_the_product_category(String Category) throws Throwable {
	   context.pageObjectManager.getProductCategory().selectProductCategory(Category);
	}

	@Then("Now user can view only that particular product {string}")
	public void now_user_can_view_only_that_particular_product(String productName) throws Throwable {
		context.pageObjectManager.getProductCategory().verifyProductCategory(productName);
		
	    
	}

}
