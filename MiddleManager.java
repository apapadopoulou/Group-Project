import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class MiddleManager extends Employee {
	private ArrayList <Department> managingDepartments = new ArrayList <Department>();
	public static ArrayList <MiddleManager> middleManagers = new ArrayList <MiddleManager>();
	private String id;
  
	/*
	 * Basic constructor for class MiddleManager.
	 * Use this if you want to create new Middle Managers. 
	 */
	public MiddleManager(String name, String surname, String telephone, String email, Date birthdate){
		super(name, surname, telephone, email, birthdate);
	    id = name.substring(1,2) + surname.substring(1,2) + String.valueOf(middleManagers.size());
	    middleManagers.add(this);
	    employees.add(this);
	    DBcon.saveMiddleManager(this);
	}
	
	/*
	 * Database constructor for class MiddleManager.
	 * This constructor is used to load Middle Managers from the database when the program opens.
	 */
	public MiddleManager(String name, String surname, String telephone, String email, Date birthdate, String id){
	    super(name, surname, telephone, email, birthdate);
	    this.id = id;
	    managingDepartments = getManagingDepartments(); //Adds the managing departments.
	}
	
	/*
	 * Returns the managing departments.
	 * Searches for every department that has the same managerId with the managerId of the object that called the method. 
	 */
	public ArrayList<Department> getManagingDepartments() {
	    ArrayList<Department> departments= new ArrayList<Department>();
	    for (int i = 0; i < Department.departments.size(); i++) {
			if (Department.departments.get(i).getManagerId() == id) {
				departments.add(Department.departments.get(i));
			}
	    }
		return departments;
	}
        /** Method that chackes if the Manager manages the HR department*/
        public boolean managingHR(){
            for ( int i = 0; i < this.getManagingDepartments().size(); i++){
                if (this.getManagingDepartments().get(i).getName() == "HR")
                    return true;
            }
            return false;      
        } 
	
	public void setManagingDepartments(ArrayList<Department> managingDepartments) {
		this.managingDepartments = managingDepartments;
	}
        /** Method that returns true if the manager works in the HR department*/
	public static boolean HREmployee(String name) {
		  for (int i = 0; i < middleManagers.size(); i++) {
		      if (middleManagers.get(i).getNameSurname().equals(name) && middleManagers.get(i).managingHR() == true) {
                        return true;
		      } else if (middleManagers.get(i).getSurname().equals(name) && middleManagers.get(i).managingHR() == true) {
		    	  return true;
		      } else 
		    	  return false;
		    }
            return false;
		
	  }
	@Override
	public String toString() {
		return "MiddleManager's Name = " + getNameSurname() + ", Id= " + getId() + ", Email = " + getEmail() + ", Telephone = " + getTelephone()
		+ ", Managing Departments = "/* + getNamesOfManagingDepartments()*/;
	}

	public static MiddleManager searchMiddleManagerById(String id) {
		for (int i = 0; i < middleManagers.size(); i++) {
			if (middleManagers.get(i).getId().contentEquals(id)) {
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
				System.out.println("The current employee needs to work harder");
			}	else if (rating == 2) {
				System.out.println("The current employee is doing well, but he needs progress");
			}   else if (rating == 3) {
				System.out.println("The current employee works satisfactorily");
			}	else if (rating == 4) {
				System.out.println("The current employee is doing very well");
			}	else if (rating == 5) {
				System.out.println("The current employee works excellent!");
			}
		}
	}	

}