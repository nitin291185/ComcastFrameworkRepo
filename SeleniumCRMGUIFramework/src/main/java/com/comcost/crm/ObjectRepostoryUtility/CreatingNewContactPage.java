package com.comcost.crm.ObjectRepostoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {
	WebDriver driver;
	public CreatingNewContactPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//input[@name='lastname']")
	private WebElement LastNameTextField;
	
	public WebElement getLastNameTextField() {
		return LastNameTextField;
	}

	

	@FindBy (xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement SaveButton;
	
	public WebElement getSaveButton() {
		return SaveButton;
		
	}
	
	@FindBy(xpath="//input[@id='jscal_field_support_start_date']")
	private WebElement startdatefield;
	
	public WebElement getStartdatefield() {
		return startdatefield;
	}

	public WebElement getEnddatefield() {
		return enddatefield;
	}

	public WebElement getOrganizationNamePlusSign() {
		return OrganizationNamePlusSign;
	}

	@FindBy(xpath="//input[@id='jscal_field_support_end_date']")
	private WebElement enddatefield;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement OrganizationNamePlusSign;
	

}
