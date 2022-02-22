package Cucumber1.Automation1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateLoginPage extends Base {
	
	public WebDriver d;
	private static Logger log=LogManager.getLogger(Base.class.getName());
	LandingPage lp;
	
	@BeforeTest
	public void initialize() throws Exception {
		d=initializeDemo();
		log.info("driver is initialize");
		d.get(prop.getProperty("url"));
		log.info("Navigated To Home Page");

	}
	
	
	@Test()
	public void basePageNavigation() throws Exception {
		
		//one is inherited
		//create object to that class and invoke method of it
		 lp =new LandingPage(d);
		//compare the text from browser with the actual text
		Assert.assertEquals(lp.getTitle().getText(),"FEATURED COURSES123");
		log.info("Successfully Validated Text Message");
		System.out.println("Test Completed");


}
	@Test
	public void validateHader() throws Exception {
		
		
    Assert.assertEquals(lp.getHeader().getText(),"AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		
		
	}
	
	
	@AfterTest
	public void tearDown() {
		d.close();
	}

}
