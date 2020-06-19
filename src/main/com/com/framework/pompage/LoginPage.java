package com.framework.pompage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.basetest.TestBase;

public class LoginPage extends TestBase{
	
	//WebDriver driver;
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath = "//div[text()='Login']")
	WebElement login_btn;
	
	@FindBy(xpath = "//*[text()='Forgot your password?']")
	WebElement forgetPassword_btn;
	
	@FindBy(xpath = "//*[text()='Classic CRM']")
	WebElement classicFreeCRM_link;
	
	@FindBy(xpath = "//*[text()='Sign Up']")
	WebElement signUp_link;

	public LoginPage(WebDriver driver) {
		
			//this.driver=driver;
	        PageFactory.initElements(driver, this);
	    
	}
	
	public void set_email(String emailaddress) {
	
		email.sendKeys(emailaddress);
		
	}
	
	public void set_password(String pwd) {
		
		password.sendKeys(pwd);
	}
	
	public void clickOnLogin() {
		
		login_btn.click();
	}
	
	public void clickOnClassicFreeCRM_Link() {
		
		classicFreeCRM_link.click();
	}
	public void clickOnSignUp_Link() {
		
		signUp_link.click();
	}
	}
