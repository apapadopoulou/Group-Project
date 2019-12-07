import java.util.ArrayList;
import java.util.Scanner;
public class MiddleManager extends Employee {
  private ArrayList <Department> managingDepartments = new ArrayList <Department>();
  private ArrayList <String> namesOfManagingDepartments = new ArrayList <String>();
  public static ArrayList <MiddleManager> middleManagers = new ArrayList <MiddleManager>();
  public MiddleManager(String name, String surname, int telephone, String email, String id){
	    super(name, surname, telephone, email);
	    id = name.substring(1,2) + surname.substring(1,2) + String.valueOf(middleManagers.size());
	    for(int i = 1; i < Department.departments.size(); i++) {
	    	Department.searchDepartmentById(i).toString();
	    }
	    System.out.println("Type the ids of the managing departements");
	    System.out.println("Press enter after each id entry");
	    System.out.println("Press 0 and Enter if you're done");
	    Scanner input = new Scanner(System.in);
	    int d_id = input.nextInt();
	    while (d_id != 0) {
	    	if (d_id > Department.departments.size() || d_id < 0 ) {
	    		System.out.println("Wrong input. Please enter another id");
	    		d_id = input.nextInt();
	    		continue;
	      	}
	    	managingDepartments.add(Department.searchDepartmentById(d_id));
	    	namesOfManagingDepartments.add(Department.searchDepartmentById(d_id).getName());
	    }
	    input.close();
	    System.out.println("The managing departments have been saved");
	    middleManagers.add(this);
	    employees.add(this);
  }


public ArrayList<Department> getManagingDepartments() {
	return managingDepartments;
}
public void setManagingDepartments(ArrayList<Department> managingDepartments) {
	this.managingDepartments = managingDepartments;
}
public ArrayList<String> getNamesOfManagingDepartments() {
	return namesOfManagingDepartments;
}
public void setNamesOfManagingDepartments(ArrayList<String> namesOfManagingDepartments) {
	this.namesOfManagingDepartments = namesOfManagingDepartments;
}
@Override
public String toString() {
	return "MiddleManager's Name = " + getNameSurname() + ", Id= " + getId() + ", Email = " + getEmail() + ", Telephone = " + getTelephone()
			+ ", Managing Departments = " + getNamesOfManagingDepartments();

}

public static MiddleManager searchMiddleManagerById(String id) {
	  for (int i = 0; i < middleManagers.size(); i++) {
	      if (middleManagers.get(i).getId().contentEquals(id)) {
	        return middleManagers.get(i);
	      } 
	  }
	return null;    
	      	 
}
@Override
public String getJobTitle() {
	// TODO Auto-generated method stub
	return null;
}
}