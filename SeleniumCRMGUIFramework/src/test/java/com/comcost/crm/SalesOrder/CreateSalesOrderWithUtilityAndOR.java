package com.comcost.crm.SalesOrder;

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
import com.comcost.crm.ObjectRepostoryUtility.CreatingNewSalesOrder;
import com.comcost.crm.ObjectRepostoryUtility.HomePage;
import com.comcost.crm.ObjectRepostoryUtility.LoginPage;
import com.comcost.crm.ObjectRepostoryUtility.OrganizationInformationPage;
import com.comcost.crm.ObjectRepostoryUtility.OrganizationWindowPopUp;
import com.comcost.crm.ObjectRepostoryUtility.OrganizationsPage;
import com.comcost.crm.ObjectRepostoryUtility.SalesOrderPage;

public class CreateSalesOrderWithUtilityAndOR {

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
		   // Maximize the browser
			wlib.Maximize(driver);

		     /* wait */
		    wlib.waitForPageToLoad(driver);
			LoginPage lp = new LoginPage(driver);
			HomePage hp = new HomePage(driver);
			OrganizationsPage op =new OrganizationsPage(driver);
			CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
			OrganizationInformationPage oip=new OrganizationInformationPage(driver);
			
			lp.LoginToApp(url, username, password);
			
			// Create Organization
			String celldata = elib.getDataFromExcel("Organisation", 22, 2) + random_number;
			hp.NavigateToOrganizationPage();
			op.getCreateNewOrganicationbutton().click();
			cnop.getOrganisationNameTextField().sendKeys(celldata);
			cnop.getSaveButton().click();
			String header_text = oip.getOrganisationInformation().getText();
			
		
			WebElement more_link = hp.getMoreLink();
			wlib.mouseMoveToElement(driver, more_link);
			hp.getSaleOrder().click();
			SalesOrderPage sop=new SalesOrderPage(driver);
			sop.getCreateNewSalesOrderButton().click();
			CreatingNewSalesOrder cnso=new CreatingNewSalesOrder(driver);
			String sale_order = elib.getDataFromExcel("SalesOrder",1,2)+random_number;
			//String Shipping_address = elib.getDataFromExcel(sale_order, 1, 3);
			String Shipping_address="Qspider@_"+random_number;
			cnso.getSubjectTextField().sendKeys(sale_order);
			WebElement status_dd = cnso.getStatusDropdown();
			wlib.selectByVisibleText(status_dd, "Approved");
			WebElement assignto_dd = cnso.getAssignToDropdown();
			wlib.selectByVisibleText(assignto_dd, "Bill Gates");
			cnso.getBillingAdddressText().sendKeys(Shipping_address);
			cnso.getCopyBillingAdddressRadioButton().click();
			cnso.getOrganizationNamePlusSign().click();
			OrganizationWindowPopUp owp=new OrganizationWindowPopUp(driver);
			wlib.switchToNewBrowser(driver, "Accounts&action");
			owp.getSearchNowButton().sendKeys(celldata);
			WebElement dd = owp.getInDropDown();
			wlib.selectByVisibleText(dd, "Organization Name");
			owp.getSearchNowButton().click();
			
//			wlib.switchToNewBrowser(driver, "SalesOrder&action");
//			System.out.println("hi");
	
			
			

	}

}
