package SampleTest;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.baseclass.BaseClass;

public class sampleReportTest extends BaseClass {
	@Test
	public void createContactTest(String test_name) {
		//spark report configuration
		ExtentSparkReporter spark=new ExtentSparkReporter("./Advance report/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Result");
		spark.config().setReportName("CRM reports");
		spark.config().setTheme(Theme.STANDARD);
		
		//add information and create test
		ExtentReports reports=new ExtentReports();   
		reports.attachReporter(spark);
		reports.setSystemInfo("Browser", "chrome");
		reports.setSystemInfo("OS", "Windows-11");
		ExtentTest test = reports.createTest("create Contact Test ");
		test.log(Status.INFO, "Login to app");
		test.log(Status.INFO, "Navigate to contact page");
		test.log(Status.INFO, "Create Contact");
		Date D=new Date();
		String date = D.toString().replace(":", "_").replace(" ", "_");
		TakesScreenshot ts=(TakesScreenshot) driver;
		String src = ts.getScreenshotAs(OutputType.BASE64);
		File dstn=new File("./ScreenShots/"+ test_name + date + ".png");
		if("HDFC".equals("HDFC"))
		{
			
		
		test.log(Status.PASS, "Contact Created");
		
	}
		else
		{
			test.log(Status.FAIL, "Contact not Created");
			test.addScreenCaptureFromBase64String("./ScreenShots/", null);
		}
		
		reports.flush();
		
}
}