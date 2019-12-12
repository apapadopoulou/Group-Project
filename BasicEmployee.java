import java.util.ArrayList;
import java.util.Date;

public class BasicEmployee extends Employee {
	
	private Department department; //Department instance variable.
	private String id; // ID instance variable.
	public static ArrayList <BasicEmployee> basicEmployees = new ArrayList <BasicEmployee>(); // An ArrayList that contains all Basic Employees.
	
	/*Constructor for class BasicEmployee.*/
	public BasicEmployee(String name, String surname,int telephone, String email, Date birthdate, Department department) {
		super(name, surname, telephone, email, birthdate);//Calls the constructoer for the superclass Employee.
		this.department = department;
		/*
		 * The id is constructed using the department's id,
		 * the first two letters of the employees's name, 
		 * the first two letters of the employee's surname
	     * and the number of employees existing already in the department.
	     */
		id = String.valueOf(department.getId()) + name.substring(1,2)
			+ surname.substring(1,2) 
			+ String.valueOf(department.getEmployeesOfDepartment().size());
		
		basicEmployees.add(this); //Adds the object in the ArrayList of BasicEmployees.
		employees.add(this); // I dont know what this does. Someone explain it here!!!!
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public String getID() {
		return id;
	}
	// Method that changes the employee's department
	public void changeDepartmentAndId(String empName, int depId) {
	       /* System.out.println('Insert the name of department in which you want to get included');
	        String depname = sc.nextLine(); -> for main*/
	      BasicEmployee e = BasicEmployee.searchEmployeeByName2(empName);
	      e.getDepartment().deleteEmployeeByName(empName);
		  Department d = Department.searchDepartmentById(depId);
		  e.setDepartment(d);
		  d.addEmployee(e);
		  /* change employee's id based on his new department */
	      e.setId(String.valueOf(d.getId()) + e.getName().substring(1,2) + e.getSurname().substring(1,2) + String.valueOf(d.getEmployeesOfDepartment().size()));
	     
	  }
	@Override
	public String getJobTitle() {
		// TODO Auto-generated method stub
		return null;
	}
	//Method that return the basic employee we have searched for
	public static BasicEmployee searchEmployeeByName2(String name) {
		  for (int i = 0; i < basicEmployees.size(); i++) {
		      if (basicEmployees.get(i).getNameSurname().equals(name)) {
		        return basicEmployees.get(i);
		      } else if (basicEmployees.get(i).getSurname().equals(name)) {
		    	  return basicEmployees.get(i);
		      } else 
		    	  System.out.println("Employee was not found");
		    }
		    return null;
	  }
}