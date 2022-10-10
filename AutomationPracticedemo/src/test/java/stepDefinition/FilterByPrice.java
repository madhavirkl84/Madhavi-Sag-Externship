package stepDefinition;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PageObjectSlidecheck;
import utils.PageObjectUtils;

public class FilterByPrice {
	
	TestContext context;
	PageObjectUtils pageObjectUtils;
	PageObjectSlidecheck slideCheck;	 
	 
	//Dependency Injection through Constructor
	public FilterByPrice(TestContext context) {
		
		this.context = context;
		this.pageObjectUtils = this.context.pageObjectUtils;
		this.slideCheck = this.context.pageObjectManager.getHomeSlider();
		
	}

	
	@Given("Open the shop testcase page")
	public void open_the_shop_testcase() {
		pageObjectUtils.openLandingPage(); 
	   
	}
	@When("Click Shop Menu")
	public void click_shop_menu() throws Throwable {
		
		slideCheck.clickShop();
	   
	}
	@Then("Adjust the filter by price between {string} to {string} rps")
	public void adjust_the_filter_by_price_between_to_rps(String rangeStart, String rangeEnd) throws Throwable {
	    context.pageObjectManager.getPriceSlider().priceFilter(Integer.valueOf(rangeStart), Integer.valueOf(rangeEnd));
	}
	@Then("Now click on Filter button") 
	public void now_click_on_filter_button() throws Throwable{
	   context.pageObjectManager.getPriceSlider().clickFilterButton();
	}
	@Then("User can view books only between {string} to {string} rps price")
	public void user_can_view_books_only_between_to_rps_price(String rangeStart, String rangeEnd) throws Throwable {
	   context.pageObjectManager.getPriceSlider().verifyBooksPrice(Integer.valueOf(rangeStart), Integer.valueOf(rangeEnd)); 
	}

}
