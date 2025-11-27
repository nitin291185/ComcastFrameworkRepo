package com.comcost.crm.ObjectRepostoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTiclet {
	
	
		WebDriver driver;
		public TroubleTiclet(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy (xpath="//a[text()='Trouble Tickets']")
		private WebElement TroubleTicletText;
		public WebElement getTroubleTicletText() {
			return TroubleTicletText;
		}
		
		
		
		
		
		
	

}
