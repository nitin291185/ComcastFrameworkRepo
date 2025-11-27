package com.comcost.crm.ObjectRepostoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {
	
	WebDriver driver;
	
	
	@FindBy(name="user_name")
	private WebElement usernameEdit;
	
	@FindBy(name="user_password")
	private WebElement passwordEdit;
	
	@FindBy(id="submitButton")
	private WebElement Loginbutton;

	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginbutton() {
		return Loginbutton;
	}

	public void LoginToApp(String url,String username,String password) 
	{
		waitForPageToLoad(driver);
		driver.get(url);
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		Loginbutton.click();
	}
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
 