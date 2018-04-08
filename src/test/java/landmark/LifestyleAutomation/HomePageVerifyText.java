package landmark.LifestyleAutomation;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.BaseClass;


public class HomePageVerifyText extends BaseClass{
	
	@BeforeTest
	public void initialize() throws IOException, InterruptedException{
		driver = initializeDriver();
		//driver.get(prop.getProperty("URL"));
		Thread.sleep(5000);	
	}
	@Test
	public void homePageCnCText() throws IOException, InterruptedException{
		LandingPage lp = new LandingPage(driver);
		//Compare the text from browser with actual given text from requirement
		// Actual - lp.getCnCText().getText();
		//Expected - "Click & Collect - order online and collect at a store of your choice for free"
		Assert.assertEquals(lp.getCnCText().getText(), "oooooClick & Collect - order online and collect at a store of your choice for free");
	}
	
	@AfterTest
	public void tearDown(){
		driver.close();
		driver=null;
	}
	
}
