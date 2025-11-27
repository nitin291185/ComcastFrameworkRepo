package com.comcast.crmCreateQuickAssetOrganisation;

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

public class CreateQuickOrganisation {
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
		 WebElement dd1 = driver.findElement(By.xpath("//select[@id='qccombo']"));
		 dd1.click();
		wlib.selectByValue("Accounts",dd1);
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(celldata_orgname);
		driver.findElement(By.xpath("//input[@name='website']")).sendKeys(celldata_website);
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(celldata_phone);
		driver.findElement(By.xpath("//input[@name='assigntype'and@value='U']")).click();
		WebElement dd2 = driver.findElement(By.xpath("//select[@name='assigned_user_id']"));
		wlib.selectByVisibleText(dd2,"6");
		
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		WebElement header = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		String header_text = header.getText().trim();
		if(header_text.contains(celldata_orgname))
		{
			System.out.println("Organisation name=======> " + celldata_orgname +" is veified");
		}
		else
		{
			System.out.println("Organisation name=======> " + celldata_orgname +" is not veified");
		}
		
	}

}
