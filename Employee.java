import java.util.ArrayList;
import java.util.Date;
public abstract class Employee {
	private String name;
	private String surname;
	private int phonenumber;
	private String email;
	private String id;
	private Date birthdate;
	  
	public static ArrayList<Employee> employees = new ArrayList<Employee>();
	// Constructor
	public Employee(String name, String surname, int phonenumber, String email, Date birthdate) {
		this.name = name;
	    this.surname = surname;
	    this.phonenumber = phonenumber;
	    this.email = email;
	    this.birthdate = birthdate;
	}	  
	
	public Date getBirthdate() {
		return birthdate;
	}	
	
	public void setBirthdate(Date birthdate) {
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
	  
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
	    this.phonenumber = phonenumber;
	}
	public void setEmail(String email) {
	    this.email = email;
	}
	public void setId(String id) {
		this.id = id;
	}
	// Method toString including a String format for the given data
	@Override
	public String toString() {
		String str_2 = "";
	    /*str_1 = String.format("%30s", name ) +
	      String.format("%30s", surname) +
	      String.format("%30s", telephone) +
	      String.format("%30s", email) +
	      String.format("%30s", id); */
	    String.format("%30s%30s%30s%30s%30s", name, surname, phonenumber, email, id );
	    return str_2;
	}
	//public abstract String getJobTitle();
	
	// Returns the employee we searched for
	public static Employee searchEmployeeById2(String id) {
		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i).getId() == id) {
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
    
  /* this is a method that changes employee's id based on his new department */
 
  
  /*a method that evaluates an employee based on the level of importance of tasks he is responsible for*/
 /* public void employeeEvaluation (int loi) {
    int count = 0;
    int sum = 0;
    for (Employee e :  ) {
      if (e.equals(emp)) {
        sum += loi; /*level of importance for this task
        count++;
      }
    }
    if (sum >= loi) {
      System.out.println("The employee with id "+this.getId()+"is considered efficient.");
    } else {
      System.out.println("The employee with id "+this.getId()+"is not considered efficien.");
    }
    } */

 }