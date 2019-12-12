import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
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
	        if (dname != "done") {
	            dep = new Department(dname);
	            System.out.println("Department created"
	            		+ " with id: " + dep.getId());
	            //Now, admin inserts basic employees of the department.
	            System.out.println("It's time to insert the "
	            		+ "Employees of the department!");
	            System.out.println("When you are done, please type done.");
	            System.out.println("Name: ");
	            name = sc.next();
	            while (name != "done") {
	            	boolean run = true;
	            	while (run) {
	            	   System.out.println("Surname: ");
	            	   surname = sc.next();
	            	   System.out.println("Email: ");
	            	   email = sc.next();
	            	   System.out.println("Phonenumber: ");
	            	   phoneNumber = sc.nextInt();
	            	   System.out.println("Date of Birth: ");
	            	   inputDate = sc.nextLine();
	            	   Date date = new SimpleDateFormat(""
	            	 		+ "dd/MM/yyyy").parse(inputDate);
	            	   BasicEmployee emp = new BasicEmployee(name, surname,
	            			   phoneNumber, email, date, dep);
	            	   System.out.println("Employee "
	            	 		+ "created with id: " + emp.getId());
	            	   //Loop breakes when an Employee is created.
	            	   break;
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
         	   inputDate = sc.nextLine();
         	   Date date = new SimpleDateFormat(""
         	 		+ "dd/MM/yyyy").parse(inputDate);
         	   MiddleManager emp = new MiddleManager(name, surname,
         			   phoneNumber, email, date);
         	   emp.getManagingDepartments().add(dep);
         	   System.out.println("Manager "
         	 		+ "created with id: " + emp.getId());
	        }
	    } while (dname != "done");
	    Department d = new Department("Top");
	    System.out.println("Now, you are going to add Top Managers."
	    		+ " Type done to terminate.");
	    System.out.println("Name: ");
        name = sc.next();
        while (name != "done") {
        	boolean run = true;
        	while (run) {
        	   System.out.println("Surname: ");
        	   surname = sc.next();
        	   System.out.println("Email: ");
        	   email = sc.next();
        	   System.out.println("Phonenumber: ");
        	   phoneNumber = sc.nextInt();
        	   System.out.println("Date of Birth: ");
        	   inputDate = sc.nextLine();
        	   Date date = new SimpleDateFormat(""
        	 		+ "dd/MM/yyyy").parse(inputDate);
        	   TopManager emp = new TopManager(name, surname,
        			   phoneNumber, email, date);
        	   System.out.println("Top Manager "
        	 		+ "created with id: " + emp.getId());
        	   //Loop breakes when an Employee is created.
        	   break;
        	 }
        	System.out.println("Name: ");
	            name = sc.next();
        }
	}
	public void dataInputScreen() {
		
	}
}
