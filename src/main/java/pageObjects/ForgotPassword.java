package pageObjects;





import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	
	public WebDriver d;
	//input[@id='user_email']
	//input[@value='Send me instructions']
	private By email=By.xpath("//input[@id='user_email']");
	private By sendMeInstruction=By.xpath("//input[@type='submit']");
	
	
	public  ForgotPassword(WebDriver d)
	{
		this.d=d;
	
	}
	public WebElement getEmail() {
		return d.findElement(email);
	}
	public WebElement getsendMeInstruction() {
		return d.findElement(sendMeInstruction);
	}

}
