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
	/*Some example variables.*/
	private int id;
	private int salary;
	
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
			stmt.executeUpdate("CREATE TABLE Department "
					            + "(depID INT not null,"
					            + "nameDep VARCHAR(20),"
					            + "PRIMARY KEY (depID));");
			stmt.executeUpdate("CREATE TABLE Employee "
								+ "(empID VARCHAR(20) not null,"
								+ "nameEmp VARCHAR(20),"
								+ "surname VARCHAR(20)"
								+ "phonenumber INT"
								+ "email VARCHAR(50)"
								+ "birthdate DATE"
								+ "PRIMARY KEY (empID));");
			//stmt.executeUpdate();
			//stmt.executeUpdate();
			//stmt.executeUpdate();
			//stmt.executeUpdate();
			//stmt.executeUpdate();
		/*Catch block if an exception occurs while making
		 *  the connection and executing the statement.*/
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		} 
		/*USED FOR TESTING ONLY.*/
		DBcon yes = new DBcon(312312, 6000);
		new DBcon(313424, 100000);
		DBcon ywdqnew = new DBcon(313424, 100000);
		DBcon yes2 = new DBcon(984312312, 6000);
		new DBcon(327545424, 100000);
		DBcon ywdqnedw = new DBcon(35213424, 100000);
		DBcon yes3 = new DBcon(5465312, 6000);
		new DBcon(313424, 100000);
		DBcon ywdqdnew = new DBcon(31423, 100000);
		System.out.println("testing done!!!");
		loadFromDB();
	}
	public DBcon (int id, int salary) {
		this.id = id;
		this.salary = salary;
		saveToDB(id, salary);
	}
	
	public static void saveToDB(int id, int salary) {
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
		/*Try block for making the DB connection and
		 *  executing the given statement.*/
		try {
			/*Makes the actual connection with the server.*/
			dbcon = DriverManager.getConnection(url);
			/*Creates the statement*/
			stmt = dbcon.createStatement();
			/*Executes the given statement that saves the object's.*/
			stmt.executeUpdate("INSERT INTO BusyB (empID, salary) VALUES (" + id + ", " + salary + ");");
			stmt.close();
			dbcon.close();
		/*Catch block if an exception occurs while making the connection and executing the statement.*/
		} catch (SQLException e) {
			//System.out.println("SQLException: " + e.getMessage());
		}
	}
	/*Method to load objects from DB*/
	public static void loadFromDB() {
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
			ResultSet rs;
			/*Makes the actual connection with the server.*/
			dbcon = DriverManager.getConnection(url);
			/*Creates the statement*/
			stmt = dbcon.createStatement();
			/*Executes the given statement that saves the object's.*/
			rs = stmt.executeQuery("SELECT empID, salary FROM BusyB");
			/*Does a loop for every row (object in this case) it finds.*/
			while (rs.next()) {
				int id = rs.getInt("empID");
				int salary = rs.getInt("salary");
				/*After we find the variables we call the constructor to make the object again.*/
				new DBcon(id, salary);
				System.out.println("testing 2 done!!!");
			}
			rs.close();
			stmt.close();
			dbcon.close();
		/*Catch block if an exception occurs while making the connection and executing the statement.*/
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}
}

