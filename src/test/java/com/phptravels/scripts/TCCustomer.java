package com.phptravels.scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
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
	System.out.println("Title of the Landing Page: "+actualTitle);
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
	System.out.println("Customer Login Successful: " +actualURL);
	Assert.assertEquals(expectedURL,actualURL);
	}

@Test(priority=7)
	public void verifyMyBookings() throws IOException, InterruptedException {
	
	objCustomer.clickMyBookings();
	Thread.sleep(2000);
	
	String expectedURL =AutomationConstants.URL4;
	String actualURL =driver.getCurrentUrl();
	System.out.println("Customer MyBookings: " +actualURL);
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
	String expectedTXT =AutomationConstants.TXT5;
	{
		if(objCustomer.getInvoice().contains(AutomationConstants.TXT5)){
		System.out.println("Invoice Window displays: "+expectedTXT);
		}else{
		System.out.println("Invoice unavailable");
		}}
	
	Thread.sleep(2000);
	driver.close();
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

@Test(priority=11)
	public void verifyPayPal() throws IOException, InterruptedException {
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	String originalHandle = driver.getWindowHandle();
	objCustomer.clickPayPal();
	
	for(String winHandle : driver.getWindowHandles())
	{
	    driver.switchTo().window(winHandle);
	}
	
	String paypalemail = ExcelUtility.getCellData(3, 4);
	objCustomer.strPaypalEmail(paypalemail);
	
	objCustomer.clickNext();
	
	String paypalpw = ExcelUtility.getCellData(4, 4);
	objCustomer.strPaypalPW(paypalpw);
	
	objCustomer.clickPaypalLogin();
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	Thread.sleep(2000);
	objCustomer.clickPaypalNow();
	
	driver.switchTo().window(originalHandle);
	Thread.sleep(2000);
	objCustomer.SuccessisDisplayed();
	
	String expectedURL =AutomationConstants.URL18;
	String actualURL =driver.getCurrentUrl();
	System.out.println("Customer Paypal Success: " +actualURL);
	Assert.assertEquals(expectedURL,actualURL);
	}
	
@Test(priority=12)
	public void verifyMyProfile() throws IOException, InterruptedException {
	
	objCustomer.clickMyProfile();
	
	String expectedURL =AutomationConstants.URL8;
	String actualURL =driver.getCurrentUrl();
	System.out.println("Customer MyProfile: " +actualURL);
	Assert.assertEquals(expectedURL,actualURL);
	}

@Test(priority=13)
public void verifyAddress() throws IOException, InterruptedException {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	
	objCustomer.clickAddress();
	String address = ExcelUtility2.getCellData(18, 7);
	objCustomer.strAddress(address);
	objCustomer.clickUpdateProfile();
	
	Thread.sleep(2000);
	String expectedTXT=AutomationConstants.TXT4;
	System.out.println("Customer Profile Update: " +objCustomer.getSuccess());
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
