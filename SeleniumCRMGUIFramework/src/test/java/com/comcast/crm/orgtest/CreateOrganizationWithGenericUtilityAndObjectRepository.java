package com.comcast.crm.orgtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcleUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.generic.webdriverutility.javaUtility;
import com.comcost.crm.ObjectRepostoryUtility.CreatingNewOrganizationPage;
import com.comcost.crm.ObjectRepostoryUtility.HomePage;
import com.comcost.crm.ObjectRepostoryUtility.LoginPage;
import com.comcost.crm.ObjectRepostoryUtility.OrganizationInformationPage;
import com.comcost.crm.ObjectRepostoryUtility.OrganizationsPage;

public class CreateOrganizationWithGenericUtilityAndObjectRepository {

	public static void main(String[] args) throws Throwable {

		FileUtility flib = new FileUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		javaUtility jlib = new javaUtility();
		ExcleUtility elib = new ExcleUtility();

		/* Read common data from Property file */
		String browser = flib.getDataFromPropertyFile("browser");
		String url = flib.getDataFromPropertyFile("url");
		String username = flib.getDataFromPropertyFile("username");
		String password = flib.getDataFromPropertyFile("password");

		WebDriver driver = null;
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		else {
			driver = new ChromeDriver();
		}
		

		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		OrganizationsPage op = new OrganizationsPage(driver);
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);

		// EnterURL
		driver.get(url);

		// Maximize the browser
		wlib.Maximize(driver);

		/* wait */
		wlib.waitForPageToLoad(driver);

		/* generate random number */
		int random_number = jlib.RandomNumber();

		// Read test script data from excel file using generic
		String celldata = elib.getDataFromExcel("Organisation", 22, 2) + random_number;

		// Login to page
		lp.LoginToApp(url,username, password);

		// Navigate to organization page
		hp.NavigateToOrganizationPage();

		// Navigate to Create New Organization Page
		op.getCreateNewOrganicationbutton().click();

		// Enter Organization name
		cnop.getOrganisationNameTextField().sendKeys(celldata);
		cnop.getSaveButton().click();

		//Verification of header text
		String header_text = oip.getOrganisationInformation().getText();

		if (header_text.contains(celldata)) {
			System.out.println(celldata + " Name verified");
		} else {
			System.out.println(celldata + " Name not verified");
		}
	}
}
