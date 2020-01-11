import java.util.ArrayList;
/**
 * @author BusyB
 */
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
  /**
   * Constructor for class Employee.
   * @param name
   * @param surname
   * @param phonenumber
   * @param email
   * @param birthdate
   * @param id
   * @param salary
   */
  public Employee(String name, String surname, String phonenumber,
      String email, String birthdate, String id, double salary) {
    this.name = name;
    this.surname = surname;
    this.phonenumber = phonenumber;
    this.email = email;
    this.birthdate = birthdate;
    this.id = id;
    this.salary = salary;
  }

  /**
   * Gets the birthDate
   * @return birthdate
   */
  public String getBirthDate() {
    return birthdate;
  }

  /**
   * Sets the birthDate
   * @param birthdate
   */
  public void setBirthDate(String birthdate) {
    this.birthdate = birthdate;
    String tableName = typeOfEmployee();
    DBcon.updateEmployeeVar(tableName, "birthdate", birthdate, id);
  }

  /**
   * Gets the name
   * @return name
   */
  public String getName() {
      return name;
  }

  /**
   * Sets the name
   * @param name
   */
  public void setName(String name) {
      this.name = name;
      String tableName = typeOfEmployee();
      DBcon.updateEmployeeVar(tableName, "nameEMP", name, id);
  }

  /**
   * Gets the surname
   * @return surname
   */
  public String getSurname() {
      return surname;
  }

  /**
   * Sets the surname
   * @param surname
   */
  public void setSurname(String surname) {
      this.surname = surname;
      String tableName = typeOfEmployee();
      DBcon.updateEmployeeVar(tableName, "surname", surname, id);
  }

  /**
   * Gets the email
   * @return email
   */
  public String getEmail() {
      return email;
  }

  /**
   * Sets the email
   * @param email
   */
  public void setEmail(String email) {
      this.email = email;
      String tableName = typeOfEmployee();
      DBcon.updateEmployeeVar(tableName, "email", email, id);
  }

  /**
   * Gets the id
   * @return id
   */
  public String getID() {
      return id;
  }

  /**
   * Sets the id
   * @param id
   */
  public void setID(String id) {
      this.id = id;
    }

  /**
   * Gets NameSurname
   * @return getName()+ " " + getsurname()
   */
  public String getNameSurname() {
      return getName() + " " + getSurname();
  }

  /**
   * Gets the salary
   * @return salary
   */
  public double getSalary() {
    return salary;
  }

  /**
   * Sets the salary
   * @param salary
   */
  public void setSalary(double salary) {
    this.salary = salary;
    String tableName = typeOfEmployee();
    DBcon.updateEmployeeVar(tableName, "salary", salary, id);
  }
  
  /**
   * Searches calendar list by day and returns the calendar object
   * @param date
   * @return calendar.get(i) or calendar.get(calendar.size()-1)
   */
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

  /**
   * Gets the phoneNumber
   * @return phonenumber
   */
  public String getPhonenumber() {
  return phonenumber;
  }

  /**
   * Sets the phonenumber
   * @param phonenumber
   */
  public void setPhonenumber(String phonenumber) {
	  this.phonenumber = phonenumber;
	  String tableName = typeOfEmployee();
	  DBcon.updateEmployeeVar(tableName, "phonenumber", phonenumber, id);
  }

  /**
   * Gets the calendar object 
   * @return
   */
  public ArrayList<Day> getCalendar() {
	  return calendar;
  }

  /**
   * Sets calendar object
   * @param calendar
   */
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
  /**
   * Searches employees list by id and returns the employee if he exists
   * @param id
   * @return employees.get(i) or null
   */
  public static Employee searchEmployeeById(String id) {
    for (int i = 0; i < employees.size(); i++) {
      if (employees.get(i).getID().equals(id)) {
            return employees.get(i);
        }
    }
    return null;
  }
  
  /**
   * Returns the names of the employees
   * @return namesOfEmployees
   */
  public static ArrayList<String> names (){
      ArrayList<String> namesOfEmployees = new ArrayList<String>();
      for (int i = 1; 1 < employees.size(); i++){
          namesOfEmployees.add(employees.get(i).getNameSurname());
      }
      return namesOfEmployees;
  
  }

  /**
   * Searches employees list by name and returns the employee we searched for if he exists
   * @param name
   * @return employees.get(i) or null
   */
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
  
  /**
   * Returns the type of Employee of an employee object
   * @return "BasicEmployee" or "MiddleManager" or "TopManager" or null
   */
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
  public static double salariesTotal() {
	  double total = 0.0;
	  for (int count = 0; count < employees.size(); count++) {
		  total += employees.get(count).getSalary();
	  }
	  return total;
  }
}