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
	public static final boolean run = true;
	public static void adminSettingsEntry() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Insert administrator's surname: ");
		String admnSurname = sc.next();
		sc.nextLine();
		System.out.println("Insert administrator's name: ");
        String admnName = sc.next();
        sc.nextLine();
        System.out.println("Insert administrator's phonenumber: ");
        String admnPhonenumber = sc.next();
        sc.nextLine();
        System.out.println("Insert administrator's email: ");
        String admnEmail = sc.next();
        sc.nextLine();
        System.out.println("Insert administrator's birthdate: ");
        String admnBirthdate = sc.next();
        sc.nextLine();
        System.out.println("Insert administrator's salary: ");
        double admnSalary = sc.nextDouble();
        sc.nextLine();
        Department admin = new Department("Administrator");
        Employee admn = new BasicEmployee(admnName, admnSurname, admnPhonenumber, admnEmail, admnBirthdate, admin.getId(), admnSalary);
       
	}
public static void dataEntry() throws ParseException {
  Scanner sc = new Scanner(System.in);
      String dname;
      String name;
      String surname;
      String email;
      String phoneNumber;
      String inputDate = null;
      Department dep;
      double salary = 0;
      do {
          System.out.println("Insert name of Department. "
              + "In case you have inserted all the"
              + " Departments, please type done.");
          dname = sc.next();
          sc.nextLine();
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
              sc.nextLine();
              while (!name.equals("done")) {
                while (run) {
                   System.out.println("Surname: ");
                   surname = sc.next();
                   sc.nextLine();
                   System.out.println("Email: ");
                   email = sc.next();
                   sc.nextLine();
                   System.out.println("Phonenumber: ");
                   phoneNumber = sc.next();
                   sc.nextLine();
                   System.out.println("Date of Birth: ");
                   boolean con = true;
                   while (!con) {
                	   try {
                		   sc.nextLine();
                		   inputDate = sc.nextLine();
                		   sc.nextLine();
                		   break;
                	   } catch (InputMismatchException ime) { }
                   }
                   System.out.println("Salary: ");
                   while (!con) {
                	   try {
                		   salary = sc.nextDouble();
                		   sc.nextLine();
                		   break;
                	   } catch (InputMismatchException ime) { }
                   }
                	  sc.nextLine();
                     BasicEmployee emp = new BasicEmployee(name,
                    	surname, phoneNumber, email, inputDate, dep.getId(), salary);
                     System.out.println("Employee "
                     + "created with id: " + emp.getID());
                     //Loop breakes when an Employee is created.
                     break;
                 }
                System.out.println("Name: ");
                name = sc.next();
                sc.nextLine();
              }
             System.out.println("Insert Department's Manager: ");
             System.out.println("Name: ");
             name = sc.next();
             sc.nextLine();
             System.out.println("Surname: ");
             surname = sc.next();
             sc.nextLine();
             System.out.println("Email: ");
             email = sc.next();
             sc.nextLine();
             System.out.println("Phonenumber: ");
             phoneNumber = sc.next();
             sc.nextLine();
             System.out.println("Date of Birth: ");
             boolean con = true;
             while (con) {
            	 try {
            		 inputDate = sc.nextLine();
            		 sc.nextLine();
            		 break;
            	 } catch (Exception ex) {
            		 System.out.println("An error occured! Please try again!");
            	 }
             }
             while (!con) {
          	   try {
          		   salary = sc.nextDouble();
          		   sc.nextLine();
          		   break;
          	   } catch (InputMismatchException ime) { }
             }
             sc.nextLine();
             MiddleManager emp = new MiddleManager(name, surname,
             phoneNumber, email, inputDate, salary);
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
             sc.nextLine();
             System.out.println("Email: ");
             email = sc.next();
             sc.nextLine();
             System.out.println("Phonenumber: ");
             phoneNumber = sc.next();
             sc.nextLine();
             System.out.println("Date of Birth: ");
             boolean con = true;
             while (con) {
            	 try {
            		 inputDate = sc.nextLine();
            		 sc.nextLine();
            		 break;
            	 } catch (InputMismatchException ime) { }
             }
             while (!con) {
          	   try {
          		   salary = sc.nextDouble();
          		   sc.nextLine();
          		   break;
          	   } catch (InputMismatchException ime) { }
             }
             TopManager emp = new TopManager(name, surname,
                 phoneNumber, email, inputDate, salary);
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
