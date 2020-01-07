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
	/* URL of database with username and password. */
	public static String url = "jdbc:sqlserver://195.251.249.161:1433;"
			+ "databaseName=DB56;user=G556;password=939wd5890;";
	/* Connection type object to make the connection. */
	public static Connection dbcon;
	/*
	 * Statement type object that contains the statement we will send to the server.
	 */
	public static Statement stmt;

	public static void createTables() {
		/* Connection type object to make the connection. */
		Connection dbcon = null;
		/*
		 * Statement type object that contains the statement we will send to the server.
		 */
		Statement stmt = null;
		/* Try block for trying to find the correct Driver to make the DB connection. */
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			/* Makes the actual connection with the server. */
			dbcon = DriverManager.getConnection(url);
			/* Creates the statement */
			stmt = dbcon.createStatement();
			/* Executes the given statement. */
			stmt.executeUpdate("CREATE TABLE BBMiddleManager " 
					+ "(empID VARCHAR(20) not null," 
					+ "nameEmp VARCHAR(20),"
					+ "surname VARCHAR(20)," 
					+ "phonenumber VARCHAR(15),"
					+ "email VARCHAR(50),"
					+ "birthdate VARCHAR(30)," 
					+ "salary REAL," 
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
					+ "birthdate VARCHAR(30),"
					+ "depID INT,"
					+ "salary REAL," 
					+ "PRIMARY KEY (empID),"
					+ "FOREIGN KEY (depID) REFERENCES BBDepartment );");
			System.out.println("TABLE BBBasicEmployee CREATED");

			stmt.executeUpdate("CREATE TABLE BBTopManager " 
					+ "(empID VARCHAR(20) not null," 
					+ "nameEmp VARCHAR(20),"
					+ "surname VARCHAR(20)," 
					+ "phonenumber VARCHAR(15)," 
					+ "email VARCHAR(50),"
					+ "birthdate VARCHAR(30)," 
					+ "salary REAL," 
					+ "PRIMARY KEY (empID));");
			System.out.println("TABLE BBTopManager CREATED");

			stmt.executeUpdate("CREATE TABLE BBAccount "
					+ "(empID VARCHAR(20) not null," 
					+ "password VARCHAR(20),"
					+ "hasDefaultPass INT," 
					+ "PRIMARY KEY(empID));");
			System.out.println("TABLE BBAccount CREATED");

			stmt.executeUpdate("CREATE TABLE BBTask " 
					+ "(taskID INT not null," 
					+ "startDate VARCHAR(20) not null,"
					+ "dueDate VARCHAR(20) not null, " 
					+ "completionDate VARCHAR(20), "
					+ "description VARCHAR(100) not null,"
					+ "importance INT not null," 
					+ "difficulty INT not null,"
					+ "PRIMARY KEY (taskID));");
			System.out.println("TABLE BBTask CREATED");

			stmt.executeUpdate("CREATE TABLE BBEvent " 
					+ "(eventID VARCHAR(15) not null," 
					+ "eventDate DATE not null,"
					+ "eventTime VARCHAR(13)not null," 
					+ "type INT," 
					+ "title VARCHAR(50),"
					+ "description VARCHAR(300),"
					+ "PRIMARY KEY (eventID));");
			System.out.println("TABLE BBEvent CREATED");

			stmt.executeUpdate("CREATE TABLE BBEvaluation "
					+ "(taskID INT not null, " 
					+ "empID VARCHAR(20) not null, "
					+ "evaluation REAL not null, " 
					+ "PRIMARY KEY (taskID, empID), "
					+ "FOREIGN KEY (empID) REFERENCES BBAccount," 
					+ "FOREIGN KEY (taskID) REFERENCES BBTask);");
			System.out.println("TABLE BBEvaluation CREATED");

			stmt.executeUpdate("CREATE TABLE BBAssignedToTask " 
					+ "(taskID INT not null, "
					+ "empID VARCHAR(20) not null, "
					+ "evaluation REAL, "
					+ "PRIMARY KEY (taskID, empID), "
					+ "FOREIGN KEY (empID) REFERENCES BBAccount,"
					+ "FOREIGN KEY (taskID) "
					+ "REFERENCES BBTask);");
			System.out.println("TABLE BBAssignedToTask CREATED");
			/* Catch block if an exception occurs and the specified driver is not found. */
		} catch (Exception e) {
			System.out.print("SQLExcpetion: ");
			System.out.println(e.getMessage());
		}
	}

	// Method to delete all tables from DB.
	public static void deleteTables() {
		/* Try block for trying to find the correct Driver to make the DB connection. */
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			/* Catch block if an exception occurs and the specified driver is not found. */
		} catch (java.lang.ClassNotFoundException e) {
			System.out.print("test: ");
			System.out.println(e.getMessage());
		}
		/*
		 * Try block for making the DB connection and executing the given statement.
		 */
		try {
			/* Makes the actual connection with the server. */
			dbcon = DriverManager.getConnection(url);
			/* Creates the statement */
			stmt = dbcon.createStatement();
			/* Executes the given statement that saves the object's. */
			stmt.executeUpdate("DROP TABLE BBAssignedToTask;");
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
			/*
			 * Catch block if an exception occurs while making the connection and executing
			 * the statement.
			 */
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}

	public static void loadData() {
		DBcon.loadDepartments();
		System.out.println("Succesfully Loaded Departments.");
		DBcon.loadBasicEmployees();
		System.out.println("Succesfully Loaded Basic Employees.");
		DBcon.loadMiddleManagers();
		System.out.println("Succesfully Loaded Middle Managers.");
		DBcon.loadTopManagers();
		System.out.println("Succesfully Loaded Top Managers.");
		DBcon.loadAccounts();
		System.out.println("Succesfully Loaded Accounts.");
		DBcon.loadTasks();
		System.out.println("Succesfully Loaded Tasks.");
	}

	// Method to save Accounts to DB.
	public static void saveAccount(Account acc) {
		/* Try block for trying to find the correct Driver to make the DB connection. */
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			/* Catch block if an exception occurs and the specified driver is not found. */
		} catch (java.lang.ClassNotFoundException e) {
			System.out.print("test: ");
			System.out.println(e.getMessage());
		}
		/*
		 * Try block for making the DB connection and executing the given statement.
		 */
		try {
			/* Makes the actual connection with the server. */
			dbcon = DriverManager.getConnection(url);
			/* Creates the statement */
			stmt = dbcon.createStatement();
			/* Executes the given statement that saves the object's. */
			stmt.executeUpdate("INSERT INTO BBAccount (empID, password, hasDefaultPass) VALUES ('"
					+ acc.getEmployee().getID() + "', '" + acc.getPassword() + "', " + acc.getHasDefaultPass() + ");");
			stmt.close();
			dbcon.close();
			/*
			 * Catch block if an exception occurs while making the connection and executing
			 * the statement.
			 */
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}

	/* Method to load Accounts from DB */
	public static void loadAccounts() {
		/* Try block for trying to find the correct Driver to make the DB connection. */
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			/* Catch block if an exception occurs and the specified driver is not found. */
		} catch (java.lang.ClassNotFoundException e) {
			System.out.print("test: ");
			System.out.println(e.getMessage());
		}
		/* Try block for making the DB connection and executing the given statement. */
		try {
			ResultSet rs;
			/* Makes the actual connection with the server. */
			dbcon = DriverManager.getConnection(url);
			/* Creates the statement */
			stmt = dbcon.createStatement();
			/* Executes the given statement that saves the object's. */
			rs = stmt.executeQuery("SELECT empID, password, hasDefaultPass FROM BBAccount");
			/* Does a loop for every row (object in this case) it finds. */
			while (rs.next()) {
				String id = rs.getString("empID");
				String password = rs.getString("password");
				int hasDefaultPass = rs.getInt("hasDefaultPass");
				/*
				 * After we find the variables we call the constructor to make the object again.
				 */
				Account acc = new Account(id, password, hasDefaultPass);
			}
			rs.close();
			stmt.close();
			dbcon.close();
			/*
			 * Catch block if an exception occurs while making the connection and executing
			 * the statement.
			 */
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}

	public static void saveDepartment(Department dep) {
		/* Try block for trying to find the correct Driver to make the DB connection. */
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			/* Catch block if an exception occurs and the specified driver is not found. */
		} catch (java.lang.ClassNotFoundException e) {
			System.out.print("test: ");
			System.out.println(e.getMessage());
		}
		/*
		 * Try block for making the DB connection and executing the given statement.
		 */
		try {
			/* Makes the actual connection with the server. */
			dbcon = DriverManager.getConnection(url);
			/* Creates the statement */
			stmt = dbcon.createStatement();
			/* Executes the given statement that saves the object's. */
			stmt.executeUpdate("INSERT INTO BBDepartment (depID, nameDep, managerID) VALUES " + "(" + dep.getId()
					+ ", '" + dep.getName() + "', null);");
			stmt.close();
			dbcon.close();
			/*
			 * Catch block if an exception occurs while making the connection and executing
			 * the statement.
			 */
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}

	/* Method to load Departments from DB */
	public static void loadDepartments() {
		/* Try block for trying to find the correct Driver to make the DB connection. */
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			/* Catch block if an exception occurs and the specified driver is not found. */
		} catch (java.lang.ClassNotFoundException e) {
			System.out.print("test: ");
			System.out.println(e.getMessage());
		}
		/* Try block for making the DB connection and executing the given statement. */
		try {
			ResultSet rs;
			/* Makes the actual connection with the server. */
			dbcon = DriverManager.getConnection(url);
			/* Creates the statement */
			stmt = dbcon.createStatement();
			/* Executes the given statement that saves the object's. */
			rs = stmt.executeQuery("SELECT depID, nameDep, managerID FROM BBDepartment");
			/* Does a loop for every row (object in this case) it finds. */
			while (rs.next()) {
				int id = rs.getInt("depID");
				String name = rs.getString("nameDep");
				String managerID = rs.getString("managerID");
				/*
				 * After we find the variables we call the constructor to make the object again.
				 */
				Department dep = new Department(name, id, managerID);
			}
			rs.close();
			stmt.close();
			dbcon.close();
			/*
			 * Catch block if an exception occurs while making the connection and executing
			 * the statement.
			 */
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}

	public static void updateDepartmentVar(String varName, String variable, int depId) {
		Connection dbcon;
		Statement stmt;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (java.lang.ClassNotFoundException e) {
			System.out.print("test: ");
			System.out.println(e.getMessage());
		}
		try {
			dbcon = DriverManager.getConnection(url);
			stmt = dbcon.createStatement();
			stmt.executeUpdate(
					"UPDATE BBDepartment SET " + varName + " = '" + variable + "' WHERE depID = " + depId + ";");
			stmt.close(); // Closes the Statement resource
			dbcon.close(); // Closes the DataBase conenction resource.
			/*
			 * Catch block if an exception occurs while making the connection and executing
			 * the statement.
			 */
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}

	public static void saveBasicEmployee(BasicEmployee emp) {
		/* Try block for trying to find the correct Driver to make the DB connection. */
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			/* Catch block if an exception occurs and the specified driver is not found. */
		} catch (java.lang.ClassNotFoundException e) {
			System.out.print("test: ");
			System.out.println(e.getMessage());
		}
		/*
		 * Try block for making the DB connection and executing the given statement.
		 */
		try {
			/* Makes the actual connection with the server. */
			dbcon = DriverManager.getConnection(url);
			/* Creates the statement */
			stmt = dbcon.createStatement();
			/* Executes the given statement that saves the object's. */
			stmt.executeUpdate(
					"INSERT INTO BBBasicEmployee (nameEmp, surname, phonenumber, email, birthdate, depID, empID, salary)"
							+ " VALUES ('" + emp.getName() + "', '" + emp.getSurname() + "', '" + emp.getPhonenumber()
							+ "', '" + emp.getEmail() + "', '" + emp.getBirthDate() + "', " + emp.getDepId() + ", '"
							+ emp.getID() + "', " + emp.getSalary() + ");");
			stmt.close();
			dbcon.close();
			/*
			 * Catch block if an exception occurs while making the connection and executing
			 * the statement.
			 */
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}

	public static void loadBasicEmployees() {
		/* Try block for trying to find the correct Driver to make the DB connection. */
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			/* Catch block if an exception occurs and the specified driver is not found. */
		} catch (java.lang.ClassNotFoundException e) {
			System.out.print("test: ");
			System.out.println(e.getMessage());
		}
		/* Try block for making the DB connection and executing the given statement. */
		try {
			ResultSet rs;
			/* Makes the actual connection with the server. */
			dbcon = DriverManager.getConnection(url);
			/* Creates the statement */
			stmt = dbcon.createStatement();
			/* Executes the given statement that saves the object's. */
			rs = stmt.executeQuery(
					"SELECT nameEmp, surname, phonenumber, email, birthdate, depID, empID, salary FROM BBBasicEmployee");
			/* Does a loop for every row (object in this case) it finds. */
			while (rs.next()) {
				String name = rs.getString("nameEmp");
				String surname = rs.getString("surname");
				String telephone = rs.getString("phonenumber");
				String email = rs.getString("email");
				String birthDate = rs.getString("birthDate");
				int depId = rs.getInt("depID");
				String empId = rs.getString("empID");
				double salary = rs.getDouble("salary");
				/*
				 * After we find the variables we call the constructor to make the object again.
				 */
				Employee emp = new BasicEmployee(name, surname, telephone, email, birthDate, depId, empId, salary);
			}
			rs.close();
			stmt.close();
			dbcon.close();
			/*
			 * Catch block if an exception occurs while making the connection and executing
			 * the statement.
			 */
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}

	public static void updateEmployeeVar(String tableName, String varName, String var, String id) {
		Connection dbcon;
		Statement stmt;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (java.lang.ClassNotFoundException e) {
			System.out.print("test: ");
			System.out.println(e.getMessage());
		}
		try {
			dbcon = DriverManager.getConnection(url);
			stmt = dbcon.createStatement();
			stmt.executeUpdate(
					"UPDATE BB" + tableName + " SET " + varName + " = '" + var + "' WHERE empID = '" + id + "';");
			stmt.close(); // Closes the Statement resource
			dbcon.close(); // Closes the DataBase conenction resource.
			/*
			 * Catch block if an exception occurs while making the connection and executing
			 * the statement.
			 */
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}

	public static void updateEmployeeVar(String tableName, String varName, double var, String id) {
		Connection dbcon;
		Statement stmt;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (java.lang.ClassNotFoundException e) {
			System.out.print("test: ");
			System.out.println(e.getMessage());
		}
		try {
			dbcon = DriverManager.getConnection(url);
			stmt = dbcon.createStatement();
			stmt.executeUpdate(
					"UPDATE BB" + tableName + " SET " + varName + " = " + var + " WHERE empID = '" + id + "';");
			stmt.close(); // Closes the Statement resource
			dbcon.close(); // Closes the DataBase conenction resource.
			/*
			 * Catch block if an exception occurs while making the connection and executing
			 * the statement.
			 */
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}

	public static void updateBasicEmpVar(String varName, java.util.Date variable, int empId) {
	} // TODO!!!!

	public static void saveMiddleManager(MiddleManager emp) {
		/* Try block for trying to find the correct Driver to make the DB connection. */
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			/* Catch block if an exception occurs and the specified driver is not found. */
		} catch (java.lang.ClassNotFoundException e) {
			System.out.print("test: ");
			System.out.println(e.getMessage());
		}
		/*
		 * Try block for making the DB connection and executing the given statement.
		 */
		try {
			/* Makes the actual connection with the server. */
			dbcon = DriverManager.getConnection(url);
			/* Creates the statement */
			stmt = dbcon.createStatement();
			/* Executes the given statement that saves the object's. */
			stmt.executeUpdate(
					"INSERT INTO BBMiddleManager (nameEmp, surname, phonenumber, email, birthdate, empID, salary)"
							+ " VALUES ('" + emp.getName() + "','" + emp.getSurname() + "', '" + emp.getPhonenumber()
							+ "', '" + emp.getEmail() + "', '" + emp.getBirthDate() + "', '" + emp.getID() + "', "
							+ emp.getSalary() + ");");
			stmt.close();
			dbcon.close();
			/*
			 * Catch block if an exception occurs while making the connection and executing
			 * the statement.
			 */
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}

	public static void loadMiddleManagers() {
		/* Try block for trying to find the correct Driver to make the DB connection. */
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			/* Catch block if an exception occurs and the specified driver is not found. */
		} catch (java.lang.ClassNotFoundException e) {
			System.out.print("test: ");
			System.out.println(e.getMessage());
		}
		/* Try block for making the DB connection and executing the given statement. */
		try {
			ResultSet rs;
			/* Makes the actual connection with the server. */
			dbcon = DriverManager.getConnection(url);
			/* Creates the statement */
			stmt = dbcon.createStatement();
			/* Executes the given statement that saves the object's. */
			rs = stmt.executeQuery(
					"SELECT nameEmp, surname, phonenumber, email, birthdate, empID, salary FROM BBMiddleManager");
			/* Does a loop for every row (object in this case) it finds. */
			while (rs.next()) {
				String name = rs.getString("nameEmp");
				String surname = rs.getString("surname");
				String telephone = rs.getString("phonenumber");
				String email = rs.getString("email");
				String birthDate = rs.getString("birthDate");
				String empId = rs.getString("empID");
				double salary = rs.getDouble("salary");
				/*
				 * After we find the variables we call the constructor to make the object again.
				 */
				Employee emp = new MiddleManager(name, surname, telephone, email, birthDate, empId, salary);
			}
			rs.close();
			stmt.close();
			dbcon.close();
			/*
			 * Catch block if an exception occurs while making the connection and executing
			 * the statement.
			 */
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}

	public static void saveTopManager(TopManager emp) {
		/* Try block for trying to find the correct Driver to make the DB connection. */
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			/* Catch block if an exception occurs and the specified driver is not found. */
		} catch (java.lang.ClassNotFoundException e) {
			System.out.print("test: ");
			System.out.println(e.getMessage());
		}
		/*
		 * Try block for making the DB connection and executing the given statement.
		 */
		try {
			/* Makes the actual connection with the server. */
			dbcon = DriverManager.getConnection(url);
			/* Creates the statement */
			stmt = dbcon.createStatement();
			/* Executes the given statement that saves the object's. */
			stmt.executeUpdate(
					"INSERT INTO BBTopManager (nameEmp, surname, phonenumber, email, birthdate, empID, salary)"
							+ " VALUES ('" + emp.getName() + "', '" + emp.getSurname() + "', '" + emp.getPhonenumber()
							+ "', '" + emp.getEmail() + "', '" + emp.getBirthDate() + "', '" + emp.getID() + "', "
							+ emp.getSalary() + ");");
			stmt.close();
			dbcon.close();
			/*
			 * Catch block if an exception occurs while making the connection and executing
			 * the statement.
			 */
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}

	public static void loadTopManagers() {
		/* Try block for trying to find the correct Driver to make the DB connection. */
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			/* Catch block if an exception occurs and the specified driver is not found. */
		} catch (java.lang.ClassNotFoundException e) {
			System.out.print("test: ");
			System.out.println(e.getMessage());
		}
		/* Try block for making the DB connection and executing the given statement. */
		try {
			ResultSet rs;
			/* Makes the actual connection with the server. */
			dbcon = DriverManager.getConnection(url);
			/* Creates the statement */
			stmt = dbcon.createStatement();
			/* Executes the given statement that saves the object's. */
			rs = stmt.executeQuery(
					"SELECT nameEmp, surname, phonenumber, email, birthdate, empID, salary FROM BBTopManager");
			/* Does a loop for every row (object in this case) it finds. */
			while (rs.next()) {
				String name = rs.getString("nameEmp");
				String surname = rs.getString("surname");
				String telephone = rs.getString("phonenumber");
				String email = rs.getString("email");
				String birthDate = rs.getString("birthDate");
				String empId = rs.getString("empID");
				double salary = rs.getDouble("salary");
				/*
				 * After we find the variables we call the constructor to make the object again.
				 */
				Employee emp = new TopManager(name, surname, telephone, email, birthDate, empId, salary);
			}
			rs.close();
			stmt.close();
			dbcon.close();
			/*
			 * Catch block if an exception occurs while making the connection and executing
			 * the statement.
			 */
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}

	public static void saveEvaluation(int taskID, String empID, double score) {
		/* Connection type object to make the connection. */
		Connection dbcon;
		/*
		 * Statement type object that contains the statement we will send to the server.
		 */
		Statement stmt;
		/* Try block for trying to find the correct Driver to make the DB connection. */
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			/* Catch block if an exception occurs and the specified driver is not found. */
		} catch (java.lang.ClassNotFoundException e) {
			System.out.print("test: ");
			System.out.println(e.getMessage());
		}
		/* Try block for making the DB connection and executing the given statement. */
		try {
			/* Makes the actual connection with the server. */
			dbcon = DriverManager.getConnection(url);
			/* Creates the statement */
			stmt = dbcon.createStatement();
			stmt.executeUpdate("INSERT INTO BBEvaluation (taskID, empID, evaluation) VALUES (" + taskID + ", " + empID
					+ ", " + score + ");");
			stmt.close(); // Closes the Statement resource.
			dbcon.close(); // Closes the DataBase conenction resource.
			/*
			 * Catch block if an exception occurs while making the connection and executing
			 * the statement.
			 */
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}

	/*
	 * Method responsible for retrieving past evaluations of employee's performance
	 * on his tasks. Returns an ArrayLIst of type Double which contains all of an
	 * employee's previous evaluations.
	 */
	public static double getEvalAverage(String id) {
		double evalAverage = 0.0;
		/* Connection type object to make the connection. */
		Connection dbcon;
		/*
		 * Statement type object that contains the statement we will send to the server.
		 */
		Statement stmt;
		/* Try block for trying to find the correct Driver to make the DB connection. */
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			/* Catch block if an exception occurs and the specified driver is not found. */
		} catch (java.lang.ClassNotFoundException e) {
			System.out.print("test: ");
			System.out.println(e.getMessage());
		}
		/* Try block for making the DB connection and executing the given statement. */
		try {
			ResultSet rs;
			/* Makes the actual connection with the server. */
			dbcon = DriverManager.getConnection(url);
			/* Creates the statement */
			stmt = dbcon.createStatement();
			/*
			 * Executes the given query that returns the History of Evaluations for the
			 * particular BasicEmployee using his ID.
			 */
			rs = stmt.executeQuery("SELECT AVG(evaluation) AS avg FROM BBEvaluation WHERE empID=" + id);
			/* Does a loop for every row it finds. */
			while (rs.next()) {
				evalAverage = rs.getDouble("avg");// Returns the evalutaion value from this row.
			}
			rs.close(); // Closes the ResultSet resource.
			stmt.close(); // Closes the Statement resource.
			dbcon.close(); // Closes the DataBase conenction resource.
			/*
			 * Catch block if an exception occurs while making the connection and executing
			 * the statement.
			 */
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
		// Returns the evaluation average.
		return evalAverage;
	}

	public static void saveTask(Task task) {
		/* Connection type object to make the connection. */
		Connection dbcon;
		/*
		 * Statement type object that contains the statement we will send to the server.
		 */
		Statement stmt;
		/* Try block for trying to find the correct Driver to make the DB connection. */
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			/* Catch block if an exception occurs and the specified driver is not found. */
		} catch (java.lang.ClassNotFoundException e) {
			System.out.print("test: ");
			System.out.println(e.getMessage());
		}
		/* Try block for making the DB connection and executing the given statement. */
		try {
			/* Makes the actual connection with the server. */
			dbcon = DriverManager.getConnection(url);
			/* Creates the statement */
			stmt = dbcon.createStatement();
			stmt.executeUpdate(
					"INSERT INTO BBTask (taskID, startDate, dueDate, completionDate, description, importance, difficulty) VALUES ('"
							+ task.getTaskID() + "', '" + task.getStartDate() + "', '" + task.getDueDate() + "', '"
							+ task.getCompletionDate() + "', '" + task.getDesc() + "', " + task.getImportance() + ", "
							+ task.getDifficulty() + ");");
			stmt.close(); // Closes the Statement resource.
			dbcon.close(); // Closes the DataBase conenction resource.
			/*
			 * Catch block if an exception occurs while making the connection and executing
			 * the statement.
			 */
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}

	public static void loadTasks() {
		/* Try block for trying to find the correct Driver to make the DB connection. */
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			/* Catch block if an exception occurs and the specified driver is not found. */
		} catch (java.lang.ClassNotFoundException e) {
			System.out.print("test: ");
			System.out.println(e.getMessage());
		}
		/* Try block for making the DB connection and executing the given statement. */
		try {
			ResultSet rs;
			/* Makes the actual connection with the server. */
			dbcon = DriverManager.getConnection(url);
			/* Creates the statement */
			stmt = dbcon.createStatement();
			/* Executes the given statement that saves the object's. */
			rs = stmt.executeQuery(
					"SELECT taskID, startDate, dueDate, completionDate, description, importance, difficulty FROM BBTask");
			/* Does a loop for every row (object in this case) it finds. */
			while (rs.next()) {
				int taskID = rs.getInt("taskID");
				String startDate = rs.getString("startDate");
				String dueDate = rs.getString("dueDate");
				String completionDate = rs.getString("completionDate");
				String desc = rs.getString("description");
				int importance = rs.getInt("importance");
				int difficulty = rs.getInt("difficulty");
				ArrayList<String> empids = loadAssignedToTask(taskID);
				if (empids.size() == 1) {
					Task task = new Task(taskID, startDate, dueDate, completionDate, desc, importance, difficulty,
							empids.get(0));
				} else {
					Task task = new Task(taskID, startDate, dueDate, completionDate, desc, importance, difficulty,
							empids);
				}
			}
			rs.close();
			stmt.close();
			dbcon.close();
			/*
			 * Catch block if an exception occurs while making the connection and executing
			 * the statement.
			 */
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}

	public static void AssignToTask(int id, String empID) {
		/* Connection type object to make the connection. */
		Connection dbcon;
		/*
		 * Statement type object that contains the statement we will send to the server.
		 */
		Statement stmt;
		/* Try block for trying to find the correct Driver to make the DB connection. */
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			/* Catch block if an exception occurs and the specified driver is not found. */
		} catch (java.lang.ClassNotFoundException e) {
			System.out.print("test: ");
			System.out.println(e.getMessage());
		}
		/* Try block for making the DB connection and executing the given statement. */
		try {
			/* Makes the actual connection with the server. */
			dbcon = DriverManager.getConnection(url);
			/* Creates the statement */
			stmt = dbcon.createStatement();
			stmt.executeUpdate("INSERT INTO BBAssignedToTask (taskID, empID) VALUES (" + id + ", '" + empID + "');");
			stmt.close(); // Closes the Statement resource.
			dbcon.close(); // Closes the DataBase conenction resource.
			/*
			 * Catch block if an exception occurs while making the connection and executing
			 * the statement.
			 */
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}

	public static ArrayList<String> loadAssignedToTask(int taskID) {
		ArrayList<String> empIds = new ArrayList<String>();
		/* Try block for trying to find the correct Driver to make the DB connection. */
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			/* Catch block if an exception occurs and the specified driver is not found. */
		} catch (java.lang.ClassNotFoundException e) {
			System.out.print("test: ");
			System.out.println(e.getMessage());
		}
		/* Try block for making the DB connection and executing the given statement. */
		try {
			ResultSet rs;
			/* Makes the actual connection with the server. */
			dbcon = DriverManager.getConnection(url);
			/* Creates the statement */
			stmt = dbcon.createStatement();
			/* Executes the given statement that saves the object's. */
			rs = stmt.executeQuery("SELECT empID FROM BBAssignedToTask WHERE taskID = " + taskID);
			/* Does a loop for every row (object in this case) it finds. */
			while (rs.next()) {
				empIds.add(rs.getString("empID"));
			}
			rs.close();
			stmt.close();
			dbcon.close();
			/*
			 * Catch block if an exception occurs while making the connection and executing
			 * the statement.
			 */
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
		return empIds;
	}

	public static void saveEvent(Event event) {
		/* Connection type object to make the connection. */
		Connection dbcon;
		/*
		 * Statement type object that contains the statement we will send to the server.
		 */
		Statement stmt;
		/* Try block for trying to find the correct Driver to make the DB connection. */
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			/* Catch block if an exception occurs and the specified driver is not found. */
		} catch (java.lang.ClassNotFoundException e) {
			System.out.print("test: ");
			System.out.println(e.getMessage());
		}
		/* Try block for making the DB connection and executing the given statement. */
		try {
			/* Makes the actual connection with the server. */
			dbcon = DriverManager.getConnection(url);
			/* Creates the statement */
			stmt = dbcon.createStatement();
			stmt.executeUpdate("INSERT INTO BBEvent (EventID, title, eventDate, eventTime, description, type) VALUES ("
					+ event.getEventID() + ", '" + event.getTitle() + "', '" + event.getEventDate() + "', '"
					+ event.getEventTime() + "', '" + event.getDesc() + "', " + event.getType() + ");");
			stmt.close(); // Closes the Statement resource.
			dbcon.close(); // Closes the DataBase conenction resource.
			/*
			 * Catch block if an exception occurs while making the connection and executing
			 * the statement.
			 */
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}

	public static void updateTaskVar(String varName, String var, int id) {
		Connection dbcon;
		Statement stmt;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (java.lang.ClassNotFoundException e) {
			System.out.print("test: ");
			System.out.println(e.getMessage());
		}
		try {
			dbcon = DriverManager.getConnection(url);
			stmt = dbcon.createStatement();
			stmt.executeUpdate("UPDATE BBTask SET " + varName + " = '" + var + "' WHERE TaskID = " + id + ";");
			stmt.close(); // Closes the Statement resource
			dbcon.close(); // Closes the DataBase conenction resource.
			/*
			 * Catch block if an exception occurs while making the connection and executing
			 * the statement.
			 */
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}

	public static void updateTaskVar(String varName, int var, int id) {
		Connection dbcon;
		Statement stmt;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (java.lang.ClassNotFoundException e) {
			System.out.print("test: ");
			System.out.println(e.getMessage());
		}
		try {
			dbcon = DriverManager.getConnection(url);
			stmt = dbcon.createStatement();
			stmt.executeUpdate("UPDATE BBTask SET " + varName + " = '" + var + "' WHERE TaskID = " + id + ";");
			stmt.close(); // Closes the Statement resource
			dbcon.close(); // Closes the DataBase conenction resource.
			/*
			 * Catch block if an exception occurs while making the connection and executing
			 * the statement.
			 */
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}
}
