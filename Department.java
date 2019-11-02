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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}



}
