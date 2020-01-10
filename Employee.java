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

  public void setBirthDate(String birthdate) {
    this.birthdate = birthdate;
    String tableName = typeOfEmployee();
    DBcon.updateEmployeeVar(tableName, "birthdate", birthdate, id);
  }

  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
      String tableName = typeOfEmployee();
      DBcon.updateEmployeeVar(tableName, "nameEMP", name, id);
  }

  public String getSurname() {
      return surname;
  }

  public void setSurname(String surname) {
      this.surname = surname;
      String tableName = typeOfEmployee();
      DBcon.updateEmployeeVar(tableName, "surname", surname, id);
  }

  public String getEmail() {
      return email;
  }

  public void setEmail(String email) {
      this.email = email;
      String tableName = typeOfEmployee();
      DBcon.updateEmployeeVar(tableName, "email", email, id);
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

  public double getSalary() {
	  return salary;
  }

  public void setSalary(double salary) {
	  this.salary = salary;
	  String tableName = typeOfEmployee();
	  DBcon.updateEmployeeVar(tableName, "salary", salary, id);
  }
  
  public Day searchDay(String date) {
	  if (!calendar.isEmpty()) {
		  for (int i = 0; i < calendar.size(); i++) {
			  if (calendar.get(i).getDate().equals(date)) {
				  return calendar.get(i);
			  }
	 	}
	  }
	  calendar.add(new Day(date, getID()));
	  return calendar.get(calendar.size()-1);
  }

  public String getPhonenumber() {
	return phonenumber;
}

public void setPhonenumber(String phonenumber) {
	this.phonenumber = phonenumber;
	String tableName = typeOfEmployee();
	DBcon.updateEmployeeVar(tableName, "phonenumber", phonenumber, id);
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
  
  public String typeOfEmployee() {
	  if (this instanceof BasicEmployee) {
		  return "BasicEmployee";
	  } else if (this instanceof MiddleManager) {
		  return "MiddleManager";
	  } else if (this instanceof TopManager) {
		  return "TopManager";
	  } else {
		  return null;
	  }
  }
}