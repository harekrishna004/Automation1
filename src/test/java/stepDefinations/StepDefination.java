package stepDefinations;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;



import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
public class StepDefination extends Base {

    @Given("^initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {
    	d=initializeDemo();
    	
       
    }
    @And("^navigate to \"([^\"]*)\" site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {
		d.get(strArg1);

    }

    @And("^click on login link in home page to land onsecure sign in page$")
    public void click_on_login_link_in_home_page_to_land_onsecure_sign_in_page() throws Throwable {
    	
		LandingPage lp =new LandingPage(d);
		if(lp.getPopUpSize()>0) {
			lp.getPopUp().click();
		}

    	lp.getSighin();
    }

   
    @When("^user enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
    	 LoginPage lip =new LoginPage(d);

     	lip.getEmail().sendKeys(username);
 		lip.getPassword().sendKeys(password);
 		lip.getlogin().click();
 		
    }
    @And("^close browser$")
    public void close_browser() throws Throwable {
    	d.quit();
    }

   

   

   

}