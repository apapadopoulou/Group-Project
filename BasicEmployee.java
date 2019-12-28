import java.util.ArrayList;
/** 
 *@author BusyB
 */
public class BasicEmployee extends Employee {
	/**
	 *Department instance variable.
	 */
	private Department department;
	/** 
	 *ID instance variable.
	 */
  private String id; 
/**
 *An ArrayList that contains all Basic Employees.
 */
  public static ArrayList<BasicEmployee> basicEmployees = new ArrayList<BasicEmployee>();
  
  /**
 * Basic constructor for class BasicEmployee.
 * Use this constructor if you want to create new Basic employees.
 * 
 *@param name
 *@param surname
 *@param phonenumber
 *@param email
 *@param birthdate
 *@param depID
 *@param salary
 */

  public BasicEmployee(String name, String surname, String phonenumber, String email, 
      String birthdate, int depID, double salary) {
	/**
	 *Calls the constructor for the superclass Employee.
	 */
    super(name, surname, phonenumber, email, birthdate, salary);
  /**
   *Gets the Department object using the Department id.
   */
    this.department = Department.getDepartment(depID); 
    /**
* The id is constructed using the department's id,
* the first two letters of the employees's name, 
* the first two letters of the employee's surname
* and the number of employees existing already in the department.
*/
    id = String.valueOf(department.getId()) + name.substring(1,2)
      + surname.substring(1,2)
      + String.valueOf(department.getEmployeesOfDepartment().size());
    this.setID(id);
  /**
   *Adds the object in the ArrayList of BasicEmployees.
   */
    basicEmployees.add(this);
 /**
  *I don't know what this does. Someone explain it here!!!!
  */
    employees.add(this);
  /**
   *Saves the object to the Database.
   */
	DBcon.saveBasicEmployee(this);
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

  public BasicEmployee(String name, String surname,String telephone, String email,
            String birthdate, int depID, String id, double salary) {
	/**
	 *Calls the constructor for the superclass Employee.
	 */
    super(name, surname, telephone, email, birthdate, salary, id); 
  /**
   *Gets the Department object using the Department id.
   */
    this.department = Department.getDepartment(depID); 
  /**
   *Adds the object in the ArrayList of BasicEmployees.
   */
    basicEmployees.add(this); 
 /**
  *I dont know what this does. Someone explain it here!!!!
  */
    employees.add(this); 
    System.out.println(this.toString());
    System.out.println("done stage 2");
  }

  public Department getDepartment() {
    return department;
  }

  /**
   *Method that changes the employee's department using the department object.
   */
  public void setDepartmet(int depID) {
    this.department = Department.searchDepartmentById(depID);
    /**
     *DBcon.UpdateBasicEmpVar("department", department.getId(), id);  
    *Saves the change to the Database.
    */
  }
  
  /** 
   *Method that changes the employee's department using the department id.
   */
  public void setDepartment(int depId) {
    department = Department.getDepartment(depId);
    /**
     *DBcon.UpdateBasicEmpVar("department", department.getId(), id);  
    *Saves the change to the Database.
    */
  }

  public int getDepId() {
    return department.getId();
  }

   @Override
  public String getJobTitle() {
    /**
     *TODO Auto-generated method stub
     */
    return null;
  }
  
  /**
   *Method that checks if a Basic Employee works in the HR department.
   */
  public static boolean HREmployee(String name) {
    for (int i = 0; i < basicEmployees.size(); i++) {
      if (basicEmployees.get(i).getNameSurname().equals(name) 
            && basicEmployees.get(i).getDepartment().getName() == "HR") {
        return true;
      } else if (basicEmployees.get(i).getSurname().equals(name)
            && basicEmployees.get(i).getDepartment().getName() == "HR") {
        return true;
      } else {
        return false;
      }
    }
    return false;
  }
        
  /** 
   *Method that returns the basic employee we have searched for.
   */
  public static BasicEmployee searchEmployeeByName2(String name) {
    for (int i = 0; i < basicEmployees.size(); i++) {
      if (basicEmployees.get(i).getNameSurname().equals(name)) {
        return basicEmployees.get(i);
      } else if (basicEmployees.get(i).getSurname().equals(name)) {
        return basicEmployees.get(i);
      } else {
        System.out.println("Employee was not found");
      }
    return null;
  }
	
  /**
   *Method that changes the employee's department.
   */
  public void changeDepartmentAndId(String empName, int depId) {
    /**
     *System.out.println('Insert the name of department in which you want to get included');
     *String depname = sc.nextLine(); -> for main
     */
    BasicEmployee e = BasicEmployee.searchEmployeeByName2(empName);
    e.getDepartment().deleteEmployeeByName(empName);
    e.setDepartment(depId);
    Department.searchDepartmentById(depId).addEmployee(e);
    /**
     *Change employee's id based on his new department. 
     */
    e.setId(String.valueOf(depId) + e.getName().substring(1,2) + e.getSurname().substring(1,2)
    	+ String.valueOf(Department.searchDepartmentById(depId).getEmployeesOfDepartment().size()));
    }
}
/**
 *End of BasicEmployee class.
 */
 