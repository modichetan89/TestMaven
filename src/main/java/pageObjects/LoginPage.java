package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	
	By uname = By.id("j_username");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUsername(){
		return driver.findElement(uname);
	}
	
	
	By pwd = By.id("j_password");
		
	public WebElement getPassword(){
		return driver.findElement(pwd);
	}
	
	By submit = By.id("signin-form-submit");
	
	public WebElement getSubmitButton(){
		return driver.findElement(submit);
	}
}
