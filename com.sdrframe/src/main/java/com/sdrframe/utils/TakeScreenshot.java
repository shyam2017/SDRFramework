package com.sdrframe.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class TakeScreenshot {
	
	/**
	 * Capture Screenshot
	 * 
	 * @param {WebDriver
	 *            driver, String fileName}
	 * 
	 *
	 */

	public static String captureScreenShot(WebDriver driver, String fileName) {
		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
		
			fileName = "C:\\Users\\rauts\\workspace\\com.sdrframe\\test-output\\" + "/screenshots/" + fileName + ".png";
			FileUtils.copyFile(src, new File(fileName));
			System.out.println("Stored the screenshot successfully for : " + fileName);
		} catch (IOException e) {
			System.err.println("Failed to copy screenshot : " + e.getMessage());
			fileName = "Failed to create/copy screenshot";
		}
		Reporter.log("<br><img src='" + fileName + "' height='400' width='400'/><br>");
		return fileName;
	}

}
