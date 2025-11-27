package com.comcast.crm.orgtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class deleteOrganizationWithUtilityAndOR {

	public static void main(String[] args) throws Throwable {
		WebDriverUtility wlib=new WebDriverUtility();
		javaUtility jlib=new javaUtility();
		FileUtility flib=new FileUtility();
		ExcleUtility elib=new ExcleUtility();
		
		int random_number = jlib.RandomNumber();

		// Read common data from Property file
		
		String browser = flib.getDataFromPropertyFile("browser");
		String url = flib.getDataFromPropertyFile("url");
		String username = flib.getDataFromPropertyFile("username");
		String password = flib.getDataFromPropertyFile("password");
		
		
	WebDriver driver=null;
	if(browser.equalsIgnoreCase("chrome"))
	{
	driver=new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("firefox"))
	{
	driver=new FirefoxDriver();
	}
	else if(browser.equalsIgnoreCase("edge"))
	{
	driver=new EdgeDriver();
	}

	else
	{
	driver=new ChromeDriver();	
	}

	//Maximize the browser
	driver.manage().window().maximize();

	//EnterURL
	driver.get(url);
	
	//wait
	wlib.waitForPageToLoad(driver);
	
	HomePage hp= new HomePage(driver);
	OrganizationsPage op = new OrganizationsPage(driver);
	CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
	OrganizationInformationPage oip = new OrganizationInformationPage(driver);
	LoginPage lp=new LoginPage(driver);

	// Read test script data from excel file using generic
			String celldata = elib.getDataFromExcel("Organisation", 22, 2) + random_number;

			// Login to page
			lp.LoginToApp(username, password, celldata);

			// Navigate to organization page
			hp.NavigateToOrganizationPage();

			// Navigate to Create New Organization Page
			op.getCreateNewOrganicationbutton().click();

			// Enter Organization name
			cnop.getOrganisationNameTextField().sendKeys(celldata);
			cnop.getSaveButton().click();
			wlib.refreshData(driver);
			
			
			// Navigate to organization page again
			hp.NavigateToOrganizationPage();
			
			op.getSearchTextField().sendKeys(celldata);
			wlib.selectByIndex(op.getDropdown(), 1);
			op.getSubmitBtn().click();
			
			Thread.sleep(2000);
			
			op.getCheckbox().click();
			op.getDeleteLink().click();
			
			wlib.switchToAlertAndAccept(driver);
			
			// Navigate to organization page again
			hp.NavigateToOrganizationPage();
			op.getSearchTextField().sendKeys(celldata);
			wlib.selectByIndex(op.getDropdown(), 1);
			op.getSubmitBtn().click();
			Thread.sleep(4000);
			WebElement ele = op.getNoOrganizationFoundSign();
			if(ele.isDisplayed())
			{
				System.out.println("Selected Organization Deleted=====>Test case passed");
			}
	
			else
			{
				System.out.println("Selected Organization not Deleted=====>Test case failed");
			}
	
	
	
	

	}

}
