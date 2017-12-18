package com.sdrframe.utils;



public class JenkinsAPI {
	
	


    public static String getRunningBuildId() {
			return System.getenv("BUILD_ID");
		}

		public static String getRunningJobName() {
			return System.getenv("JOB_NAME");
		}





}
