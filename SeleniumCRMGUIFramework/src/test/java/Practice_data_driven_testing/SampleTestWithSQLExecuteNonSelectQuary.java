package Practice_data_driven_testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SampleTestWithSQLExecuteNonSelectQuary {

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
		
		int result = stat.executeUpdate("INSERT INTO test_through_MYSQL VALUES('admin','admin','http://49.249.28.218:8888','opera','Qspider_');");
	System.out.println(result);

		
		//close the connection
		conn.close();

}



	}


