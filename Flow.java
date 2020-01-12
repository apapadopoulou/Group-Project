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
		String admnSurname;
		 while (run) {
        	 try {
        		 admnSurname = sc.next();
        		 sc.nextLine();
        		 if (!Checkers.isValidLastName(admnSurname)) {
        			 throw new Exception();
        		 }
        		 break;
        	 } catch (Exception ex) {
        		 System.out.println("An error occurred! Please try again!");
        		 sc.nextLine();
        	 }
         }
		System.out.println("Insert administrator's name: ");
        String admnName;
        while (run) {
       	 try {
       		 admnName = sc.next();
       		 sc.nextLine();
       		if (!Checkers.isValidFirstName(admnName)) {
   			 throw new Exception();
   		 }
       		 break;
       	 } catch (Exception ex) {
       		 System.out.println("An error occurred! Please try again!");
       		 sc.nextLine();
       	 }
        }
        System.out.println("Insert administrator's phonenumber: ");
        String admnPhonenumber;
        while (run) {
       	 try {
       		 admnPhonenumber = sc.next();
       	    if (!Checkers.isValidPhoneNumber(admnPhonenumber)) {
       	      throw new IllegalArgumentException();
       	    }
       		 sc.nextLine();
       		 break;
       	 } catch (Exception ex) {
       		 System.out.println("An error occurred! Please try again!");
       		 sc.nextLine();
       	 }
        }
        System.out.println("Insert administrator's email: ");
        String admnEmail;
        while (run) {
       	 try {
       		 admnEmail = sc.next();
       		 sc.nextLine();
       		 break;
       	 } catch (Exception ex) {
       		 System.out.println("An error occurred! Please try again!");
       		 sc.nextLine();
       	 }
        }
        System.out.println("Insert administrator's birthdate (dd/mm/yyyy): ");
        String admnBirthdate;
        while (run) {
       	 try {
       		 admnBirthdate = sc.next();
       		 sc.nextLine();
       		 break;
       	 } catch (Exception ex) {
       		 System.out.println("An error occurred! Please try again!");
       		 sc.nextLine();
       	 }
        }
        System.out.println("Insert administrator's salary: ");
        double admnSalary;
        while (run) {
       	 try {
       		 admnSalary = sc.nextDouble();
       		 sc.nextLine();
       		 break;
       	 } catch (Exception ex) {
       		 System.out.println("An error occurred! Please try again!");
       		 sc.nextLine();
       	 }
        }
        Department admin = new Department("Administrator");
        Employee admn = new BasicEmployee(admnName, admnSurname, admnPhonenumber, admnEmail, admnBirthdate, admin.getId(), admnSalary);
	}
