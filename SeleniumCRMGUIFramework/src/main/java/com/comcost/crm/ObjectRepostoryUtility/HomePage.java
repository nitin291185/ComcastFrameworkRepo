package com.comcost.crm.ObjectRepostoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[@href='index.php?module=Calendar&action=index']")
	private WebElement calenderLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement Admin;
	
	@FindBy(xpath="(//a[text()='Organizations'])[1]")
	private WebElement OrganizationLink;
	
	public WebElement getAdmin() {
		return Admin;
	}


	@FindBy(xpath="//a[@href='index.php?module=Potentials&action=index']")
	private WebElement OpportunitiesLink;
	
	@FindBy(xpath="//a[@href='index.php?module=Contacts&action=index']")
	private WebElement ContactsLink;
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement MoreLink ;
	
	@FindBy(xpath="//a[@href='index.php?module=SalesOrder&action=index']")
	private WebElement SaleOrder ;
	
	@FindBy(xpath="//a[text()='Products']")
	private WebElement ProductsLink ;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement SignOutLink ;
	
	public WebElement getProductsLink() {
		return ProductsLink;
	}



	public WebElement getSignOutLink() {
		return SignOutLink;
	}



	public WebElement getOpportunitiesLink() {
		return OpportunitiesLink;
	}

	

	public WebElement getMoreLink() {
		return MoreLink;
	}



	public WebElement getSaleOrder() {
		return SaleOrder;
	}



	public WebElement getCalenderLink() {
		return calenderLink;
		
		
	}

	public WebElement getOrganizationLink() {
		return OrganizationLink;
	}
	
	public WebElement getContactsLink() {
		return ContactsLink;
	}



	public void NavigateToOrganizationPage() {
		OrganizationLink.click();
	}
	
	public void logout() {
		WebDriverUtility wlib=new WebDriverUtility();
		wlib.mouseMoveToElement(driver, Admin);
		SignOutLink.click();
		
	}
}
