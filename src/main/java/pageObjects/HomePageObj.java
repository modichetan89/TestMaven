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
	
	By uname = By.xpath("//input[@type='email']");
	public WebElement getUsername(){
		return driver.findElement(uname);
	}
	
	By unameContinue = By.xpath("//input[@id='continue']");
	public WebElement getUsernameContinue(){
		return driver.findElement(unameContinue);
	}
	
	By pwd = By.xpath("//input[@type='password']");	
	public WebElement getPassword(){
		return driver.findElement(pwd);
	}
	
	By submit = By.id("signInSubmit");	
	public WebElement getSubmitButton(){
		return driver.findElement(submit);
	}
	
	
	By signoutLink = By.xpath("//span[text()='Sign Out']");
	public WebElement getSignOutLink(){
		return driver.findElement(signoutLink);
	}
}
