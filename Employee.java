import java.util.ArrayList;
public abstract class Employee {
  private Department department;
  private String name;
  private String surname;
  private int telephone;
  private String email;
  private String id;
  /*????????? ??? ??????? ??? ?? ID*/
  private static int counter = 1;
  /*????? ??? ??? ?????????? ??? ???????????? Employee*/
  public ArrayList<Employee> employees = new ArrayList<Employee>();
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
  
  public String getDepartment() {
    return department.getName();
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
  public void changeDepartmentandId(String empName, String depName) {
       /* System.out.println('Insert the name of department in which you want to get included');
        String depname = sc.nextLine(); -> for main*/
       deleteEmployeeByName(empName); /* remove employee from his department*/
       for (int i = 0 ; i < Department.departments.size() ; i++) {
              if (Department.departments.get(i).getName().equals(depname)) {
                    System.out.println("The id of department you want to get included is : " + Department.departments.get(i).getId());
                    departments[i].addEmployee(getName());
                    id = String.valueOf(Department.departments.get(i).getId()) + name.substring(1,2) + surname.substring(1,2) + String.valueOf(Department.getEmployeesOfDepartment().size()); /* change employee's id based on his new department*/
              } 
       }
  }
  }