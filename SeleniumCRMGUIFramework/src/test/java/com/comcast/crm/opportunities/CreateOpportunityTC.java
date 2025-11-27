package com.comcast.crm.opportunities;

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

public class CreateOpportunityTC {
	
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
		String celldata = elib.getDataFromExcel("Organisation", 1, 2)+random_number;
		String celldata_Opportunities = elib.getDataFromExcel("Opportunities", 1, 2)+random_number;
	

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

	driver.findElement(By.xpath("(//a[text()='Organizations'and@href='index.php?module=Accounts&action=index'])")).click();
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(celldata);
	
	driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
	wlib.refreshData(driver);
	
	driver.findElement(By.xpath("//tr/descendant::a[@href='index.php?module=Potentials&action=index']")).click();
	driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
	driver.findElement(By.name("potentialname")).sendKeys(celldata_Opportunities);
	WebElement dd1 = driver.findElement(By.id("related_to_type"));
	
	wlib.selectByVisibleText(dd1,"Organizations");
	
	driver.findElement(By.xpath("(//td[@class='dvtCellInfo']/img[@src='themes/softed/images/select.gif'])[1]")).click();
	
	wlib.switchToNewBrowser(driver, "Accounts&action");
	driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(celldata);
	driver.findElement(By.xpath("//input[@type='button']")).click();

	driver.findElement(By.xpath("//a[text()='"+celldata+"']")).click();
	/*Switch back to main window*/
	
	wlib.switchToTabOnTitle(driver, "Potentials&action");

	
	WebElement date_Field = driver.findElement(By.id("jscal_field_closingdate"));
	date_Field.clear();
	date_Field.sendKeys(jlib.FutureDateAfter2Months());
	
	WebElement dd2 = driver.findElement(By.name("sales_stage"));
	wlib.selectByVisibleText(dd2, "Prospecting");
	
	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	
	WebElement related_to_field = driver.findElement(By.xpath("(//td[@class='dvtCellInfo'and@align='left'])[3]"));
	String related_to_field_text = related_to_field.getText();
	
	if(related_to_field_text.contains(celldata))
	{
		System.out.println(celldata + "field verified");
	}
	else
	{
		System.out.println(celldata + "not field verified");
	}
	
	WebElement Opportunity_Name_field = driver.findElement(By.xpath("//td[@id='mouseArea_Opportunity Name']"));
	String Opportunity_Name_field_text = Opportunity_Name_field.getText();
	if(Opportunity_Name_field_text.contains(celldata_Opportunities))
	{
		System.out.println(Opportunity_Name_field_text + "field verified");
	}
	else
	{
		System.out.println(Opportunity_Name_field_text + "not field verified");
	}
	
	


	}

}
