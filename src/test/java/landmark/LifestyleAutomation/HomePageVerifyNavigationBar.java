package landmark.LifestyleAutomation;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.BaseClass;


public class HomePageVerifyNavigationBar extends BaseClass{
	
	@BeforeTest
	public void initialize() throws IOException, InterruptedException{
		driver = initializeDriver();
		driver.get(prop.getProperty("URL"));
		Thread.sleep(5000);	
	}
	
	@Test
	public void homePageNavigationBar() throws IOException, InterruptedException{
		LandingPage lp = new LandingPage(driver);
		//lp.getNavigationBar().isDisplayed();
		//Assert.assertTrue always expects "lp.getNavigationBar().isDisplayed()" this argument as true
		Assert.assertTrue(lp.getNavigationBar().isDisplayed());
		
		/*
		Assertions - 
		Assert.assertTrue - Always expect passed argument as true. If get fails then this will fail.
		Assert.assertFalse - Always expect passed argument as false. If get pass then this will fail.
		Assert.assertEquals - Used to compare the actual and expected.
		 */

	}
	
	@AfterTest
	public void tearDown(){
		driver.close();
		driver=null;
	}
	
}
