package utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Base {
	 public static WebDriver driver;
    public Properties prop;
    public static ExtentSparkReporter spark;
	public static ExtentReports extent;
	public static ExtentTest test;
	//creating extent report in base constructor.
	public Base()
	{
		    spark = new ExtentSparkReporter("htmlReport//healthCare"+new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date())+"index.html");
			extent = new ExtentReports();
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("Automate Report");
			spark.config().setReportName("HealthCare Site Auotmate Report");
			extent.attachReporter(spark);
	}
    
	public WebDriver initalization() throws IOException
	{
		 prop=new Properties();
		 //Taking data from properties file
		FileInputStream fis=new FileInputStream(".\\utilities\\data.properties");
		prop.load(fis);
		//taking browser name from properties file
        String browsername=prop.getProperty("browser");
      
        //Selecting Browser
        if (browsername.equals("chrome"))
        {
          System.setProperty("webdriver.chrome.driver",".//driver//chromedriver.exe");	
          driver=new ChromeDriver();
          driver.manage().window().maximize();
        }
        
        else if (browsername.equals("firefox"))
        {
        	
        }
        
        else if (browsername.equals("IE"))
        {
        	
        }
		return driver;

	}
	//method for ScreenShot
	public void screenShot(String name) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File(name));
		
	}

}