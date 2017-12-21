package com.sdrframe.listeners;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.ResultMap;

import com.sdrframe.common.BaseClass;
import com.sdrframe.driver.CapabilityFactory;
import com.sdrframe.props.TestIDs;
import com.sdrframe.utils.CommandExecutor;
import com.sdrframe.utils.JenkinsAPI;
import com.sdrframe.utils.RunParam;
import com.sdrframe.utils.TakeScreenshot;



public class ListernerTest extends BaseClass implements ITestListener  {

	private static ThreadLocal<String> testID= new ThreadLocal<String>();
	 private IResultMap failedCases = new ResultMap();
	
	public void onTestStart(ITestResult result) {
		
		System.out.println("Job Name of Jenkins is   --------  " +JenkinsAPI.getRunningJobName());
		System.out.println("Job ID of Jenkins is    "  + JenkinsAPI.getRunningBuildId());
	
		String id= result.getMethod().getMethodName();
		 testID.set(id.toString().toLowerCase());
		 TestIDs.setTestId(testID.get());
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
		
		
		String TestCaseResult = result.getMethod().getMethodName();
		System.out.println(" Name of PASSED Test Case is  " +TestCaseResult );
		
		if( result.isSuccess()){
			TestIDs.addPassedTest(testID.get());
			result.setStatus(ITestResult.SUCCESS);
			System.out.println(" Test Case is passed  "  );
		}else{
			result.setStatus(ITestResult.FAILURE);
			System.out.println("YOU   AAAAAAAAAAAAAAAAAEWWEEEEEEEEEE  ");
			failedCases.addResult(result, result.getMethod());
			TestIDs.addFailedTest(testID.get());
		}
	
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
