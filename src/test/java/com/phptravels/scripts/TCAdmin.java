package com.phptravels.scripts;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.phptravels.constants.AutomationConstants;
import com.phptravels.pages.Admin;
import com.phptravels.pages.Supplier;
import com.phptravels.utilities.ExcelUtility;

public class TCAdmin extends TestBase {
	Admin objAdmin;
	
	
	@Test(priority=1)
	public void verifyHomePage() throws IOException, InterruptedException {
	
		objAdmin= new Admin(driver);
		String parent=driver.getWindowHandle(); 
		
		String expectedTitle=AutomationConstants.HOMEPAGETITLE;
		String actualTitle =driver.getTitle();
		System.out.println("Title of the page Loaded is "+actualTitle);
		Assert.assertEquals(expectedTitle,actualTitle);
		}
	@Test(priority=2)
	public void verifyAdminBE() throws IOException, InterruptedException {
	
		objAdmin= new Admin(driver);
		objAdmin.clickAdminBE();
		Thread.sleep(2000);
		
		for(String winHandle : driver.getWindowHandles())
		{
		    driver.switchTo().window(winHandle);
		}
		
		String expectedTitle =AutomationConstants.TITLE5;
		String actualTitle =driver.getTitle();
		System.out.println("Admin Login page: "+actualTitle);
		Assert.assertEquals(expectedTitle,actualTitle);
		}

	@Test(priority=3)
	public void verifyNullABLogin() throws IOException, InterruptedException {
			
			objAdmin= new Admin(driver);
			objAdmin.clickAdminLogin();
			Thread.sleep(2000);
			String actualErrorMessage =objAdmin.getErrorMsg();
			{
			if(objAdmin.getErrorMsg().contains(AutomationConstants.ERRORMESSG1)){
			System.out.println("Admin login error: "+actualErrorMessage);
			}else{
			System.out.println("Login Successful");
			}}}

		@Test(priority=4)
		public void verifyInvalidABEmail() throws IOException, InterruptedException {
			
			objAdmin= new Admin(driver);
			String adminemail = ExcelUtility.getCellData(6, 2);
			objAdmin.strAdminEmail(adminemail);
			
			String adminpass = ExcelUtility.getCellData(7, 2);
			objAdmin.strAdminPass(adminpass);
			objAdmin.clickAdminLogin();
			Thread.sleep(3000);
			
			String expectedErrorMessage =AutomationConstants.ERRORMESSG2;
			String actualErrorMessage=objAdmin.getErrorMsg2();
			System.out.println("Admin invalid login error1: "+actualErrorMessage);
			Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
			}
	@Test(priority=5)
	public void verifyInvalidABPass() throws IOException, InterruptedException {
		
		objAdmin= new Admin(driver);
		
		objAdmin.clearEmail();
		String adminemail = ExcelUtility.getCellData(9,2);
		objAdmin.strAdminEmail(adminemail);
		
		objAdmin.clearPass();
		String adminpass = ExcelUtility.getCellData(10, 2);
		objAdmin.strAdminPass(adminpass);
		
		Thread.sleep(2000);
		objAdmin.clickAdminLogin();
		Thread.sleep(2000);
		
		String expectedErrorMessage =AutomationConstants.ERRORMESSG2;
		String actualErrorMessage=objAdmin.getErrorMsg2();
		System.out.println("Admin invalid login error2: "+actualErrorMessage);
		Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
		}
	@Test(priority=6)
	public void verifValidAdminBE() throws IOException, InterruptedException {
		
		objAdmin= new Admin(driver);
		objAdmin.clearEmail();
		String adminemail = ExcelUtility.getCellData(3, 2);
		objAdmin.strAdminEmail(adminemail);
		
		objAdmin.clearPass();
		String adminpass = ExcelUtility.getCellData(4, 2);
		objAdmin.strAdminPass(adminpass);
		objAdmin.clickAdminLogin();
		Thread.sleep(2000);
		
		String expectedTitle =AutomationConstants.TITLE4;
		String actualTitle =driver.getTitle();
		
		if (expectedTitle.equals(actualTitle))
        {
               System.out.println("Admin Successful Login Title: " + actualTitle);
        }
        else
        {
               System.out.println("Admin login Failed - An incorrect title is displayed on the web page.");
        }
		
		Assert.assertEquals(expectedTitle,actualTitle);
		}
	@Test(priority=7)
	public void verifyBookings() throws IOException, InterruptedException {
		
		objAdmin= new Admin(driver);
		objAdmin.clickBookings();
		 Thread.sleep(2000);
		
		String expectedTitle =AutomationConstants.TITLE6;
		String actualTitle =driver.getTitle();
		System.out.println("Admin Bookings Tab: "+actualTitle);
		Assert.assertEquals(expectedTitle,actualTitle);
		}
		
