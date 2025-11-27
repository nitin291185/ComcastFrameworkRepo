package PracticsTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class GoIbiboTest {

	
String MonthAndYear="March 2026";
	int date=25;
	@Test
	public void Goibibo() {

		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(opt);

		// wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// maximize
		driver.manage().window().maximize();

		// URL

		driver.get("https://www.goibibo.com/");
		
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		
		for(;;)
			try {
		driver.findElement(By.xpath("//div[text()='"+MonthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
		break;
			}
		catch (Exception e) {
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
	}

}
