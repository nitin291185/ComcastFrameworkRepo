package amazonTC;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcleUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class getProductInfoTest {
@Test(dataProvider ="getData")
public void getProductInfoTestAmazon(String brand_name,String product_name) throws Throwable {
	
	
	FileUtility flib = new FileUtility();
	WebDriverUtility wlib = new WebDriverUtility();
	ExcleUtility elib=new ExcleUtility();
	
	/* Read common data from Property file */
	String browser = flib.getDataFromPropertyFile("browser");
	String url = flib.getDataFromPropertyFile("url1");
	brand_name=elib.getDataFromExcel("Amazon", 1, 0);
	product_name=elib.getDataFromExcel("Amazon", 1, 1);
	
	WebDriver driver = null;
	if (browser.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
	} else if (browser.equalsIgnoreCase("firefox")) {
		driver = new FirefoxDriver();
	} else if (browser.equalsIgnoreCase("edge")) {
		driver = new EdgeDriver();
	}

	else {
		driver = new ChromeDriver();
	}
	
	   // EnterURL
		driver.get(url);
	   // Maximize the browser
		wlib.Maximize(driver);

	     /* wait */
	    wlib.waitForPageToLoad(driver);
	    
	    driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brand_name,Keys.ENTER);
	    //Capture product info
	    
	    String x = "(//span[text()='"+product_name+"'])[2]/../../../../div[3]/div[1]/div/div/div/div/a/span/span[2]";
	    String price = driver.findElement(By.xpath(x)).getText();
	    System.out.println(price);
	    
	   	
}

@DataProvider
public Object[][] getData() throws Throwable {
	ExcleUtility elib = new ExcleUtility();
	int rowCount = elib.getRowCount("Amazon");
	
	Object[][] objArr=new Object[rowCount][2];
	for(int i=0;i<rowCount-1;i++)
	{
		objArr[i][0]=elib.getDataFromExcel("Amazon", i+1, 0);
		objArr[i][1]=elib.getDataFromExcel("Amazon", i+1, 1);
			
	}

	return objArr;
	
	
}



		    
	    
}

