import java.util.ArrayList;

public class BasicEmployee extends Employee {
	private Department department;
	public static ArrayList <BasicEmployee> basicEmployees = new ArrayList <BasicEmployee>(); 
	public BasicEmployee(String name, String surname,int telephone, String email, String id, Department department) {
		super(name, surname, telephone, email);
		this.department = department;
		id = String.valueOf(department.getId()) + name.substring(1,2) + surname.substring(1,2) + String.valueOf(department.getEmployeesOfDepartment().size());
		basicEmployees.add(this);
		employees.add(this);
	}
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void changeDepartmentAndId(String empName, int depId) {
	       /* System.out.println('Insert the name of department in which you want to get included');
	        String depname = sc.nextLine(); -> for main*/
	      BasicEmployee e = BasicEmployee.searchEmployeeByName2(empName);
	      e.getDepartment().deleteEmployeeByName(empName);
		  Department d = Department.searchDepartmentById(depId);
		  e.setDepartment(d);
		  d.addEmployee(e);
	      e.setId(String.valueOf(d.getId()) + e.getName().substring(1,2) + e.getSurname().substring(1,2) + String.valueOf(d.getEmployeesOfDepartment().size()));
	       /* change employee's id based on his new department */
	  
	  }
	@Override
	public String getJobTitle() {
		// TODO Auto-generated method stub
		return null;
	}
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
