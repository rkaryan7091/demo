package resources;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.MediaEntityBuilder;

import utilities.Base;

public class ListenerTest extends Base implements ITestListener    {

	public void onTestFailure(ITestResult Result) 					
    { 	
       try {
    	   
		
       	String path="C:\\Users\\M1073161\\eclipse-workspace\\healthCare\\htmlReport\\FailedScreenshot\\screenshot"+new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date())+Result.getName()+".png";
       	screenShot(path);
       	Thread.sleep(2000);
       	test.fail("Failed ScreenShot : ", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		extent.flush();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}				
    }		

    // When Test case get Skipped, this method is called.		
    public void onTestSkipped(ITestResult Result)					
    {		
     System.out.println("The name of the testcase Skipped is :"+Result.getName());					
    }

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		test=extent.createTest(result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.pass(result.getName());
		extent.flush();
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
			
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	
		
	}	



}
