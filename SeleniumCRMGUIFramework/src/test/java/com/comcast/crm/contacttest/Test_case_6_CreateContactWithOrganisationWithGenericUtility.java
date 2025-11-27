package com.comcast.crm.contacttest;

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

public class Test_case_6_CreateContactWithOrganisationWithGenericUtility {
public static void main(String[] args) throws Throwable {
		
		WebDriverUtility wlib=new WebDriverUtility();
		javaUtility jlib=new javaUtility();
		FileUtility flib=new FileUtility();
		ExcleUtility elib=new ExcleUtility();
		
		/*generate random number*/
		int random_number = jlib.RandomNumber();
		/* Read common data from Property file*/
		String browser = flib.getDataFromPropertyFile("browser");
		String url = flib.getDataFromPropertyFile("url");
		String username = flib.getDataFromPropertyFile("username");
		String password = flib.getDataFromPropertyFile("password");
		
		//Read test script data from excel file using generic	
		String celldata = elib.getDataFromExcel("Organisation", 16, 4)+random_number;
		
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

	/*wait*/
	wlib.waitForPageToLoad(driver);
	
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//a[text()='Organizations'and@href='index.php?module=Accounts&action=index'])")).click();
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(celldata);
	driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
	
	/*Click on contact tab*/
	String first_name = elib.getDataFromExcel("Organisation", 16, 2);

	String last_name = elib.getDataFromExcel("Organisation", 16, 3)+random_number;

	driver.navigate().refresh();
	driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	WebElement dd1 = driver.findElement(By.xpath("//select[@name='salutationtype']"));
	wlib.selectByVisibleText(dd1, "Mr.");

	driver.findElement(By.xpath("//input[@class='detailedViewTextBox'and@name='firstname']")).sendKeys(first_name);
	driver.findElement(By.xpath("//input[@class='detailedViewTextBox'and@name='lastname']")).sendKeys(last_name);
	driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img")).click();
	/*Handling child window*/ 
	wlib.switchToNewBrowser(driver, "Accounts&action");
driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(celldata);
Thread.sleep(2000);
driver.findElement(By.xpath("//input[@name='search']")).click();
driver.findElement(By.xpath("//a[text()='"+celldata+"']")).click();

/*Switch back to main window*/

wlib.switchToTabOnTitle(driver, "Contacts&action");

driver.findElement(By.xpath("//input[@title='Save [Alt+S]'and@class='crmButton small save']")).click();
//Verification of header text
String header_text = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
String Last_name_text_field = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
if(header_text.contains(Last_name_text_field))
{
	System.out.println(Last_name_text_field + " Name verified");
}
else
{
	System.out.println(Last_name_text_field + " Name not verified");
}
	}
}
