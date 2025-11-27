package com.comcost.crm.ObjectRepostoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewProduct {
	WebDriver driver;
	public CreatingNewProduct (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//input[@name='productname']")
	private WebElement ProductNameField;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement SaveButton;
	
	public WebElement getSaveButton() {
		return SaveButton;
	}

	public WebElement getProductNameField() {
		return ProductNameField;
	}

	public WebElement getChooseFileButton() {
		return ChooseFileButton;
	}
	@FindBy(xpath="//input[@id='my_file_element']")
	private WebElement ChooseFileButton;

}
