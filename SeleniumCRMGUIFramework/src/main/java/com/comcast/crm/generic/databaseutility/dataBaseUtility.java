package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class dataBaseUtility {
	Connection conn;
	public void getDBConnection(String url,String username,String password) throws SQLException {
		
	Driver driver=new Driver();
	try {
		DriverManager.registerDriver(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		
	}
		catch(Exception e) {
			
		}

			}
public void closeConnection() {
	try {
		conn.close();
		
	}
		catch(Exception e) {
			
		}	
	}
public ResultSet executeSelectQuery(String query)
{
	ResultSet result=null;
	try {
		Statement stat = conn.createStatement();
		 result = stat.executeQuery(query);
	
		
	}
	catch(Exception e) {
		
	}
	return result;	
}
public int executeNonSelectQuert(String query) {
	int result=0;
	try {
		Statement stat = conn.createStatement();
		result=stat.executeUpdate(query);
	}
catch(Exception e) {
		
	}
	
	
	return result;
	
}
public void getDBConnection() throws SQLException {
	Connection conn=null;
	
	try {
		Driver driveref=new Driver();
		DriverManager.registerDriver(driveref);
	 conn = DriverManager.getConnection("jdbc:Mysql://127.0.0./:3306/my_database","root","root"); 
		
	}
		catch(Exception e) {
			
		}


			}




} 
