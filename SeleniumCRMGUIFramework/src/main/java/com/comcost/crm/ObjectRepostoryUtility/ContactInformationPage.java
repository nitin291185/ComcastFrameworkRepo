package com.comcost.crm.ObjectRepostoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	WebDriver driver;
	public ContactInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getContactHeaderText() {
		return ContactHeaderText;
	}

	public WebElement getContactText() {
		return ContactText;
	}

	@FindBy (xpath="//span[@class='dvHeaderText']")
	private WebElement ContactHeaderText;
	
	@FindBy(xpath="//span[@id='dtlview_Last Name']")
	private WebElement ContactText;
	
	@FindBy(xpath = "//td[@id='mouseArea_Organization Name']/a")
	private WebElement OrgNameField;
	public WebElement getOrgNameField() {
		return OrgNameField;
	}

}
