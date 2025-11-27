 package Practice_data_driven_testing;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SampleDataDrivenTestingThroughPropertyFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//get the java representation object of the physical file
		FileInputStream fis =new FileInputStream("C:\\Users\\Nitin Pant\\OneDrive\\Desktop\\commondata.properties");
		
		//using property class load all the key
		Properties pobj=new Properties();
		
		pobj.load(fis);
		//get the value based on key
		
		//get property
		System.out.println(pobj.getProperty("browser"));
		System.out.println(pobj.getProperty("url"));

	}

}
