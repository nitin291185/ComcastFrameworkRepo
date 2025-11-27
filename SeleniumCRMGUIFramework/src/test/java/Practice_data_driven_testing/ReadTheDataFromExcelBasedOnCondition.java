package Practice_data_driven_testing;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadTheDataFromExcelBasedOnCondition {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String ExpectedTestID="TC_02";
		FileInputStream fis=new FileInputStream("C:\\Users\\Nitin Pant\\OneDrive\\Desktop\\Data for DDT\\Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet2");
		int rownumber = sheet.getLastRowNum();
		
		for(int i=0;i<=rownumber;i++)
		{
			Row row1 = sheet.getRow(i);
			Cell cell1data = row1.getCell(0);
			Cell cell2data = row1.getCell(1);
			System.out.println(cell1data+"\t"+cell2data);
		}
		
		
		
			
	
			
		wb.close();
		fis.close();

	}


	}


	