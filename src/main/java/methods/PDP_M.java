package methods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import pageObjects.PDPObj;
import resources.BaseClass;

public class PDP_M extends BaseClass{
	
	Properties prop = new Properties();
	PDPObj ob = new PDPObj(driver);
	
	public PDP_M() throws IOException{
		String fileName = "src/main/java/resources/data.properties";
		FileInputStream fis = new FileInputStream(fileName);
		prop.load(fis);	
	}
	
	public boolean HomePageSearch(){
		boolean flag = true;
		try{
			String product = prop.getProperty("productName");
			ob.getSearchBar().sendKeys(product);
			ob.getSearchBar().sendKeys(Keys.ENTER);
			String textActual = ob.getProductSearchPage().getText();
			String textExpected = "Show results for";
			Assert.assertEquals(textActual, textExpected);
			Thread.sleep(10000);
		}
		catch(Exception ex){
			log.info("Search bar not present");
			flag = false;
		}
		return flag;		
	}
	
	
}
