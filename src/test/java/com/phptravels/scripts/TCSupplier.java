package com.phptravels.scripts;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.phptravels.constants.AutomationConstants;
import com.phptravels.pages.Customer;
import com.phptravels.pages.Supplier;
import com.phptravels.utilities.ExcelUtility;

public class TCSupplier extends TestBase {
Supplier objSupplier;

@Test(priority=1)
public void verifyHomePage() throws IOException, InterruptedException {

	objSupplier = new Supplier(driver);
	String parent=driver.getWindowHandle(); 
	
	String expectedTitle=AutomationConstants.HOMEPAGETITLE;
	String actualTitle =driver.getTitle();
	System.out.println("Title of the page Loaded is "+actualTitle);
	Assert.assertEquals(expectedTitle,actualTitle);
	}
@Test(priority=2)
public void verifySupplierBE() throws IOException, InterruptedException {

	objSupplier= new Supplier(driver);
	objSupplier.clickSupplierBE();
	Thread.sleep(2000);
	
	for(String winHandle : driver.getWindowHandles())
	{
	    driver.switchTo().window(winHandle);
	}
	
	String expectedTitle =AutomationConstants.TITLE3;
	String actualTitle =driver.getTitle();
	System.out.println("Supplier Login page: "+actualTitle);
	Assert.assertEquals(expectedTitle,actualTitle);
	}

@Test(priority=3)
			public void verifyNullSBLogin() throws IOException, InterruptedException {
			
			objSupplier= new Supplier(driver);
			objSupplier.clickSupplierLogin();
			Thread.sleep(2000);
			String actualErrorMessage =objSupplier.getErrorMsg();
			{
			if(objSupplier.getErrorMsg().contains(AutomationConstants.ERRORMESSG1)){
			System.out.println("Supplier login error: "+actualErrorMessage);
			}else{
			System.out.println("Login Successful");
			}}}

@Test(priority=4)
			public void verifyInvalidSBEmail() throws IOException, InterruptedException {
			
			objSupplier= new Supplier(driver);
			String supplieremail = ExcelUtility.getCellData(6, 3);
			objSupplier.strSupplierEmail(supplieremail);
			
			String supplierpass = ExcelUtility.getCellData(7, 3);
			objSupplier.strSupplierPass(supplierpass);
			objSupplier.clickSupplierLogin();
			Thread.sleep(3000);
			
			String expectedErrorMessage =AutomationConstants.ERRORMESSG2;
			String actualErrorMessage=objSupplier.getErrorMsg2();
			System.out.println("Supplier invalid login error: "+actualErrorMessage);
			Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
			}
		@Test(priority=5)
		public void verifyInvalidSBPass() throws IOException, InterruptedException {
		
		objSupplier= new Supplier(driver);
		
		objSupplier.clearEmail();
		String supplieremail = ExcelUtility.getCellData(9, 3);
		objSupplier.strSupplierEmail(supplieremail);
		
		objSupplier.clearPass();
		String supplierpass = ExcelUtility.getCellData(10, 3);
		objSupplier.strSupplierPass(supplierpass);
		
		Thread.sleep(2000);
		objSupplier.clickSupplierLogin();
		Thread.sleep(2000);
		
		String expectedErrorMessage =AutomationConstants.ERRORMESSG2;
		String actualErrorMessage=objSupplier.getErrorMsg2();
		System.out.println("Supplier invalid login error: "+actualErrorMessage);
		Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
		}
		@Test(priority=6)
		public void verifValidSupplierBE() throws IOException, InterruptedException {
		
		objSupplier= new Supplier(driver);
		objSupplier.clearEmail();
		String supplieremail = ExcelUtility.getCellData(3, 3);
		objSupplier.strSupplierEmail(supplieremail);
		
		objSupplier.clearPass();
		String supplierpass = ExcelUtility.getCellData(4, 3);
		objSupplier.strSupplierPass(supplierpass);
		objSupplier.clickSupplierLogin();
		Thread.sleep(2000);
		
		String expectedTitle =AutomationConstants.TITLE4;
		String actualTitle =driver.getTitle();
		
		if (expectedTitle.equals(actualTitle))
        {
               System.out.println("Supplier Login Successful - " + actualTitle);
        }
        else
        {
               System.out.println("Supplier login Failed - An incorrect title is displayed on the web page.");
        }
		
		Assert.assertEquals(expectedTitle,actualTitle);
		}
		
		
		@Test(priority=7)
		public void verifySalesOverview() throws IOException, InterruptedException {
		
		objSupplier= new Supplier(driver);
		objSupplier.getSales();
		
		String expectedTXT=AutomationConstants.TXT2;
		Assert.assertEquals(expectedTXT,objSupplier.getSales());
		System.out.println("Supplier BE: " +objSupplier.getSales()+" is displayed.");
		}
		
		@Test(priority=8)
		public void verifyRevenueBD() throws IOException, InterruptedException {
		
		objSupplier= new Supplier(driver);
		objSupplier.getRevenue();
		
		String expectedTXT=AutomationConstants.TXT3;
		Assert.assertEquals(expectedTXT,objSupplier.getRevenue());
		System.out.println("Supplier FE: " +objSupplier.getRevenue()+" is displayed.");
		}
		@Test(priority=9)
		public void verifyTours() throws IOException, InterruptedException {
		
		objSupplier= new Supplier(driver);
		
		if (objSupplier.clickTours()) {
			
			System.out.println("Supplier BE:Tours displayed and Clickable");
		}else {
			System.out.println("Tours Not Clickable");
		}
		}
		@Test(priority=10)
		public void verifyBookings() throws IOException, InterruptedException {
		
		objSupplier= new Supplier(driver);
		
		if (objSupplier.clickBookings()) {
			System.out.println("Supplier BE Bookings displayed and Clickable");
		}else {
			System.out.println("Bookings Not Clickable");
		}
		}
		@Test(priority=11)
		public void verifyVisa() throws IOException, InterruptedException {
		
		objSupplier= new Supplier(driver);
		String v = "visa";
	    
	    if ( driver.getPageSource().contains(v)){
	       System.out.println("Supplier BE: Module: " + v + " is displayed. ");
	    } else {
	       System.out.println("Supplier BE: Module: " + v + " is not displayed. ");
	    }
	 }
		@Test(priority=12)
		public void verifyFlight() throws IOException, InterruptedException {
		
		objSupplier= new Supplier(driver);
		String f = "flight";
	    
	    if ( driver.getPageSource().contains(f)){
	       System.out.println("Supplier BE: Module: " + f + " is displayed. ");
	    } else {
	       System.out.println("Supplier BE: Module: " + f + " is not displayed. ");
	    }
		}
		@Test(priority=13)
		public void verifyConfirmedBookings() throws IOException, InterruptedException {
		
		objSupplier= new Supplier(driver);
		objSupplier.getCount();
		
		int icount = Integer.parseInt(objSupplier.getCount());
		Integer initialcount = Integer.valueOf(objSupplier.getCount());
		System.out.println("Initial count: "+initialcount);
		
		objSupplier.clickPendingBookings();
		objSupplier.statusDrpdn(1);
		
		Thread.sleep(2000);
		
		driver.navigate().back();
		
		objSupplier.getCount();
		int fcount = Integer.parseInt(objSupplier.getCount());
		Integer finalcount = Integer.valueOf(objSupplier.getCount());
		System.out.println("Final count: "+finalcount);
		
		if(fcount > icount){
		    System.out.println("Supplier BE: Confirmed bookings incremented");
		}else{
		    System.out.println("Confirmed bookings not incremented");
		}
		}
}

