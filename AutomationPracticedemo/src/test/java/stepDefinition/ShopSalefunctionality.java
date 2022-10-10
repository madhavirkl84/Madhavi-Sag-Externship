package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PageObjectSlidecheck;
import utils.PageObjectUtils;

public class ShopSalefunctionality {
	
	TestContext context;
	PageObjectUtils pageObjectUtils;
	PageObjectSlidecheck slideCheck;	 
	 
	//Dependency Injection through Constructor
	public ShopSalefunctionality(TestContext context) {
		
		this.context = context;
		this.pageObjectUtils = this.context.pageObjectUtils;
		this.slideCheck = this.context.pageObjectManager.getHomeSlider();
		
	}
	
	
	@Given("Open automationtesting page for shop sale") 
	public void open_automationtesting_page_for_shop_sale() {
		pageObjectUtils.openLandingPage();
	}

	@When("Click on Shop Menu for shop sale")
	public void click_on_shop_menu_for_shop_sale() throws Throwable {
		slideCheck.clickShop();
	   
	}

	@Then("Click on Sale written product in home page")
	public void click_on_sale_written_product_in_home_page() throws InterruptedException {
	    context.pageObjectManager.getShopSalePro().getSaleProduct();
	}

	@Then("User can clearly view the actual price with old price striken for the sale written products")
	public void user_can_clearly_view_the_actual_price_with_old_price_striken_for_the_sale_written_products() {
	   context.pageObjectManager.getShopSalePro().verifyOldAndSalePrice();
	}


}
