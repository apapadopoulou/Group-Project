import java.util.ArrayList;
public abstract class Employee {
  private Department department;
  private String name;
  private String surname;
  private int telephone;
  private String email;
  private String id;
  private PersonalisedCalendar employeesCalendar = new PersonalisedCalendar();
  /*????????? ??? ??????? ??? ?? ID*/
  private static int counter = 1;
  /*????? ??? ??? ?????????? ??? ???????????? Employee*/
  public static ArrayList<Employee> employees = new ArrayList<Employee>();
  /* ?????? Constructor ??? ??? ????? Employee*/
  public Employee(String name, String surname, int telephone, String email, Department department) {
    this.name = name;
    this.surname = surname;
    this.telephone = telephone;
    this.email = email;
    this.department = department;
    department.getEmployeesOfDepartment().add(this);
    id = String.valueOf(department.getId()) + name.substring(1,2) + surname.substring(1,2) + String.valueOf(department.getEmployeesOfDepartment().size());
    employees.add(this);
  }
  
  public String getDepartmentName() {
    return department.getName();
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
  
  public static Employee searchEmployeeById2(String id) {
    for (int i = 0; i < employees.size(); i++) {
        if (employees.get(i).getId() == id) {
          return employees.get(i);
        } 
      }
      return null;
  }
  
  /* this is a method that changes employee's id based on his new department */
  public void changeDepartmentAndId(String empName, int depId) {
       /* System.out.println('Insert the name of department in which you want to get included');
        String depname = sc.nextLine(); -> for main*/
      Employee e = Employee.searchEmployeeByName2(empName);
      e.getDepartment().deleteEmployeeByName(empName);
    Department d = Department.searchDepartmentById(depId);
    e.setDepartment(d);
    d.addEmployee(e);
      e.setId(String.valueOf(d.getId()) + e.getName().substring(1,2) + e.getSurname().substring(1,2) + String.valueOf(d.getEmployeesOfDepartment().size()));
      
  }


  }