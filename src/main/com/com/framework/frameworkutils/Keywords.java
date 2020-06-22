package com.framework.frameworkutils;

import java.util.Hashtable;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.basetest.TestBase;
import com.framework.contants.VariableConstants;

public class Keywords extends TestBase{
	
	public String testCasesName = "";

	public void executeKeywords(String testcases, Hashtable<String, String> data) throws Exception {

		this.testCasesName = testcases;
		loadproperties();
		//PropertyConfigurator.configure("log4j.properties");
		System.out.println("Executable test cases is :" + testcases);

		String keyword = null;
		String objectkeys = null;
		String datakeys = null;

		for (int rNum = 2; rNum <= xls.getRowCount("Test Steps"); rNum++) {
			if (testcases.equals(xls.getCellData("Test Steps", "TCID", rNum))) {
				keyword = xls.getCellData("Test Steps", "Keyword", rNum);
				objectkeys = xls.getCellData("Test Steps", "Object", rNum);
				datakeys = xls.getCellData("Test Steps", "Data", rNum);

				System.out.println(keyword + "--" + objectkeys + "--" + datakeys);

				String result = null;
				switch (keyword) {
				
				case "openBrowser":
					result = openBrowser(objectkeys);
					break;

				case "navigateURL":
					result = navigateURL(objectkeys);
					break;

				case "verifyTitle": 
					result = verifyTitle(datakeys); 
					break;
				case "click":
					result = click(objectkeys);
					break;

				case "enter":
					if (data != null)
						result = enter(objectkeys, data.get(datakeys));
					else
						result = enter(objectkeys, datakeys);
					break;
				
				  case "verifyText": if (data != null) 
					  result = verifyText(objectkeys,data.get(datakeys)); 
				  else 
					  result = verifyText(objectkeys, datakeys); 
				  break;
				  case "selectDropdown": 
					  result = selectDropdown(objectkeys, datakeys); 
					  break;
				  case "waitForTextPresent":
					  result = waitForTextPresent(objectkeys, datakeys);
				  	  break;
				case "close":
					result = close();
					break;
				
				default:
					System.out.println("Not Matching Keyword :" + keyword);
					break;
				}

				if (result != null) {
					if (result.equals("Pass"))
						xls.setCellData1("Test Steps", "Status", (rNum - 1), "Executed");
					else
						xls.setCellData1("Test Steps", "Status", (rNum - 1), "Not Executed");
				}

			}

		}

	}


	private String enter(String objectkeys, String string) throws Exception {
		
		getWebElement(objectkeys).sendKeys(string);
		
		return "Pass";
	}

	private String click(String objectkeys) throws Exception {

		getWebElement(objectkeys).click();
		
		return "Pass";
	}
	
	private String verifyTitle(String datakeys) {
		
		Assert.assertEquals(driver.getTitle(), datakeys);
		
		return "Pass";
	}
	
	private String verifyText(String objectkeys, String string) throws Exception {
		
		Assert.assertEquals(getWebElement(objectkeys).getText(), string);
		return "Pass";
	}

	private String selectDropdown(String objectkeys, String datakeys) throws Exception {
		
		Select select = new Select(getWebElement(objectkeys));
		select.selectByValue(datakeys);
		
		return "Pass";
	}
	
	private String waitForTextPresent(String objectkeys, String datakeys) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElement(getWebElement(objectkeys), datakeys));
		
		return "Pass";
	}
	
	public String close() {
		
		if(driver!=null) {
			driver.quit();
		}
		return "Pass";
	}

}
