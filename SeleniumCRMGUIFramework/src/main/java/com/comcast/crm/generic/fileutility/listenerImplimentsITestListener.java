package com.comcast.crm.generic.fileutility;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class listenerImplimentsITestListener implements ITestListener,ISuiteListener {
	
	@Test
	
	public void createInvoiceTest() {
		
	}

	@Override
	public void onStart(ISuite suite) {
		Reporter.log("Report Configuration,true");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		Reporter.log("Report Backup");
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("Test starts====>" + result.getMethod().getMethodName(),true);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("Test passed====>" + result.getMethod().getMethodName(),true);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		//String ver = result.getName();
		System.out.println("hi");
		
		
	
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	

}
