package Test_Case_Vtiger;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Test_case_3_With_Phone_number {

	public static void main(String[] args) throws Throwable {
		//generate random number
	    Random random = new Random();
	  int randomInt = random.nextInt();

		// Read common data from Property file
			FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\commondata.properties");
			Properties pobj=new Properties();
			pobj.load(fis);
			String browser = pobj.getProperty("browser");
			String url = pobj.getProperty("url");
			String username = pobj.getProperty("username");
			String password = pobj.getProperty("password");
			

	FileInputStream fis1=new FileInputStream("C:\\Users\\Nitin Pant\\OneDrive\\Desktop\\Data for DDT\\Testdata.xlsx");
	Workbook wb = WorkbookFactory.create(fis1);
	Sheet sheet = wb.getSheet("Organisation");
	Row row = sheet.getRow(1);
	String celldata = row.getCell(2).toString()+randomInt;
	Row row7 = sheet.getRow(7);
	String phoneNo_cell = row7.getCell(4).toString();

	wb.close();
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

	driver.findElement(By.xpath("(//a[text()='Organizations'and@href='index.php?module=Accounts&action=index'])")).click();
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(celldata);
	
	WebElement phone_field = driver.findElement(By.xpath("//input[@name='phone']"));
	phone_field.sendKeys(phoneNo_cell);
	driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
	String Phone_number_Field = driver.findElement(By.xpath("//td[@id='mouseArea_Phone']")).getText();
System.out.println(Phone_number_Field);
	if(Phone_number_Field.equals(phoneNo_cell))
	{
		System.out.println("Phone Number field is verified");
	}
	else
	{
		System.out.println("Phone number field is not verified");
	}
	
	WebElement org = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
	String actual_org = org.getText();
	
	System.out.println("The organisation name is "+ actual_org);
	System.out.println(celldata);
	if(actual_org.contains(celldata))
	{
		System.out.println("Header Data "+actual_org+ " Is Verified");
	}
	else
	{
		System.out.println("Header Data "+actual_org+ " Is not Verified");
	}
	
	String stored_data = driver.findElement(By.id("dtlview_Organization Name")).getText();
	if(stored_data.contains(celldata))
	{
		System.out.println("Stored data "+stored_data+ " Is Verified");
	}
	else
	{
		System.out.println("Stored data "+stored_data+ " Is not Verified");
	}
	Actions act=new Actions(driver);
	WebElement icon = driver.findElement(By.xpath("//td[@class='small'and@align='right']/descendant::td[@class='small']/img[@src='themes/softed/images/user.PNG']"));
	act.moveToElement(icon).build().perform();
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	driver.quit();

	}

}
