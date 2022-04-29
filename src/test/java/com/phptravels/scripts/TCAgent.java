package com.phptravels.scripts;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.phptravels.constants.AutomationConstants;
import com.phptravels.pages.Agent;
import com.phptravels.utilities.ExcelUtility;

public class TCAgent extends TestBase{
	Agent objAgent;
	
	@Test(priority=1)
	public void verifyHomePage() throws IOException, InterruptedException {
	
	objAgent = new Agent(driver);
	
	String parent=driver.getWindowHandle(); 
	}
	
	@Test(priority=2)
	public void verifyAgentFE() throws IOException, InterruptedException {
	
	objAgent= new Agent(driver);
	objAgent.clickAgentFE();
	Thread.sleep(2000);

	for(String winHandle : driver.getWindowHandles())
	{
	    driver.switchTo().window(winHandle);
	}
	
	String expectedURL =AutomationConstants.URL1;
	String actualURL =driver.getCurrentUrl();
	System.out.println("Agent Login page: "+actualURL);
	Assert.assertEquals(expectedURL,actualURL);
	}

@Test(priority=3)
	public void verifyNullCFLogin() throws IOException, InterruptedException {
	
	objAgent= new Agent(driver);
	objAgent.clickAgentLogin();
	Thread.sleep(2000);
	
	String expectedValidationMessage =AutomationConstants.VALMESSG;
	String actualValidationMessage =objAgent.getEmail().getAttribute("validationMessage");
	System.out.println("Agent login error: "+actualValidationMessage);
	Assert.assertEquals(expectedValidationMessage,actualValidationMessage);
	}

@Test(priority=4)
	public void verifyInvalidAFEmail() throws IOException, InterruptedException {
	
	objAgent= new Agent(driver);
	String agentemail = ExcelUtility.getCellData(6, 1);
	objAgent.strAgentEmail(agentemail);
	
	String custpass = ExcelUtility.getCellData(7, 1);
	objAgent.strAgentPass(custpass);
	
	objAgent.clickAgentLogin();
	Thread.sleep(2000);
	
	String expectedURL =AutomationConstants.URL2;
	String actualURL =driver.getCurrentUrl();
	System.out.println("Agent invalid login error: "+actualURL);
	Assert.assertEquals(expectedURL,actualURL);
	}

@Test(priority=5)
	public void verifyInvalidAFPass() throws IOException, InterruptedException {
	
	objAgent= new Agent(driver);
	String agentemail = ExcelUtility.getCellData(9, 1);
	objAgent.strAgentEmail(agentemail);
	
	String agentpass = ExcelUtility.getCellData(10, 1);
	objAgent.strAgentPass(agentpass);
	
	objAgent.clickAgentLogin();
	Thread.sleep(2000);
	
	String expectedURL =AutomationConstants.URL2;
	String actualURL =driver.getCurrentUrl();
	System.out.println("Agent invalid login error: "+actualURL);
	Assert.assertEquals(expectedURL,actualURL);
	}

@Test(priority=6)
	public void verifyValidAFLogin() throws IOException, InterruptedException {
	
	objAgent= new Agent(driver);
	String agentemail = ExcelUtility.getCellData(3, 1);
	objAgent.strAgentEmail(agentemail);
	
	String agentpass = ExcelUtility.getCellData(4, 1);
	objAgent.strAgentPass(agentpass);
	
	objAgent.clickAgentLogin();
	Thread.sleep(2000);
	
	String expectedURL =AutomationConstants.URL3;
	String actualURL =driver.getCurrentUrl();
	System.out.println("Agent Login Successful - " +actualURL);
	Assert.assertEquals(expectedURL,actualURL);
	}
@Test(priority=7)
public void verifyAFMyBookings() throws IOException, InterruptedException {
	
	objAgent.clickMyBookings();
	Thread.sleep(2000);
	String expectedURL =AutomationConstants.URL4;
	String actualURL =driver.getCurrentUrl();
	System.out.println("Agent bookings: " +actualURL);
	Assert.assertEquals(expectedURL,actualURL);
	
	Thread.sleep(2000);
	}
@Test(priority=8)
public void verifyAFAddFunds() throws IOException, InterruptedException {

	objAgent.clickAddFunds();
	Thread.sleep(2000);
	
	String expectedURL =AutomationConstants.URL6;
	String actualURL =driver.getCurrentUrl();
	System.out.println("Agent Addfunds: " +actualURL);
	Assert.assertEquals(expectedURL,actualURL);
	
	Thread.sleep(2000);
	}
@Test(priority=9)
public void verifyAFMyProfile() throws IOException, InterruptedException {

	objAgent.clickMyProfile();
	
	String expectedURL =AutomationConstants.URL8;
	String actualURL =driver.getCurrentUrl();
	System.out.println("Agent Myprfile: " +actualURL);
	Assert.assertEquals(expectedURL,actualURL);
	
	Thread.sleep(2000);
	}
@Test(priority=10)
public void verifyAFHome() throws IOException, InterruptedException {

	objAgent.clickHome();
	
	String expectedURL =AutomationConstants.URL16;
	String actualURL =driver.getCurrentUrl();
	System.out.println("Agent Home: " +actualURL);
	Assert.assertEquals(expectedURL,actualURL);
	
	Thread.sleep(2000);
	}
@Test(priority=11)
public void verifyAFHotels() throws IOException, InterruptedException {

	objAgent.clickHotels();
	
	String expectedURL =AutomationConstants.URL10;
	String actualURL =driver.getCurrentUrl();
	System.out.println("Agent Hotels: " +actualURL);
	Assert.assertEquals(expectedURL,actualURL);
	
	Thread.sleep(2000);
	}
@Test(priority=12)
public void verifyAFHotelsbyCity() throws IOException, InterruptedException {
	objAgent.clickHotelsbyCity();
	
	String cityname = ExcelUtility.getCellData(2, 4);
	objAgent.strCityName(cityname);
	Thread.sleep(2000);
	objAgent.enterCityName();
	Thread.sleep(2000);
	objAgent.clickSearch();
	
	String expectedTitle=AutomationConstants.TITLE2;
	String actualTitle =driver.getTitle();
	System.out.println("Agent Hotels by City: "+actualTitle);
	Assert.assertEquals(expectedTitle,actualTitle);

}
@Test(priority=13)
public void verifyAFFlights() throws IOException, InterruptedException {

	objAgent.clickflights();
	
	String expectedURL =AutomationConstants.URL11;
	String actualURL =driver.getCurrentUrl();
	System.out.println("Agent Flights: " +actualURL);
	Assert.assertEquals(expectedURL,actualURL);
	
	Thread.sleep(2000);
	}
@Test(priority=14)
public void verifyAFTours() throws IOException, InterruptedException {

	objAgent.clickTours();
	
	String expectedURL =AutomationConstants.URL12;
	String actualURL =driver.getCurrentUrl();
	System.out.println("Agent Tours: " +actualURL);
	Assert.assertEquals(expectedURL,actualURL);
	
	Thread.sleep(2000);
	}
@Test(priority=15)
public void verifyAFVisa() throws IOException, InterruptedException {

	objAgent.clickvisa();
	
	String expectedURL =AutomationConstants.URL13;
	String actualURL =driver.getCurrentUrl();
	System.out.println("Agent Visa: " +actualURL);
	Assert.assertEquals(expectedURL,actualURL);
	
	Thread.sleep(2000);
	}
@Test(priority=16)
public void verifyAFBlog() throws IOException, InterruptedException {

	objAgent.clickBlog();
	
	String expectedURL =AutomationConstants.URL14;
	String actualURL =driver.getCurrentUrl();
	System.out.println("Agent Blog: " +actualURL);
	Assert.assertEquals(expectedURL,actualURL);
	
	Thread.sleep(2000);
	}
@Test(priority=17)
public void verifyAFOffers() throws IOException, InterruptedException {

	objAgent.clickOffers();
	
	String expectedURL =AutomationConstants.URL15;
	String actualURL =driver.getCurrentUrl();
	System.out.println("Agent Offers: " +actualURL);
	Assert.assertEquals(expectedURL,actualURL);
	
	Thread.sleep(2000);
	}

@Test(priority=18)
	public void verifyCurrency() throws IOException, InterruptedException {
	
	objAgent.clickCurrency();
	Thread.sleep(2000);
	
	String expectedTXT=AutomationConstants.TXT1;
	Assert.assertEquals(expectedTXT,objAgent.getText());
	System.out.println("Agent Currency: " +objAgent.getText());
		}

@Test(priority=19)
public void verifyAFLogout() throws IOException, InterruptedException {
	
	objAgent.clickAccount();
	Thread.sleep(2000);
	objAgent.clickLogout();
	Thread.sleep(2000);
	
	String expectedURL =AutomationConstants.URL1;
	String actualURL =driver.getCurrentUrl();
	System.out.println("Agent Logout: " +actualURL);
	Assert.assertEquals(expectedURL,actualURL);
	}
}
