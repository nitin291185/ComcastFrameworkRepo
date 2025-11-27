package com.comcost.crm.ObjectRepostoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {
	WebDriver driver;
	public ProductInformationPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement Header;
	public WebElement getHeader() {
		return Header;
	}

}
