package Test_Case_Vtiger;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
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

public class Test_case_5_CreateContactWithSupportDate {

	public static void main(String[] args) throws Throwable {
		//generate random number
	    Random random = new Random();
	  int randomInt = random.nextInt();
	  
	  //Support date in the format
	  Date d= new Date();
	  
	  SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
	 String start_date = sim.format(d);
	 
	 //Capture Calendar date for next 30 days
	 Calendar cal=sim.getCalendar();
	 cal.add(Calendar.DAY_OF_MONTH, 30);
	 String end_date = sim.format(cal.getTime());

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
	Row row = sheet.getRow(10);
	String first_name = row.getCell(2).toString()+randomInt;
	Row row10 = sheet.getRow(10);
	String last_name = row10.getCell(3).toString();
	
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
	
//Click on Contacts
	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	WebElement dd1 = driver.findElement(By.xpath("//select[@name='salutationtype']"));
	Select s=new Select(dd1);
	s.selectByValue("Mr.");
	driver.findElement(By.xpath("//input[@class='detailedViewTextBox'and@name='firstname']")).sendKeys(first_name);
	driver.findElement(By.xpath("//input[@class='detailedViewTextBox'and@name='lastname']")).sendKeys(last_name);
	
	driver.findElement(By.name("support_start_date")).clear();
	driver.findElement(By.name("support_start_date")).sendKeys(start_date);
	
	driver.findElement(By.name("support_end_date")).clear();
	driver.findElement(By.name("support_end_date")).sendKeys(end_date);
	
	driver.findElement(By.xpath("//input[@name='button'and@class='crmButton small save']")).click();
	String startDateField = driver.findElement(By.xpath("//span[@id='dtlview_Support Start Date']")).getText();
	String endDateField = driver.findElement(By.xpath("//span[@id='dtlview_Support End Date']")).getText();
	//verification
	if(startDateField.equals(start_date))
	{
		System.out.println("Support Start Date verified");
	}
	else
	{
		System.out.println("Support Start Date not verified");
	}
	if(endDateField.equals(end_date))
	{
		System.out.println("Support End Date verified");
	}
	else
	{
		System.out.println("Support End Date not verified");
	}

	}
}
