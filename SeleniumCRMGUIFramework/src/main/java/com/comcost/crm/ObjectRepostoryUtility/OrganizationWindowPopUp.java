package com.comcost.crm.ObjectRepostoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationWindowPopUp {
	WebDriver driver;
	public OrganizationWindowPopUp(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement SearchTextField;
	
	@FindBy(xpath="//select[@class='txtBox']")
	private WebElement InDropDown;
	
	@FindBy(xpath="//input[@class='crmbutton small create']")
	private WebElement SearchNowButton;
	


	public WebElement getSearchTextField() {
		return SearchTextField;
	}

	public WebElement getInDropDown() {
		return InDropDown;
	}

	public WebElement getSearchNowButton() {
		return SearchNowButton;
	}

	

	
	
	
}
