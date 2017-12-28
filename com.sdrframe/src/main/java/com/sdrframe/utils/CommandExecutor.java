package com.sdrframe.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang.ArrayUtils;

public class CommandExecutor {
	
	private static ThreadLocal<String> command = new ThreadLocal<String>();
	private static ThreadLocal<String> output = new ThreadLocal<String>();
	private static ThreadLocal<Integer> exitCode = new ThreadLocal<Integer>();
	private static String path;
	private static final String USER_DIR = System.getProperty("user.dir");
public static void exeCmd(String Path,String commandexe)  {
	
	if(Path==null){
		path = USER_DIR + File.separator +"src";
  }
  else{
 
	  path = Path;
  }
	
	CommandExecutor.command.set(commandexe.toString());   
	//  ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd \"C:\\Workspace\\Seleniumnew\" && java -Dwebdriver.gecko.driver=C:\\Workspace\\Seleniumnew\\geckodriver.exe -Dwebdriver.ie.driver=C:\\Workspace\\Seleniumnew\\IEDriverServer.exe -Dwebdriver.chrome.driver=C:\\Workspace\\Seleniumnew\\chromedriver.exe -jar selenium-server-standalone-3.5.3.jar -port 4443");
	ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", path +"&&"+ CommandExecutor.command.get() );
			
    
	        builder.redirectErrorStream(true);
	        try {
				Process p = builder.start();
				BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
				String line;
				while (true) {
				    line = r.readLine();
				    if (line == null) { break; }
				    System.out.println(line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

}



public static String execCommand(String command, String machineIPAddress, Integer timeoutInSec) {
//	Integer timeout = setTimeout(timeoutInSec);
	Integer timeout = 2000;

//	String user = getAdminUserSSHString(machineIPAddress);
	CommandExecutor.command.set(command);
	CommandExecutor.output.set(command);
	Process process = null;
	
	String errorMsg = "The command '" + CommandExecutor.command.get() + "' failed to execute.";
	try {
		process = Runtime.getRuntime().exec(CommandExecutor.command.get());
		
		process.waitFor(timeout, TimeUnit.SECONDS);
	   
		exitCode.set(process.exitValue());
		  /* 
		
		CommandExecutor.output.set(Stream.of(process.getErrorStream(), process.getInputStream()).parallel().map((InputStream isForOutput) -> {
	        StringBuilder output = new StringBuilder();
	        try (BufferedReader br = new BufferedReader(new InputStreamReader(isForOutput))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                output.append(line);
	                output.append("\n");
	            }
	            br.close();
	        } catch (IOException e) {
	        	System.out.println("AAAAAAAAAAAA" +errorMsg);
	        	System.out.println(e.getMessage());
	        }
	        return output;
	    }).collect(Collectors.joining()));
	    */
	} catch (Exception e) {
		System.out.println("BBBBBBBBBBBBBBBBBB"+errorMsg);
		System.out.println(e.getMessage());
	} finally {
		process.destroyForcibly();
	}

	
	//ec2Hop.set(true);
    return CommandExecutor.output.get();
}











}
