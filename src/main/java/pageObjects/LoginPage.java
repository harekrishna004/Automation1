package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
////input[@type='email']
	public WebDriver d;
	private By Login=By.xpath("//input[@type='email']");
	private By pswd=By.xpath("//input[@type='password']");
	
	private By loginButton=By.xpath("//input[@type='submit']");
	//a[contains(text(),'Forgot Password?')]
	private By forgotpswd=By.xpath("//a[contains(text(),'Forgot Password?')]");
	
	//private By verifyText=By.xpath("//div[contains(text(),'Invalid email or password')]");
			 
		
	
	

	
	public  LoginPage(WebDriver d)
	{
		this.d=d;
		
	}
	

	public WebElement getEmail() {
		return d.findElement(Login);
	}
	public WebElement getPassword() {
		return d.findElement(pswd);
	}
	
	public WebElement getlogin() {
		return d.findElement(loginButton);
	}
	public ForgotPassword getForgotPswd() {
		 d.findElement(forgotpswd).click();
		 return new ForgotPassword(d);
		
	}
	

}
