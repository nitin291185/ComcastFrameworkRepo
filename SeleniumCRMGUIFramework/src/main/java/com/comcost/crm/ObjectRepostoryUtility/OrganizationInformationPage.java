package com.comcost.crm.ObjectRepostoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	WebDriver driver;
	public OrganizationInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="mouseArea_Opportunity ")
	private WebElement OpportunityNameField;
	
	@FindBy(xpath="//a[@title='Organizations']")
	private WebElement RelatedToField;
	
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrganisationInformation;
	
	@FindBy(xpath="//td[@id='mouseArea_Industry']")
	private WebElement IndustryField;
	
	public WebElement getOpportunityNameField() {
		return OpportunityNameField;
	}

	public WebElement getRelatedToField() {
		return RelatedToField;
	}
	@FindBy(xpath="//td[@id='mouseArea_Phone']")
	private WebElement PhoneNumberField;

	public WebElement getOrganisationInformation() {
		return OrganisationInformation;
		
		
		
		
	}

	public WebElement getIndustryField() {
		return IndustryField;
	}

	public WebElement getPhoneNumberField() {
		return PhoneNumberField;
	}

	}
