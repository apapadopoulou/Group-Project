import java.util.ArrayList;
public class Department {
	private int id;
	private String name;
	private static int num_dep = 1; // counter
	private ArrayList <Employee> employeesOfDepartment = new ArrayList <Employee>(); /* a list that contains the employees
	of each department separately*/
	public static ArrayList <Department> departments = new ArrayList <Department>(); // a list that contains all the departments
	public Department(String name, ArrayList<Employee> employeesOfDepartment) {
		id = num_dep++;
		this.name = name;
		this.employeesOfDepartment = employeesOfDepartment;
		departments.add(this);
	} // constructor of departments
	public static ArrayList<Department> getDepartments() {
		return departments;
	}
	public int getId() {
		return id;
	}
	
	public ArrayList<Employee> getEmployeesOfDepartment() {
		return employeesOfDepartment;
	}
	public void addEmployee(Employee employee) {
		employeesOfDepartment.add(employee);
	}
	public Employee searchEmployeeByName(String name) {
		for (int i = 0; i < employeesOfDepartment.size(); i++) {
			if (employeesOfDepartment.get(i).getNameSurname().equals(name)) {
				System.out.println("The employee was found");
				return employeesOfDepartment.get(i);
			} else {
				System.out.println("This employee doesn't work in this department");
			}
		}
		return null;
	} // a search method that search the employee list of the department to find a specific employee using his name
	public Employee searchEmployeeById(String id) {
		for (int i = 0; i < employeesOfDepartment.size(); i++) {
			if (employeesOfDepartment.get(i).getId().equals(id)) {
				System.out.println("The employee was found");
				return employeesOfDepartment.get(i);
			} else {
				System.out.println("This employee doesn't work in this department");
			}
		}
		return null;
	}// a search method that search the employee list of the department to find a specific employee using his id
	public void deleteEmployeeByName(String name) {
		for (int i = 0; i < employeesOfDepartment.size(); i++) {
			if (employeesOfDepartment.get(i).getNameSurname().contentEquals(name)) {
				employeesOfDepartment.remove(i);
				System.out.println("Employee was removed");
			} else { 
				System.out.println("This employee couldn't be removed because he wasn't found in this department");			
			}
		}
	}// a method that deletes a specific employee from a department's arraylist using his name to find him
	public void deleteEmployeeById(String id) {
		for (int i = 0; i < employeesOfDepartment.size(); i++) {
			if (employeesOfDepartment.get(i).getId().equals(id)) {
				employeesOfDepartment.remove(i);
				System.out.println("Employee was removed");
			} else { 
				System.out.println("This employee couldn't be removed because he wasn't found in this department");			
			}
		}
	}// a method that deletes a specific employee from a department's arraylist using his id to find him
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		String str_1 = "";
        /*str_1 = String.format("|%-20d|", id) +
         String.format("%30s" + name); */
		String.format("%30s%30s", id, name);
		return str_1;
	}
}