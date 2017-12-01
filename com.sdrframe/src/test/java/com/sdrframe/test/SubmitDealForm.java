package com.sdrframe.test;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.sdrframe.common.BaseClass;
import com.sdrframe.dataprovider.DataProviderMang;
import com.sdrframe.driver.CapabilityFactory;
import com.sdrframe.utils.TakeScreenshot;

import junit.framework.Assert;
import ru.yandex.qatools.allure.annotations.Stories;



public class SubmitDealForm  extends BaseClass{

	static String nodeUrl;
	String dealnumber;

	HashMap<String, String> environdata;
	String browser;
	String operatingSys;

	
	@Factory(dataProvider="mydata",dataProviderClass = DataProviderMang.class)
	
//	public TestNGTest(String windowsname,String browsername )throws Exception{
	public SubmitDealForm(String runParams )throws Exception{
		super.setRunParams(runParams);
		
		
//		environdata= new HashMap<String, String>();
//		environdata.put(operatingSys,windowsname);
//		environdata.put(browser, browsername);
		
	
	}
	


	
	@BeforeTest(alwaysRun=true)
	public void beforeTest(){
		  	
	 	System.out.println("this is beforeTest " );
		
	}
		
	
	@Test(priority =1)
	
	public void FirstTest() throws InterruptedException, AWTException{
		Thread.sleep(5000);
		CapabilityFactory.getWebDriver().findElement(By.xpath(".//*[@id='zz13_RootAspMenu']/li[1]/a/span/span")).click();
		Thread.sleep(5000);
		CapabilityFactory.getWebDriver().findElement(By.xpath(".//*[@id='grid']/table/tbody/tr[1]/td[2]/span")).click();
		Thread.sleep(5000);
		CapabilityFactory.getWebDriver().findElement(By.xpath(".//*[@id='StartNewInstance']")).click();
		Thread.sleep(5000);
		TakeScreenshot.captureScreenShot(CapabilityFactory.getWebDriver(), "FirstScreen");
		String handle= CapabilityFactory.getWebDriver().getWindowHandle();
		Set handles = CapabilityFactory.getWebDriver().getWindowHandles();
		for (String handle1 : CapabilityFactory.getWebDriver().getWindowHandles()) {
			 
           	CapabilityFactory.getWebDriver().switchTo().window(handle1);

        	}
	
		String gettitle = CapabilityFactory.getWebDriver().getTitle();
		dealnumber= gettitle.substring(9, 14);
		TakeScreenshot.captureScreenShot(CapabilityFactory.getWebDriver(),"SecondScreen");
		System.out.println(" Deal Number is TestNGTest of menotod FirstTest   " +dealnumber);
		
	      CapabilityFactory.getWebDriver().close();
	      CapabilityFactory.getWebDriver().switchTo().window(handle);
	     Assert.assertEquals(dealnumber, dealnumber);
	      System.out.println(" First Test Browser will be closed  " );
		
    }
	

	  
	@Test(priority =2)
	@Stories("AAAAAAAAAAAAAAAAAAAAAA")
	public void SecondTest() throws InterruptedException{
	CapabilityFactory.getWebDriver().findElement(By.xpath(".//*[@id='zz13_RootAspMenu']/li[2]/a/span/span[1]")).click();
		
	Thread.sleep(5000);
	CapabilityFactory.getWebDriver().findElement(By.xpath(".//*[@id='zz13_RootAspMenu']/li[1]/a/span/span")).click();
	Thread.sleep(5000);
	CapabilityFactory.getWebDriver().findElement(By.xpath(".//*[@id='grid']/table/tbody/tr[1]/td[2]/span")).click();
	Thread.sleep(5000);
	CapabilityFactory.getWebDriver().findElement(By.xpath(".//*[@id='StartNewInstance']")).click();
	Thread.sleep(5000);
	
	String handle= CapabilityFactory.getWebDriver().getWindowHandle();
	Set handles = CapabilityFactory.getWebDriver().getWindowHandles();
	for (String handle1 : CapabilityFactory.getWebDriver().getWindowHandles()) {
		 
       	CapabilityFactory.getWebDriver().switchTo().window(handle1);

    	}

	String gettitle = CapabilityFactory.getWebDriver().getTitle();
	dealnumber= gettitle.substring(9, 14);
	System.out.println(" Deal Number is TestNGTest  of methid SecondTest  " +dealnumber);
	  Assert.assertEquals(dealnumber, dealnumber);
      CapabilityFactory.getWebDriver().close();
      CapabilityFactory.getWebDriver().switchTo().window(handle);
      System.out.println(" Second  Test Browser will be closed  " );
		
}
	


@AfterMethod
public void closebrosers(){
	System.out.println("Closing the Browser  TestNGTest ");
	CapabilityFactory.getWebDriver().close();
	
}
}
