package com.comcast.crm.contacttest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcleUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.generic.webdriverutility.javaUtility;
import com.comcost.crm.ObjectRepostoryUtility.ContactInformationPage;
import com.comcost.crm.ObjectRepostoryUtility.ContactsPage;
import com.comcost.crm.ObjectRepostoryUtility.CreatingNewContactPage;
import com.comcost.crm.ObjectRepostoryUtility.HomePage;
import com.comcost.crm.ObjectRepostoryUtility.LoginPage;

public class CreateContactWithGeneralUtilityAndOBjectrepository {
	public static void main(String[] args) throws Throwable {
	
	FileUtility flib = new FileUtility();
	WebDriverUtility wlib = new WebDriverUtility();
	javaUtility jlib = new javaUtility();
	ExcleUtility elib = new ExcleUtility();
	
	/* generate random number */
	int random_number = jlib.RandomNumber();

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
	
	
	
	
	// EnterURL
		driver.get(url);
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		ContactsPage cp=new ContactsPage(driver);
		ContactInformationPage cip=new ContactInformationPage(driver);
		
		
		// Login to page
		lp.LoginToApp(url,username, password);
		
		// Read test script data from excel file using generic
		String celldata = elib.getDataFromExcel("Contact", 1, 3) + random_number;
		
		// Maximize the browser
		wlib.Maximize(driver);

		/* wait */
		wlib.waitForPageToLoad(driver);

		CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
	
	//Click on Contact link
	hp.getContactsLink().click();
	
	//Click on Create new contact button
	cp.getCreateContactButton().click();
	
	//enter the data
	cncp.getLastNameTextField().sendKeys(celldata);
	cncp.getSaveButton().click();
	
	//
	
	String Contact_Header_Text = cip.getContactHeaderText().getText();
	if(Contact_Header_Text.contains(celldata))
	{
		System.out.println(celldata + "text Verified");
	}
	else
	{
		System.out.println(celldata + " text not Verified");
	}

	}
}
