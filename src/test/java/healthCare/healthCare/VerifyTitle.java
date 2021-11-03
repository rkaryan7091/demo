package healthCare.healthCare;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.Base;

public class VerifyTitle extends Base {

		VerifyTitle() {
			super();
			
		}
	    String url;
		public static Logger log=LogManager.getLogger(VerifyTitle.class.getName());

		//Initializing driver through Base Class
		@BeforeMethod
		public void OpenBrowser() throws IOException
		{
			 driver=initalization();
			 //Getting url from properties file
			 url=prop.getProperty("url");
			 
			 
		}
		
		//Test Case
		@Test
		public void verifingTitle()
		{
			driver.get(url);
			log.info("Testing for HealthCare Site");
			test.info("Browser Open");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			test.info("Page Navigate To : "+driver.getCurrentUrl());
			Locator lp=new Locator(driver);
			lp.getBookAA().click();
			test.info("Opening Book Availabe Service");
	        log.info("Tab Title : "+driver.getTitle());
	        Assert.assertEquals(lp.getTilte().getText(),"Book-Service");
	        log.info("Title Matched");
	        test.info("Title Match");
		}
		
		@AfterMethod
		public void tearDown()
		{
			driver.close();
		}
}
