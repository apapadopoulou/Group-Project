package gr.aueb.dmst.ProgrammingII.BusyB.BusyB;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author BusyB
 *
 */

public class MiddleManager extends Employee {
	
    private ArrayList<Department> managingDepartments = new ArrayList<Department>();
	public static ArrayList<MiddleManager> middleManagers = new ArrayList<MiddleManager>();
	/**
	 * Basic constructor for class MiddleManager.
	 * Use this if you want to create new Middle Managers.
	 * @param name
	 * @param surname
	 * @param phonenumber
	 * @param email
	 * @param birthdate
	 * @param salary
	 */
	public MiddleManager(String name, String surname, String phonenumber, String email, String birthdate, double salary) {
		super(name, surname, phonenumber, email, birthdate, null, salary);
	    String id = name.substring(0, 2) + surname.substring(0, 2) + String.valueOf(middleManagers.size());
	    setID(id);
	    middleManagers.add(this);
	    employees.add(this);
	    DBcon.saveMiddleManager(this);
	    Account acc = new Account(this);
	}

	/**
	 * Database constructor for class MiddleManager.
	 * This constructor is used to load Middle Managers
	 * from the database when the program opens.
	 * @param name
	 * @param surname
	 * @param telephone
	 * @param email
	 * @param birthdate
	 * @param id
	 * @param salary
	 */
	public MiddleManager(String name, String surname, String telephone, String email, String birthdate, String id, double salary) {
	    super(name, surname, telephone, email, birthdate, id, salary);
	    this.managingDepartments = getManagingDepartments();
	    middleManagers.add(this);
	    employees.add(this);
	}

	/**
	 * Searches for every department that has the same managerId
	 * with the managerId of the object that called the method and returns it
	 * @return departments
	 */
	public ArrayList<Department> getManagingDepartments() {
	    ArrayList<Department> departments = new ArrayList<Department>();
	    for (int i = 0; i < Department.departments.size(); i++) {
	    	if (Department.departments.get(i).getManagerId() != null) { 
	    		if (Department.departments.get(i).getManagerId().equals(getID())) {				
	    			departments.add(Department.departments.get(i));
	    		}
	    	}
	    }
		return departments;
	}
	
	/**
	 * Sets the managingDepartments field
	 * @param managingDepartments
	 */
	public void setManagingDepartments(ArrayList<Department> managingDepartments) {
		this.managingDepartments = managingDepartments;
		for (int i = 0; i < managingDepartments.size(); i++) {
			managingDepartments.get(i).setManagerId(getID());
		}
	}
	
	public void setManagingDepartment(int depID) {
		managingDepartments.add(Department.searchDepartmentById(depID));
		Department.searchDepartmentById(depID).setManagerId(getID());
		
	}

	/**
	 * Method that checks if the Manager manages the HR department
	 * @param midman
	 * @return true or false
	 */
    public static boolean managingHR(MiddleManager midman) {
    	for (int i = 0; i < midman.getManagingDepartments().size(); i++) {
    		if (midman.getManagingDepartments().get(i).getName().equals("HR")) {
                    return true;
            }
            
        }
    	return false;
    }

    /**
     * Method that searches a middle manager by his/her name in middleManagers list and returns him/her if he/she exists
     * @param name
     * @return middleManagers.get(i) or null
     */
	 public static MiddleManager searchMiddleManager(String name) {
	    	for (int i = 0; i < middleManagers.size(); i++) {
		      if (middleManagers.get(i).getNameSurname().equals(name)) {
		        return middleManagers.get(i);
		      } else if (middleManagers.get(i).getSurname().equals(name)) {
		        return middleManagers.get(i);
		      }
			}
	    	return null;
	    }

	 /**
	  * toString method that returns the details of a middle manager
	  * @return "MiddleManager's Name = " + getNameSurname() + ", Id= " + getID()
		+ ", Email = " + getEmail() + ", Telephone = " + getPhonenumber()
		+ ", Managing Departments = " + /*getNamesOfManagingDepartments()
	  */
	@Override
	public String toString() {
		return "MiddleManager's Name = " + getNameSurname() + ", Id= " + getID()
		+ ", Email = " + getEmail() + ", Telephone = " + getPhonenumber()
	/*	+ ", Managing Departments = " + /*getNamesOfManagingDepartments()*/;
	}

	/**
	 * Method that searches a middle manager by his/her id in middleManagers list and returns him/her if he/she exists
	 * @param id
	 * @return ,iddleManagers.get(i) or null
	 */
	public static MiddleManager searchMiddleManagerById(String id) {
		for (int i = 0; i < middleManagers.size(); i++) {
			if (middleManagers.get(i).getID().contentEquals(id)) {
				return middleManagers.get(i);
			}
		}
		return null;
	}

	/**
	 * Method that prints the departments that are managed by a certain middle manager
	 * @param mm
	 */
	public static void showManagingDepartments(MiddleManager mm) {
		for (int i = 0; i < mm.managingDepartments.size(); i++) {
			System.out.println(mm.managingDepartments.get(i).getName());
		}
	}

	/**
	 * Method that prints a message regarding the rating of an employee
	 * @param rating
	 */
  public static void evaluation(int rating) {
    for (int i = 0; i < middleManagers.size(); i++) {
      if (rating == 1) {
	      System.out.println("The current employee "
	      		+ "needs to work harder");
	  }	else if (rating == 2) {
	      System.out.println("The current employee is doing well, "
	      		+ "but he needs progress");
	  } else if (rating == 3) {
		  System.out.println("The current employee "
		  		+ "works satisfactorily");
      }	else if (rating == 4) {
		  System.out.println("The current employee is "
		  		+ "doing very well");
      }	else if (rating == 5) {
          System.out.println("The current employee "
          		+ "works excellent!");
	  }
	}
  }
}
/**
 * End of MiddleManager class
*/