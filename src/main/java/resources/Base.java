package resources;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	 public WebDriver d;
	 public Properties prop;
	 
		public WebDriver initializeDemo() throws Exception {
			 prop= new Properties();
			 //to not hard core the path of project
			 //we java method available as given bellow
			 //System.getProperty("user.dir");
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
				//FileInputStream fis = new FileInputStream(System.getProperty("C:\\Users\\Hare Krishna\\eclipse-workspacedemo1\\EndToEndFramework\\src\\main\\java\\resources\\data.properties"));

			
			prop.load(fis);
			//to run particular browser from  maven we need to do by using commandprompt
			// mvn test -Dbrowser=chrome
			//String browsername=System.getProperty("browser");
			
			String browsername=prop.getProperty("browser");
			System.out.println(browsername);

			if(browsername.contains("chrome"))
			{
				
				System.setProperty("webdriver.chrome.driver","C:\\work\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
				ChromeOptions options =new ChromeOptions();
				//to run chrome in headless mode
				//we have a class caled ChromeOptions create opject and pass the bobject reference
				//which may run your scripts fast as there is no openinig of browser
				if(browsername.contains("headless"))
				{
				
				options.addArguments("headless");
				}
				
		         d=new ChromeDriver(options);
			}
			else if(browsername.equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver","C:\\work\\FireFox Driver\\geckodriver.exe");
				 d = new FirefoxDriver();
			}
	        else if(browsername.equals("IE"))
	        {
				// C:\\work\\I E Driver\\IEDriverServer.exe
	        	//System.setProperty("webdriver.ie.driver","C:\\work\\I E Driver\\IEDriverServer.exe");
		        //WebDriver d=new InternetExplorerDriver();
			}
			d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return d;
			
		}
		public String getScreenShotPath(String testCaseName,WebDriver d) throws Exception {
			TakesScreenshot ts=(TakesScreenshot)d;
			File source=ts.getScreenshotAs(OutputType.FILE);
			String destinationfile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
			FileUtils.copyFile(source,new File(destinationfile));
			return destinationfile;
		}

}
