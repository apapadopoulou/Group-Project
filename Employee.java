import java.util.ArrayList;
import java.util.Date;

public abstract class Employee {
  private String name;
  private String surname;
  private String phonenumber;
  private String email;
  private String birthdate;
  private double salary;
  private int id;
  private double personalScore = 10;
  private PersonalisedCalendar pc; 
  public static ArrayList<Employee> employees = new ArrayList<Employee>();
  
  // Constructor
  public Employee(String name, String surname, String phonenumber, String email, String birthdate, double salary, int id/*, double personal_score*/) {
    try {
      if (!Checkers.isValidPhoneNumber(phonenumber)) {
        throw new IllegalArgumentException("phone number is not valid");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
	  this.name = name;
      this.surname = surname;
      this.phonenumber = phonenumber;
      this.email = email;
      this.birthdate = birthdate;
      this.salary=salary;
      this.id = id;
      /*this.personal_score = personal_score;*/
  }   
  public Employee(String name, String surname, String phonenumber, String email, String birthdate, double salary/*, double personal_score*/) {
	    try {
	      if (!Checkers.isValidPhoneNumber(phonenumber)) {
	        throw new IllegalArgumentException("phone number is not valid");
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
		  this.name = name;
	      this.surname = surname;
	      this.phonenumber = phonenumber;
	      this.email = email;
	      this.birthdate = birthdate;
	      this.salary=salary;
	      /*this.personal_score = personal_score;*/
	  }  
  
  public String getBirthDate() {
    return birthdate;
  } 
  
  public void setBirthdate(String birthdate) {
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
  
  public String getID() {
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
    
  public String getTelephone() {
    return phonenumber;
  }
  public void setSalary(double salary) {
	  this.salary=salary;
  }
  public double getSalary() {
	  return salary;
  }
  public void setTelephone(String phonenumber) {
      this.phonenumber = phonenumber;
  }
  public void setEmail(String email) {
      this.email = email;
  }
  public double getPersonal_Score() {
	  return personal_score;
  }
  public void setPersonal_Score(double personal_score) {
	  this.personal_score = personal_score;
  }
  
  // Method toString including a String format for the given data
  @Override
  public String toString() {
    String str_2 = "";
      /*str_1 = String.format("%30s", name ) +
        String.format("%30s", surname) +
        String.format("%30s", telephone) +
        String.format("%30s", email) +
        String.format("%30s", id)+
        String.format("%30s", salary)+
        String.format("%30s", personal_score); */
      String.format("%30s%30s%30s%30s", name, surname, phonenumber, email, salary, personal_score );
      return str_2;
  }
  //public abstract String getJobTitle();
  
  // Returns the employee we searched for
  public static Employee searchEmployeeById(String id) {
    for (int i = 0; i < employees.size(); i++) {
      if (employees.get(i).getID() == id) {
            return employees.get(i);
        } 
    }
    return null;
  }

  
  // Method toString including a String format for the given data
 
  public static Employee searchEmployeeByName2(String name) {
    for (int i = 0; i < employees.size(); i++) {
        if (employees.get(i).getNameSurname().equals(name)) {
          return employees.get(i);
        } else if (employees.get(i).getSurname().equals(name)) {
          return employees.get(i);
        } else 
          System.out.println("Employee was not found");
      }
      return null;
  }
}
    
  /* this is a method that changes employee's id based on his new department */
 
  
  /*a method that evaluates an employee based on the level of importance of tasks he is responsible for*/
  

 
