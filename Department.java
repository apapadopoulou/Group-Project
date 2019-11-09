import java.util.ArrayList;
public class Department {
	private int id;
	private String name;
	private static int num_dep = 1;
	private ArrayList <Employee> employeesOfDepartment = new ArrayList <Employee>();
	public static ArrayList <Department> departments = new ArrayList <Department>();
	public Department(String name, ArrayList<Employee> employeesOfDepartment) {
		id = num_dep++;
		this.name = name;
		this.employeesOfDepartment = employeesOfDepartment;
		departments.add(this);
	}
	public static ArrayList<Department> getDepartments() {
		return departments;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Employee> getEmployeesOfDepartment() {
		return employeesOfDepartment;
	}
	public void addEmployee(Employee employee) {
		employeesOfDepartment.add(employee);
	}
	public Employee searchEmployeeByName(String name) {
		for (int i = 0; i < employeesOfDepartment.size(); i++) {
			if (employeesOfDepartment.get(i).getNameSurname() == name) {
				System.out.println("The employee was found");
				return employeesOfDepartment.get(i);
			} else {
				System.out.println("This employee doesn't work in this department");
			}
		}
		return null;
	}
	public Employee searchEmployeeById(int id) {
		for (int i = 0; i < employeesOfDepartment.size(); i++) {
			if (employeesOfDepartment.get(i).getId() == id) {
				System.out.println("The employee was found");
				return employeesOfDepartment.get(i);
			} else {
				System.out.println("This employee doesn't work in this department");
			}
		}
		return null;
	}
	public void deleteEmployeeByName(String name) {
		for (int i = 0; i < employeesOfDepartment.size(); i++) {
			if (employeesOfDepartment.get(i).getNameSurname() == name) {
				employeesOfDepartment.remove(i);
				System.out.println("Employee was removed");
			} else { 
				System.out.println("This employee couldn't be removed because he wasn't found in this department");			
			}
		}
	}
	public void deleteEmployeeById(int id) {
		for (int i = 0; i < employeesOfDepartment.size(); i++) {
			if (employeesOfDepartment.get(i).getId() == id) {
				employeesOfDepartment.remove(i);
				System.out.println("Employee was removed");
			} else { 
				System.out.println("This employee couldn't be removed because he wasn't found in this department");			
			}
		}
	}
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