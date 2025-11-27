package com.comcast.crm.opportunities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcleUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.generic.webdriverutility.javaUtility;
import com.comcost.crm.ObjectRepostoryUtility.CreateNewOpportunity;
import com.comcost.crm.ObjectRepostoryUtility.CreatingNewOrganizationPage;
import com.comcost.crm.ObjectRepostoryUtility.HomePage;
import com.comcost.crm.ObjectRepostoryUtility.LoginPage;
import com.comcost.crm.ObjectRepostoryUtility.OpportunitiesPage;
import com.comcost.crm.ObjectRepostoryUtility.OpportunityInformationPage;
import com.comcost.crm.ObjectRepostoryUtility.OrganizationWindowPopUp;
import com.comcost.crm.ObjectRepostoryUtility.OrganizationsPage;

public class CreateOpportunityWithUtilityAndOR {

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
			
			OrganizationsPage op=new OrganizationsPage(driver);
			CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
			OpportunitiesPage opp=new OpportunitiesPage(driver);
			CreateNewOpportunity cno=new CreateNewOpportunity(driver);
			
			// Read test script data from excel file using generic//CreateOrganization
			String celldata = elib.getDataFromExcel("Organisation", 22, 2) + random_number;
			lp.LoginToApp(username, password, celldata);
			hp.NavigateToOrganizationPage();
            op.getCreateNewOrganicationbutton().click();
            cnop.getOrganisationNameTextField().sendKeys(celldata);
			cnop.getSaveButton().click();

			// Read test script data from excel file using generic
			String celldata_Opportunity = elib.getDataFromExcel("Opportunities", 1, 2) + random_number;
			wlib.refreshData(driver);
			
			hp.getOpportunitiesLink().click();
			opp.getCreateOpportunitiesLink().click();
			cno.getOpportunityNameTextField().sendKeys(celldata_Opportunity);
			cno.getPlussignImage().click();
			wlib.switchToNewBrowser(driver, "Accounts&action");
			OrganizationWindowPopUp owp=new OrganizationWindowPopUp(driver);
			owp.getSearchTextField().sendKeys(celldata);
			WebElement dd = owp.getInDropDown();
			wlib.selectByVisibleText(dd, "Organization Name");
			owp.getSearchNowButton().click();
			Thread.sleep(2000);
			WebElement link = driver.findElement(By.xpath("//a[text()='"+celldata+"']"));
			link.click();
			wlib.switchToNewBrowser(driver, "Potentials&action");
			cno.getAssignToradioButton().click();
			WebElement AssignDD = cno.getAssignTorDropdown();
			wlib.selectByVisibleText(AssignDD, "Bill Gates");
			cno.getExpextedCloseDate().clear();
			String futuredate = jlib.FutureDateAfter2Months();
			cno.getExpextedCloseDate().sendKeys(futuredate);
			WebElement salesStagedd = cno.getSalesStageDropdown();
			wlib.selectByVisibleText(salesStagedd, "Qualification");
			cno.getSaveButton().click();
			OpportunityInformationPage oip=new OpportunityInformationPage(driver);
			String headertext = oip.getOpportunityInformationHeader().getText();
			String OpportunitynameFieldText = oip.getOpportunityNameField().getText();
			String RelatedToField = oip.getRelatedToField().getText();
					
					if(headertext.contains(OpportunitynameFieldText))
					{
						System.out.println("Opportunity is Matching====>Test Case passed");
					}
					else{
						System.out.println("Opportunity is Not Matching====>Test Case Failed");
					}
					if(RelatedToField.equals(celldata))
					{
						System.out.println("Organization is Matching====>Test Case passed");
					}
					else{
						System.out.println("Organization is Not Matching====>Test Case Failed");
					}

	}
	
	
}
