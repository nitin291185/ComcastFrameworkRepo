package com.comcost.crm.ObjectRepostoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganizationPage {
	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement OrganisationNameTextField;
	
	@FindBy(xpath="//td[@class='dvtCellInfo']/select[@name='industry']")
	private WebElement IndustryDropdown;
	
	@FindBy(xpath="//input[@name='phone']")
	private WebElement PhoneNumbertextField;
	
	public WebElement getOrganisationNameTextField() {
		return OrganisationNameTextField;
	}

	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement SaveButton;
	
	public WebElement getIndustryDropdown() {
		return IndustryDropdown;
	}


	public WebElement getPhoneNumbertextField() {
		return PhoneNumbertextField;
	}


	public WebElement getSaveButton() {
		return SaveButton;
	}
	
	
public void EnterOrgAndSave() {
	
	OrganisationNameTextField.sendKeys("Qspider484514218");
	SaveButton.click();
	
	
	
	
	
	
}
	
	
	
	
	
	
}
