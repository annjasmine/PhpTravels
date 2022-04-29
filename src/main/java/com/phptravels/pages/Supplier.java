package com.phptravels.pages;

import java.nio.channels.AcceptPendingException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Supplier {
	WebDriver driver;
    @FindBy(partialLinkText="//www.phptravels.net/supplier")
    private WebElement supplierfe;
    
    @FindBy(name="email")
    private WebElement supplieremail;
    
    @FindBy(name="password")
    private WebElement supplierpass;
    
    @FindBy(css="button[class*='btn btn-primary btn-block ladda-button fadeIn animated mdc-ripple-upgraded']")
    private WebElement supplierlogin;
   
    @FindBy(css="div[class='alert alert-danger loading wow fadeIn animated animated']")
    private WebElement errormsg;
    
    @FindBy(css="div[class=resultlogin]")
    private WebElement errormsg2;
    
    @FindBy(css="div[class=text-muted]")
    private WebElement sales;
    
    @FindBy(xpath="//*[text()='Revenue Breakdown 2022']")
    private WebElement revenue;
    
    @FindBy(xpath="//*[@id='drawerAccordion']/div[1]/div/a[5]")
    private WebElement tours;
    
    @FindBy(css="a[class='loadeffect nav-link collapsed mdc-ripple-upgraded']")
    private WebElement bookings;	
    
    @FindBy(css="div[class='card card-raised border-start border-warning border-4 pending_']")
    private WebElement pendingbookings;
    
    @FindBy(css="div[class='text-uppercase font-monospace']")
    private WebElement dashboard;
    		
    @FindBy(css="div[class='col-xxl-4 col-md-6 mb-3 ripple_primary']")
    private WebElement confirmedbookings;
    
    @FindBy(css="div[class='display-5']")
    private WebElement initialcount;
    
    @FindBy(id="booking_status")
    private WebElement status;
    		
   // @FindBy(id="booking_status")
    private WebElement confirmed;
    
    public Supplier(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}

		public void clickSupplierFE(){ 
			supplierfe.click();
		 }
		public void clickSupplierLogin(){ 
			supplierlogin.click();
		 }
		
		 public void clearEmail(){
			 supplieremail.clear();
		 }
		public void strSupplierEmail(String strSupplierEmail){
			supplieremail.sendKeys(strSupplierEmail);
		}
		public void clearPass(){
			 supplierpass.clear();
		 }
		public void strSupplierPass(String strSupplierPass){
			supplierpass.sendKeys(strSupplierPass);
		}
		
		public String getErrorMsg() {
		    return errormsg.getText();
		}
		public String getErrorMsg2() {
		    return errormsg2.getText();
		}
		public String getSales() {
		    return sales.getText();
		}
		public String getRevenue() {
		    return revenue.getText();
		}
		public boolean clickTours(){
	            return tours.isEnabled();
		}
		public boolean clickBookings(){
            return bookings.isEnabled();
		}
		public void clickPendingBookings(){ 
			pendingbookings.click();
		}
		public void clickDashboard(){ 
			dashboard.click();
		}
		public void clickConfirmedBookings(){ 
			confirmedbookings.click();
		}
		public String getCount() {
		    return initialcount.getText();
		}
		public void statusDrpdn(int index){ 
			Select drop = new Select(status);
		      drop.selectByIndex(index);
		}
		
		
}
		
