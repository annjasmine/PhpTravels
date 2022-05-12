package com.phptravels.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Admin {
	WebDriver driver;
	
    @FindBy(partialLinkText="//www.phptravels.net/admin")
    private WebElement adminbe;
    
    @FindBy(name="email")
    private WebElement adminemail;
    
    @FindBy(name="password")
    private WebElement adminpass;
    
    @FindBy(css="button[class*='btn btn-primary btn-block ladda-button fadeIn animated mdc-ripple-upgraded']")
    private WebElement adminlogin;
	
    @FindBy(css="div[class='alert alert-danger loading wow fadeIn animated animated']")
    private WebElement errormsg;
    
    @FindBy(css="div[class=resultlogin]")
    private WebElement errormsg2;

    @FindBy(css="a[class='nav-link loadeffect']")
    private WebElement bookings;
    
    @FindBy(xpath="//*[text()='Paid Bookings']")
    private WebElement paidbookings;  

	 @FindBy(css="i[class='fa fa-file']")
	 private WebElement voucher;
	 
	 @FindBy(xpath="//*[text()='Booking Invoice                            ']")
	 private WebElement vouchertitle;
	 
	@FindBy(css="div[class='card card-raised border-start border-danger border-4 cancelled_']")
	private WebElement cancelledbooking;
	
	@FindBy(css="button[class='btn btn-danger mdc-ripple-upgraded']")
	private WebElement deletebtn;
	
	@FindBy(css="div[class='display-5']")
    private WebElement initialcount;
    
	@FindBy(css="div[class='card card-raised border-start border-warning border-4 pending_']")
    private WebElement pendingbookings;
	
    @FindBy(id="booking_status")
    private WebElement status;
    
    @FindBy(css="li[class='nav-item']")
    private WebElement website;
	 
		public Admin(WebDriver driver){
 		this.driver = driver;
 		PageFactory.initElements(driver, this);
		}

	public void clickAdminBE(){ 
		adminbe.click();
	 }
	public void clickAdminLogin(){ 
		adminlogin.click();
	 }
	public void clearEmail(){
		adminemail.clear();
	}
	
	public void strAdminEmail(String strAdminEmail){
		adminemail.sendKeys(strAdminEmail);
	}
	
	public void clearPass(){
		 adminpass.clear();
	 }
	public void strAdminPass(String strAdminPass){
		adminpass.sendKeys(strAdminPass);
	}
	public String getErrorMsg() {
	    return errormsg.getText();
	}
	public String getErrorMsg2() {
	    return errormsg2.getText();
	}
	public void clickBookings(){ 
		bookings.click();
	}
	public void clickPaidBookings(){ 
		paidbookings.click();
	}
	public void clickInvoice(){ 
		voucher.click();
	}
	public String getInvoice() {
	    return vouchertitle.getText();
	}
	public void clickCnldBook(){ 
		cancelledbooking.click();
	}
	public void clickDeletebtn(){ 
		deletebtn.click();
	}
	public String getCount() {
	    return initialcount.getText();
	}
	
	public void clickPendingBookings(){ 
		pendingbookings.click();
	}
	public void statusDrpdn(int index){ 
		Select drop = new Select(status);
	      drop.selectByIndex(index);
	}
	public void clickWebsite(){ 
		website.click();
	}
}