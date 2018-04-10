package landmark.LifestyleAutomation;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import methods.HomePage_M;
import resources.BaseClass;

//Inherit BaseClass by using extends to use BaseClass method.
public class HomePage extends BaseClass{
	
	@BeforeTest
	public void initialize() throws IOException, InterruptedException{
		//Since initializeDriver method returning driver we are storing it in driver object
		driver = initializeDriver();
		log.info("Driver initialized...");
		//driver.get(prop.getProperty("URL"));
	}
	
	
	
	
	@Test(priority=1,alwaysRun=true)
    public void navigateToLoginPage(ITestContext context) throws Exception {
		log.info("Execution started for homePageLogin");
       context.setAttribute("description", "Open login dialog");
       HomePage_M accessTestMethod = new HomePage_M();
       Assert.assertTrue(accessTestMethod.homePageLogin());}
	
	
	
	
	@AfterTest
	public void tearDown(){
		driver.close();
		driver=null;
	}
	
	
}
