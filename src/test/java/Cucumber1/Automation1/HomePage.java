package Cucumber1.Automation1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	
	public WebDriver d;

	private static Logger log=LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialize() throws Exception {
		d=initializeDemo();
		d.get(prop.getProperty("url"));
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String username,String passwd,String text ) throws Exception {
			
		
		//we can call particular class by two ways
		//one is through inheritance 
		//other is creating objects to that class and invoking that class
		d.get(prop.getProperty("url"));

		LandingPage lp =new LandingPage(d);
		LoginPage lip=lp.getSighin();
		
		
		//logInPage lip =new logInPage(d);
				lip.getEmail().sendKeys(username);
				lip.getPassword().sendKeys(passwd);
				lip.getlogin().click();
				ForgotPassword fp=lip.getForgotPswd();
				fp.getEmail().sendKeys("hello");
				fp.getsendMeInstruction().click();
				
				log.info("text");

				
				
				
			}
			@DataProvider
			public Object[][] getData() {
				//row stands for how many different data types test should run
				//coloumn stands for for how many values for each test
				Object[][] data=new Object[2][3];
				//0th row
				data[0][0]="norestricteduser@gmail.com";
				data[0][1]="pswd123";
				data[0][2]="restricteduser";
				
				//1sr row
				data[1][0]="restricteduser@gmail.com";
				data[1][1]="pswd234";
				data[1][2]="nonrestricteduser";
				return data;
						
						
			}
			@AfterTest
			public void tearDown() {
				d.close();
			}

}
