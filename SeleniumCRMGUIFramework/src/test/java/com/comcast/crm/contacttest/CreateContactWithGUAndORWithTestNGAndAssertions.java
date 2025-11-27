package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.listenerutility.threadLocalClass;
import com.comcost.crm.ObjectRepostoryUtility.ContactInformationPage;
import com.comcost.crm.ObjectRepostoryUtility.ContactsPage;
import com.comcost.crm.ObjectRepostoryUtility.CreatingNewContactPage;
import com.comcost.crm.ObjectRepostoryUtility.CreatingNewOrganizationPage;
import com.comcost.crm.ObjectRepostoryUtility.HomePage;
import com.comcost.crm.ObjectRepostoryUtility.OrganizationWindowPopUp;
import com.comcost.crm.ObjectRepostoryUtility.OrganizationsPage;

@Listeners(com.comcast.crm.listenerutility.ListImpClass.class)
public class CreateContactWithGUAndORWithTestNGAndAssertions extends BaseClass {

	@Test(groups = "Smoke_Testing")
	public void createContactTest() throws Throwable {

		/* generate random number */
		int random_number = jlib.RandomNumber();

		// Read test script data from excel file using generic
		String celldata = elib.getDataFromExcel("Contact", 1, 3) + random_number;

		// Click on Contact link
		HomePage hp = new HomePage(driver);
		threadLocalClass.getTest().log(Status.INFO, "Navigate to contact page");
		hp.getContactsLink().click();

		// Click on Create new contact button
		// ListImpClass.test.log(Status.INFO, "Navigate to create new contact page");
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactButton().click();

		ContactInformationPage cip = new ContactInformationPage(driver);

		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		// enter the data
		cncp.getLastNameTextField().sendKeys(celldata);
		cncp.getSaveButton().click();

		String Contact_Header_Text = cip.getContactHeaderText().getText().trim();
		String contact_field = cip.getContactText().getText().trim();
		boolean status = Contact_Header_Text.contains(contact_field);
		
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(status);
		sa.assertAll();

	}

	@Test(groups = "Regression_Testing")

	public void createContactWithSupportdateTest() throws Throwable {

		/* generate random number */
		int random_number = jlib.RandomNumber();

		String today_date = jlib.DateYYYYMMDD();
		String future_date = jlib.FutureDateAfter2Months();

		HomePage hp = new HomePage(driver);
		ContactsPage cp = new ContactsPage(driver);
		ContactInformationPage cip = new ContactInformationPage(driver);

		// Read test script data from excel file using generic
		String celldata = elib.getDataFromExcel("Contact", 1, 3) + random_number;

		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);

		// Click on Contact link
		hp.getContactsLink().click();

		// Click on Create new contact button
		cp.getCreateContactButton().click();

		// enter the data
		cncp.getLastNameTextField().sendKeys(celldata);
		cncp.getStartdatefield().clear();
		cncp.getStartdatefield().sendKeys(today_date);
		cncp.getEnddatefield().clear();
		cncp.getEnddatefield().sendKeys(future_date);
		cncp.getSaveButton().click();

		String Contact_Header_Text = cip.getContactHeaderText().getText().trim();
		String contact_field = cip.getContactText().getText().trim();
		boolean status = Contact_Header_Text.contains(contact_field);
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(status);;
		
		sa.assertAll();

	}

	@Test(groups = "Regression_Testing")
	public void createContactWithOrganization_Test() throws Throwable {

		/* generate random number */
		int random_number = jlib.RandomNumber();

		HomePage hp = new HomePage(driver);
		ContactsPage cp = new ContactsPage(driver);
		ContactInformationPage cip = new ContactInformationPage(driver);

		OrganizationsPage op = new OrganizationsPage(driver);
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);

		// read organization name from excel
		String org_name = elib.getDataFromExcel("Organisation", 22, 2) + random_number;

		// Read test script data from excel file using generic
		String celldata = elib.getDataFromExcel("Contact", 1, 3) + random_number;

		// Navigate to organization page
		hp.NavigateToOrganizationPage();

		// Navigate to Create New Organization Page
		op.getCreateNewOrganicationbutton().click();

		// Enter Organization name
		cnop.getOrganisationNameTextField().sendKeys(org_name);
		cnop.getSaveButton().click();

		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);

		wlib.refreshData(driver);

		// Click on Contact link
		hp.getContactsLink().click();

		// Click on Create new contact button
		cp.getCreateContactButton().click();

		// enter the data
		cncp.getLastNameTextField().sendKeys(celldata);
		cncp.getOrganizationNamePlusSign().click();
		Thread.sleep(3000);
		// switch to new window

		wlib.switchToNewBrowser(driver, "Accounts&action");
		OrganizationWindowPopUp owp = new OrganizationWindowPopUp(driver);
		Thread.sleep(3000);
		owp.getSearchTextField().sendKeys(org_name);
		Thread.sleep(2000);
		wlib.selectByVisibleText(owp.getInDropDown(), "Organization Name");
		owp.getSearchNowButton().click();

		WebElement link = driver.findElement(By.xpath("//a[text()='" + org_name + "']"));
		link.click();
		wlib.switchToNewBrowser(driver, "Contacts&action");
		cncp.getSaveButton().click();
		Thread.sleep(2000);
		String orgName = cip.getOrgNameField().getText();
		Reporter.log(orgName, true);
		Assert.assertEquals(orgName, org_name);
	}
}
