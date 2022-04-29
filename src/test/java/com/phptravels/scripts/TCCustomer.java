package com.phptravels.scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.phptravels.constants.AutomationConstants;
import com.phptravels.pages.Customer;
import com.phptravels.utilities.ExcelUtility;
import com.phptravels.utilities.ExcelUtility2;

public class TCCustomer extends TestBase {
	Customer objCustomer;
	
	@Test(priority=1)
	public void verifyHomePage() throws IOException, InterruptedException {
	
	objCustomer = new Customer(driver);
	String parent=driver.getWindowHandle(); 
	
	String expectedTitle=AutomationConstants.HOMEPAGETITLE;
	String actualTitle =driver.getTitle();
	System.out.println("Title of the page Loaded is "+actualTitle);
	Assert.assertEquals(expectedTitle,actualTitle);
	}
	
@Test(priority=2)
	public void verifyCustomerFE() throws IOException, InterruptedException {
	
	objCustomer= new Customer(driver);
	objCustomer.clickCustomerFE();
	Thread.sleep(2000);

	for(String winHandle : driver.getWindowHandles())
	{
	    driver.switchTo().window(winHandle);
	}
	
	String expectedURL =AutomationConstants.URL1;
	String actualURL =driver.getCurrentUrl();
	System.out.println("Customer Login page: "+actualURL);
	Assert.assertEquals(expectedURL,actualURL);
	}

@Test(priority=3)
	public void verifyNullCFLogin() throws IOException, InterruptedException {
	
	objCustomer= new Customer(driver);
	objCustomer.clickCustLogin();
	Thread.sleep(2000);
	
	String expectedValidationMessage =AutomationConstants.VALMESSG;
	String actualValidationMessage =objCustomer.getEmail().getAttribute("validationMessage");
	System.out.println("Customer login error: "+actualValidationMessage);
	Assert.assertEquals(expectedValidationMessage,actualValidationMessage);
	}

@Test(priority=4)
	public void verifyInvalidCFEmail() throws IOException, InterruptedException {

	objCustomer= new Customer(driver);
	String custemail = ExcelUtility.getCellData(6, 0);
	objCustomer.strCustEmail(custemail);
	
	String custpass = ExcelUtility.getCellData(7, 0);
	objCustomer.strCustPass(custpass);
	
	objCustomer.clickCustLogin();
	Thread.sleep(2000);
	
	String expectedURL =AutomationConstants.URL2;
	String actualURL =driver.getCurrentUrl();
	System.out.println("Customer invalid login error: "+actualURL);
	Assert.assertEquals(expectedURL,actualURL);
	}

@Test(priority=5)
	public void verifyInvalidCFPass() throws IOException, InterruptedException {

	objCustomer= new Customer(driver);
	String custemail = ExcelUtility.getCellData(9, 0);
	objCustomer.strCustEmail(custemail);
	
	String custpass = ExcelUtility.getCellData(10, 0);
	objCustomer.strCustPass(custpass);
	
	objCustomer.clickCustLogin();
	Thread.sleep(2000);
	
	String expectedURL =AutomationConstants.URL2;
	String actualURL =driver.getCurrentUrl();
	System.out.println("Customer invalid login error: "+actualURL);
	Assert.assertEquals(expectedURL,actualURL);
	}

@Test(priority=6)
	public void verifyvalidCFLogin() throws IOException, InterruptedException {
	
	objCustomer= new Customer(driver);
	String custemail = ExcelUtility.getCellData(3, 0);
	objCustomer.strCustEmail(custemail);
	
	String custpass = ExcelUtility.getCellData(4, 0);
	objCustomer.strCustPass(custpass);
	
	objCustomer.clickCustLogin();
	Thread.sleep(2000);
	
	String expectedURL =AutomationConstants.URL3;
	String actualURL =driver.getCurrentUrl();
	System.out.println("Customer Login Successful - " +actualURL);
	Assert.assertEquals(expectedURL,actualURL);
	}

@Test(priority=7)
	public void verifyMyBookings() throws IOException, InterruptedException {
	
	objCustomer.clickMyBookings();
	Thread.sleep(2000);
	String expectedURL =AutomationConstants.URL4;
	String actualURL =driver.getCurrentUrl();
	System.out.println("Customer bookings: " +actualURL);
	Assert.assertEquals(expectedURL,actualURL);
	}

@Test(priority=8)
	public void verifyVoucher() throws IOException, InterruptedException {
	
	String originalHandle = driver.getWindowHandle();
	
	objCustomer.clickVoucher();
	Thread.sleep(2000);
	
	for(String winHandle : driver.getWindowHandles())
	{
	    driver.switchTo().window(winHandle);
	}
	
	String expectedTitle =AutomationConstants.TITLE1;
	String actualTitle =driver.getTitle();
	System.out.println("Customer voucher: " +actualTitle);
	//Assert.assertEquals(expectedTitle,actualTitle);
	
	Thread.sleep(2000);
	
	for(String handle : driver.getWindowHandles()) {
        if (!handle.equals(originalHandle)) {
            driver.switchTo().window(handle);
            driver.close();
        }
    }
    driver.switchTo().window(originalHandle);
	}

@Test(priority=9)
	public void verifyAddFunds() throws IOException, InterruptedException {
	
	objCustomer.clickAddFunds();
	Thread.sleep(2000);
	
	String expectedURL =AutomationConstants.URL6;
	String actualURL =driver.getCurrentUrl();
	System.out.println("Customer Addfunds: " +actualURL);
	Assert.assertEquals(expectedURL,actualURL);
	}

@Test(priority=10)
	public void verifyPaybyPayPal() throws IOException, InterruptedException {
	
	objCustomer.clickPayPalBtn();
	objCustomer.clickPayNow();
	Thread.sleep(2000);
	
	String expectedURL =AutomationConstants.URL7;
	String actualURL =driver.getCurrentUrl();
	System.out.println("Customer Paypal: " +actualURL);
	Assert.assertEquals(expectedURL,actualURL);
	}

@Test(priority=11, enabled=false)
	public void verifyPayPal() throws IOException, InterruptedException {
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	for(String winHandle : driver.getWindowHandles())
	{
	    driver.switchTo().window(winHandle);
	}
	
	objCustomer.clickPayPal();
	}

@Test(priority=12)
	public void verifyMyProfile() throws IOException, InterruptedException {
	
	driver.navigate().back();
	driver.navigate().back();
	objCustomer.clickMyProfile();
	
	String expectedURL =AutomationConstants.URL8;
	String actualURL =driver.getCurrentUrl();
	System.out.println("Customer Profile: " +actualURL);
	Assert.assertEquals(expectedURL,actualURL);
	}

@Test(priority=13)
public void verifyAddress() throws IOException, InterruptedException {
	
	objCustomer.clickAddress();
	String address = ExcelUtility2.getCellData(18, 7);
	objCustomer.strAddress(address);
	objCustomer.clickUpdateProfile();
	
	String expectedTXT=AutomationConstants.TXT4;
	System.out.println("Customer profile update: " +objCustomer.getSuccess());
	Assert.assertEquals(expectedTXT,objCustomer.getSuccess());
	}

@Test(priority=14)
public void verifyLogout() throws IOException, InterruptedException {
	
	objCustomer.clickLogout();
	
	String expectedURL =AutomationConstants.URL1;
	String actualURL =driver.getCurrentUrl();
	System.out.println("Customer Logout: " +actualURL);
	Assert.assertEquals(expectedURL,actualURL);
	}


}
