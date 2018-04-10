package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObj {
	public WebDriver driver;
	
	public HomePageObj(WebDriver driver) {
		this.driver=driver;
	}
	
	
	By signin = By.id("nav-link-yourAccount");
	public WebElement getLogin()
	{
		return driver.findElement(signin);
	}
	
	/*
	By verifyCnCText = By.xpath("//*[text()=' - order online and collect at a store of your choice for free']");
	public WebElement getCnCText()
	{
		return driver.findElement(verifyCnCText);
	}
	
	By verifyNavigationBar = By.xpath("//div[@class='nav-wrap clearfix']");
	public WebElement getNavigationBar()
	{
		return driver.findElement(verifyNavigationBar);
	}
	*/
	
}
