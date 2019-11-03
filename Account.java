public class Account {
 private Department department;
 private String name;
 private String surname;
 private String telephone;
 private String email;
 private String password;
 private int id;
 public Account(Department department , String name , String surname , String telephone , String email , String password , int id) {
	 department = Employee.getDepartment();
	 name = Employee.getName();
	 surname = Employee.getSurname();
	 telephone = Employee.getTelephone();
	 email = Employee.getEmail();
	 password = Employee.getPassword();
	 id = Employee.getId();
 }
}