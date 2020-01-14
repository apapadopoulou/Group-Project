import java.util.ArrayList;
/**
 * BasicEmployee class extends Employee class and is used to create
 * objects that represent a simple employee.
 * @author BusyB
 */
public class BasicEmployee extends Employee {
   /**Department instance variable.*/
    private Department department;
   /**An ArrayList that contains all Basic Employees.*/
    public static ArrayList<BasicEmployee> basicEmployees =
    	new ArrayList<BasicEmployee>();
	/**
	 * Basic constructor for class BasicEmployee.
	 * Use this constructor if you want to create new Basic employees.
	 * The id is constructed using the department's id,
	 * the first two letters of the employees's name,
	 * the first two letters of the employee's surname
     * and the number of employees existing already in the department.
	 *@param name
	 *@param surname
	 *@param telephone
	 *@param email
	 *@param birthdate
	 *@param depID
	 *@param salary
	 */
	public BasicEmployee(String name, String surname, String telephone, String email, String birthdate, int depID, double salary) {
		super(name, surname, telephone, email, birthdate, null, salary);
		this.department = Department.getDepartment(depID);
		department.addEmployee(this);
		String id = String.valueOf(department.getId())
			+ name.substring(0, 2) + surname.substring(0, 2)
			+ String.valueOf(department.getEmployeesOfDepartment().size());
		setID(id);
		basicEmployees.add(this);
		employees.add(this);
		DBcon.saveBasicEmployee(this);
		Account acc = new Account(this);
	}
   /**
	* Database constructor for class BasicEmployee.
	* This constructor is used to load employees from the database when the program opens.
	* @param name
	* @param surname
	* @param telephone
	* @param email
	* @param birthdate
	* @param depID
	* @param id
	* @param salary
	*/
	public BasicEmployee(String name, String surname, String telephone, String email, String birthdate, int depID, String id, double salary) {
	    super(name, surname, telephone, email, birthdate, id, salary);
	    this.department = Department.getDepartment(depID);
		department.addEmployee(this);
	    basicEmployees.add(this);
	    employees.add(this);
	  }
	/**
	 * Returns the department field.
	 *@return department
	 */
	public Department getDepartment() {
		return department;
	}
	 /**
	  *Method that changes the employee's department
	  * using the department object.
	  *@param depID
	  */
	public void setDepartment(int depID) {
		this.department = Department.searchDepartmentById(depID);
		DBcon.updateEmployeeVar("BasicEmployee", "depID", depID, getID());
	}
	/**
	 * Returns the depId field.
	 *@return department.getId()
	 */
	public int getDepId() {
		return department.getId();
	}
    /**
     *Method that checks if a Basic Employee works in HR department.
     *@param emp
     *@return true or false
     */
	public static boolean isHREmployee(BasicEmployee emp) {
		if (emp.getDepartment().getName().equals("HR")) {
			return true;
		} else {
			return false;
		}
	}
  /**
   *Method that searches a basic employee.
   *@param name
   *@return basicEmployees.get(i) or null
   */
    public static BasicEmployee searchEmployeeByName2(String name) {
    	for (int i = 0; i < basicEmployees.size(); i++) {
	      if (basicEmployees.get(i).getNameSurname().equals(name)) {
	        return basicEmployees.get(i);
	      } else if (basicEmployees.get(i).getSurname().equals(name)) {
	        return basicEmployees.get(i);
	      }
		}
    	return null;
    }
}
