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
        		 break;
        	 } catch (Exception ex) {
        		 System.out.println("An error occured! Please try again!");
        	 }
         }
		sc.nextLine();
		System.out.println("Insert administrator's name: ");
        String admnName;
        while (run) {
       	 try {
       		 admnName = sc.next();
       		 sc.nextLine();
       		 break;
       	 } catch (Exception ex) {
       		 System.out.println("An error occured! Please try again!");
       	 }
        }
        sc.nextLine();
        System.out.println("Insert administrator's phonenumber: ");
        String admnPhonenumber;
        while (run) {
       	 try {
       		 admnPhonenumber = sc.next();
       		 sc.nextLine();
       		 break;
       	 } catch (Exception ex) {
       		 System.out.println("An error occured! Please try again!");
       	 }
        }
        sc.nextLine();
        System.out.println("Insert administrator's email: ");
        String admnEmail;
        while (run) {
       	 try {
       		 admnEmail = sc.next();
       		 sc.nextLine();
       		 break;
       	 } catch (Exception ex) {
       		 System.out.println("An error occured! Please try again!");
       	 }
        }
        sc.nextLine();
        System.out.println("Insert administrator's birthdate (dd/mm/yyyy): ");
        String admnBirthdate;
        while (run) {
       	 try {
       		 admnBirthdate = sc.next();
       		 sc.nextLine();
       		 break;
       	 } catch (Exception ex) {
       		 System.out.println("An error occured! Please try again!");
       	 }
        }
        sc.nextLine();
        System.out.println("Insert administrator's salary: ");
        double admnSalary;
        while (run) {
       	 try {
       		 admnSalary = sc.nextDouble();
       		 sc.nextLine();
       		 break;
       	 } catch (Exception ex) {
       		 System.out.println("An error occured! Please try again!");
       	 }
        }
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
          while (run) {
         	 try {
         		 dname = sc.next();
         		 sc.nextLine();
         		 break;
         	 } catch (Exception ex) {
         		 System.out.println("An error occured! Please try again!");
         	 }
          }
          sc.nextLine();
          if (!dname.equals("done")) {
              dep = new Department(dname);
              System.out.println("Department created"
                  + " with id: " + dep.getId());
              System.out.println("It's time to insert the "
                  + "Employees of the department!");
              System.out.println("When you are done, please type done.");
              System.out.println("Name: ");
              while (run) {
             	 try {
             		 name = sc.next();
             		 sc.nextLine();
             		 break;
             	 } catch (Exception ex) {
             		 System.out.println("An error occured! Please try again!");
             	 }
              }
              sc.nextLine();
              while (!name.equals("done")) {
                while (run) {
                   System.out.println("Surname: ");
                   while (run) {
                  	 try {
                  		 surname = sc.next();
                  		 sc.nextLine();
                  		 break;
                  	 } catch (Exception ex) {
                  		 System.out.println("An error occured! Please try again!");
                  	 }
                   }
                   sc.nextLine();
                   System.out.println("Email: ");
                   while (run) {
                  	 try {
                  		 email = sc.next();
                  		 sc.nextLine();
                  		 break;
                  	 } catch (Exception ex) {
                  		 System.out.println("An error occured! Please try again!");
                  	 }
                   }
                   sc.nextLine();
                   System.out.println("Phonenumber: ");
                   while (run) {
                  	 try {
                  		 phoneNumber = sc.next();
                  		 sc.nextLine();
                  		 break;
                  	 } catch (Exception ex) {
                  		 System.out.println("An error occured! Please try again!");
                  	 }
                   }
                   sc.nextLine();
                   System.out.println("Date of Birth: ");
                   while (run) {
                	   try {
                		   sc.nextLine();
                		   inputDate = sc.nextLine();
                		   sc.nextLine();
                		   break;
                	   } catch (Exception ex) {
                		   System.out.println("An error occured! Please try again!");
                	   }
                   }
                   System.out.println("Salary: ");
                   while (run) {
                	   try {
                		   salary = sc.nextDouble();
                		   sc.nextLine();
                		   break;
                	   } catch (Exception ex) {
                		   System.out.println("An error occured! Please try again!");
                	   }
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
                while (run) {
             	   try {
             		   name = sc.next();
             		   sc.nextLine();
             		   break;
             	   } catch (Exception ex) {
             		   System.out.println("An error occured! Please try again!");
             	   }
                }
                sc.nextLine();
              }
             System.out.println("Insert Department's Manager: ");
             System.out.println("Name: ");
             while (run) {
           	   try {
           		   name = sc.next();
           		   sc.nextLine();
           		   break;
           	   } catch (Exception ex) {
           		   System.out.println("An error occured! Please try again!");
           	   }
              }
             sc.nextLine();
             System.out.println("Surname: ");
             while (run) {
           	   try {
           		   surname = sc.next();
           		   sc.nextLine();
           		   break;
           	   } catch (Exception ex) {
           		   System.out.println("An error occured! Please try again!");
           	   }
              }
             sc.nextLine();
             System.out.println("Email: ");
             while (run) {
           	   try {
           		   email = sc.next();
           		   sc.nextLine();
           		   break;
           	   } catch (Exception ex) {
           		   System.out.println("An error occured! Please try again!");
           	   }
              }
             sc.nextLine();
             System.out.println("Phonenumber: ");
             while (run) {
            	 try {
            		 phoneNumber = sc.next();
            		 sc.nextLine();
            		 break;
            	 } catch (Exception ex) {
            		 System.out.println("An error occured! Please try again!");
            	 }
             }
             sc.nextLine();
             System.out.println("Date of Birth: ");
             while (run) {
            	 try {
            		 inputDate = sc.nextLine();
            		 sc.nextLine();
            		 break;
            	 } catch (Exception ex) {
            		 System.out.println("An error occured! Please try again!");
            	 }
             }
             System.out.println("Salary: ");
             while (run) {
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
      while (run) {
    	   try {
    		   name = sc.next();
    		   sc.nextLine();
    		   break;
    	   } catch (Exception ex) {
    		   System.out.println("An error occured! Please try again!");
    	   }
       }
        while (!name.equals("done")) {
          while (run) {
             System.out.println("Surname: ");
             while (run) {
           	   try {
           		   surname = sc.next();
           		   sc.nextLine();
           		   break;
           	   } catch (Exception ex) {
           		   System.out.println("An error occured! Please try again!");
           	   }
              }
             sc.nextLine();
             System.out.println("Email: ");
             while (run) {
           	   try {
           		   email = sc.next();
           		   sc.nextLine();
           		   break;
           	   } catch (Exception ex) {
           		   System.out.println("An error occured! Please try again!");
           	   }
              }
             sc.nextLine();
             System.out.println("Phonenumber: ");
             while (run) {
           	   try {
           		   phoneNumber = sc.next();
           		   sc.nextLine();
           		   break;
           	   } catch (Exception ex) {
           		   System.out.println("An error occured! Please try again!");
           	   }
              }
             sc.nextLine();
             System.out.println("Date of Birth: ");
             while (run) {
            	 try {
            		 inputDate = sc.nextLine();
            		 sc.nextLine();
            		 break;
            	 } catch (Exception ex) {
            		 System.out.println("An error occured! Please try again!");
            	 }
             }
             while (run) {
          	   try {
          		   salary = sc.nextDouble();
          		   sc.nextLine();
          		   break;
          	   } catch (Exception ex) { 
          		 System.out.println("An error occured! Please try again!");
          	   }
             }
             TopManager emp = new TopManager(name, surname,
                 phoneNumber, email, inputDate, salary);
             System.out.println("Top Manager "
              + "created with id: " + emp.getID());
             //Loop breakes when an Employee is created.
             break;
           }
          System.out.println("Name: ");
          while (run) {
       	   try {
       		   name = sc.next();
       		   sc.nextLine();
       		   break;
       	   } catch (Exception ex) {
       		   System.out.println("An error occured! Please try again!");
       	   }
          }
        }
        sc.close();
  }
}
