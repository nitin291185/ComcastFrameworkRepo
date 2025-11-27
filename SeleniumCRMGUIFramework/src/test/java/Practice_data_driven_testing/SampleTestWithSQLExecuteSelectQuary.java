package Practice_data_driven_testing;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

public class SampleTestWithSQLExecuteSelectQuary {

	public static void main(String[] args) throws SQLException {
		//Register the database driver
				Driver driverref=new Driver();
				DriverManager.registerDriver(driverref);
				
				//Connect to data base
				Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/my_database", "root","root");
				System.out.println("===============Connection================");
				//Create SQL Statement
				
				Statement stat = conn.createStatement();
				
				//Execute select Quarry and get result
				
				ResultSet resultset = stat.executeQuery("select* from test_through_MYSQL");
			
				while (resultset.next())
				{
					System.out.println(resultset.getString(1) +"\t" +resultset.getString(2)+"\t" +resultset.getString(3)+"\t" +resultset.getString(4)+"\t" +resultset.getString(5));
				}
				
				//close the connection
				conn.close();

	}

}
