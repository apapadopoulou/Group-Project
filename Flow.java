import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.lang.Exception;
import java.util.InputMismatchException;
 /* Class Flow manages the main flow of the application and
  * supports data entry and first connection to the database." */
public class Flow {
public static void dataEntry() throws ParseException {
  Scanner sc = new Scanner(System.in);
      String dname;
      String name;
      String surname;
      String email;
      int phoneNumber;
      String inputDate;
      Department dep;
      do {
          System.out.println("Insert name of Department. "
              + "In case you have inserted all the"
              + " Departments, please type done.");
          dname = sc.next();
          if (!dname.equals("done")) {
              dep = new Department(dname);
              System.out.println("Department created"
                  + " with id: " + dep.getId());
              //Now, admin inserts basic employees of the department.
              System.out.println("It's time to insert the "
                  + "Employees of the department!");
              System.out.println("When you are done, please type done.");
              System.out.println("Name: ");
              name = sc.next();
              while (!name.equals("done")) {
                boolean run = true;
                while (run) {
                   System.out.println("Surname: ");
                   surname = sc.next();
                   System.out.println("Email: ");
                   email = sc.next();
                   System.out.println("Phonenumber: ");
                   phoneNumber = sc.nextInt();
                   System.out.println("Date of Birth: ");
                   try {
                      sc.nextLine();
                      inputDate = sc.nextLine();
                   } catch (DateformatException e2) {
                      System.err.println("Wrong way to import date of birth. Please import date birth according to 'dd/MM/yyyy'." + e2);
                   } catch (InputMismatchException e3) {}
                    Date date = new SimpleDateFormat(""
                    + "dd/MM/yyyy").parse(inputDate);
                    sc.nextLine();
                   BasicEmployee emp = new BasicEmployee(name, surname,
                       phoneNumber, email, date, dep);
                   System.out.println("Employee "
                    + "created with id: " + emp.getId());
                   //Loop breakes when an Employee is created.
                   return;
                 }
                System.out.println("Name: ");
                name = sc.next();
              }
             System.out.println("Insert Department's Manager: ");
             System.out.println("Name: ");
             name = sc.next();
             System.out.println("Surname: ");
             surname = sc.next();
             System.out.println("Email: ");
             email = sc.next();
             System.out.println("Phonenumber: ");
             phoneNumber = sc.nextInt();
             System.out.println("Date of Birth: ");
             try {
                inputDate = sc.nextLine();
             } catch (DateformatException e4) {
                System.err.println("Wrong way to import date of birth. Please import date birth according to 'dd/MM/yyyy'." + e4);
             } catch (InputMismatchException e5) {}
             Date date = new SimpleDateFormat(""
             + "dd/MM/yyyy").parse(inputDate);
             sc.nextLine();
             MiddleManager emp = new MiddleManager(name, surname,
             phoneNumber, email, date);
             emp.getManagingDepartments().add(dep);
             System.out.println("Manager "
              + "created with id: " + emp.getId());
          }
      } while (!dname.equals("done"));
      Department d = new Department("Top");
      System.out.println("Now, you are going to add Top Managers."
      + " Type done to terminate.");
      System.out.println("Name: ");
        name = sc.next();
        while (!name.equals("done")) {
          boolean run = true;
          while (run) {
             System.out.println("Surname: ");
             surname = sc.next();
             System.out.println("Email: ");
             email = sc.next();
             System.out.println("Phonenumber: ");
             phoneNumber = sc.nextInt();
             System.out.println("Date of Birth: ");
             try {
                  inputDate = sc.nextLine();
             } catch (DateformatException e6) {
                  System.err.println("Wrong way to import date of birth. Please import date birth according to 'dd/MM/yyyy'." + e6);
             } catch (InputMismatchException e7) {}
                  Date date = new SimpleDateFormat(""
                  + "dd/MM/yyyy").parse(inputDate);
             TopManager emp = new TopManager(name, surname,
                 phoneNumber, email, date);
             System.out.println("Top Manager "
              + "created with id: " + emp.getId());
             //Loop breakes when an Employee is created.
             return;
           }
          System.out.println("Name: ");
              name = sc.next();
        }
        sc.close();
  }
public static void main(String [] args) {
  try {
  dataEntry();
  }
  catch (Exception e) { }
}
  public void dataInputScreen() {
    
  }
}
