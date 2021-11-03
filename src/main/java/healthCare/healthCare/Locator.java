package healthCare.healthCare;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locator {
	
	public  WebDriver driver;
	public Locator(WebDriver driver)
	{
		this.driver=driver;
	}
    //bas=Booking Available service
	By bas=By.xpath("//li[@id='menu-item-218926");
	By title=By.xpath("//h2[@class='emsb-archive-header']");
	//baa=Book An Appointment
	By baa=By.xpath("//div[@class='et_pb_row']/div/div[2]/a");
	By fullName=By.xpath("//input[@name='emsb_user_fullName']");
	By userEmail=By.xpath("//input[@name='emsb_user_email']");
	By cnfrBooking=By.xpath("//button[@id='submitForm']");
	By mobileNo=By.xpath("//input[@name='emsb_user_telephone']");
	By date=By.xpath("//td[@data-original-title='Available 1']");
	By homeSelect=By.xpath("//article[@id='post-219082']//button");
	By thankYou=By.xpath("//div[@id='emsb_booking_ticket']/div[2]//h4");
	By contact=By.xpath("(//li[@id='menu-item-218935'])[1]");
	
	By contactName=By.xpath("//input[@data-original_id=\"name\"]");
	By contactEmail=By.xpath("//input[@data-original_id='email']");
	By contactMessage=By.xpath("//textarea[@data-original_id='message']");
	
	public WebElement getBAS() {
		return driver.findElement(bas);
	}
	


	public WebElement getFullName() {
		return driver.findElement(fullName);
	}

	public WebElement getUserEmail() {
		return driver.findElement(userEmail);
	}

	public WebElement getCnfrBooking() {
		return driver.findElement(cnfrBooking);
	}

	public WebElement getMobileNo() {
		return driver.findElement(mobileNo);
	}

	public WebElement getTilte() {
		return driver.findElement(title);
	}
	
	public WebElement getBookAA() {
		return driver.findElement(baa);
	}
	
	public WebElement getHomeSelector() {
		return driver.findElement(homeSelect);
	}
	
	public WebElement getDateSelect() {
		return driver.findElement(date);
	}
	public WebElement getThanks() {
		return driver.findElement(thankYou);
	}
	
	public WebElement getContact() {
		return driver.findElement(contact);
	}
	public WebElement getContactName() {
		return driver.findElement(contactName);
	}



	public WebElement getContactEmail() {
		return driver.findElement(contactEmail);
	}



	public WebElement getContactMessage() {
		return driver.findElement(contactMessage);
	}

	
	
	

}
