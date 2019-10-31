import java.util.Random;
import java.util.ArrayList;
public abstract class Employee {
	private Department department;
	private String nameSurname;
	private String telephone;
	private String email;
	private String password;
	private int id;
	public Random rdm = new Random();
	public ArrayList<Employee> employees = new ArrayList<Employee>();

	public Employee(String nameSurname ,String password, String telephone, String email, Department department) {
		this.nameSurname = nameSurname;
		this.password = password;
		this.telephone = telephone;
		this.email = email;
		this.department = department;
		this.id=rdm.nextInt(10000);
		employees.add(this);
	}
	public Employee(String nameSurname ,String password, Department department) {
		super(nameSurname,password,null.null.department);
	}
	public String getDepartment() {
		return department;
	}
	public String getNameSurname() {
		return nameSurname;
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
	public String getPassword() {
		return password;
	}
	public abstract String getJobTitle();

	public void setDepartment(Department department) {
		this.department = department;
	}
	public void setNameSurname(String nameSurname) {
		this.nameSurname = nameSurname;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employee [department=" + department + ", nameSurname=" + nameSurname + ", telephone=" + telephone
				+ ", email=" + email + ", id=" + id + "]";
	}

}
