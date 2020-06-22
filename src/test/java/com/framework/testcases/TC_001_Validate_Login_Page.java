package com.framework.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.framework.basetest.TestBase;
import com.framework.frameworkutils.Keywords;
import com.framework.frameworkutils.TestUtils;

public class TC_001_Validate_Login_Page extends TestBase {
	
	
	@Test(dataProvider = "getData")
	public void TC_001_Validate_Login_Page(Hashtable<String, String> dataa) throws Exception {
		
		if(!dataa.get("Runmode").equalsIgnoreCase("Y")) {
			
			throw new SkipException("Test Cases execution mode is set by No..!!!!!!!!!!!!");
		}
		
		
		Keywords k = new Keywords();
		k.executeKeywords("TC_001_Validate_Login_Page", dataa);
		
	}
	
	@DataProvider
	public Object[][] getData(){
		
		return TestUtils.getData("TC_001_Validate_Login_Page", xls);
	}

}