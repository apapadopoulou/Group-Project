import java.util.Random;
import java.util.ArrayList;
public abstract class Employee {
	private String department;
	private String nameSurname;
	private String telephone;
	private String email;
	private int id;
	public Random rdm = new Random();
	public ArrayList<Employee> employees = new ArrayList<Employee>();

	public Employee(String nameSurname , String telephone, String email) {
		this.nameSurname = nameSurname;
		this.telephone = telephone;
		this.email = email;
		this.id=rdm.nextInt(10000);
		employees.add(this);
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
	public abstract String getJobTitle();
	
	public void setDepartment(String department) {
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
	
}
