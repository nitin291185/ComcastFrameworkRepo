
package com.comcast.crm.baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.fileutility.ExcleUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.generic.webdriverutility.javaUtility;
import com.comcast.crm.listenerutility.threadLocalClass;
import com.comcost.crm.ObjectRepostoryUtility.HomePage;
import com.comcost.crm.ObjectRepostoryUtility.LoginPage;

public class BaseClass {
	public FileUtility flib = new FileUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public javaUtility jlib = new javaUtility();
	public ExcleUtility elib = new ExcleUtility();
	public static WebDriver driver = null;

	@BeforeSuite(alwaysRun = true)
	public void BeforeSuite() {
		

	}

	@AfterSuite(alwaysRun = true)
	public void AfterSuite() {
	

	}

	@Parameters("BROWSER")

	@BeforeClass(alwaysRun = true)
	public void ConfigureBrowser(@Optional("chrome") String browser) throws Throwable {
		
	String BROWSER= browser;
		
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		else {
			driver = new ChromeDriver();
		}

		threadLocalClass.setDriver(driver);

		wlib.Maximize(driver);

	}

	@AfterClass(alwaysRun = true)
	public void AfterClass() {
		
		driver.quit();

	}

	@BeforeMethod(alwaysRun = true)
	public void BeforeMethod() throws Throwable {
		
		String url1=flib.getDataFromPropertyFile("url1");
		String url = flib.getDataFromPropertyFile("url");
		String username = flib.getDataFromPropertyFile("username");
		String password = flib.getDataFromPropertyFile("password");
if(url.equals("http://49.249.28.218:88880"))
{
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(url, username, password);
}
else {
	LoginPage lp = new LoginPage(driver);
	lp.LoginToApp(url1, username, password);
	
}
		/* wait */
		wlib.waitForPageToLoad(driver);
	}

	@AfterMethod(alwaysRun = true)
	public void AfterMethod() {

		HomePage hp = new HomePage(driver);
		hp.logout();

	}

}
