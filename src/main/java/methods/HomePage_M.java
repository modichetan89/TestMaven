package methods;

import java.io.IOException;

import pageObjects.HomePageObj;
import resources.BaseClass;

public class HomePage_M extends BaseClass{
	public boolean homePageLogin() throws IOException, InterruptedException{
		boolean flag=true;
		try{
		log.info("Navigated to website...");
		Thread.sleep(5000);	
		HomePageObj lp = new HomePageObj(driver);
		lp.getLogin().click();  // This is equivalent to driver.findElement(By.id(""));
		log.info("Navigated to Login Dialog...");
		}catch(Exception ex){
			log.error("Failed to open login dialog");
			 flag=false;
		}
		return flag;
	}
}
