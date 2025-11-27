package Practice_data_driven_testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;
@Test
public class SampleUnitTestCheckProjectInBackend {
	
	Connection conn=null;
	public void projectCheckTest() throws SQLException
	{
		String Exp_browser_type="chrome";
		boolean flag=false;
		try {
		//Step1: Register the database driver
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		//Step2:Connect to data base
	 conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/my_database", "root","root3");
		System.out.println("===============Connection================");
		//Create SQL Statement
		
		Statement stat = conn.createStatement();
		
		//Step3:Execute select Quarry and get result
		
		ResultSet resultset = stat.executeQuery("select* from test_through_MYSQL");
	
		while (resultset.next())
		{
			String Act_browser_type = resultset.getString(4);
			System.out.println(Act_browser_type);
			if(Exp_browser_type.equals(Act_browser_type))
			{
				flag=true;
				System.out.println(Exp_browser_type +"is available==Pass");
			}
			
		}
		if(flag==false)
		{
			System.out.println(Exp_browser_type +"is not available==Fail");
			Assert.fail();
		}
		}
		catch(Exception e)
		{
			System.out.println("Handle exception");
		}
		finally {
		//Step4:close the connection
		conn.close();
		System.out.println("===close the connection===");
		}
	}
	}


