package com.sdrframe.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import com.sdrframe.props.BrowserType;
import com.sdrframe.props.DesktopOSType;
import com.sdrframe.utils.RunParam;



public class BaseClass {
	protected String runParams;
	

	WebDriver driver;
	static String nodeUrl;
	
	


	public void setRunParams(String runParams) {
		this.runParams = runParams;
		
	}
	
	
   @BeforeMethod(alwaysRun = true)
	    public void startSelenium() {
	   System.out.println("value is Start Selenium   " );
	   RunParam.init(runParams);
	 
		   
	   }

	 
	   
		
}
