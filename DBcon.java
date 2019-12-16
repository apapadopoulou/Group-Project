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
	/*URL of database with username and password.*/
	public static String url ="jdbc:sqlserver://sqlserver.dmst.aueb.gr:1433;" +
			"databaseName=DB56;user=G556;password=939wd5890;";
	/*Connection type object to make the connection.*/
	public static Connection dbcon;
	/*Statement type object that contains the statement we will send to the server.*/
	public static Statement stmt;

	public static void tableCreation() {
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
			stmt.executeUpdate("CREATE TABLE BasicEmployee "
				+ "(empID VARCHAR(20) not null,"
			    + "PRIMARY KEY (empID)"
			    + "FOREIGN KEY (empID) REFERENCES Employee );");
			stmt.executeUpdate("CREATE TABLE MiddleManager "
				+ "(empID VARCHAR(20) not null,"
				+ "PRIMARY KEY (empID)"
				+ "FOREIGN KEY (empID) REFERENCES Employee );");
			stmt.executeUpdate("CREATE TABLE TopManager "
			    + "(empID VARCHAR(20) not null,"
		        + "PRIMARY KEY (empID)"
		        + "FOREIGN KEY (empID) REFERENCES Employee );");
			stmt.executeUpdate("CREATE TABLE Account "
				+ "(empID VARCHAR(20) not null,"
				+ "email VARCHAR(50 UNIQUE)"
				+ "password VARCHAR(8)"
				+ "PRIMARY KEY(empID)"
				+ "FOREIGN KEY (empID) REFERENCES Employee"
				+ "FOREIGN KEY (email) REFERENCES Employee);");
			stmt.executeUpdate("CREATE TABLE Program "
				+ "(progDate VARCHAR(20) not null,"
				+ "PRIMARY KEY(progDate));");
			stmt.executeUpdate("CREATE TABLE Task "
				+ "(desc VARCHAR(20) not null,"
				+ "parts INT not null"
				+ "importance INT not null"
				+ "difficulty INT not null"
				+ "empID VARCHAR(20) not null"
				+ "id INT not null);");
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
	/*Method ti save objects to Database*/
	public static void saveToDB(int id, int salary) {
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
	/*Method to load objects from Database*/
	public static void loadFromDB() {
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

	public static void saveDepartment(Department dep) {
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
			stmt.executeUpdate("INSERT INTO BBDepartment (departmentID, name) VALUES (" + dep.getId() + ", " + dep.getName() + ");");
			stmt.close();
			dbcon.close();
		/*Catch block if an exception occurs while making the connection and executing the statement.*/
		} catch (SQLException e) {
			//System.out.println("SQLException: " + e.getMessage());
		}
	}

	/*Method to load Departments from DB*/
	public static void loadDepartments() {
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
			rs = stmt.executeQuery("SELECT departmentID, name FROM BBDepartment");
			/*Does a loop for every row (object in this case) it finds.*/
			while (rs.next()) {
				int id = rs.getInt("departmentID");
				String name = rs.getString("name");
				/*After we find the variables we call the constructor to make the object again.*/
				new Department(name, id);
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

	public static void saveBasicEmployee(BasicEmployee emp) {
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
			stmt.executeUpdate("INSERT INTO BBBasicEmployee (name, surname, telephone, email, birthdate, depID, empID)"
					+ " VALUES (" + emp.getName() + ", " + emp.getSurname() + ", " + emp.getTelephone()
					+  ", " + emp.getEmail() + ", " + emp.getBirthDate()/*I dont think this will work. We have to change data type probably.*/ + ", " + emp.getDepId() + ", " + emp.getId() + ");");
			stmt.close();
			dbcon.close();
		/*Catch block if an exception occurs while making the connection and executing the statement.*/
		} catch (SQLException e) {
			//System.out.println("SQLException: " + e.getMessage());
		}
	}

	public static void loadBasicEmployees() {
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
			rs = stmt.executeQuery("SELECT name, surname, telephone, email, birthdate, depID, empID FROM BBBasicEmployee");
			/*Does a loop for every row (object in this case) it finds.*/
			while (rs.next()) {
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				String telephone = rs.getString("telephone");
				String email = rs.getString("email");
				Date birthDate = rs.getDate("birthDate");
				int depId = rs.getInt("depID");
				String empId = rs.getString("empID");
				/*After we find the variables we call the constructor to make the object again.*/
				new BasicEmployee(name, surname, telephone, email, birtDate, depId, empId);
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

	public static void UpdateBasicEmpVar(String varName, String variable) {} //TODO!!!!

	public static void UpdateBasicEmpVar(String varName, int variable) {} //TODO!!!!

	public static void UpdateBasicEmpVar(String varName, Date variable) {} //TODO!!!!
	
	public static void saveEvaluation(Task task, double score) {
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
			if (!task.isGroupTask()) { //Checks if its a group task or not.
				/*Executes the given statement that saves the evaluation score and the employee's ID. */
				stmt.executeUpdate("INSERT INTO JEvaluations (taskID, empID, evaluation) VALUES (" + task.getTaskID() + ", " + task.getEmpID() + ", " + score + ");");
			} else {
				for (int i =0; i < task.getEmpIDs().size(); i++) {
					stmt.executeUpdate("INSERT INTO JEvaluations (taskID, empID, evaluation) VALUES (" + task.getTaskID() + ", " + task.getEmpIDs().get(i) + ", " + score + ");");
				}
			}
				
	
			stmt.close(); //Closes the Statement resource.
			dbcon.close(); //Closes the DataBase conenction resource.
		/*Catch block if an exception occurs while making the connection and executing the statement.*/
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}

	/*
	 *Method responsible for retrieving past evaluations of employee's performance on his tasks.
	 *Returns an ArrayLIst of type Double which contains all of an employee's previous evaluations. 
	 */
	public static ArrayList<Double> getEvalHistory(String id) {
		
		ArrayList<Double> evalHistory = new ArrayList<Double>(); //ArrayList to save previous evaluations.
		
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
			/*Executes the given query that returns the History of Evaluations for the particular BasicEmployee using his ID.*/
			rs = stmt.executeQuery("SELECT evaluation FROM JEvaluations WHERE empID=" + id );
			/*Does a loop for every row it finds.*/
			while (rs.next()) {
				double evaluation = rs.getDouble("evaluation");//Returns the evalutaion value from this row.
				evalHistory.add(evaluation);// Adds the evaluation value to the ArrayList.
				System.out.println("check if its correct!!");//Used for testing.
			}
			rs.close(); //Closes the ResultSet resource.
			stmt.close(); //Closes the Statement resource.
			dbcon.close(); //Closes the DataBase conenction resource.
		/*Catch block if an exception occurs while making the connection and executing the statement.*/
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
		return evalHistory; // Returns the ArrayList.
	}
}