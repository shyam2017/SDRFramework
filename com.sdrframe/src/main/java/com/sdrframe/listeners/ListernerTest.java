package com.sdrframe.listeners;

import java.net.MalformedURLException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.sdrframe.common.BaseClass;
import com.sdrframe.driver.CapabilityFactory;
import com.sdrframe.utils.RunParam;
import com.sdrframe.utils.TakeScreenshot;



public class ListernerTest extends BaseClass implements ITestListener  {

	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
				try {
					System.out.println("IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII" + RunParam.getBrowser().value());

			CapabilityFactory.initiateDriver();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		TakeScreenshot.captureScreenShot(CapabilityFactory.getWebDriver(), result.getName());
	}


	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub
		/*
		try {
			CapabilityFactory.initiateDriver();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}


	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
}
