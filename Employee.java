import java.util.ArrayList;
import java.util.Date;
public abstract class Employee {
  private String name;
  private String surname;
  private int telephone;
  private String email;
  private String id;
  private Date birthdate;
  /*????????? ??? ??????? ??? ?? ID*/
  private static int counter = 1;
  /*????? ??? ??? ?????????? ??? ???????????? Employee*/
  public static ArrayList<Employee> employees = new ArrayList<Employee>();
  /* ?????? Constructor ??? ??? ????? Employee*/
  public Employee(String name, String surname, int telephone, String email, Date birthdate) {
    this.name = name;
    this.surname = surname;
    this.telephone = telephone;
    this.email = email;
    this.birthdate = birthdate;
  }

  public String getName() {
    return name;
  }
  public String getSurname() {
    return surname;
  }
  
  public String getEmail() {
    return email;
  }
  public String getId() {
    return id;
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
  
  public int getTelephone() {
    return telephone;
  }
  public void setTelephone(int telephone) {
    this.telephone = telephone;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public void setId(String id) {
		this.id = id;
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

  public static Employee searchEmployeeById2(String id) {
	  for (int i = 0; i < employees.size(); i++) {
	      if (employees.get(i).getId() == id) {
	        return employees.get(i);
	      } 
	    }
	    return null;
  }
}