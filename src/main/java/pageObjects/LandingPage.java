package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	

	public WebDriver d;
	private By signin=By.cssSelector("a[href*='sign_in']");
	
	private By title=By.xpath("//h2[contains(text(),'Featured Courses')]");
	
	private By navbar=By.xpath("//a[contains(text(),'Contact')]");
	
	private By header=By.cssSelector("//div[class*='video-banner'] h3");
	//button[contains(text(),'NO THANKS')]
	private By popup=By.xpath("	//button[contains(text(),'NO THANKS')]");
			

				
			
	
	public LandingPage(WebDriver d)
	{
		this.d=d;
	}
	
	public LoginPage getSighin() {
		 d.findElement(signin).click();
		 LoginPage lip =new LoginPage(d);
			return lip;

	}
	
	public WebElement getTitle() {
		return d.findElement(title);
	}
	
	

	public WebElement getNavigationBar() {
		return d.findElement(navbar);
	}
	
	public WebElement getHeader() {
		return d.findElement(header);
	}
	public int getPopUpSize() {
		return d.findElements(popup).size();
	}

	public WebElement getPopUp() {
		return d.findElement(popup);
	}
	

}
