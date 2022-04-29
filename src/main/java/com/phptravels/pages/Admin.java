package com.phptravels.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Admin {

	@FindBy(partialLinkText="https://www.phptravels.net/api/admin/bookings/paid")
	//@FindBy(css="div[class='col-xxl-4 col-md-6 mb-5']"
	private WebElement paidbookings;
	
	 @FindBy(css="i[class='fa fa-file']")
	// @FindBy(partialLinkText=="https://www.phptravels.net/api/../hotels/booking/invoice/1325/1")
	 private WebElement voucher;
	 
	 //@FindBy(xpath="//*[text()='Booking Invoice                            ']")
	 private WebElement vouchertitle;
}