public static void dataEntry() {
  Scanner sc = new Scanner(System.in);
      String dname = null;
      String name = null;
      String surname = null;
      String email = null;
      String phoneNumber = null;
      String inputDate = null;
      Department dep = null;
      double salary = 0;
      do {
          System.out.println("Insert name of Department. "
              + "In case you have inserted all the"
              + " Departments, please type 'Done'.");
          while (run) {
         	 try {
         		 dname = sc.next();
         		 sc.nextLine();
         		 break;
         	 } catch (Exception ex) {
         		 System.out.println("An error occurred! Please try again!");
         		 sc.nextLine();
         	 }
          }
          if (!dname.equals("Done")) {
              dep = new Department(dname);
              System.out.println("Department created"
                  + " with id: " + dep.getId());
              System.out.println("It's time to insert the "
                  + "Employees of the department!");
              System.out.println("When you are done, please type 'Done'.");
              System.out.println("Name: ");
              while (run) {
             	 try {
             		 name = sc.next();
             		 sc.nextLine();
             		 if (!Checkers.isValidFirstName(name)) {
             			 throw new Exception();
             		 }
             		 break;
             	 } catch (Exception ex) {
             		 System.out.println("An error occurred! Please try again!");
             		 sc.nextLine();
             	 }
              }
              while (!name.equals("Done")) {
                while (run) {
                   System.out.println("Surname: ");
                   while (run) {
                  	 try {
                  		 surname = sc.next();
                  		 sc.nextLine();
                  		 if (!Checkers.isValidLastName(surname)) {
                  			 throw new Exception();
                  		 }
                  		 break;
                  	 } catch (Exception ex) {
                  		 System.out.println("An error occurred! Please try again!");
                  		 sc.nextLine();
                  	 }
                   }
                   System.out.println("Email: ");
                   while (run) {
                  	 try {
                  		 email = sc.next();
                  		 sc.nextLine();
                  		 break;
                  	 } catch (Exception ex) {
                  		 System.out.println("An error occurred! Please try again!");
                  		 sc.nextLine();
                  	 }
                   }
                   System.out.println("Phonenumber: ");
                   while (run) {
                  	 try {
                  		 phoneNumber = sc.next();
                  		if (!Checkers.isValidPhoneNumber(phoneNumber)) {
                     	      throw new IllegalArgumentException();
                     	    }
                  		 sc.nextLine();
                  		 break;
                  	 } catch (Exception ex) {
                  		 System.out.println("An error occurred! Please try again!");
                  		 sc.nextLine();
                  	 }
                   }
                   System.out.println("Date of Birth (dd/mm/yyyy): ");
                   while (run) {
                	   try {
                		   inputDate = sc.next();
                		   sc.nextLine();
                		   break;
                	   } catch (Exception ex) {
                		   System.out.println("An error occurred! Please try again!");
                		   sc.nextLine();
                	   }
                   }
                   System.out.println("Salary: ");
                   while (run) {
                	   try {
                		   salary = sc.nextDouble();
                		   sc.nextLine();
                		   break;
                	   } catch (Exception ex) {
                		   System.out.println("An error occurred! Please try again!");
                		   sc.nextLine();
                	   }
                   }
                     BasicEmployee emp = new BasicEmployee(name,
                    	surname, phoneNumber, email, inputDate, dep.getId(), salary);
                     System.out.println("Employee "
                     + "created with id: " + emp.getID());
                     //Loop breakes when an Employee is created.
                     break;
                 }
                System.out.println("Name: ");
                while (run) {
             	   try {
             		   name = sc.next();
             		   sc.nextLine();
             		   if (!Checkers.isValidFirstName(name)) {
               			 throw new Exception();
               		  }
             		   break;
             	   } catch (Exception ex) {
             		   System.out.println("An error occurred! Please try again!");
             		  sc.nextLine();
             	   }
                }
              }
             System.out.println("Does the department's manager already exists? (Y for yes, N for no): ");
             String ans;
             while (run) {
           	   try {
           		   ans = sc.next();
           		   sc.nextLine();
           		   break;
           	   } catch (Exception ex) {
           		   System.out.println("An error occurred! Please try again!");
           		  sc.nextLine();
           	   }
             }
           	 if (ans.contentEquals(("N"))) {
           		 System.out.println("Insert Department's Manager: ");
           		 System.out.println("Name: ");
           		 while (run) {
           			 try {
           				 name = sc.next();
           				 sc.nextLine();
           				 if (!Checkers.isValidFirstName(name)) {
                 			 throw new Exception();
                 		 }
           				 break;
           			 } catch (Exception ex) {
           				 System.out.println("An error occurred! Please try again!");
           			     sc.nextLine();
           			  }
           		   }
           		   System.out.println("Surname: ");
           		   while (run) {
           			   try {
           				   surname = sc.next();
           				   sc.nextLine();
           				   if (!Checkers.isValidLastName(surname)) {
                			   throw new Exception();
                		   }
           				   break;
           			   } catch (Exception ex) {
           				   System.out.println("An error occurred! Please try again!");
           				   sc.nextLine();
           			   }
           		   }
           		   System.out.println("Email: ");
           		   while (run) {
           			   try {
           				   email = sc.next();
           				   sc.nextLine();
           				   break;
           			   } catch (Exception ex) {
           				   System.out.println("An error occurred! Please try again!");
           				   sc.nextLine();
           			   }
           		   }
           		   System.out.println("Phonenumber: ");
           		   while (run) {
           			   try {
           				   phoneNumber = sc.next();
           				if (!Checkers.isValidPhoneNumber(phoneNumber)) {
           	       	      throw new IllegalArgumentException();
           	       	    }
           				   break;
           			   } catch (Exception ex) {
           				   System.out.println("An error occurred! Please try again!");
           				   sc.nextLine();
           			   }
           		   }
           		   System.out.println("Date of Birth (dd/mm/yyyy): ");
           		   while (run) {
           			   try {
           				   inputDate = sc.next();
           				   sc.nextLine();
           				   break;
           			   } catch (Exception ex) {
           				   System.out.println("An error occurred! Please try again!");
           				   sc.nextLine();
           			   }
           		   }
           		   System.out.println("Salary: ");
           		   while (run) {
           			   try {
           				   salary = sc.nextDouble();
           				   sc.nextLine();
           				   break;
           			   } catch (Exception ex) {
           				   System.out.println("An error occurred! Please try again!");
           				   sc.nextLine();
           			   }
           		   }
           	   } else if (ans.equals("Y")) {
           		   System.out.println("Insert Manager's ID: ");
           		   String id;
           		   while (run) {
        			   try {
        				   id = sc.next();
        				   sc.nextLine();
        				   break;
        			   } catch (Exception ex) {
        				   System.out.println("An error occurred! Please try again!");
        				   sc.nextLine();
        			   }
        		   }
           		   for (int count = 0; count < MiddleManager.middleManagers.size(); count++) {
           			   if (MiddleManager.middleManagers.get(count).getID().equals(id)){
           				MiddleManager.middleManagers.get(count).getManagingDepartments().add(dep);
           			   }
           		   }
           	   }
             MiddleManager emp = new MiddleManager(name, surname,
             phoneNumber, email, inputDate, salary);
             emp.getManagingDepartments().add(dep);
             dep.setManagerId(emp.getID());
             System.out.println("Manager "
              + "created with id: " + emp.getID());
          }
      } while (!dname.equals("Done"));
      System.out.println("Now, you are going to add Top Managers."
      + " Type 'Done' to terminate.");
      System.out.println("Name: ");
      while (run) {
    	   try {
    		   name = sc.next();
    		   sc.nextLine();
    		   if (!Checkers.isValidFirstName(name)) {
       			 throw new Exception();
    		   }
    		   break;
    	   } catch (Exception ex) {
    		   System.out.println("An error occurred! Please try again!");
    		   sc.nextLine();
    	   }
       }
        while (!name.equals("Done")) {
             System.out.println("Surname: ");
             while (run) {
           	   try {
           		   surname = sc.next();
           		   sc.nextLine();
           		   if (!Checkers.isValidLastName(surname)) {
        			 throw new Exception();
           		   }
           		   break;
           	   } catch (Exception ex) {
           		   System.out.println("An error occurred! Please try again!");
           		   sc.nextLine();
           	   }
              }
             System.out.println("Email: ");
             while (run) {
           	   try {
           		   email = sc.next();
           		   sc.nextLine();
           		   break;
           	   } catch (Exception ex) {
           		   System.out.println("An error occurred! Please try again!");
           		   sc.nextLine();
           	   }
              }
             System.out.println("Phonenumber: ");
             while (run) {
           	   try {
           		   phoneNumber = sc.next();
           		if (!Checkers.isValidPhoneNumber(phoneNumber)) {
             	      throw new IllegalArgumentException();
             	    }
           		   sc.nextLine();
           		   break;
           	   } catch (Exception ex) {
           		   System.out.println("An error occurred! Please try again!");
           		   sc.nextLine();
           	   }
              }
             System.out.println("Date of Birth (dd/mm/yyyy): ");
             while (run) {
            	 try {
            		 inputDate = sc.next();
            		 sc.nextLine();
            		 break;
            	 } catch (Exception ex) {
            		 System.out.println("An error occurred! Please try again!");
            		 sc.nextLine();
            	 }
             }
             System.out.println("Salary: ");
             while (run) {
          	   try {
          		   salary = sc.nextDouble();
          		   sc.nextLine();
          		   break;
          	   } catch (Exception ex) { 
          		 System.out.println("An error occurred! Please try again!");
          		 sc.nextLine();
          	   }
             }
             TopManager emp = new TopManager(name, surname,
                 phoneNumber, email, inputDate, salary);
             System.out.println("Top Manager "
              + "created with id: " + emp.getID());
          System.out.println("Name: ");
          while (run) {
       	   try {
       		   name = sc.next();
       		   sc.nextLine();
       		   if (!Checkers.isValidFirstName(name)) {
       			   throw new Exception();
       		   }
       		   break;
       	   } catch (Exception ex) {
       		   System.out.println("An error occurred! Please try again!");
       		   sc.nextLine();
       	   }
          }
        }
        sc.close();
  }
}
