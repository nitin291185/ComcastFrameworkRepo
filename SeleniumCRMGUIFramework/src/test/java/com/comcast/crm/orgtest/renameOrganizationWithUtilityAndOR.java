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
import com.comcost.crm.ObjectRepostoryUtility.EditOrganizationInformation;
import com.comcost.crm.ObjectRepostoryUtility.HomePage;
import com.comcost.crm.ObjectRepostoryUtility.LoginPage;
import com.comcost.crm.ObjectRepostoryUtility.OrganizationInformationPage;
import com.comcost.crm.ObjectRepostoryUtility.OrganizationsPage;

public class renameOrganizationWithUtilityAndOR {

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
	
	LoginPage lp=new LoginPage(driver);
	EditOrganizationInformation eoi=new EditOrganizationInformation(driver);

	// Read test script data from excel file using generic
			String celldata1 = elib.getDataFromExcel("Organisation", 22, 2) + random_number;
			String celldata2 = elib.getDataFromExcel("Organisation", 22, 5) + random_number;
			// Login to page
			lp.LoginToApp(username, password, celldata2);

			// Navigate to organization page
			hp.NavigateToOrganizationPage();

			// Navigate to Create New Organization Page
			op.getCreateNewOrganicationbutton().click();

			// Enter Organization name
			cnop.getOrganisationNameTextField().sendKeys(celldata1);
			cnop.getSaveButton().click();
			wlib.refreshData(driver);
			
			
			// Navigate to organization page again
			hp.NavigateToOrganizationPage();
			
			op.getSearchTextField().sendKeys(celldata1);
			wlib.selectByIndex(op.getDropdown(), 1);
			op.getSubmitBtn().click();
			
			Thread.sleep(2000);
			
			op.getCheckbox().click();
			op.getEditLink().click();
			eoi.getTextbox().clear();
			eoi.getTextbox().sendKeys(celldata2);
			eoi.getSaveButton().click();
			wlib.refreshData(driver);
			
			
			// Navigate to organization page again
			hp.NavigateToOrganizationPage();
			op.getSearchTextField().sendKeys(celldata2);
			wlib.selectByIndex(op.getDropdown(), 1);
			op.getSubmitBtn().click();
			Thread.sleep(4000);
			
			String actual_text = op.getOrganizationNameField().getText();
			if(actual_text.equals(celldata2))
			{
				System.out.println("Selected Organization Edited=====>Test case passed");
			}
			
			else
			{
				System.out.println("Selected Organization not Edited=====>Test case failed");
			}
	
			if(actual_text.equals(celldata1))
			{
				System.out.println("Selected Organization not Edited=====>Test case failed");
			}
	
			else
			{
				System.out.println("Selected Organization Edited=====>Test case passed");
			}
	}

}
