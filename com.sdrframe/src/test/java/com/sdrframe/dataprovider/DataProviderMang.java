package com.sdrframe.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviderMang {
	
	@DataProvider(name="mydata")
	static public Object[][] latestBrowsersDataProvider(){
	return new Object[][]{
				

		
		new Object[] {"WINDOWS::chrome"},
	//	new Object[] {"windows_nt::firefox"},
//	new Object[] {"WINDOWS::internet explorer"},
		//new Object[]{"WINDOWS","firefox"},
		//			new Object[]{"WINDOWS","chrome"}
	};
}

}
