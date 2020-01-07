import java.util.ArrayList;
import java.util.Scanner;

public class MiddleManager extends Employee {
    private ArrayList<Department> managingDepartments = new ArrayList<Department>();
	public static ArrayList<MiddleManager> middleManagers = new ArrayList<MiddleManager>();
	/**
	 * Basic constructor for class MiddleManager.
	 * Use this if you want to create new Middle Managers.
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
	 */
	public MiddleManager(String name, String surname, String telephone, String email, String birthdate, String id, double salary) {
	    super(name, surname, telephone, email, birthdate, id, salary);
	    managingDepartments = getManagingDepartments(); //Adds the managing departments.
	    middleManagers.add(this);
	    employees.add(this);
	}

	/*
	 * Returns the managing departments.
	 * Searches for every department that has the same managerId
	 * with the managerId of the object that called the method.
	 */
	public ArrayList<Department> getManagingDepartments() {
	    ArrayList<Department> departments = new ArrayList<Department>();
	    for (int i = 0; i < Department.departments.size(); i++) {
			if (Department.departments.get(i).getManagerId().equals(getID())) {				
				departments.add(Department.departments.get(i));
			}
	    }
		return departments;
	}

	/** Method that checks if the Manager manages the HR department*/
    public static boolean managingHR(MiddleManager midman) {
    	for (int i = 0; i < midman.getManagingDepartments().size(); i++) {
    		if (midman.getManagingDepartments().get(i).getName() == "HR") {
                    return true;
            }
            
        }
    	return false;
    }

	public void setManagingDepartments(ArrayList<Department> managingDepartments) {
		this.managingDepartments = managingDepartments;
	}

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

	@Override
	public String toString() {
		return "MiddleManager's Name = " + getNameSurname() + ", Id= " + getID()
		+ ", Email = " + getEmail() + ", Telephone = " + getPhonenumber()
	/*	+ ", Managing Departments = " + /*getNamesOfManagingDepartments()*/;
	}

	public static MiddleManager searchMiddleManagerById(String id) {
		for (int i = 0; i < middleManagers.size(); i++) {
			if (middleManagers.get(i).getID().contentEquals(id)) {
				return middleManagers.get(i);
			}
		}
		return null;
	}

	public static void showManagingDepartments(MiddleManager mm) {
		for (int i = 0; i < mm.managingDepartments.size(); i++) {
			System.out.println(mm.managingDepartments.get(i).getName());
		}
	}

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
