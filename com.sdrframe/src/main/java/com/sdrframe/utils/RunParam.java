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
    		System.out.println(" ValAAAAAAAAAAAAAAAAAAA" +runParams.split("::")[1]);
    		System.out.println(" ValAAAAAAAAAAAAAAAAAAA" +browser.get());
    		BrowserType threadLocalValue =(BrowserType)browser.get();
    		System.out.println(" OOOOOOOO" + threadLocalValue);
    		
    		// set the os type    		
    			osType.set(DesktopOSType.getEnumByString(runParams.split("::")[0]));
    					            
    			System.out.println(" BBBBBBBBBBBBBBBBBBBBB" +runParams.split("::")[0]);
    		
    	}
		
		
    }



	   public static synchronized void setBrowser(BrowserType browser) {
		   RunParam.browser.set(browser);
	    }
    
	    public static synchronized  BrowserType getBrowser() {
	    	return browser.get(); 
	    }


}
