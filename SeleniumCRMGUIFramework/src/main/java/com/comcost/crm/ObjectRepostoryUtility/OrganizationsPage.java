package com.comcost.crm.ObjectRepostoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	 WebDriver driver;

	public OrganizationsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement CreateNewOrganicationbutton;
	
	public WebElement getCreateNewOrganicationbutton() {
		return CreateNewOrganicationbutton;
	}

	public WebElement getSearchTextField() {
		return SearchTextField;
	}

	public WebElement getDropdown() {
		return dropdown;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	@FindBy(name="search_text")
	private WebElement SearchTextField;
	
	@FindBy(id="bas_searchfield")
	private WebElement dropdown;
	
	public WebElement getProductLink() {
		return productLink;
	}


	@FindBy(name="submit")
	private WebElement submitBtn;
	
	public WebElement getCheckbox() {
		return checkbox;
	}

	public WebElement getDeleteLink() {
		return deleteLink;
	}

	public WebElement getEditLink() {
		return editLink;
	}


	@FindBy(xpath="//tr[@id='row_78106']/td/input")
	private WebElement productLink;
	
	@FindBy(xpath="//input[@name='selectall']")
	private WebElement checkbox;
	
	@FindBy(xpath="//a[text()='del']")
	private WebElement deleteLink;
	
	public WebElement getNoOrganizationFoundSign() {
		return NoOrganizationFoundSign;
	}


	@FindBy(xpath="//a[text()='edit']")
	private WebElement editLink;
	
	@FindBy(xpath="//span[@class='genHeaderSmall']")
	private WebElement NoOrganizationFoundSign;
	
	@FindBy(xpath="//tr[@bgcolor='white']/td/a[@title='Organizations']")
	private WebElement OrganizationNameField;

	public WebElement getOrganizationNameField() {
		return OrganizationNameField;
	}
	
	
}
