package com.comcast.crm.orgtest;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.comcast.crm.baseclass.BaseClass;
import com.comcost.crm.ObjectRepostoryUtility.CreatingNewOrganizationPage;
import com.comcost.crm.ObjectRepostoryUtility.HomePage;
import com.comcost.crm.ObjectRepostoryUtility.OrganizationInformationPage;
import com.comcost.crm.ObjectRepostoryUtility.OrganizationsPage;

public class CreateOrganizationWithGUAndORwithTestNG extends BaseClass {

	@Test(groups = "Smoke_Testing")
	public void createOrganizationTest() throws Throwable {

		HomePage hp = new HomePage(driver);
		OrganizationsPage op = new OrganizationsPage(driver);
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);

		/* generate random number */
		int random_number = jlib.RandomNumber();

		// Read test script data from excel file using generic
		String celldata = elib.getDataFromExcel("Organisation", 22, 2) + random_number;

		// Navigate to organization page
		hp.NavigateToOrganizationPage();

		// Navigate to Create New Organization Page
		op.getCreateNewOrganicationbutton().click();

		// Enter Organization name
		cnop.getOrganisationNameTextField().sendKeys(celldata);
		cnop.getSaveButton().click();

		// Verification of header text
		String header_text = oip.getOrganisationInformation().getText();

		if (header_text.contains(celldata)) {
			System.out.println(celldata + " Name verified");
		} else {
			System.out.println(celldata + " Name not verified");
		}

	}

	@Test(groups = "Regression_Testing")
	public void createOrganizationwithPhoneNumberTest() throws Throwable {
		HomePage hp = new HomePage(driver);
		OrganizationsPage op = new OrganizationsPage(driver);
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);

		/* generate random number */
		int random_number = jlib.RandomNumber();

		// Read test script data from excel file using generic
		String celldata = elib.getDataFromExcel("Organisation", 22, 2) + random_number;

		// Navigate to organization page
		hp.NavigateToOrganizationPage();

		// Navigate to Create New Organization Page
		op.getCreateNewOrganicationbutton().click();

		// Enter Organization name
		cnop.getOrganisationNameTextField().sendKeys(celldata);

		Thread.sleep(2000);
		String NumberCellData = elib.getDataFromExcel("Organisation", 22, 4).toString();
		cnop.getPhoneNumbertextField().sendKeys(NumberCellData);
		cnop.getSaveButton().click();
		// Verification of Industry
		String Number_text = oip.getPhoneNumberField().getText().trim();

		if (Number_text.equals(NumberCellData)) {
			System.out.println("Phone number verified====> Test case passed");
		} else
			System.out.println(" Phone number not verified====> Test Case failed");
	}

	@Test(groups = "Regression_Testing")
	public void createOrganizationwithIndustrytest() throws Throwable {
		HomePage hp = new HomePage(driver);
		OrganizationsPage op = new OrganizationsPage(driver);
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);

		/* generate random number */
		int random_number = jlib.RandomNumber();

		// Read test script data from excel file using generic
		String celldata = elib.getDataFromExcel("Organisation", 22, 2) + random_number;

		// Navigate to organization page
		hp.NavigateToOrganizationPage();

		// Navigate to Create New Organization Page
		op.getCreateNewOrganicationbutton().click();

		// Enter Organization name
		cnop.getOrganisationNameTextField().sendKeys(celldata);

		Thread.sleep(2000);

		WebElement dd = cnop.getIndustryDropdown();
		wlib.selectByVisibleText(dd, "Education");
		cnop.getSaveButton().click();
		// Verification of Industry
		String Industry_text = oip.getIndustryField().getText();

		if (Industry_text.contains("Education")) {
			System.out.println(" Industry verified====> Test case passed");
		} else {
			System.out.println(" Industry not verified====> Test Case failed");
		}

	}

}
