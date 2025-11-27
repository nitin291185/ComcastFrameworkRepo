package com.comcast.crm.orgtest;

	import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.comcost.crm.ObjectRepostoryUtility.LoginPage;

	public class Login_with_objectRepository {

		public static void main(String[] args) throws Throwable {
			

			// Read common data from Property file
				FileInputStream fis =new FileInputStream("./configAppData/commondata.properties");
				Properties pobj=new Properties();
				pobj.load(fis);
				String browser = pobj.getProperty("browser");
				String url = pobj.getProperty("url");
				String username = pobj.getProperty("username");
				String password = pobj.getProperty("password");
				

		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome"))
		{
		driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
		driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
		driver=new EdgeDriver();
		}

		else
		{
		driver=new ChromeDriver();	
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	driver.get(url);
		
		//login to page
	LoginPage lp = PageFactory.initElements(driver,LoginPage.class);
//		lp.getUsernameEdit().sendKeys(username); 
//		lp.getPasswordEdit().sendKeys(password);
//		lp.getLoginbutton().click();
	
	//Login to page using business class
	
	lp.LoginToApp(username, password, password);
	
	
	
	
	
	
	
	
	
	
	
	
		}
	}

