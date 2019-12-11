import java.io.*;
import java.sql.*;
import java.util.*;

public class DBcon {
	public static void main (String args[]) {
		String url ="jdbc:sqlserver://sqlserver.dmst.aueb.gr:1433;" + 
				"databaseName=DB56;user=G556;password=939wd5890;";
		Connection dbcon;
		Statement stmt;
		//ResultSet rs;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (java.lang.ClassNotFoundException e) {
			System.out.print("test: ");
			System.out.println(e.getMessage());
		}
		try {
			dbcon = DriverManager.getConnection(url);
			stmt = dbcon.createStatement();
			stmt.executeUpdate("CREATE TABLE BusyB " + 
					             "(empID INT not null," + 
					             "salary INT," +  
								"PRIMARY KEY  (empID));");
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		} 
	}
}
