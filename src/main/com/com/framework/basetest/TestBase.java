package com.framework.basetest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	
	
	public void openBrowser(String browserName) {
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			
			WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		}
		else if(browserName.equalsIgnoreCase("Firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			
			driver = new FirefoxDriver();
			
		}
		else if(browserName.equalsIgnoreCase("Edge")) {
			
			WebDriverManager.edgedriver().setup();
			
			driver = new EdgeDriver();
			
		}
		else {
			
			throw new SkipException("DRIVER IS NOT MATCHED>>>>>>> PLEASE CHECK BROWSER SETUP..");
			
		}
		
	}
	
	public void navigateURL(String url) {
		
		driver.get(url);
	}

}
