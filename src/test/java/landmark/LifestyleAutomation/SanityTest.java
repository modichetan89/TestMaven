package landmark.LifestyleAutomation;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import methods.HomePage_M;
import methods.PDP_M;
import resources.BaseClass;

//Inherit BaseClass by using extends to use BaseClass method.
public class SanityTest extends BaseClass{
	
	@BeforeTest
	public void initialize() throws IOException, InterruptedException{
		//Since initializeDriver method returning driver we are storing it in driver object
		driver = initializeDriver();
		log.info("Driver initialized...");		
	}
	
	
	
	//Home Page Test cases
	@Test(priority=1,alwaysRun=true)
    public void navigateToLoginPage(ITestContext context) throws Exception {
		log.info("Execution started for navigateToLoginPage");
       context.setAttribute("description", "Open login dialog");
       HomePage_M accessTestMethod = new HomePage_M();
       //once above step will execute it will execute the default constructor of HomePage_M class.
       Assert.assertTrue(accessTestMethod.LoginPageNavigation());}
	
	@Test(priority=2, alwaysRun=true)
	public void LoginToAccount(ITestContext context) throws Exception {
		log.info("Execution started for LoginToAccount");
		context.setAttribute("description", "Attempting to login");
		HomePage_M accessTestMethod = new HomePage_M();
	     Assert.assertTrue(accessTestMethod.Login());
	}
	
	@Test(priority=3, alwaysRun=true)
	public void VerifyLoggedIn(ITestContext context) throws Exception {
		log.info("Execution started for VerifyLoggedIn");
		context.setAttribute("description", "Checking logout link");
		HomePage_M accessTestMethod = new HomePage_M();
	     Assert.assertTrue(accessTestMethod.verifyLogoutLinkPresent());
	}
	
	//PDP Test Cases
	
	@Test(priority=4, alwaysRun=true)
	public void verifySearch(ITestContext context) throws IOException {
		log.info("Execution started for verifySearch");
		context.setAttribute("description", "Searching a product");
		PDP_M accessTestMethod = new PDP_M();
		Assert.assertTrue(accessTestMethod.HomePageSearch());
	}
	
	@AfterTest
	public void tearDown(){
		driver.close();
		driver=null;
	}
	
	
}
