import java.util.ArrayList;

public abstract class Employee {
	private String name;
	private String surname;
	private String phonenumber;
	private String email;
	private String id;
	private String birthdate;
	private double salary;
    private ArrayList<Day> calendar;
	public static ArrayList<Employee> employees = new ArrayList<Employee>();

	// Constructor
	public Employee(String name, String surname, String phonenumber,
	    String email, String birthdate, String id, double salary) {
		if (!Checkers.isValidPhoneNumber(phonenumber)) {
			throw new IllegalArgumentException(
				"phone number is not valid");
		}
		this.name = name;
		this.surname = surname;
		this.phonenumber = phonenumber;
		this.email = email;
		this.birthdate = birthdate;
		this.id = id;
		this.salary = salary;
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

  public void setName(String name) {
      this.name = name;
  }

  public String getSurname() {
      return surname;
  }

  public void setSurname(String surname) {
      this.surname = surname;
  }

  public String getEmail() {
	  //System.out.println("33");
      return email;
  }

  public void setEmail(String email) {
      this.email = email;
  }

  public String getID() {
      return id;
  }

  public void setID(String id) {
	    this.id = id;
	  }

  public String getNameSurname() {
      return getName() + getSurname();
  }

  public String getTelephone() {
    return phonenumber;
  }

  public void setTelephone(String phonenumber) {
      this.phonenumber = phonenumber;
  }

  public double getSalary() {
	  return salary;
  }

  public void setSalary(double salary) {
	  this.salary = salary;
  }
  
  public Day searchDay(String date) {
	  for (int i = 1; i < calendar.size(); i++) {
		 if (!calendar.get(i).getDate().equals(date)) {
			 Day d = new Day(date);
			 calendar.add(d);
			 return d;
		 } else {
			 return calendar.get(i);
		 }
	  }
	return null;
  }

  public String getPhonenumber() {
	return phonenumber;
}

public void setPhonenumber(String phonenumber) {
	this.phonenumber = phonenumber;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public ArrayList<Day> getCalendar() {
	return calendar;
}

public void setCalendar(ArrayList<Day> calendar) {
	this.calendar = calendar;
}

// Method toString including a String format for the given data
  @Override
  public String toString() {
    String str_2 = "";
      String.format("%30s%30s%30s%30s%30s", name, surname,
    		  phonenumber, email, id);
      return str_2;
  }
  //public abstract String getJobTitle();

  // Returns the employee we searched for
  public static Employee searchEmployeeById(String id) {
    for (int i = 0; i < employees.size(); i++) {
      if (employees.get(i).getID().equals(id)) {
            return employees.get(i);
        }
    }
    return null;
  }
  
  public static ArrayList<String> names (){
      ArrayList<String> namesOfEmployees = new ArrayList<String>();
      for (int i = 1; 1 < employees.size(); i++){
          namesOfEmployees.add(employees.get(i).getNameSurname());
      }
      return namesOfEmployees;
  
  }


  // Method toString including a String format for the given data

  public static Employee searchEmployeeByName2(String name) {
    for (int i = 0; i < employees.size(); i++) {
        if (employees.get(i).getNameSurname().equals(name)) {
          return employees.get(i);
        } else if (employees.get(i).getSurname().equals(name)) {
          return employees.get(i);
        } else {
          System.out.println("Employee was not found");
      }
   }
    return null;
  }
}