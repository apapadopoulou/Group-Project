package gr.aueb.dmst.ProgrammingII.BusyB.BusyB;
import java.util.ArrayList;
/** 
 *@author BusyB
 */
public class Department {

	private int id;
	private String name;
	private static int counter = 0; /** counter*/
	private String managerId;
	private ArrayList<BasicEmployee> employeesOfDepartment = new ArrayList<BasicEmployee>(); 
	/** A list that contains the employees of each department separately*/
	public static ArrayList<Department> departments = new ArrayList<Department>();
	/** A list that contains all the departments*/
	
	/**
	 * Basic constructor for class Department.
	 * Use this constructor if you want to create a new Department.
	 * @param name
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
	 * Sets the counter to the current id to be used for
	 * new objects that are being created.
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

		

		counter = ++id;
	}

	/**
	 * Returns a department from departments field
	 * @param id
	 * @return
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
	 *Returns the departments field
	 *@return departments
	 */

	public static ArrayList<Department> getDepartments() {
		return departments;
	}

	/**
	 *Returns the id field
	 *@return id
	 */
	public int getId() {
		return id;
	}
	/**
	 *Returns the name field.
	 *@return name
	 */

	public String getName() {
		return name;
	}
	/**
	 * Sets the name field.
	 * @param name
	 */

	public void setName(String name) {
		this.name = name;
		DBcon.updateDepartmentVar("name", name, this.id);
	}
	
	/**
	 * Sets the id field
	 * @param id
	 */
	public void setManagerId(String id) {
		managerId = id;
		DBcon.updateDepartmentVar("managerId", managerId, this.id);
	}
	/**
	 *Returns the id field
	 *@return managerId
	 */

	public String getManagerId() {
		return managerId;
	}
    /**
     *Returns the employees of a department
     *@return employeesOfDepartment
     */
	public ArrayList<BasicEmployee> getEmployeesOfDepartment() {
	  return employeesOfDepartment;
	}
	/**
	 * Adds the employee to employeesOfDepartment field
	 * @param employee
	 */
	public void addEmployee(BasicEmployee employee) {
		employeesOfDepartment.add(employee);
	}
    /**
     * Searches an employee by his name in employeesOfDepartment list 
     * @param name
     * @return employeesOfDepartment.get(i) or null
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
	 * Searches an employee by his id in employeesOfDepartment list 
	 * @param id
	 * @return employeesOfDepartment.get(i) or null
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
	 * Searches an employee by his/her name in employeesOfDepartment list and deletes him if he/she exists 
	 * @param name
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
	 * Searches an employee by his/her id in employeesOfDepartment list and deletes him if he/she exists 
	 * @param id
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
   * Searches departments list by the department's id and returns the department if it exists.
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
	/**
	 * Searches departments list  by the department's name and returns the department if it exists.
	 * @param name
	 * @return department or null
	 */
	public static Department searchDepartmentByName(String name) {
		for (int i = 0; i < departments.size(); i++) {
			if (departments.get(i).getName() == name) {
				return departments.get(i);
			}
	    }
	  return null;
	}
        
        public static double departmentScore(Department dept){
            double avg = 0;
            for (BasicEmployee employeesOfDepartment1 : dept.employeesOfDepartment) {
                avg += employeesOfDepartment1.getScore();
            }
            avg += MiddleManager.searchMiddleManagerById(dept.getManagerId())
                    .getScore();
            if (dept.employeesOfDepartment.size() + 1 == 0)
                return 0;
            avg = avg / (dept.employeesOfDepartment.size() + 1 );
            return avg;                
        }
}

/**
*End of Department class
*/