package com.framework.testcases;

import org.testng.annotations.Test;

import com.framework.basetest.TestBase;
import com.framework.pompage.LoginPage;

public class TC_001_Validate_Login_Page extends TestBase {
	
	
	@Test
	public void validate_Login_Page() {
		
		TestBase testbase = new TestBase();
		testbase.openBrowser("Chrome");
		testbase.navigateURL("https://ui.cogmento.com/");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.set_email("josephkuruvilla891@gmail.com");
		loginpage.set_password("Jakay07@");
		loginpage.clickOnLogin();
		
		
	}

}
