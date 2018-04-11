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
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	private static String screenshotDirectoryPath;
	
	private String appWebURL;
	private String browserName;
	private String chromedriver;
	private String firefoxdriver;
	private String IEDriver;
	

	
	//initializeDriver method starts here
	public WebDriver initializeDriver() throws IOException{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("src/main/java/resources/data.properties");
		prop.load(fis);
		browserName = prop.getProperty("browser");
		chromedriver = prop.getProperty("gooleChromePath");
		firefoxdriver = prop.getProperty("geckoDriverPath");
		IEDriver = prop.getProperty("IEPath");
		appWebURL = prop.getProperty("URL");
		screenshotDirectoryPath = prop.getProperty("failedScreenShotDirectoryPath");
		
		
		//Use logging here to get the browser name
		if(browserName.equals("chrome")){
			//execute with chrome driver
			System.setProperty("webdriver.chrome.driver", chromedriver);
			log.info("Chrome browser running");
			driver = new ChromeDriver();
			driver.get(appWebURL);
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			
		}
		else if(browserName.equals("firefox")){
			//execute with firefox driver
			System.setProperty("webdriver.gecko.driver", firefoxdriver);
			log.info("Firefox browser running");
			driver = new FirefoxDriver();
			driver.get(appWebURL);
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			
		}
		else if(browserName.equals("IE")){
			//execute with IE driver
			System.setProperty("webdriver.ie.driver", IEDriver);
			log.info("IE browser running");
			driver = new InternetExplorerDriver();
			driver.get(appWebURL);
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		}
		else{
			log.info("Given browser not found in system");
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		

		//returning driver object so that who ever want to use driver can use it
		return driver;
			
	}
	
	public void getScreenshot(String result1) throws IOException{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(screenshotDirectoryPath+result1+"_"+timestamp()+".png");
		FileUtils.copyFile(src, dest);
	}
	
	
	public static String timestamp() {
	    return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
	
} 
