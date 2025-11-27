package com.comcost.crm.Products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcleUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.generic.webdriverutility.javaUtility;

public class CreateProduct {
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
		
		String celldata_qty = elib.getDataFromExcel("Products", 1, 4);
		String celldata_Products = elib.getDataFromExcel("Products", 1, 3)+random_number;
		
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
		
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		driver.findElement(By.xpath("//input[@class='detailedViewTextBox'and@name='productname']")).sendKeys(celldata_Products);
		driver.findElement(By.xpath("//input[@name='qtyinstock']")).sendKeys(celldata_qty);
		driver.findElement(By.xpath("//input[@id='my_file_element']")).sendKeys("C:\\Users\\Nitin Pant\\eclipse-workspace\\SeleniumCRMGUIFramework\\TestData\\Products\\IMG_1.jpg");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='my_file_element']")).sendKeys("C:\\Users\\Nitin Pant\\eclipse-workspace\\SeleniumCRMGUIFramework\\TestData\\Products\\IMG_2.jpg");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='my_file_element']")).sendKeys("C:\\Users\\Nitin Pant\\eclipse-workspace\\SeleniumCRMGUIFramework\\TestData\\Products\\IMG_3.jpg");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='my_file_element']")).sendKeys("C:\\Users\\Nitin Pant\\eclipse-workspace\\SeleniumCRMGUIFramework\\TestData\\Products\\IMG_4.jpg");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='my_file_element']")).sendKeys("C:\\Users\\Nitin Pant\\eclipse-workspace\\SeleniumCRMGUIFramework\\TestData\\Products\\IMG_5.jpg");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='my_file_element']")).sendKeys("C:\\Users\\Nitin Pant\\eclipse-workspace\\SeleniumCRMGUIFramework\\TestData\\Products\\IMG_6.jpg");
		Thread.sleep(2000);
	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		
}
}
