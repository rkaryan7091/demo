package healthCare.healthCare;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.Base;

public class Contact extends Base{
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

	
	@Test
	public void contactDetail()
	{
		driver.get(url);
		log.info("Testing for HealthCare Site");
		test.info("Browser Open");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		test.info("Page Navigate To : "+driver.getCurrentUrl());
		Locator lp=new Locator(driver);
		lp.getContact().click();
		test.info("Entering contact Detail");
		lp.getContactName().sendKeys("raushan Kumar");
		test.info("Entering Name");
		lp.getContactEmail().sendKeys("flashrk9801@gamil.com");
		test.info("Email Entered");
		lp.getContactMessage().sendKeys("My self rausha KUumar");
		test.info("Message Eneterd");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
