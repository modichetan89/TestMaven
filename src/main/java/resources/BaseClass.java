package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class BaseClass {
	
	public static WebDriver driver;
	public Properties prop;
	public static Logger log;
	//initializeDriver method starts here
	public WebDriver initializeDriver() throws IOException{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Workspace\\LifestyleAutomation\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		//Use logging here to get the browser name
		if(browserName.equals("chrome")){
			//execute with chrome driver
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium New\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();	
		}
		else if(browserName.equals("firefox")){
			//execute with firefox driver
			System.setProperty("webdriver.gecko.driver", "D:/Selenium New/geckodriver-v0.19.1-win64/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("IE")){
			//execute with IE driver
			System.setProperty("webdriver.ie.driver", "D:/Selenium New/IEDriverServer_x64_3.8.0/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else{
			//Browser not present
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		log=LogManager.getLogger(BaseClass.class.getName());
		//returning driver object so that who ever want to use driver can use it
		return driver;
			
	}
	
	public void getScreenshot(String result1) throws IOException{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\Workspace\\LifestyleAutomation\\screenshot\\"+result1+"_"+timestamp()+".png");
		FileUtils.copyFile(src, dest);
	}
	
	public static String timestamp() {
	    return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
	
} 
