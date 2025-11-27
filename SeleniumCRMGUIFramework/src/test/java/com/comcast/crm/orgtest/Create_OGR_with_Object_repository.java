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

public class Create_OGR_with_Object_repository {
	public static void main(String[] args) throws Throwable {
		
	
//call all utilities
WebDriverUtility wlib=new WebDriverUtility();
	javaUtility jlib=new javaUtility();
	FileUtility flib=new FileUtility();
	ExcleUtility elib=new ExcleUtility();
	
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
	
	driver.get(url);
	//Login to application
	LoginPage lp=new LoginPage(driver);
	lp.LoginToApp(username, password, password);
	
	
	//Navigate  to Organizations
	
	HomePage hp=new HomePage(driver);
	hp.getOrganizationLink().click();
	
	//Create new Organization
	OrganizationsPage op=new OrganizationsPage(driver);
	op.getCreateNewOrganicationbutton().click();
	
	
	//EnterData and save
	CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
	cnop.EnterOrgAndSave();
	Thread.sleep(2000);
	//verify the organization name
	OrganizationInformationPage oip= new OrganizationInformationPage(driver);

	String actualOrgName = oip.getOrganisationInformation().getText();
	if(actualOrgName.contains("Qspider"))
	{
		System.out.println("passed");
	}
	else
	{
		System.out.println("failed");
	}
	
	
	
	
	
	}	
}
