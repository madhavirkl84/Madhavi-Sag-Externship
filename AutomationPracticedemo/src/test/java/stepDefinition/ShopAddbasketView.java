package stepDefinition;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PageObjectSlidecheck;
import utils.PageObjectUtils;

public class ShopAddbasketView {
	
	TestContext context; 
	PageObjectUtils pageObjectUtils;
	PageObjectSlidecheck slideCheck;
	
	//Dependency Injection through Constructor
	public ShopAddbasketView(TestContext context) {
		
		this.context = context;
		this.pageObjectUtils = this.context.pageObjectUtils;
		this.slideCheck = this.context.pageObjectManager.getHomeSlider();
	}
	
	@Given("Open automationtesting page for View Basket")
	public void open_automationtesting_page_for_view_basket() {
		pageObjectUtils.openLandingPage();
	}
 
	@When("Click on Shop Menu for View Basket")
	public void click_on_shop_menu_for_view_basket() throws Throwable {
		slideCheck.clickShop();
	   
	}

	@Then("Click on the Add To Basket to add book to your basket")
	public void click_on_the_add_to_basket_button() {
	   context.pageObjectManager.getAddViewBasket().clickAddBasket();
	}

	@Then("User can view that Book in the Menu item with price")
	public void user_can_view_that_book_in_the_menu_item_with_price() {
	   
	}

	@Then("Click on View Basket link to proceed to check out page")
	public void click_on_view_basket_link_to_proceed_to_check_out_page() {
		context.pageObjectManager.getAddViewBasket().clickViewBasket();
	   
	}

	@Then("User can find total and subtotal values just above the Proceed to Checkout button")
	public void user_can_find_total_and_subtotal_values_just_above_the_proceed_to_checkout_button() {
	    context.pageObjectManager.getAddViewBasket().checkTotalSubTotal();
	}

	@Then("Total always < subtotal as taxes are added in the subtotal")
	public void total_always_subtotal_as_taxes_are_added_in_the_subtotal() {
	   
	}

	@Then("Click on Proceed to Check out button to payment gateway page")
	public void click_on_proceed_to_check_out_button_to_payment_gateway_page() {
		context.pageObjectManager.getAddViewBasket().proceedCheckOut();
	   
	}

	@Then("View Billing,Order,Additional details and Payment gateway details")
	public void view_billing_order_additional_details_and_payment_gateway_details() {
		context.pageObjectManager.getAddViewBasket().checkOrderBillingAdditionalDetails();
	}

	@Then("^User can fill billing details form and can opt any payment in the payment gateway.$")
	public void user_can_fill_billing_details_form_and_can_opt_any_payment_in_the_payment_gateway(DataTable data) {
		context.pageObjectManager.getAddViewBasket().fillForm(data);
	}

	@Then("Click on Place Order button to complete process")
	public void click_on_place_order_button_to_complete_process() {
		context.pageObjectManager.getAddViewBasket().clickPlaceOrder();
	    
	}

	@Then("After place order user completes his process and navigates to Order confirmation page with order, bank, customer and billing details.")
	public void after_place_order_user_completes_his_process_and_navigates_to_order_confirmation_page_with_order_bank_customer_and_billing_details() {
		context.pageObjectManager.getAddViewBasket().orderConfirmation();   
	}

}
