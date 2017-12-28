package com.sdrframe.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadFiles {
	
	private static final String USER_DIR = System.getProperty("user.dir");
	private static String savedFile;
	public static void downloadDependency(String fileName, String downloadFrom, String saveFilePath) throws Exception {
		
		System.out.println("Downloading dependency '" + fileName + "' to the user dir.");
		String FileURL=downloadFrom;
		String fileUrl = FileURL + fileName ;
		URL url = new URL(fileUrl);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();
        System.out.println("Response Code is  '" + responseCode);
        System.out.println("Dependency saved to '" + savedFile + "'.");
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // opens input stream from the HTTP connection
            InputStream inputStream = httpConn.getInputStream();
           
            if(saveFilePath==null){
            	  savedFile = USER_DIR + File.separator +"/src" + File.separator+fileName;
            }
            else{
           
             savedFile = saveFilePath +File.separator+ fileName;
            }
            FileOutputStream outputStream = new FileOutputStream(savedFile);
            int bytesRead = -1;
            byte[] buffer = new byte[4096];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
 
            outputStream.close();
            inputStream.close();
 
            System.out.println("Dependency saved to '" + savedFile + "'.");
        } else {
            System.out.println("No dependency found at url '" + fileUrl + "'. Response code: " + responseCode);
        }
        httpConn.disconnect();
	}



}
