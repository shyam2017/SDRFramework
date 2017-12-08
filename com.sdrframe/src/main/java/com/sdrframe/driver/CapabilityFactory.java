package com.sdrframe.driver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.sdrframe.utils.RunParam;

public class CapabilityFactory {
	
	public static WebDriver driver;
	 
	  private static ThreadLocal<RemoteWebDriver> webDriver = new ThreadLocal<RemoteWebDriver>();
	 
	 static String nodeUrl ="http://166.77.212.84:5555/wd/hub" ;
	    public static void initiateDriver() throws MalformedURLException, InterruptedException {
	    	
	    	
	    	DesiredCapabilities capabilities = new DesiredCapabilities();

	        // set the browser
	        capabilities.setBrowserName(RunParam.getBrowser().value());
	        System.out.println("OSTYPE  OSTYPE OSTYPE OSTYPEOSTYPE" +RunParam.getOSType().value());
	        // set the os/platform
	        capabilities.setCapability("platform", RunParam.getOSType().value());
	        
	       		
			webDriver.set(new RemoteWebDriver(new URL(nodeUrl), capabilities));
			getWebDriver().get("https://flowstg.viacom.com");
			 System.out.println("BROWSER IS OPEN  ");
					setWebDriver(webDriver.get());
	    }
	    






	    public static RemoteWebDriver getWebDriver() {
	        return webDriver.get();
	    }



	    public static synchronized void setWebDriver(RemoteWebDriver driver) {
	        webDriver.set(driver);
	    }

}
