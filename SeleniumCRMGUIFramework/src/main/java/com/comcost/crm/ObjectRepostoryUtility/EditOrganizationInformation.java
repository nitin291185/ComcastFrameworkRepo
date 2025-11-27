package com.comcost.crm.ObjectRepostoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditOrganizationInformation {
	WebDriver driver;
	public EditOrganizationInformation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement textbox;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;
	public WebElement getTextbox() {
		return textbox;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

}
