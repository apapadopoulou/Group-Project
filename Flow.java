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
      String phoneNumber;
      String inputDate = null;
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
                   phoneNumber = sc.next();
                   System.out.println("Date of Birth: ");
                   boolean con = true;
                   while (!con) {
                	   try {
                		   sc.nextLine();
                		   inputDate = sc.nextLine();
                		   break;
                	   } catch (InputMismatchException ime) { }
                   }
                	  sc.nextLine();
                     BasicEmployee emp = new BasicEmployee(name,
                    	surname, phoneNumber, email, inputDate, dep.getId());
                     System.out.println("Employee "
                     + "created with id: " + emp.getID());
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
             phoneNumber = sc.next();
             System.out.println("Date of Birth: ");
             boolean con = true;
             while (con) {
            	 try {
            		 inputDate = sc.nextLine();
            		 break;
            	 } catch (InputMismatchException ime) { }
             }
             sc.nextLine();
             MiddleManager emp = new MiddleManager(name, surname,
             phoneNumber, email, inputDate);
             emp.getManagingDepartments().add(dep);
             System.out.println("Manager "
              + "created with id: " + emp.getID());
          }
      } while (!dname.equals("done"));
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
             phoneNumber = sc.next();
             System.out.println("Date of Birth: ");
             boolean con = true;
             while (con) {
            	 try {
            		 inputDate = sc.nextLine();
            		 break;
            	 } catch (InputMismatchException ime) { }
             }
             TopManager emp = new TopManager(name, surname,
                 phoneNumber, email, inputDate);
             System.out.println("Top Manager "
              + "created with id: " + emp.getID());
             //Loop breakes when an Employee is created.
             break;
           }
          System.out.println("Name: ");
              name = sc.next();
        }
        sc.close();
  }
}
