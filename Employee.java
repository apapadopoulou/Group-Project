import java.util.ArrayList;
public abstract class Employee {
	private Department department;
	private String name;
	private String surname;
	private String telephone;
	private String email;
	private String id;
	/*��������� ��� ������� ��� �� ID*/
	private static int counter = 1;
	/*����� ��� ��� ���������� ��� ������������ Employee*/
	public ArrayList<Employee> employees = new ArrayList<Employee>();
	/* ������ Constructor ��� ��� ����� Employee*/
	public Employee(String name, String surname, String telephone, String email, Department department) {
		this.name = name;
		this.surname = surname;
		this.telephone = telephone;
		this.email = email;
		this.department = department;
		id = String.valueOf(department.getId()) + name.substring(1,2) + surname.substring(1,2) + counter++;
		employees.add(this);
	}
	/*����� Constructor ��� ��� Employee (WIP)*/
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
        String str_2 = "";
        /*str_1 = String.format("%30s", name ) +
        String.format("%30s", surname) +
        String.format("%30s", telephone) +
        String.format("%30s", email) +
        String.format("%30s", id); */
        String.format("%30s%30s%30s%30s%30s", name, surname, telephone, email, id );
        return str_2;
	}
	public abstract String getJobTitle();

}