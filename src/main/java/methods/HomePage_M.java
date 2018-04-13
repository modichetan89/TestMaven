package methods;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.interactions.Actions;
import pageObjects.HomePageObj;
import resources.BaseClass;

public class HomePage_M extends BaseClass{
	
      Properties prop1 = new Properties();
	   BaseClass testEnv = new BaseClass();
		HomePageObj lp = new HomePageObj(driver);
	   
	   
public  HomePage_M () throws IOException {
	   String fileName = "src/main/java/resources/data.properties";
	   FileInputStream fin=new FileInputStream(fileName);
	   prop1.load(fin);
	}
	

	
	public boolean LoginPageNavigation() throws IOException, InterruptedException{
		boolean flag=true;
		try{
		log.info("Navigated to website...");
		Thread.sleep(5000);	
		lp.getLogin().click();  // This is equivalent to driver.findElement(By.id(""));
		log.info("Navigated to Login Dialog...");		
		}catch(Exception ex){
			log.error("Failed to open login dialog");
			 flag=false;
		}
		return flag;
	}
	
	public boolean Login(){
		boolean flag = true;
		try{
			log.info("Entering the username");
			//WebDriverWait wait = new WebDriverWait(driver, 10);
			
			String USERNAME = prop1.getProperty("username");
			//wait.until(ExpectedConditions.visibilityOfElementLocated((By) lp.getUsername()));
			lp.getUsername().sendKeys(USERNAME);
			log.info("Continue to next page to enter password");
			lp.getUsernameContinue().click();
			log.info("Entering the password");
			String PASSWORD = prop1.getProperty("password");
			lp.getPassword().sendKeys(PASSWORD);
			log.info("Clicking on Submit button");
			lp.getSubmitButton().click();
		}catch(Exception ex){
			log.error("Failed to login");
			flag = false;
		}
		return flag;	
	}
	
	public boolean verifyLogoutLinkPresent(){
		boolean flag = true;
		try{
			Actions act = new Actions(driver);
			act.moveToElement(lp.getLogin()).perform();
			Thread.sleep(2000);
			boolean link = lp.getSignOutLink().isDisplayed();
			if(link==true){
				log.info("User is logged in");
			}
		}catch(Exception ex){
			log.error("Logout link not present or User is not logged in");
			flag = false;
		}
		return flag;
	}
	
}
