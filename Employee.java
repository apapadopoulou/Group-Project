import java.util.ArrayList;
public abstract class Employee {
	private Department department;
	private String name;
	private String surname;
	private String telephone;
	private String email;
	private String id;
	/*Μεταβλητή που βοηθάει για το ID*/
	private static int counter = 1;
	/*Λίστα για την αποθήκευση των αντικειμένων Employee*/
	public ArrayList<Employee> employees = new ArrayList<Employee>();
	/* Πλήρης Constructor για την κλάση Employee*/
	public Employee(String name, String surname, String telephone, String email, Department department) {
		this.name = name;
		this.surname = surname;
		this.telephone = telephone;
		this.email = email;
		this.department = department;
		id = String.valueOf(department.getId()) + name.substring(1,2) + surname.substring(1,2) + counter++;
		employees.add(this);
	}
	/*Απλός Constructor για την Employee (WIP)*/
	public Employee(String name,String surname ,String password, Department department) {
		this(name,surname,password,null,department);
	}
	public String getDepartment() {
		return department.getName();
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getTelephone() {
		return telephone;
	}
	public String getEmail() {
		return email;
	}
	public String getId() {
		return id;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
			this.surname = surname;
	}
	public String getNameSurname() {
			return getName() + getSurname();
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {

		return "********************\nEmployee #" + id + "\nname : " + name + "\nsurname : " + surname + "\ntelephone : " + telephone
				+ "\nemail :" + email +"\n********************";
	}
	public abstract String getJobTitle();

}