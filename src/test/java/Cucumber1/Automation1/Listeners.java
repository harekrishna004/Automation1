package Cucumber1.Automation1;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReporterNG;
public class Listeners extends Base implements ITestListener {
	
ExtentTest test;
	
	ExtentReports extent=ExtentReporterNG.getReporterObject();
	
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result)
	{
		 test=extent.createTest(result.getMethod().getMethodName());
		 extentTest.set(test);
		
		
	}

	public void onTestSuccess(ITestResult result) 
	{
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result)
	{
		extentTest.get().fail(result.getThrowable());
		WebDriver d=null;
		
		String testMethodName= result.getMethod().getMethodName();
		try {
			d=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("d").get(result.getInstance());
		} 
		catch(Exception e) {
			
		}
		
			try {
				extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,d),result.getMethod().getMethodName());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}


			public void onTestSkipped(ITestResult result) {
				
			}

			public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
				
			}

			public void onTestFailedWithTimeout(ITestResult result) {
				
			}

			public void onStart(ITestContext context) {
				
			}

			public void onFinish(ITestContext context) {
				extent.flush();
			}

}
