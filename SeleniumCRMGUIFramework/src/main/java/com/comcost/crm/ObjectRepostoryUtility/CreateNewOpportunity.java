package com.comcost.crm.ObjectRepostoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOpportunity {
	
	WebDriver driver;
	public CreateNewOpportunity(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='potentialname']")
	private WebElement OpportunityNameTextField;
	
	@FindBy(xpath="//select[@id='related_to_type']")
	private WebElement OrganizationDropDown;
	
	public WebElement getOpportunityNameTextField() {
		return OpportunityNameTextField;
	}

	public WebElement getOrganizationDropDown() {
		return OrganizationDropDown;
	}

	public WebElement getPlussignImage() {
		return PlussignImage;
	}

	public WebElement getAssignToradioButton() {
		return AssignToradioButton;
	}

	public WebElement getAssignTorDropdown() {
		return AssignTorDropdown;
	}

	public WebElement getExpextedCloseDate() {
		return ExpextedCloseDate;
	}

	public WebElement getSalesStageDropdown() {
		return SalesStageDropdown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	@FindBy(xpath="//select[@id='related_to_type']/../following-sibling::td/img")
	private WebElement PlussignImage;
	
	@FindBy(xpath="//input[@value='U']")
	private WebElement AssignToradioButton;
	
	@FindBy(xpath="//select[@name='assigned_user_id']")
	private WebElement AssignTorDropdown;
	
	@FindBy(xpath="//input[@name='closingdate']")
	private WebElement ExpextedCloseDate;
	
	@FindBy(xpath="//select[@name='sales_stage']")
	private WebElement SalesStageDropdown;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;
	
	
}
