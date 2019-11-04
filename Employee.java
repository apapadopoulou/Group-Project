import java.util.ArrayList;
public abstract class Employee {
	private Department department;
	private String name;
	private String surname;
	private String telephone;
	private String email;
	private int id;
	public ArrayList<Employee> employees = new ArrayList<Employee>();

	public Employee(String name, String surname, String telephone, String email, Department department) {
		this.name = name;
		this.surname = surname;
		this.telephone = telephone;
		this.email = email;
		this.department = department;
		this.id=Integer.parseInt("1234");
		employees.add(this);
	}
	/*public Employee(String nameSurname, Department department) {
		super(nameSurname,password,null.null.department);
	}*/
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
	public int getId() {
		return id;
	}
	public abstract String getJobTitle();

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
		return "Employee [department=" + department.getName() + ", name=" + name + "surname=" + surname + ", telephone=" + telephone
				+ ", email=" + email + ", id=" + id + "]";
	}

}


