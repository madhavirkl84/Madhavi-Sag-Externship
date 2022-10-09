package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PageObjectLaptop;
import utils.PageObjectUtils;

public class LaptopPageStepDefinition {

	TestContext context;
	PageObjectUtils pageObjectUtils;
	PageObjectLaptop pageObjectLaptop;
	
	//Dependency Injection through Constructor
	public LaptopPageStepDefinition(TestContext context) {
		this.context = context;
		this.pageObjectUtils = this.context.pageObjectUtils;
		this.pageObjectLaptop = this.context.pageObjectManager.getLaptopPage();				
	}
	
	@Given("^User is on Flipkart home page$")
	public void user_is_on_flipkart_home_page() throws Throwable {
		pageObjectUtils.openLandingPage();
	}

	@When("^close the login popup$")
	public void close_the_login_popup() throws Throwable {
		pageObjectUtils.closePopup();
	}

	@Then("^search for \"([^\"]*)\" using searchbar$")
	public void search_for_laptop_using_searchbar(String searchStr) throws Throwable {
		pageObjectLaptop.searchLaptops(searchStr); 
	}

	@Then("^select PROCESSOR$")
	public void select_processor() throws Throwable {
		pageObjectLaptop.selectProcessor();
	}

	@Then("^select BRAND$")
	public void select_brand() throws Throwable {
		pageObjectLaptop.selectBrand();
	}

	@Then("^select TYPE$")
	public void select_type() throws Throwable {
		pageObjectLaptop.selectType();
	}

	@Then("^select the laptop open in new page$")
	public void select_the_laptop_open_in_new_page() throws Throwable {
		pageObjectLaptop.openLaptopDetailsPage();
	}

	@Then("^Add pincode for laptop before adding it to cart$")
	public void Add_pincode_for_laptop_before_adding_it_to_cart() throws Throwable {
		pageObjectUtils.checkPincode();
	}

	@Then("^Add to cart the selected item$")
	public void add_to_cart_the_selected_item() throws Throwable {
		pageObjectUtils.addToCart();
	}
	
	
}
