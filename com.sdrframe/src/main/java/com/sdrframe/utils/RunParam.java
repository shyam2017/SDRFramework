package com.sdrframe.utils;

import com.sdrframe.props.BrowserType;
import com.sdrframe.props.DesktopOSType;

public class RunParam {
	
	
	private static ThreadLocal<BrowserType> browser = new ThreadLocal<BrowserType>();
	private static ThreadLocal<DesktopOSType> osType = new ThreadLocal<DesktopOSType>();
	
	public static synchronized void init(String runParams) {
		if (runParams != null) {
    		// set the browser
			
    			browser.set(BrowserType.getEnumByString(runParams.split("::")[1]));
    		System.out.println(" Browser set as   " +runParams.split("::")[1]);
    //		System.out.println("OSTYPE set as  " +browser.get());
    		BrowserType threadLocalValue =(BrowserType)browser.get();
    		
    		
    		// set the os type    		
    			osType.set(DesktopOSType.getEnumByString(runParams.split("::")[0]));
    					            
    			System.out.println(" OSTYPE set as" +runParams.split("::")[0]);
    		
    	}
		
		
    }



	   public static synchronized void setBrowser(BrowserType browser) {
		   RunParam.browser.set(browser);
	    }
    
	    public static synchronized  BrowserType getBrowser() {
	    	return browser.get(); 
	    }

		   public static synchronized void setOSType(DesktopOSType ostype) {
			   RunParam.osType.set(ostype);
		    }
	    
		    public static synchronized  DesktopOSType getOSType() {
		    	return osType.get(); 
		    }
}
