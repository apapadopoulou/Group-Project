public class Account {
 private Department department;
 private String name;
 private String surname;
 private String telephone;
 private String email;
 private String password;
 private int id;
 public Account(Employee e) {
	 department = e.getDepartment();
	 name = e.getName();
	 surname = e.getSurname();
	 telephone = e.getTelephone();
	 email = e.getEmail();
	 password = e.getPassword();
	 id = e.getId();
 }
}