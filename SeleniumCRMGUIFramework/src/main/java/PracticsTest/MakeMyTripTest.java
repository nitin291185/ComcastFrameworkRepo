package PracticsTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class MakeMyTripTest {
	String MonthAndYear="March 2026";
	int date=25;
	@Test
	public void MakeMyTrip() {
		
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(opt);

		// wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// maximize
		driver.manage().window().maximize();

		// URL

		driver.get("https://www.makemytrip.com/");	
		
		
		
		
		
	}
	
	
	

}
