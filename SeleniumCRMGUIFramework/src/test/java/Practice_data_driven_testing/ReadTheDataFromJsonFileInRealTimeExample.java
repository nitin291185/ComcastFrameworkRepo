package Practice_data_driven_testing;

import java.io.FileInputStream;
import java.io.FileReader;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ReadTheDataFromJsonFileInRealTimeExample {
	@Test
	public void createOrgtest() throws Throwable
	{
	// Read common data fron JSon file
	JSONParser parser = new JSONParser();
	Object obj = parser.parse(new FileReader("C:\\Users\\Nitin Pant\\OneDrive\\Desktop\\Data for DDT\\commondata_json.json"));
	JSONObject map=(JSONObject) obj;
	
	//generate random number
    Random random = new Random();
  int randomInt = random.nextInt();
	
	String Browser =(String) map.get("browser");
	String URL = (String) map.get("url");
	String UN = (String) map.get("username");
	String PWSRD = map.get("password").toString(); 
    String organisation =  map.get("organisation").toString()+randomInt;
   


FileInputStream fis1=new FileInputStream("C:\\Users\\Nitin Pant\\OneDrive\\Desktop\\Data for DDT\\Testdata.xlsx");
Workbook wb = WorkbookFactory.create(fis1);
Sheet sheet = wb.getSheet("Phone");
Row row = sheet.getRow(0);
String cell = row.getCell(1).toString()+randomInt;

wb.close();
WebDriver driver=null;
if(Browser.equalsIgnoreCase("chrome"))
{
driver=new ChromeDriver();
}
else if(Browser.equalsIgnoreCase("firefox"))
{
driver=new FirefoxDriver();
}
else if(Browser.equalsIgnoreCase("edge"))
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
driver.get(URL);

//wait
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//driver.findElement(By.xpath("//span[@class='custom-login']")).click();
driver.findElement(By.xpath("//input[@type='text']")).sendKeys(UN);
driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PWSRD);
driver.findElement(By.xpath("//input[@type='submit']")).click();
Thread.sleep(3000);
//driver.findElement(RelativeLocator.with((//a[text()='Organizations'])))
driver.findElement(By.xpath("(//a[text()='Organizations'and@href='index.php?module=Accounts&action=index'])")).click();
driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(organisation);
driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
WebElement org = driver.findElement(By.xpath("(//table[@align='center'])[5]//descendant::span[@class='dvHeaderText']"));
System.out.println("The organisation name is "+org.getText());

//assert organisation.contains("Qspider666"):"Assertion failed: organisation does not contain 'Success'";
System.out.println("Verification done for organisation");
Actions act=new Actions(driver);
WebElement icon = driver.findElement(By.xpath("//td[@class='small'and@align='right']/descendant::td[@class='small']/img[@src='themes/softed/images/user.PNG']"));
act.moveToElement(icon).build().perform();
driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

driver.quit();
}
	
}

