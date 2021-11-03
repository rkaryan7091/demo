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

public class BookingAppoinment extends Base {

	BookingAppoinment() {
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
		test.info("Opening Appoinment Portal");
        lp.getHomeSelector().click();
        test.info("Navigate to HomeCare Page");
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        lp.getDateSelect().click();
        test.info("Date Selected");
        lp.getFullName().sendKeys("Raushan Kumar");
        test.info("FullName Enter");
        lp.getUserEmail().sendKeys("flashrk9801@gmail.com");
        test.info("Email Entered");
        lp.getMobileNo().sendKeys("7091699830");
        test.info("Mobile No Enetered");
        lp.getCnfrBooking().click();
        test.info("Clicked ON Confirm Booking");
        String thank=lp.getThanks().getText();
        Assert.assertEquals(thank,"Thank You");
        test.info("Thank You Message Matched");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
