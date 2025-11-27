package SampleTest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class createContactReportTest {

	@Test
	public void report() {
		
		//spark report configuration 
		ExtentSparkReporter spark=new ExtentSparkReporter("./Advance Report/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Report");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//Add environmental Information and create test
		
		ExtentReports reports =new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("Operating System", "Windows-11");
		ExtentTest test = reports.createTest("report");
		test.log(Status.INFO, "Login to app");
		test.log(Status.INFO, "Navigate to contact page");
		test.log(Status.INFO, "Create Contact");
		
	if(("HDFC").equals("HDFC")) {
		test.log(Status.PASS, "Contact is created");
	}
	else
	{
		test.log(Status.FAIL, "Contact is not created");
	}
	
	reports.flush();
	}
}
