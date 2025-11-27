package PracticsTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class Redbus_task{
	

		
	
	@Test
	public void redbusTask() throws Throwable {
		
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.redbus.in/");
		
		FileInputStream fis=new FileInputStream("C:\\Users\\Nitin Pant\\OneDrive\\Desktop\\RedBus.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		 String src1 = wb.getSheet("DepartTodstn").getRow(0).getCell(0).getStringCellValue();
		 String src2 = wb.getSheet("DepartTodstn").getRow(1).getCell(0).getStringCellValue();
		 String src3 = wb.getSheet("DepartTodstn").getRow(2).getCell(0).getStringCellValue();
		 String dstn1 = wb.getSheet("DepartTodstn").getRow(0).getCell(1).getStringCellValue();
		 String dstn2 = wb.getSheet("DepartTodstn").getRow(1).getCell(1).getStringCellValue();
		 String dstn3 = wb.getSheet("DepartTodstn").getRow(2).getCell(1).getStringCellValue();
		 
		wb.close();
		fis.close();
		driver.get("https://www.redbus.in/");
		driver.findElement(By.xpath("//div[text()='From']")).click();
		driver.findElement(By.xpath("//input[@id='srcDest']")).sendKeys(src1);
		driver.findElement(By.xpath("//div[@role='heading']/following-sibling::div/div/div/div[@aria-label='Bangalore']")).click();
		
		driver.findElement(By.xpath("//div[text()='To']")).click();
		driver.findElement(By.xpath("//input[@id='dstn1']")).sendKeys(dstn1);
	}

}

