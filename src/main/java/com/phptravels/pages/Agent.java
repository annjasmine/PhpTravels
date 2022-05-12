package com.phptravels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Agent {

	WebDriver driver;
    @FindBy(partialLinkText="//www.phptravels.net/login")
    private WebElement agentfe;
    
    @FindBy(name="email")
    private WebElement agentemail;
    
    @FindBy(name="password")
    private WebElement agentpass;
    
    @FindBy(css="button[class*='btn btn-default btn-lg btn-block effect ladda-button waves-effect']")
    private WebElement agentlogin;
   
    @FindBy(css="i[class*='la la-shopping-cart mr-2 text-color-3']")
    private WebElement mybookings;
    
    @FindBy(css="i[class*='la la-wallet mr-2 text-color-9']")
    private WebElement addfunds;
    
    @FindBy(css="i[class='la la-user mr-2 text-color-2']")
    private WebElement myprofile;
   
    @FindBy(xpath="//*[text()='Home']")
    private WebElement home;
    
    @FindBy(xpath="//*[text()='Hotels']")
    private WebElement hotels;
    
    @FindBy(id="select2-hotels_city-container")
    private WebElement hotelsbycity;
    
    @FindBy(css="input.select2-search__field")
    private WebElement cityname;
    
    @FindBy(id="submit")
    private WebElement search;
    
    @FindBy(xpath="//*[text()='flights']")
    private WebElement flights;
    
    @FindBy(xpath="//*[text()='Tours']")
    private WebElement tours;
    
    @FindBy(xpath="//*[text()='visa']")
    private WebElement visa;
    
    @FindBy(xpath="//*[text()='Blog']")
    private WebElement blog;
    
    @FindBy(xpath="//*[text()='Offers']")
    private WebElement offers;
    
    @FindBy(id="currency")
    private WebElement drpdncurrency;
     
    @FindBy(xpath="//*[text()=' INR']")
    private WebElement rupee;
 
    @FindBy(css="div[class='header-right-action pt-1 pe-2']")
    private WebElement account;
    
    @FindBy(xpath="//*[text()=' Logout']")
    private WebElement logout;
    
	    	public Agent(WebDriver driver){
			this.driver = driver;
			PageFactory.initElements(driver, this);
			}

		public void clickAgentFE(){ 
			 agentfe.click();
		 }
		public void clickAgentLogin(){ 
			 agentlogin.click();
		 }
		public void strAgentEmail(String strAgentEmail){
			agentemail.sendKeys(strAgentEmail);
		}
		
		public void strAgentPass(String stragentPass){
			agentpass.sendKeys(stragentPass);
		}
		
		public WebElement getEmail() {
		return agentemail;
		}
		
		public void setEmail(WebElement agentemail) {
		this.agentemail=agentemail;
		}
		
		public WebElement getPassword() {
		return agentpass;
		}
		
		public void setPassword(WebElement agentpass) {
		this.agentpass=agentpass;
		}
		
		public void clickMyBookings(){
			 mybookings.click();
		}
		public void clickAddFunds(){
			 addfunds.click();
		}
		public void clickMyProfile(){
			myprofile.click();
		}
		public void clickHome(){
			home.click();
		}
		public void clickHotels(){
			hotels.click();
		}
		public void clickHotelsbyCity(){
			hotelsbycity.click();
		}
		
		public void strCityName(String strCityName){
			cityname.sendKeys(strCityName);
		}
			public void enterCityName(){
			cityname.sendKeys(Keys.RETURN);
		}
		public void clickSearch(){	
			search.submit();
		}
		
		public void clickflights(){
			flights.click();
		}
		public void clickTours(){
			tours.click();
		}
		public void clickvisa(){
			visa.click();
		}
		public void clickOffers(){
			offers.click();
		}
		public void clickBlog(){
			blog.click();
		}
		     
	    public void clickCurrency(){
	    drpdncurrency.click();
	    rupee.click();
	    }
	    public String getText() {
	    return drpdncurrency.getText();
	    }
		
	    public void clickAccount(){
			 account.click();
		}
		
		public void clickLogout(){
			 logout.click();
		}
}
