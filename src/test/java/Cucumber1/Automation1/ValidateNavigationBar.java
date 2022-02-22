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

public class ValidateNavigationBar extends Base {
	public WebDriver d;

	private static Logger log=LogManager.getLogger(Base.class.getName());

	
	@BeforeTest
	public void initialize() throws Exception {
		d=initializeDemo();
		d.get(prop.getProperty("url"));
	}
	
	@Test()
	public void basePageNavigation() throws Exception {
		
		LandingPage lp =new LandingPage(d);
		//lp.getNavigationBar().isDisplayed();
		Assert.assertTrue(lp.getNavigationBar().isDisplayed());
		log.info("Navigation Bar is Displayed");
		//Assert.assertFalse(false);

	}
		@AfterTest
		public void tearDown() {
			d.close();
		}

}
