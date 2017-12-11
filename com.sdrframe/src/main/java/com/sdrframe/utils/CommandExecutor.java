package com.sdrframe.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandExecutor {
	
public static void exeCmd() throws IOException{
	        ProcessBuilder builder = new ProcessBuilder(
	            "cmd.exe", "/c", "cd \"C:\\Workspace\\Seleniumnew\" && java -Dwebdriver.gecko.driver=C:\\Workspace\\Seleniumnew\\geckodriver.exe -Dwebdriver.ie.driver=C:\\Workspace\\Seleniumnew\\IEDriverServer.exe -Dwebdriver.chrome.driver=C:\\Workspace\\Seleniumnew\\chromedriver.exe -jar selenium-server-standalone-3.5.3.jar -port 4443");
	        builder.redirectErrorStream(true);
	        Process p = builder.start();
	        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
	        String line;
	        while (true) {
	            line = r.readLine();
	            if (line == null) { break; }
	            System.out.println(line);
	        }

}}
