package gr.aueb.dmst.ProgrammingII.BusyB.BusyB;
import java.util.ArrayList;
/** 
 *@author BusyB
 */
public class Department {

	private int id;
	private String name;
	private static int counter = 1; /** counter*/
	private String managerId;
	private ArrayList<BasicEmployee> employeesOfDepartment = new ArrayList<BasicEmployee>(); 
	/** A list that contains the employees of each department separately*/
	public static ArrayList<Department> departments = new ArrayList<Department>();
	/** A list that contains all the departments*/
	
	/**
	 * Basic constructor for class Department.
	 * Use this constructor if you want to create a new Department.
	 */
	public Department(String name) {
		id = counter++;
		this.name = name;
		departments.add(this);
		DBcon.saveDepartment(this);
	}

	/**
	 * Database constructor for class Department.
	 * This constructor is used to load Departments from the database
	 * when the program opens.
	 * @param name
	 * @param id
	 * @param managerId
	 */
	public Department(String name, int id, String managerId) {
		this.id = id;
		this.name = name;
		this.managerId = managerId;
		departments.add(this);

		/*Sets the counter to the current id to be used for
		new objects that are being created.*/

		/**Sets the counter to the current id to be used for
		*new objects that are being created.
		*/

		counter = ++id;
	}

	/**
	 *@return dep
	 */
	public static Department getDepartment(int id) {
		Department dep = null;
		for (int i = 0; i < departments.size(); i++) {
			if (id == departments.get(i).getId()) {
				dep = departments.get(i);
			}
		}
		return dep;
	}
	/**
	 *Gets the departments.
	 *@return departments
	 */

	public static ArrayList<Department> getDepartments() {
		return departments;
	}

	/**
	 *Gets the id.
	 *@return id
	 */
	public int getId() {
		return id;
	}
	/**
	 *Gets the name.
	 *@return name
	 */

	public String getName() {
		return name;
	}
	/**
	 *Sets the name.
	 */

	public void setName(String name) {
		this.name = name;
	}
	
/**
 *Sets the manager id.
 */
	public void setManagerId(String id) {
		managerId = id;
		DBcon.updateDepartmentVar("managerId", managerId, this.id);
	}
	/**
	 *Gets the manager id.
	 *@return manager id
	 */

	public String getManagerId() {
		return managerId;
	}
    /**
     *Gets the employees of department.
     *@return employees of department
     */
	public ArrayList<BasicEmployee> getEmployeesOfDepartment() {
	  return employeesOfDepartment;
	}

	public void addEmployee(BasicEmployee employee) {
		employeesOfDepartment.add(employee);
	}
    /**
     *@return employees of department by name or null
     */
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
	} 
	
	/** 
	 *A search method that search the employee list of the department to find a specific employee using his name.
	 *@return employees of department by id or null
	  */
	public Employee searchEmployeeById(String id) {
		for (int i = 0; i < employeesOfDepartment.size(); i++) {
			if (employeesOfDepartment.get(i).getID().equals(id)) {
				System.out.println("The employee was found");
				return employeesOfDepartment.get(i);
			} else {
				System.out.println("This employee doesn't work in this department");
			}
		}
		return null;
	}

	/** 
	 *A search method that searches the employee list of the department to find a specific employee using his id.
	 */
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
	
	/** 
	 *A method that deletes a specific employee from a department's arraylist using his/her name to find him/her.
	*/
	public void deleteEmployeeById(String id) {
		for (int i = 0; i < employeesOfDepartment.size(); i++) {
			if (employeesOfDepartment.get(i).getID().equals(id)) {
				employeesOfDepartment.remove(i);
				System.out.println("Employee was removed");
			} else { 
				System.out.println("This employee couldn't be removed because he wasn't found in this department");
			}
		}
	}
	
	@Override
	public String toString() {
		String str_1 = "";
		/**str_1 = String.format("|%-20d|", id) +
         String.format("%30s" + name); */
		String.format("%30s%30s", id, name);
		return str_1;
	}
  /**
   *@return department or null 
   */
	public static Department searchDepartmentById(int id) {
		for (int i = 0; i < departments.size(); i++) {
			if (departments.get(i).getId() == id) {
				return departments.get(i);
			}
	    }
	  return null;
	}
	
	public static Department searchDepartmentByName(String name) {
		for (int i = 0; i < departments.size(); i++) {
			if (departments.get(i).getName() == name) {
				return departments.get(i);
			}
	    }
	  return null;
	}
}

/**
*End of Department class
*/