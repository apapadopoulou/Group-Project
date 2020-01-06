import java.util.ArrayList;
/** 
 * BasicEmployee class adds all basic employees in an ArrayList called basicEmployees.
 * This addition is based on the department in which each employee works.
 * This class can change the employee's department.
 * This class can check if a basic employee works in the HR department.
 * @author BusyB
 */
public class BasicEmployee extends Employee {
	
    private double score = 10;
  
   //Department instance variable.
   
	private Department department; 
	
	 //An ArrayList that contains all Basic Employees. 
	 
	public static ArrayList <BasicEmployee> basicEmployees = new ArrayList <BasicEmployee>(); 
	
	/**
	 * Basic constructor for class BasicEmployee.
	 * Use this constructor if you want to create new Basic employees.
	 * 
	 *@param name
	 *@param surname
	 *@param telephone
	 *@param email
	 *@param birthdate
	 *@param depID
	 */
	public BasicEmployee(String name, String surname, String telephone, String email, String birthdate, int depID) {
        
         //Calls the constructor for the superclass Employee. 
         
		super(name, surname, telephone, email, birthdate, null, 0);
		
		 //Gets the Department object using the Department id.
		 
		this.department = Department.getDepartment(depID);
		/**
		 * The id is constructed using the department's id,
		 * the first two letters of the employees's name, 
		 * the first two letters of the employee's surname
	     * and the number of employees existing already in the department.
	     */
		String id = String.valueOf(department.getId()) + name.substring(1,3)
			+ surname.substring(1,3) 
			+ String.valueOf(department.getEmployeesOfDepartment().size());
		setID(id);
		
		 //Adds the object in the ArrayList of BasicEmployees. 
		 
		basicEmployees.add(this);
		
		 //Adds the object in the ArrayList of Employees. 
		 
		employees.add(this);
        
         //Saves the object to the Database. 
        
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
		
		 //Calls the constructor for the superclass Employee.
		 
	    super(name, surname, telephone, email, birthdate, id, salary); 
	  
	   //Gets the Department object using the Department id.
	   
	    this.department = Department.getDepartment(depID); 
	  
	   //Adds the object in the ArrayList of BasicEmployees.
	   
	    basicEmployees.add(this); 
	 
	  //I dont know what this does. Someone explain it here!!!!
	  
	    employees.add(this);
	  }
   
	/** 
	 *@return department 
	 */
	public Department getDepartment() {
		return department;
	}
	
	
	 /**
	  *Method that changes the employee's department using the department object.
	  *@param depID  
	  */
	 
	public void setDepartment(int depID) {
		this.department = Department.searchDepartmentById(depID);
		
		 //DBcon.UpdateBasicEmpVar("department", department.getId(), id); 
		//Saves the change to the Database.
		 
	}
	
	/** 
	 *@return department.getId() 
	 */
	public int getDepId() {
		return department.getId();
	}

    /**
     *Method that checks if a Basic Employee works in HR department.
     *@param name
     *@return true or false
     */
	public static boolean HREmployee(String name) {
		for (int i = 0; i < basicEmployees.size(); i++) {
			if (basicEmployees.get(i).getNameSurname().equals(name) && basicEmployees.get(i).getDepartment().getName() == "HR") {
		        return true;
		      } else if (basicEmployees.get(i).getSurname().equals(name) && basicEmployees.get(i).getDepartment().getName() == "HR") {
		    	  return true;
		      } else 
		    	  return false;
		    }
            return false;
	}
        
  /** 
   *Method that returns the basic employee we have searched for.
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
	
    
    /**
     * Gets the score.
     *@return score
     */
	public double getScore() {
	return score;
}

	
	 /**
	  *Sets the score.
	  *@param score 
	  */
	 
public void setScore(double score) {
	this.score = score;
}

	/**
	 *Method that changes the employee's department.
	 *@param empName
	 *@param depId
	 */
	public void changeDepartmentAndId(String empName, int depId) {
		BasicEmployee e = BasicEmployee.searchEmployeeByName2(empName);
		e.getDepartment().deleteEmployeeByName(empName);
		e.setDepartment(depId);
		Department.searchDepartmentById(depId).addEmployee(e);
		
		 //Change employee's id based on his new department.
		 
		e.setID(String.valueOf(depId) + e.getName().substring(1,2) + e.getSurname().substring(1,2) + String.valueOf(Department.searchDepartmentById(depId).getEmployeesOfDepartment().size()));
	}

}

 //End of BasicEmployee class.
 
 
