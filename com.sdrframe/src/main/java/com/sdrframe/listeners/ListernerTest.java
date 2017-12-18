package com.sdrframe.listeners;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.sdrframe.Proxy.ProxyManager;
import com.sdrframe.TestRail.TestRailManager;
import com.sdrframe.common.BaseClass;
import com.sdrframe.driver.CapabilityFactory;
import com.sdrframe.utils.CommandExecutor;
import com.sdrframe.utils.RunParam;
import com.sdrframe.utils.TakeScreenshot;



public class ListernerTest extends BaseClass implements ITestListener  {

	
	public void onTestStart(ITestResult result) {
		
		System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSS" +CapabilityFactory.getRunningJobName());
	//	String str=CommandExecutor.execCommand("ipconfig", null, null);
	//	System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSS" +str);
		// TODO Auto-generated method stub
	/*	try {
			CommandExecutor.exeCmd();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
				try {
					

			CapabilityFactory.initiateDriver();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		CapabilityFactory.getWebDriver().quit();
	}

	
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		TakeScreenshot.captureScreenShot(CapabilityFactory.getWebDriver(), result.getName());
		CapabilityFactory.getWebDriver().quit();
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
