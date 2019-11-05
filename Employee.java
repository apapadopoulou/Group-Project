import java.util.ArrayList;
public abstract class Employee {
	private Department department;
	private String name;
	private String surname;
	private String telephone;
	private String email;
	private String password;
	private int id;
	private static int counter = 1;
	public ArrayList<Employee> employees = new ArrayList<Employee>();

	public Employee(String name, String surname ,String password, String telephone, String email, Department department) {
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.telephone = telephone;
		this.email = email;
		this.department = department;
		this.id =counter;
		counter++;
		employees.add(this);
	}
	public Employee(String name,String surname ,String password, Department department) {
		this(name,surname,password,null,null,department);
	}
	public Department getDepartment() {
		return department;
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
	public String getPassword() {
		return password;
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
		return "********************\nEmployee #" + id + "\nname : " + name + "\nsurname : " + surname + "\ntelephone : " + telephone
				+ "\nemail :" + email +"\n********************";
	}

}
