package stepDefinition;

import io.cucumber.java.After;
public class Hooks {

TestContext context;
	
	public Hooks(TestContext context) {
		this.context = context;
	}
	
	@After
	public void cleanUp() {
		context.driverManager.closeDriver();
	}
	
}
