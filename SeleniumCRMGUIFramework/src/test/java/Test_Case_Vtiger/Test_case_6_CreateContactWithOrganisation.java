package Test_Case_Vtiger;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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
import org.openqa.selenium.support.ui.Select;

public class Test_case_6_CreateContactWithOrganisation {

	public static void main(String[] args) throws Throwable {
		//generate random number
	    Random random = new Random(2000);
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
	Row row = sheet.getRow(16);
	String celldata = row.getCell(4).toString()+randomInt;

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
	driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
	
	//Click on contact tab
	FileInputStream fis2=new FileInputStream("C:\\Users\\Nitin Pant\\OneDrive\\Desktop\\Data for DDT\\Testdata.xlsx");
	Workbook wb2 = WorkbookFactory.create(fis2);
	Sheet sheet2 = wb2.getSheet("Organisation");
	Row row2 = sheet2.getRow(16);
	String first_name = row2.getCell(2).toString();
	Row row10 = sheet2.getRow(16);
	String last_name = row10.getCell(3).toString()+randomInt;
	driver.navigate().refresh();
	driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
	
	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	WebElement dd1 = driver.findElement(By.xpath("//select[@name='salutationtype']"));
	Select s=new Select(dd1);
	s.selectByValue("Mr.");
	driver.findElement(By.xpath("//input[@class='detailedViewTextBox'and@name='firstname']")).sendKeys(first_name);
	driver.findElement(By.xpath("//input[@class='detailedViewTextBox'and@name='lastname']")).sendKeys(last_name);
	driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img")).click();
	//Handling child window 
	String main_page = driver.getWindowHandle();
	Set<String> windows = driver.getWindowHandles();
	for(String window:windows)
	{
		if(!main_page.equals(window))
		{
			driver.switchTo().window(window);
		}
		
	}
	
driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(celldata);
Thread.sleep(2000);
driver.findElement(By.xpath("//input[@name='search']")).click();
driver.findElement(By.xpath("//a[text()='"+celldata+"']")).click();
//Switch back to main window
for(String window:windows)
{
	if(main_page.equals(window))
	{
		driver.switchTo().window(window);
	}
	
}

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
