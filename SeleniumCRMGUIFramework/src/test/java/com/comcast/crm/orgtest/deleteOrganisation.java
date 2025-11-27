package com.comcast.crm.orgtest;

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

public class deleteOrganisation {

	public static void main(String[] args) throws Throwable {
		WebDriverUtility wlib=new WebDriverUtility();
		javaUtility jlib=new javaUtility();
		FileUtility flib=new FileUtility();
		ExcleUtility elib=new ExcleUtility();
		
		int random_number = jlib.RandomNumber();

		// Read common data from Property file
		
		String browser = flib.getDataFromPropertyFile("browser");
		String url = flib.getDataFromPropertyFile("url");
		String username = flib.getDataFromPropertyFile("username");
		String password = flib.getDataFromPropertyFile("password");
		
		// Read common data from Excel file
		String celldata_org_name1 = elib.getDataFromExcel("Organisation", 19, 2)+random_number;
		String celldata_org_name2 = elib.getDataFromExcel("Organisation", 19, 5)+random_number;
		
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
	//driver.findElement(By.xpath(""));
	//wait
	wlib.waitForPageToLoad(driver);
	
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	Thread.sleep(3000);
	
	//driver.findElement(By.xpath(""));
	driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(celldata_org_name1);
	
	driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
	String org_text = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText().trim();
	driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
	driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(celldata_org_name1);
	WebElement dd1 = driver.findElement(By.id("bas_searchfield"));
	wlib.selectByVisibleText(dd1,"Organization Name");
	driver.findElement(By.xpath("(//input[@value=' Search Now '])")).click();
	driver.findElement(By.xpath("//tr[@bgcolor='white']/td/input")).click();
	driver.findElement(By.xpath("//a[text()='del']")).click();
	Thread.sleep(2000);
	wlib.switchToAlertAndCancel(driver);
	driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(celldata_org_name1);
	WebElement dd2 = driver.findElement(By.xpath("(//select[@id='bas_searchfield'])[1]"));
	wlib.selectByVisibleText(dd2, "Organization Name");
	driver.findElement(By.xpath("(//input[@value=' Search Now '])")).click();
	String text = driver.findElement(By.xpath("//span[@class='genHeaderSmall']")).getText().trim();
	if(text.contains("No Organization Found"))
	{
		System.out.println("Organisation deleted");
	}
	else
	{
		System.out.println("Organisation not deleted");
	}
	
}
}
