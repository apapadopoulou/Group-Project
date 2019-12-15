import java.util.ArrayList;
public class Department {
	
	private int id;
	private String name;
	private static int num_dep = 1; // counter
	private ArrayList <BasicEmployee> employeesOfDepartment = new ArrayList <BasicEmployee>(); /* a list that contains the employees of each department separately*/
	public static ArrayList <Department> departments = new ArrayList <Department>(); // a list that contains all the departments
	
	/*
	 * Basic constructor for class Department.
	 * Use this constructor if you want to create a new Department.
	 */
	public Department(String name) {
		id = num_dep++;
		this.name = name;
		departments.add(this);
	}
	
	/*
	 * Database constructor for class Department.
	 * This constructor is used to load Departments from the database when the program opens.
	 */
	public Department(String name, int id) {
		this.id = id;
		this.name = name;
		departments.add(this);
	} 
	
	public static Department getDepartment (int id) {
		for (int i = 0; i < departments.size(); i++) {
			if (id == departments.get(i).getId()) {
				return departments.get(i);
			}
		}
	}
	public static ArrayList<Department> getDepartments() {
		return departments;
	}
	
	public int getId() {
		return id;
	}

	public ArrayList<BasicEmployee> getEmployeesOfDepartment() {
	  return employeesOfDepartment;
	}
	
	public void addEmployee(BasicEmployee employee) {
		employeesOfDepartment.add(employee);
	}
	
	public BasicEmployee searchEmployeeByName(String name) {
		for (int i = 0; i < employeesOfDepartment.size(); i++) {
			if (employeesOfDepartment.get(i).getNameSurname().equals(name)) {
				System.out.println("The employee was found");
				return employeesOfDepartment.get(i);
			} else {
				System.out.println("This employee doesn't work in this department");
			}
		}
		return null;
	} // a search method that search the employee list of the department to find a specific employee using his name
	
	public Employee searchEmployeeById(String id) {
		for (int i = 0; i < employeesOfDepartment.size(); i++) {
			if (employeesOfDepartment.get(i).getId().equals(id)) {
				System.out.println("The employee was found");
				return employeesOfDepartment.get(i);
			} else {
				System.out.println("This employee doesn't work in this department");
			}
		}
		return null;
	}// a search method that searches the employee list of the department to find a specific employee using his id
	
	public void deleteEmployeeByName(String name) {
		for (int i = 0; i < employeesOfDepartment.size(); i++) {
			if (employeesOfDepartment.get(i).getNameSurname().contentEquals(name)) {
				employeesOfDepartment.remove(i);
			} else if (employeesOfDepartment.get(i).getSurname().contentEquals(name)) {
				employeesOfDepartment.remove(i);
			} else
				System.out.println("This employee couldn't be removed because he wasn't found in this department");     
		}
    }
	
	// a method that deletes a specific employee from a department's arraylist using his name to find him
	public void deleteEmployeeById(String id) {
		for (int i = 0; i < employeesOfDepartment.size(); i++) {
			if (employeesOfDepartment.get(i).getId().equals(id)) {
				employeesOfDepartment.remove(i);
				System.out.println("Employee was removed");
			} else { 
				System.out.println("This employee couldn't be removed because he wasn't found in this department");     
			}
		}
	}// a method that deletes a specific employee from a department's arraylist using his id to find him
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		String str_1 = "";
		/*str_1 = String.format("|%-20d|", id) +
         String.format("%30s" + name); */
		String.format("%30s%30s", id, name);
		return str_1;
	}
  
	public static Department searchDepartmentById(int id) {
		for (int i = 0; i < departments.size(); i++) {
			if (departments.get(i).getId() == id) {
				return departments.get(i);
			} 
	    }
	  return null;    
           
	}
	/*Method to load Departments from DB*/
	public static void loadDepartments() {
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
			rs = stmt.executeQuery("SELECT departmentID, name FROM JDepartment");
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
	
	public static void saveDepartment(int id, int salary) {
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
}
  