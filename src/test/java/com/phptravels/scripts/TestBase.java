package com.phptravels.scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
    public static Properties prop = null;
    
    	public static void TestBase() {
        try {
        	
            prop = new Properties();
         
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources"
                    + "/Config.properties");
     
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
}
			@Parameters("browser") 
			@BeforeTest
			public void onSetup(String browserName) {
    	        TestBase(); 
    	       
    	        if (browserName.equals("chrome")) {
    	        	//System.setProperty("webdriver.chrome.driver", driverPath);
    	        	WebDriverManager.chromedriver().setup();
    	        	driver = new ChromeDriver();
    	        }
    	        else if (browserName.equals("firefox")) {
    	        	WebDriverManager.firefoxdriver().setup();
    	        	//driver = new FirefoxDriver();
    	        }
    	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	        driver.get(prop.getProperty("url"));
    	        driver.manage().window().maximize();
    		    }
            @AfterMethod
		    public void tearDown(ITestResult iTestResult) throws IOException {
		        if (iTestResult.FAILURE == iTestResult.getStatus()) {
		            takeScreenshot(iTestResult.getName());
		        }
		    }
            public String takeScreenshot(String name) throws IOException {
		    	
		       String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		        
		        String destination =  System.getProperty("user.dir") + "\\target\\" + name + dateName
		                + ".png";
		       
		        File finalDestination = new File(destination);
		        FileUtils.copyFile(source, finalDestination);
		        return destination;   
            	 }
         @AfterClass
			public void closeBrowser() throws IOException {
        	
        	driver.get(prop.getProperty("url"));
        	driver.manage().window().maximize();
         }
	@AfterTest
				public void quitBrowser() throws IOException {
				//driver.quit();
				}
	
}
