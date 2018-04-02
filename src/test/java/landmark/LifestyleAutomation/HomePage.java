package landmark.LifestyleAutomation;

import java.io.IOException;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.BaseClass;

//Inherit BaseClass by using extends to use BaseClass method.
public class HomePage extends BaseClass{
	
	@BeforeTest
	public void initialize() throws IOException, InterruptedException{
		//Since initializeDriver method returning driver we are storing it in driver object
		driver = initializeDriver();
		log.info("Driver initialized...");
	}
	
	@Test(dataProvider="getData")
	public void homePageLogin(String username, String password) throws IOException, InterruptedException{
		driver.get(prop.getProperty("URL"));
		log.info("Navigated to website...");
		Thread.sleep(5000);	
		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();  // This is equivalent to driver.findElement(By.id(""));
		log.info("Navigated to Login Dialog...");
		LoginPage lip = new LoginPage(driver);
		lip.getUsername().sendKeys(username);
		Thread.sleep(2000);
		log.info("Typing username...");
		lip.getPassword().sendKeys(password);
		Thread.sleep(2000);
		log.info("Typing password...");
		lip.getSubmitButton().click();
		log.info("Clicked on submit button...");
	}
	
	@AfterTest
	public void tearDown(){
		driver.close();
		driver=null;
	}
	
	@DataProvider
	public Object[][] getData(){
		//row e.g 3 stands for how many iterations you want to send. 3 means 3 set of data.
		//column stands for how many values per test. 2 means 2 values i.e uname and pwd
		//The first array represents a data set whereas the second array contains the parameter values.
		// 3 and 2 is size of array, so when assigning value index start from 0
		
		Object[][] data = new Object[3][2];  data[0][0] = "test1@gmail.com";
		data[0][1] = "123456";
		data[1][0] = "test2@gmail.com";
		data[1][1] = "12345678";
		data[2][0] = "test3@gmail.com";
		data[2][1] = "1234567890";
		
		return data;
	}
	
}