	@Test(priority=8)
	public void verifyPaidBookings() throws IOException, InterruptedException {
		
		objAdmin= new Admin(driver);
		objAdmin.clickPaidBookings();
		 Thread.sleep(2000);
		String expectedTitle =AutomationConstants.TITLE7;
		String actualTitle =driver.getTitle();
		System.out.println("Admin Paid Bookings tab: "+actualTitle);
		Assert.assertEquals(expectedTitle,actualTitle);
		}
	@Test(priority=9)
	public void verifyInvoice() throws IOException, InterruptedException {
		
		String originalHandle = driver.getWindowHandle();
		
		objAdmin= new Admin(driver);
		objAdmin.clickInvoice();
		Thread.sleep(3000);
		
		for(String winHandle : driver.getWindowHandles())
		{
		    driver.switchTo().window(winHandle);
		}
		
		String expectedTXT =AutomationConstants.TXT5;
		{
			if(objAdmin.getInvoice().contains(AutomationConstants.TXT5)){
			System.out.println("Admin Paid bookings Invoice Window displays: "+expectedTXT);
			}else{
			System.out.println("Invoice unavailable");
			}}
		
		for(String handle : driver.getWindowHandles()) {
	        if (!handle.equals(originalHandle)) {
	            driver.switchTo().window(handle);
	            driver.close();
	        }
	    }
	    driver.switchTo().window(originalHandle);
		}
	
	
	@Test(priority=10)
	public void verifycancelledBookings() throws IOException, InterruptedException {
		
		objAdmin= new Admin(driver);
		objAdmin.clickCnldBook();
		 Thread.sleep(2000);
		 
		String expectedTitle =AutomationConstants.TITLE8;
		String actualTitle =driver.getTitle();
		System.out.println("Admin Cancelled Bookings tab: "+actualTitle);
		Assert.assertEquals(expectedTitle,actualTitle);
		}
	@Test(priority=11)
	public void verifydeleteBookings() throws IOException, InterruptedException {
		
		objAdmin= new Admin(driver);
		objAdmin.clickDeletebtn();
		 Thread.sleep(2000);
		 
		 String alertmessg=driver.switchTo().alert().getText();
		 System.out.println("Popup message-Delete cancelled booking: "+alertmessg);
		 driver.switchTo().alert().accept();
		 Thread.sleep(2000);
		 
		String expectedTitle =AutomationConstants.TITLE8;
		String actualTitle =driver.getTitle();
		System.out.println("Admin Cancelled Bookings tab: "+actualTitle);
		Assert.assertEquals(expectedTitle,actualTitle);
		}
	@Test(priority=12)
	public void verifyConfirmedBookings() throws IOException, InterruptedException {
		
		objAdmin= new Admin(driver);
		objAdmin.getCount();
		
		int icount = Integer.parseInt(objAdmin.getCount());
		Integer initialcount = Integer.valueOf(objAdmin.getCount());
		System.out.println("Initial count of Confirmed Bookings: "+initialcount);
		
		objAdmin.clickPendingBookings();
		objAdmin.statusDrpdn(1);
		
		Thread.sleep(2000);
		
		driver.navigate().back();
		
		objAdmin.getCount();
		int fcount = Integer.parseInt(objAdmin.getCount());
		Integer finalcount = Integer.valueOf(objAdmin.getCount());
		System.out.println("Final count of Confirmed Bookings: "+finalcount);
		
		if(fcount > icount){
		    System.out.println("Admin BE: Number of Confirmed bookings incremented");
		}else{
		    System.out.println("Confirmed bookings not incremented");
		}
		}
	@Test(priority=13)
	public void verifyWebsite() throws IOException, InterruptedException {
	
		String originalHandle= driver.getWindowHandle();
		objAdmin= new Admin(driver);	
		objAdmin.clickWebsite();
		
		for(String winHandle : driver.getWindowHandles())
		{
		    driver.switchTo().window(winHandle);
		}
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.urlToBe("https://www.phptravels.net/"));
		
		String expectedURL =AutomationConstants.URL16;
		String actualURL =driver.getCurrentUrl();
		System.out.println("Admin 'Website' URL: " +actualURL);
		Assert.assertEquals(expectedURL,actualURL);
	
		}
	}
