/**
 * DBcon Class
 * Used for testing the Database connection.
 * 
 * @author Vasilis Xifaras
 */

/*Im not sure if we need that.*/
import java.io.*;
/*used to create the sql connection.*/
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class DBcon {
	/*URL of database with username and password.*/
	public static String url ="jdbc:sqlserver://sqlserver.dmst.aueb.gr:1433;" +
			"databaseName=DB56;user=G556;password=939wd5890;";
	/*Connection type object to make the connection.*/
	public static Connection dbcon;
	/*Statement type object that contains the statement we will send to the server.*/
	public static Statement stmt;

	//Method to create tables on the DB.
	public static void tableCreation() {
		/*Connection type object to make the connection.*/
		Connection dbcon = null;
		/*Statement type object that contains the statement we will send to the server.*/
		Statement stmt = null;
		/*Try block for trying to find the correct Driver to make the DB connection.*/
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			/*Makes the actual connection with the server.*/
			dbcon = DriverManager.getConnection(url);
			/*Creates the statement*/
			stmt = dbcon.createStatement();
			/*Executes the given statement.*/
			stmt.executeUpdate("CREATE TABLE BBMiddleManager "
				+ "(empID VARCHAR(20) not null,"
				+ "nameEmp VARCHAR(20),"
				+ "surname VARCHAR(20),"
				+ "phonenumber VARCHAR(15),"
				+ "email VARCHAR(50),"
				+ "birthdate DATE,"
				+ "PRIMARY KEY (empID));");
			System.out.println("TABLE BBMiddleManager CREATED"); 
			
			stmt.executeUpdate("CREATE TABLE BBDepartment "
			    + "(depID INT not null,"
		        + "nameDep VARCHAR(20),"
			    + "managerID VARCHAR (20),"
		        + "PRIMARY KEY (depID),"
			    + "FOREIGN KEY (managerID) REFERENCES BBMiddleManager);");
			System.out.println("TABLE BBDepartment CREATED"); 
			
			stmt.executeUpdate("CREATE TABLE BBBasicEmployee "
				+ "(empID VARCHAR(20) not null,"
				+ "nameEmp VARCHAR(20),"
				+ "surname VARCHAR(20),"
				+ "phonenumber VARCHAR(15),"
				+ "email VARCHAR(50),"
				+ "birthdate DATE,"
				+ "depID INT,"
			    + "PRIMARY KEY (empID),"
			    + "FOREIGN KEY (depID) REFERENCES BBDepartment );");
			System.out.println("TABLE BBBasicEmployee CREATED");
			
			stmt.executeUpdate("CREATE TABLE BBTopManager "
				+ "(empID VARCHAR(20) not null,"
				+ "nameEmp VARCHAR(20),"
				+ "surname VARCHAR(20),"
				+ "phonenumber VARCHAR(15),"
				+ "email VARCHAR(50),"
				+ "birthdate DATE,"
				+ "depID INT,"
			    + "PRIMARY KEY (empID));");
			System.out.println("TABLE BBTopManager CREATED"); 
			
			stmt.executeUpdate("CREATE TABLE BBAccount "
				+ "(empID VARCHAR(20) not null,"
				+ "password VARCHAR(20),"
				+ "hasDefaultPass INT,"
				+ "PRIMARY KEY(empID));");
			System.out.println("TABLE BBAccount CREATED"); 
			
			stmt.executeUpdate("CREATE TABLE BBTask "
				+ "(taskCode INT not null,"
				+ "startDate DATE not null,"
				+ "dueDate DATE not null, "
				+ "description VARCHAR(40) not null,"
				+ "parts INTEGER not null,"
				+ "importance INT not null,"
				+ "difficulty INT not null,"
				+ "empID VARCHAR(20) not null,"
				+ "PRIMARY KEY (taskCode),"
				+ "FOREIGN KEY (empID) REFERENCES BBAccount);");
			System.out.println("TABLE BBTask CREATED");
			
			stmt.executeUpdate("CREATE TABLE BBEvent "
				+ "(eventCode VARCHAR(15) not null,"
				+ "eventDate DATE not null,"
				+ "eventTime VARCHAR(13)not null,"
				+ "type INT,"
				+ "title VARCHAR(50),"
				+ "description VARCHAR(300),"
				+ "PRIMARY KEY (eventCode));");
			System.out.println("TABLE BBEvent CREATED");
			
			stmt.executeUpdate("CREATE TABLE BBEvaluation "
				+ "(taskID INT not null,"
				+ "empID VARCHAR(20) not null,"
				+ "evaluation REAL not null,"
				+ "PRIMARY KEY (taskID, empID),"
				+ "FOREIGN KEY (empID) REFERENCES BBAccount,"
				+ "FOREIGN KEY (taskID) REFERENCES BBTask);");
			System.out.println("TABLE BBEvaluation CREATED");
		/*Catch block if an exception occurs and the specified driver is not found.*/
		} catch (Exception e) {
			System.out.print("test23: ");
			System.out.println(e.getMessage());
		}
	}
	
	//Method to delete all tables from DB.
	public static void deleteTables() {
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
			stmt.executeUpdate("DROP TABLE BBEvaluation;");
			stmt.executeUpdate("DROP TABLE BBEvent;");
			stmt.executeUpdate("DROP TABLE BBTask;");
			stmt.executeUpdate("DROP TABLE BBAccount;");
			stmt.executeUpdate("DROP TABLE BBTopManager;");
			stmt.executeUpdate("DROP TABLE BBBasicEmployee;");
			stmt.executeUpdate("DROP TABLE BBDepartment;");
			stmt.executeUpdate("DROP TABLE BBMiddleManager;");
			System.out.println("SUCCESFULLY DELETED TABLES");
			stmt.close();
			dbcon.close();
		/*Catch block if an exception occurs while making the connection and executing the statement.*/
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}
	
	//Method to save Accounts to DB.
	public static void saveAccount(Account acc) {
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
			stmt.executeUpdate("INSERT INTO BBAccount (empID, password, hasDefaultPass) VALUES ('"
								+ acc.getEmployee().getId() + "', '" + acc.getPassword()+ "', " + acc.getHasDefaultPass() +");");
			stmt.close();
			dbcon.close();
		/*Catch block if an exception occurs while making the connection and executing the statement.*/
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}
	
	/*Method to load Accounts from DB*/
	public static void loadAccounts() {
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
			rs = stmt.executeQuery("SELECT empID, password, hasDefaultPass FROM BBAccount");
			/*Does a loop for every row (object in this case) it finds.*/
			while (rs.next()) {
				String id = rs.getString("empID");
				String password = rs.getString("password");
				int hasDefaultPass = rs.getInt("hasDefaultPass");
				/*After we find the variables we call the constructor to make the object again.*/
				new Account(id, password, hasDefaultPass);
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
			stmt.executeUpdate("INSERT INTO BBDepartment (depID, nameDep, managerID) VALUES "
								+ "(" + dep.getId() + ", '" + dep.getName() + "', null);");
			stmt.close();
			dbcon.close();
		/*Catch block if an exception occurs while making the connection and executing the statement.*/
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
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
			rs = stmt.executeQuery("SELECT depID, nameDep, managerID FROM BBDepartment");
			/*Does a loop for every row (object in this case) it finds.*/
			while (rs.next()) {
				int id = rs.getInt("depID");
				String name = rs.getString("nameDep");
				String managerID = rs.getString("managerID");
				/*After we find the variables we call the constructor to make the object again.*/
				new Department(name, id, managerID);
			}
			rs.close();
			stmt.close();
			dbcon.close();
		/*Catch block if an exception occurs while making the connection and executing the statement.*/
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}
	
	public static void updateDepartmentVar(String varName, String variable, int depId) {} //TODO !!!!
	
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
			stmt.executeUpdate("INSERT INTO BBBasicEmployee (name, surname, telephone, email, birthdate, dep_id, emp_id)"
					+ " VALUES (" + emp.getName() + ", " + emp.getSurname() + ", " + emp.getTelephone()
					+  ", " + emp.getEmail() + ", " + emp.getBirthDate()/*I dont think this will work. We have to change data type probably.*/ + ", " + emp.getDepId() + ", " + emp.getId() + ");");
			System.out.println("EXECUTED THE STATEMENT");
			stmt.close();
			dbcon.close();
		/*Catch block if an exception occurs while making the connection and executing the statement.*/
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("what?");
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
			rs = stmt.executeQuery("SELECT name, surname, telephone, email, birthdate, dep_id, emp_id FROM BBBasicEmployee");
			/*Does a loop for every row (object in this case) it finds.*/
			System.out.println("yeyey!!!!");
			while (rs.next()) {
				System.out.println("yeyeyy22");
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				String telephone = rs.getString("telephone");
				String email = rs.getString("email");
				java.sql.Date birthDate = rs.getDate("birthDate");
				int depId = rs.getInt("dep_id");
				String empId = rs.getString("emp_id");
				java.util.Date birthDateNew = birthDate;
				/*After we find the variables we call the constructor to make the object again.*/
				new BasicEmployee(name, surname, telephone, email, birthDateNew, depId, empId);
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

	public static void UpdateBasicEmpVar(String varName, String variable, int empid) {} //TODO!!!!

	public static void UpdateBasicEmpVar(String varName, int variable, int empId) {} //TODO!!!!

	public static void UpdateBasicEmpVar(String varName, java.util.Date variable, int empId) {} //TODO!!!!
	
	public static void saveMiddleManager(MiddleManager emp) {
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
			stmt.executeUpdate("INSERT INTO BBMiddleManager (name, surname, telephone, email, birthdate, empID)"
					+ " VALUES (" + emp.getName() + ", " + emp.getSurname() + ", " + emp.getTelephone()
					+ ", " + emp.getEmail() + ", " + emp.getBirthDate()/*I dont think this will work. We have to change data type probably.*/ 
					+ ", " + emp.getId() + ");");
			stmt.close();
			dbcon.close();
		/*Catch block if an exception occurs while making the connection and executing the statement.*/
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}
	
	public static void loadMiddleManagers() {
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
			rs = stmt.executeQuery("SELECT name, surname, telephone, email, birthdate, empID FROM BBMiddleManager");
			/*Does a loop for every row (object in this case) it finds.*/
			while (rs.next()) {
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				String telephone = rs.getString("telephone");
				String email = rs.getString("email");
				java.sql.Date birthDate = rs.getDate("birthDate");
				String empId = rs.getString("empID");
				java.util.Date birthDateNew = birthDate;
				/*After we find the variables we call the constructor to make the object again.*/
				new MiddleManager(name, surname, telephone, email, birthDateNew, empId);
				System.out.println("MiddleManager loading  done!!!");
			}
			rs.close();
			stmt.close();
			dbcon.close();
		/*Catch block if an exception occurs while making the connection and executing the statement.*/
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}
	
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
				stmt.executeUpdate("INSERT INTO BBEvaluation (taskID, empID, evaluation) VALUES (" + task.getTaskID() + ", " + task.getEmpID() + ", " + score + ");");
			} else {
				for (int i =0; i < task.getEmpIDs().size(); i++) {
					stmt.executeUpdate("INSERT INTO BBEvaluation (taskID, empID, evaluation) VALUES (" + task.getTaskID() + ", " + task.getEmpIDs().get(i) + ", " + score + ");");
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
