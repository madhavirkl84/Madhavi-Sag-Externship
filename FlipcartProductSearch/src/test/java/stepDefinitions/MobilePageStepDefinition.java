package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PageObjectMobile;
import utils.PageObjectUtils;

public class MobilePageStepDefinition {

	TestContext context;
	PageObjectUtils pageObjectUtils;
	PageObjectMobile pageObjectMobile;
	
	//Dependency Injection through Constructor
	public MobilePageStepDefinition(TestContext context) {
		this.context = context;
		this.pageObjectUtils = this.context.pageObjectUtils;
		this.pageObjectMobile = this.context.pageObjectManager.getMobilePage();
	}
	
	@Given("^User is on flipkart landing page$")
	public void user_is_on_flipkart_landing_page() throws Throwable {
		pageObjectUtils.openLandingPage();
	}

	@When("^Close the login popupM$")
	public void close_the_login_popupm() throws Throwable {
		pageObjectUtils.closePopup();
	}

	@Then("^search for the \"([^\"]*)\" using searchbar$")
	public void search_for_mobles_using_searchbar(String searchStr) throws Throwable {
		pageObjectMobile.searchMobile(searchStr); 
	}

	@Then("^select brand, RAM and ratings$")
	public void select_brand_ram_and_ratings() throws Throwable {
		pageObjectMobile.selectBrandRamRatings();
	}

	@Then("^select the mobile open in new page$")
	public void select_the_mobile_open_in_new_page() throws Throwable {
		pageObjectMobile.openMobileDetailsPage();
	}

	@Then("^Add pincode before adding it to cart$")
	public void Add_pincode_before_adding_it_to_cart() throws Throwable {
		pageObjectUtils.checkPincode();
	}

	@Then("^Add to cart the selected mobile$")
	public void add_to_cart_the_selected_mobile() throws Throwable {
		pageObjectUtils.addToCart();
	}
}
