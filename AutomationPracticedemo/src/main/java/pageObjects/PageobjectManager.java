package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageobjectManager {
	WebDriver driver;
	PageObjectSlidecheck  HPageSlider;
	PriceFilterSlider priceSlider;
	ShopProductCategoryObj shopProductCate;
	SortByPopularityObj sortByPopularity;
	ReadMoreFunctionality readMorefun;
	ShopSaleFunctionality shopSalePro;
	AddViewBasket addViewBasket;
	
	
	
	public PageobjectManager (WebDriver driver) {
		this.driver = driver;
	}
	
	public PageObjectSlidecheck getHomeSlider() {
		HPageSlider = new PageObjectSlidecheck(driver);
		return HPageSlider ;
	
	}

	public PriceFilterSlider getPriceSlider() {
		priceSlider = new PriceFilterSlider(driver);
		return priceSlider;
	}
	
	public ShopProductCategoryObj getProductCategory() {
		
		shopProductCate = new ShopProductCategoryObj(driver);
		return shopProductCate;
		
	}
	
	public SortByPopularityObj sortByPopularity() {
		
		sortByPopularity = new SortByPopularityObj(driver);
		return sortByPopularity;
		
	}
	
	public ReadMoreFunctionality getReadMoreFun() {
		
		readMorefun = new ReadMoreFunctionality(driver);
		return readMorefun;
		
	}
	
   public ShopSaleFunctionality getShopSalePro() {
	    shopSalePro = new ShopSaleFunctionality(driver);
		return shopSalePro;
		
	}
   public AddViewBasket getAddViewBasket() {
	   addViewBasket = new AddViewBasket(driver);
		return addViewBasket;
		
	}
   
   
}
