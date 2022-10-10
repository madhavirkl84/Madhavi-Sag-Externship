package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/feature", glue="stepDefinition", monochrome= true,

//tags="@AddCart or @ShopSale or @FilterByPrice or @ReadMore or  @ShopProduct or @SortBy", 
 
//plugin= {"html:target/cucumber.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"} )
plugin = { "pretty", "html:target/cucumber-reports" })		 


public class TestRunner extends  AbstractTestNGCucumberTests { 

	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}	
}								
