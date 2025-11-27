package PracticsTest;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenLinksTest {

	@Test
	public void BrokenLinks() throws Exception, Exception {
		
		WebDriver driver = new ChromeDriver();

		// wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// maximize
		driver.manage().window().maximize();

		// URL

		driver.get("https://uidai.gov.in/en/");	
		
		//step-1
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		System.out.println(links.size());
		
		//step-2
		for(WebElement eachlink:links)
		{
			@Nullable
			String link = eachlink.getAttribute("href");
			URL url=new URI(link).toURL();
			HttpURLConnection conn=(HttpURLConnection) url.openConnection();
			int status_code = conn.getResponseCode();
			
			if(status_code>=400 && url!=null)
			{
				System.out.println(link +status_code + "Is Broken Link");
				
				System.out.println("--------------------------------------------------");
			}
			
			
			
			
			
			else {
				System.out.println(link +status_code + "Is not a Broken Link");
			}
			
			
		}
		
		
	}
	
	
	
}
