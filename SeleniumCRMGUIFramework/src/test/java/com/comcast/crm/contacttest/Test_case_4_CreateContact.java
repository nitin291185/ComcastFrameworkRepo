package com.comcast.crm.contacttest;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.ExcleUtility;
import com.comcast.crm.generic.fileutility.FileUtility;

public class Test_case_4_CreateContact {

	public static void main(String[] args) throws Throwable {
		//generate random number
	    Random random = new Random();
	  int randomInt = random.nextInt(2000);

	  FileUtility flib=new FileUtility();
	  ExcleUtility elib=new ExcleUtility();
		//Read common  data from property file using generic	
	 String browser = flib.getDataFromPropertyFile("browser");
	 String url = flib.getDataFromPropertyFile("url");
	 String username = flib.getDataFromPropertyFile("username");
	 String password = flib.getDataFromPropertyFile("password");

		// Read common data from Property file
//			FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\commondata.properties");
//			Properties pobj=new Properties();
//			pobj.load(fis);
//			String browser = pobj.getProperty("browser");
//			String url = pobj.getProperty("url");
//			String username = pobj.getProperty("username");
//			String password = pobj.getProperty("password");
	 
	 
	 
		//Read test script data from excel file using generic	
	 String firstname = elib.getDataFromExcel("Organisation", 10, 2);
	 String lastname = elib.getDataFromExcel("Organisation", 10, 3)+randomInt;
//read data from Excel File
//	FileInputStream fis1=new FileInputStream("C:\\Users\\Nitin Pant\\OneDrive\\Desktop\\Data for DDT\\Testdata.xlsx");
//	Workbook wb = WorkbookFactory.create(fis1);
//	Sheet sheet = wb.getSheet("Organisation");
//	Row row = sheet.getRow(10);
//	String first_name = row.getCell(2).toString()+randomInt;
//	Row row10 = sheet.getRow(10);
//	String last_name = row10.getCell(3).toString();;
	//wb.close();
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
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	Thread.sleep(3000);
	
//Click on Contacts
	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	WebElement dd1 = driver.findElement(By.xpath("//select[@name='salutationtype']"));
	Select s=new Select(dd1);
	s.selectByValue("Mr.");
	driver.findElement(By.xpath("//input[@class='detailedViewTextBox'and@name='firstname']")).sendKeys(firstname);
	driver.findElement(By.xpath("//input[@class='detailedViewTextBox'and@name='lastname']")).sendKeys(lastname);
	driver.findElement(By.xpath("//input[@name='button'and@class='crmButton small save']")).click();
	//verification
	String Last_name_text_field = driver.findElement(By.xpath("//td[@class='dvtCellInfo'and@id='mouseArea_Last Name']")).getText().trim();
System.out.println(Last_name_text_field);
String header_text = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText().trim();
System.out.println(header_text);
if(header_text.contains(Last_name_text_field))
{
	System.out.println("Name verified");
}
else
{
	System.out.println("Name not verified");
}

	}

}
