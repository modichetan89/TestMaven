package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PDPObj {
	WebDriver driver;
	public PDPObj(WebDriver driver){
		this.driver = driver;
	}
	
	
	By searchBar = By.id("twotabsearchtextbox");
	public WebElement getSearchBar(){
		return driver.findElement(searchBar);
	}
	
	By ProductSearchPage = By.xpath("//div[@id='leftNavContainer']/h3[1]");
	public WebElement getProductSearchPage() {
		return driver.findElement(ProductSearchPage);
	}
}
