package com.comcost.crm.SalesOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcleUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.generic.webdriverutility.javaUtility;

public class CreateNewSalesOrder {

	public static void main(String[] args) throws Throwable {
		
	
		 WebDriverUtility wlib=new WebDriverUtility();
			javaUtility jlib=new javaUtility();
			FileUtility flib=new FileUtility();
			ExcleUtility elib=new ExcleUtility();
			
			
			int random_number = jlib.RandomNumber();
			
			String browser = flib.getDataFromPropertyFile("browser");
			String url = flib.getDataFromPropertyFile("url");
			String username = flib.getDataFromPropertyFile("username");
			String password = flib.getDataFromPropertyFile("password");
			
			String celldata_subject = elib.getDataFromExcel("SalesOrder", 1, 2)+random_number;
			String celldata_Billing_Address = elib.getDataFromExcel("SalesOrder", 1, 3);
			String celldata_Shipping_Address = elib.getDataFromExcel("SalesOrder", 1, 4);
			String celdata_product = elib.getDataFromExcel("SalesOrder", 1, 5)+random_number;
			String celldata_orgname = elib.getDataFromExcel("CreateQuick", 1, 2).trim()+random_number;
			String celldata_website = elib.getDataFromExcel("CreateQuick", 1, 3);
			String celldata_phone = elib.getDataFromExcel("CreateQuick", 1, 4);
			
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

			//Maximize the browser
			driver.manage().window().maximize();

			//EnterURL
			driver.get(url);

			//wait
			wlib.waitForPageToLoad(driver);
			
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(3000);
			WebElement dd6 = driver.findElement(By.id("qccombo"));
			 dd6.click();
			wlib.selectByValue("Products",dd6);
			driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(celdata_product);
			driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
			 WebElement dd1 = driver.findElement(By.id("qccombo"));
			 dd1.click();
			wlib.selectByValue("Accounts",dd1);
			driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(celldata_orgname);
			driver.findElement(By.xpath("//input[@name='website']")).sendKeys(celldata_website);
			driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(celldata_phone);
			driver.findElement(By.xpath("//input[@name='assigntype'and@value='U']")).click();
			WebElement dd2 = driver.findElement(By.xpath("//select[@name='assigned_user_id']"));
			wlib.selectByValue("6",dd2);
			
			driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
			wlib.refreshData(driver);
			driver.findElement(By.xpath("//a[text()='More']")).click();
			driver.findElement(By.xpath("//a[@name='Sales Order']")).click();
			driver.findElement(By.xpath("//img[@alt='Create Sales Order...']")).click();
			driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(celldata_subject);
			WebElement dd3 = driver.findElement(By.xpath("//select[@name='sostatus']"));
			wlib.selectByValue("Created", dd3);
			driver.findElement(By.xpath("//input[@value='U']")).click();
			WebElement dd4 = driver.findElement(By.xpath("//select[@name='assigned_user_id']"));
			wlib.selectByValue("6", dd4);
			driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys(celldata_Billing_Address);
			driver.findElement(By.xpath("//textarea[@name='ship_street']")).sendKeys(celldata_Shipping_Address);
			WebElement dd5 = driver.findElement(By.xpath("//select[@name='invoicestatus']"));
			wlib.selectByValue("Approved", dd5);
			driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[4]")).click();
			wlib.switchToNewBrowser(driver, "Accounts&action");
			driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(celldata_orgname);
			driver.findElement(By.xpath("//input[@name='search']")).click();
			driver.findElement(By.xpath("//a[text()='"+celldata_orgname+"']")).click();
			wlib.switchToAlertAndAccept(driver);
			wlib.switchToNewBrowser(driver, "SalesOrder&action");
			driver.findElement(By.xpath("//img[@id='searchIcon1']")).click();
			wlib.switchToNewBrowser(driver, "Products&action");
			
			driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(celdata_product);
			driver.findElement(By.xpath("//input[@name='search']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[text()='"+celdata_product+"']")).click();
			Thread.sleep(5000);
			wlib.switchToNewBrowser(driver, "SalesOrder&action");
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();

	}

}
