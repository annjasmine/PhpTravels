package com.phptravels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Customer {
	WebDriver driver;
    @FindBy(partialLinkText="//www.phptravels.net/login")
    private WebElement customerfe;
    
    @FindBy(name="email")
    private WebElement custemail;
    
    @FindBy(name="password")
    private WebElement custpass;
    
    @FindBy(css="button[class*='btn btn-default btn-lg btn-block effect ladda-button waves-effect']")
    private WebElement custlogin;
    
    @FindBy(css="i[class*='la la-shopping-cart mr-2 text-color-3']")
    private WebElement mybookings;
    
    @FindBy(css="i[class*='la la-eye']")
    private WebElement voucher;
    
    @FindBy(css="i[class*='la la-wallet mr-2 text-color-9']")
    private WebElement addfunds;
    
    @FindBy(id="gateway_paypal")
    private WebElement paypalbtn;
    
    @FindBy(css="i[class*='la la-arrow-right']")
    private WebElement paynow;

    @FindBy(xpath="//*[@id='buttons-container']/div/div/div")
    private WebElement paypal;
    
    @FindBy(css="i[class*='la la-user mr-2 text-color-2']")
    private WebElement myprofile;
    
    @FindBy(name="address1")
    private WebElement address;
    
    @FindBy(css="button[class='theme-btn waves-effect']")
    private WebElement updateprofile;
    
    
    @FindBy(css="div[class='alert alert-success']")
    //@FindBy(xpath="//*[text()=' Profile updated successfully.                                ']")
    private WebElement success;
    
    @FindBy(css="i[class*='la la-power-off mr-2 text-color-6']")
    private WebElement logout;	
    
    @FindBy(xpath="//*[text()='Booking Invoice                            ']")
	 private WebElement vouchertitle;
   
    		public Customer(WebDriver driver){
    		this.driver = driver;
    		PageFactory.initElements(driver, this);
			}

	public void clickCustomerFE(){ 
		 customerfe.click();
	 }
	public void clickCustLogin(){ 
		 custlogin.click();
	 }
	public void strCustEmail(String strCustEmail){
		custemail.sendKeys(strCustEmail);
	}
	
	public void strCustPass(String strCustPass){
		custpass.sendKeys(strCustPass);
	}
	
	public WebElement getEmail() {
	return custemail;
	}
	
	public void setEmail(WebElement custemail) {
	this.custemail=custemail;
	}
	
	public WebElement getPassword() {
	return custpass;
	}
	
	public void setPassword(WebElement custpass) {
	this.custpass=custpass;
	}
	
	 public void clickMyBookings(){
		 mybookings.click();
	 }
	 public void clickVoucher(){
		 voucher.click();
	 }
	 public void clickAddFunds(){
		 addfunds.click();
	 }
	 public void clickPayPalBtn(){
		 paypalbtn.click();
	 }
	 public void clickPayNow(){
		 paynow.click();
	 }
	 public void clickPayPal(){
		 paypal.click();
	 }
	 public void clickMyProfile(){
		 myprofile.click();
	 }
	 public void clickAddress(){
		 address.clear();
	 } 
	 public void strAddress(String strAddress){
			address.sendKeys(strAddress);
	 }
	 public void clickUpdateProfile(){
		 updateprofile.submit();
	 }
	 public String getSuccess(){
		return success.getText();
	 }
	 
	 public void clickLogout(){
		 logout.click();
	 }
	 public String getInvoice() {
		    return vouchertitle.getText();
	 }
}
