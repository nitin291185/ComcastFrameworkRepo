package com.comcost.crm.Products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcleUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.generic.webdriverutility.javaUtility;
import com.comcost.crm.ObjectRepostoryUtility.CreatingNewProduct;
import com.comcost.crm.ObjectRepostoryUtility.HomePage;
import com.comcost.crm.ObjectRepostoryUtility.LoginPage;
import com.comcost.crm.ObjectRepostoryUtility.OpportunityInformationPage;
import com.comcost.crm.ObjectRepostoryUtility.ProductsPage;

public class CreateProductWithUtilityandOR {

	public static void main(String[] args) throws Throwable {
		FileUtility flib = new FileUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		javaUtility jlib = new javaUtility();
		ExcleUtility elib = new ExcleUtility();
		
		/* generate random number */
		int random_number = jlib.RandomNumber();
		
		/* Read common data from Property file */
		String browser = flib.getDataFromPropertyFile("browser");
		String url = flib.getDataFromPropertyFile("url");
		String username = flib.getDataFromPropertyFile("username");
		String password = flib.getDataFromPropertyFile("password");

		WebDriver driver = null;
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		else {
			driver = new ChromeDriver();
		}
		
		String product = elib.getDataFromExcel("Products", 1, 3)+random_number;
		   // EnterURL
			driver.get(url);
		   // Maximize the browser
			wlib.Maximize(driver);

		     /* wait */
		    wlib.waitForPageToLoad(driver);
			LoginPage lp = new LoginPage(driver);
			HomePage hp = new HomePage(driver);
			
			lp.LoginToApp(username, password, product);
			hp.getProductsLink().click();
			ProductsPage pp=new ProductsPage(driver);
			pp.getCreateProductsButton().click();
			
			CreatingNewProduct cnp=new CreatingNewProduct(driver);
			cnp.getProductNameField().sendKeys(product);
			cnp.getChooseFileButton().sendKeys("C:\\Users\\Nitin Pant\\eclipse-workspace\\SeleniumCRMGUIFramework\\TestData\\Products\\IMG_1.jpg");
			Thread.sleep(2000);
			cnp.getChooseFileButton().sendKeys("C:\\Users\\Nitin Pant\\eclipse-workspace\\SeleniumCRMGUIFramework\\TestData\\Products\\IMG_2.jpg");
			Thread.sleep(2000);
			cnp.getChooseFileButton().sendKeys("C:\\Users\\Nitin Pant\\eclipse-workspace\\SeleniumCRMGUIFramework\\TestData\\Products\\IMG_3.jpg");
			Thread.sleep(2000);
			cnp.getChooseFileButton().sendKeys("C:\\Users\\Nitin Pant\\eclipse-workspace\\SeleniumCRMGUIFramework\\TestData\\Products\\IMG_4.jpg");
			Thread.sleep(2000);
			cnp.getChooseFileButton().sendKeys("C:\\Users\\Nitin Pant\\eclipse-workspace\\SeleniumCRMGUIFramework\\TestData\\Products\\IMG_5.jpg");
			Thread.sleep(2000);
			cnp.getChooseFileButton().sendKeys("C:\\Users\\Nitin Pant\\eclipse-workspace\\SeleniumCRMGUIFramework\\TestData\\Products\\IMG_6.jpg");
			Thread.sleep(2000);
			
			cnp.getSaveButton().click();
			
			OpportunityInformationPage oip=new OpportunityInformationPage(driver);
			String headertext = oip.getOpportunityInformationHeader().getText();
			String nameField = oip.getOpportunityNameField().getText();
			
			if(headertext.contains(nameField))
			{
				System.out.println(nameField + " Is OK===>Test case passed");
			}
			
			else
			{
				System.out.println(nameField + " Is Not ok===>Test case Failed");
			}
	}

}
