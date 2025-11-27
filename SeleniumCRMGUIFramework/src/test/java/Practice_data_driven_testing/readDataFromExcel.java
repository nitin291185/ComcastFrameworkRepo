package Practice_data_driven_testing;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readDataFromExcel {

	public static void main(String[] args) throws Exception, IOException {
		//get the excel path location & java object of the physical excel  file 
		FileInputStream fis =new FileInputStream("C:\\Users\\Nitin Pant\\OneDrive\\Desktop\\Data for DDT\\Testdata.xlsx");
		
		//Open workbook to read mode
		 Workbook wb = WorkbookFactory.create(fis);
		
		
		//Get the control of mobile sheet
		Sheet sh = wb.getSheet("Phone");
		
		//Get the control of 1st row
		Row row = sh.getRow(0);
		
		//Get the control of 1st cell
		Cell cell = row.getCell(1);
		
		
	//read the value of the cell
		
		String data = cell.getStringCellValue();
		
		System.out.println(data);
		fis.close();
		wb.close();

		}


			
		

	}


