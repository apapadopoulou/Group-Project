import java.util.ArrayList;
public class BasicEmployee extends Employee {
  private ArrayList <BasicEmployee> basicemployees = new ArrayList <BasicEmployee>();
  public BasicEmployee(String name, String surname, String telephone, String email, Department department) {
    super(name, surname, telephone, email, department);
    id = String.valueOf(department.getId()) + name.substring(1,2) + surname.substring(1,2) + String.valueOf(department.getEmployeesOfDepartment().size());
    employees.add(this);
    basicemployees.add(this);
  }
  
  @Override
  public String getJobTitle() {
    // TODO Auto-generated method stub
    return null;
  }
}
