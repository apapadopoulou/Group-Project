import java.util.ArrayList;
import java.util.Scanner;
public class MiddleManager extends Employee {
  private ArrayList <Department> managingDepartments = new ArrayList <Department>();
  public MiddleManager(String name, String surname, String telephone, String email, Department department) {
    super(name, surname, telephone, email, department);
    System.out.println("Insert manager's department.");
    Scanner sc = new Scanner(System.in);
    String nameOfDepartment = sc.nextLine();
    for (int i=0; i<Department.departments.size(); i++) {
      if (Department.departments.get(i).getName().equals(nameOfDepartment)) {
        managingDepartments.add(Department.departments.get(i));
      } else {
        System.out.println("The department you inserted doesn't exist.");
      }
    }
    /* do {
      System.out.println("Is there any other Department of employees you manage? If yes, please press y or Y, else please press n or N.");
      String ans = sc.nextLine();
      if (ans.equals(y) || ans.equals(Y)) {
        System.out.println("Please insert Department's name.");
        for (int i=0; i<Department.departments.size(); i++) {
              if (Department.departments.get(i).getName().equals(nameOfDepartment)) {
                managingDepartments.add(Department.departments.get(i));
              } else {
                System.out.println("The department you inserted doesn't exist.");
              }
          }
        }
    } while (ans.equals(y) || ans.equals(Y)) */
    sc.close();
  }
}

