package com.comcost.crm.ObjectRepostoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewSalesOrder {
	WebDriver driver;
	public CreatingNewSalesOrder(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='subject']")
	private WebElement SubjectTextField;
	
	@FindBy(xpath="//input[@name='sostatus']")
	private WebElement StatusDropdown;
	
	@FindBy(xpath="//input[@name='assigntype'and@value='U']")
	private WebElement AssignToRadioButton;
	
	@FindBy(xpath="//select[@name='assigned_user_id']")
	private WebElement AssignToDropdown;
	
	@FindBy(xpath="//input[@id='single_accountid']/following-sibling::img")
	private WebElement OrganizationNamePlusSign;
	
	@FindBy(xpath="//select[@name='invoicestatus']")
	private WebElement InvoiceStatusDropdown;
	
	@FindBy(xpath="//textarea[@name='bill_street']")
	private WebElement BillingAdddressText;
	
	public WebElement getSubjectTextField() {
		return SubjectTextField;
	}

	public WebElement getStatusDropdown() {
		return StatusDropdown;
	}

	public WebElement getAssignToRadioButton() {
		return AssignToRadioButton;
	}

	public WebElement getAssignToDropdown() {
		return AssignToDropdown;
	}

	public WebElement getOrganizationNamePlusSign() {
		return OrganizationNamePlusSign;
	}

	public WebElement getInvoiceStatusDropdown() {
		return InvoiceStatusDropdown;
	}

	public WebElement getBillingAdddressText() {
		return BillingAdddressText;
	}

	public WebElement getCopyBillingAdddressRadioButton() {
		return CopyBillingAdddressRadioButton;
	}

	public WebElement getProductsIcon() {
		return ProductsIcon;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}
	@FindBy(xpath="//b[text()='Copy Shipping address']")
	private WebElement CopyBillingAdddressRadioButton;
	
	@FindBy(xpath="//img[@id='searchIcon1']")
	private WebElement ProductsIcon;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement SaveButton;
	
	
}

