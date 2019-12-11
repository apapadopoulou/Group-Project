/**
 * DBcon Class
 * Used for testing the Database connection.
 */
/*Im not sure if we need that.*/
import java.io.*;
/*used to create the sql connection.*/
import java.sql.*;
import java.util.*;

public class DBcon {
	public static void main (String args[]) {
		 
		 /*URL of database with username and password.*/
		String url ="jdbc:sqlserver://sqlserver.dmst.aueb.gr:1433;" + 
				"databaseName=DB56;user=G556;password=939wd5890;";
		/*Connection type object to make the connection.*/
		Connection dbcon;
		/*Statement type object that contains the statement we will send to the server.*/
		Statement stmt;
		/*Try block for trying to find the correct Driver to make the DB connection.*/
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		/*Catch block if an exception occurs and the specified driver is not found.*/
		} catch (java.lang.ClassNotFoundException e) {
			System.out.print("test: ");
			System.out.println(e.getMessage());
		}
		/*Try block for making the DB connection and executing the given statement.*/
		try {
			/*Makes the actual connection with the server.*/
			dbcon = DriverManager.getConnection(url);
			/*Creates the statement*/
			stmt = dbcon.createStatement();
			/*Executes the given statement.*/
			stmt.executeUpdate("CREATE TABLE BusyB " + 
					             "(empID INT not null," + 
					             "salary INT," +  
								"PRIMARY KEY  (empID));");
		/*Catch block if an exception occurs while making the connection and executing the statement.*/
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		} 
	}
}
