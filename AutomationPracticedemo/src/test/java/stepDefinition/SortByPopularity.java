package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PageObjectSlidecheck;
import utils.PageObjectUtils;

public class SortByPopularity {
	
	TestContext context;
	PageObjectUtils pageObjectUtils;
	PageObjectSlidecheck slideCheck;	 
	 
	//Dependency Injection through Constructor
	public SortByPopularity(TestContext context) {
		
		this.context = context;
		this.pageObjectUtils = this.context.pageObjectUtils;
		this.slideCheck = this.context.pageObjectManager.getHomeSlider();
		
	}
 
	@Given("Open automationtesting page")
	public void open_automationtesting_page() {
		pageObjectUtils.openLandingPage();
	}

	@When("Click on Shop Menu for sorthing")
	public void click_on_shop_menu_for_sorthing() throws Throwable {
		slideCheck.clickShop();
	}

	@Then("Click on {string} item in Default sorting dropdown")
	public void click_on_item_in_default_sorting_dropdown(String proName) {
		context.pageObjectManager.sortByPopularity().sortByPopularPro(proName);
	  
	}

	@Then("Now user can view the popular products only")
	public void now_user_can_view_the_popular_products_only() {
		context.pageObjectManager.sortByPopularity().viewByPopularity();
	}
	
}
