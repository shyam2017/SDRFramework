package com.sdrframe.listeners;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.sdrframe.TestRail.TestRailManager;
import com.sdrframe.common.BaseClass;
import com.sdrframe.props.TestIDs;

public class SuiteListeners extends BaseClass implements ISuiteListener{

	@Override
	public void onFinish(ISuite suite) {
		
		LinkedHashMap<String, String> environmentProps = new LinkedHashMap<String, String>();
    	environmentProps.put("BuildNumber", "25");
    	environmentProps.put("TestGroups", "TEST GROUP");
    	
    	// check for failures to update on a successful retry
    	List<String> failuresToUpdate = new ArrayList<String>();
    	for (String failure : TestIDs.getFailedTestIds()) {
    	    if (TestIDs.getPassedTestIds().contains(failure)) {
    	    	failuresToUpdate.add(failure);
    	    }
    	}
		
	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		
		TestRailManager.startNewSuiteRun("0","0", suite );
	}

}
