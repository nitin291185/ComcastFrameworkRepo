package com.comcost.crm.ObjectRepostoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityInformationPage {
	WebDriver driver;
	public OpportunityInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@id='dtlview_Product Name']")
	private WebElement OpportunityNameField;
	
	@FindBy(xpath="//a[@title='Organizations']")
	private WebElement RelatedToField;
	
	public WebElement getOpportunityNameField() {
		return OpportunityNameField;
	}

	public WebElement getRelatedToField() {
		return RelatedToField;
	}

	public WebElement getOpportunityInformationHeader() {
		return OpportunityInformationHeader;
	}
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement OpportunityInformationHeader;

}
