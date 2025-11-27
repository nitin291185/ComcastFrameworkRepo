package PracticsTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class KSRTC_Test {

	@Test
	
	public void KSRTC() {
		
		
		WebDriver driver=new ChromeDriver();
		
		//wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//maximize
		 driver.manage().window().maximize();
		 
		 
		 
		 //URL
		 
		 driver.get("https://ksrtc.in/");
		 //select departure
		 
		 driver.findElement(By.xpath("//select[@id='fromCity']"));
		 //select date
		 driver.findElement(By.xpath("//input[@id='departDate']")).click();
		 driver.findElement(By.xpath("//span[text()='November']/ancestor::div[@class='ui-datepicker-group ui-datepicker-group-first']/descendant::a[text()='27']")).click();
		
	}
}
