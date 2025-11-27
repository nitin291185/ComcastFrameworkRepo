package com.comcast.crm.listenerutility;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListImpClass implements ITestListener, ISuiteListener {
	//public static WebDriver driver;
	public static ExtentTest test;
	public static ExtentReports reports;
	public static ExtentSparkReporter spark;
	
	public File dstn;
	public String time = new Date().toString().replace(" ", "_").replace(":", "_");

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onStart(suite);
		Reporter.log("Report Configuration");
		// spark report configuration
		spark = new ExtentSparkReporter("./Advance Report/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Report");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		reports = new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("Operating System", "Windows-11");
		threadLocalClass.setTest(test);
		dstn = new File("./ScreenShots/" + test + time + ".png");
		//ExtentSparkReporter spark = new ExtentSparkReporter(dstn);

	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onFinish(suite);
		Reporter.log("Report backUP");
		reports.flush();
	
		//test.log(Status.INFO, "eport saved");
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test=reports.createTest(result.getMethod().getMethodName());
		ITestListener.super.onTestStart(result);
		Reporter.log("=====" + result.getMethod().getMethodName() + "=======started==========");
		test = reports.createTest(result.getMethod().getMethodName());
		
		Date D = new Date();
		String date = D.toString().replace(":", "_").replace(" ", "_");
		String test_name = result.getMethod().getMethodName();
		threadLocalClass.setTest(test);
		TakesScreenshot ts = (TakesScreenshot) threadLocalClass.getDriver();
		
		String src = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(src, test_name +" "+ date);
		test.log(Status.INFO, result.getMethod().getMethodName() + " Started ");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		threadLocalClass.setTest(test);
		//test.log(Status.PASS, "=====>" + result.getMethod().getMethodName() + "=======test passed==========");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		ExtentTest test=reports.createTest(result.getMethod().getMethodName());
		Date D = new Date();
		String date = D.toString().replace(":", "_").replace(" ", "_");
		String test_name = result.getMethod().getMethodName();
		threadLocalClass.setTest(test);
		TakesScreenshot ts = (TakesScreenshot) threadLocalClass.getDriver();
		
		String src = ts.getScreenshotAs(OutputType.BASE64);
		
		test.addScreenCaptureFromBase64String(src, test_name + date);
		test.log(Status.FAIL, "=====>" + result.getMethod().getMethodName() + "=======test failed==========");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

	int count = 0;
	int limitcount = 5;

	public Boolean Retry(ITestResult result) {

		if (count < limitcount) {
			count++;
			return true;
		} else {
			return false;
		}
	}
}
