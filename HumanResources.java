import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

/*class HumanResources*/
public class HumanResources extends Employee {
    /*Constructor for class HumanResources*/
    public HumanResources(String name, String surname, String phonenumber,
    		String email, String id, Date birthdate) {
		super(name, surname, phonenumber, email, id, birthdate);
		employees.add(this);
    }

/*Using for loop in order to find out if the employee is a HR Director
 *  and to display the salary of the current employee*/
     /*  for (int counter = 0; counter < employees.size(); counter++) {
        hr.login();/*Calling method login() from Account class*/
       /* if (Department.getDepartments().get(counter).getName.equals("HR")) {
            System.out.println("The current employee"
            + "is registered at HR department!");
            Menu1();/*Calling method Menu1() */
     /*   } else {
            System.out.println("The current employee is not registered"
            + " at HR department.");
        }
       }
        /*Creating method to display the menu to the employee*/
        public static void Display_Menu() {
     	   System.out.println("1) Edit Salaries\n 2) Edit Timeoffs \n 3)"
     	   		+ " See Calendar");
     	   System.out.print("Selection:");
        }
        /*Creating method Menu1 to make menu operating*/
        public static void Menu1() {
     	   Scanner sc = new Scanner(System.in);
     	   Display_Menu(); /*Calling method Display_Menu*/
     	   switch (sc.nextInt()) { /*Picking one of the above selections*/
     		   case 1:
     		     System.out.println("You picked Edit Salaries");
     		     break;
     		   case 2:
     		     System.out.println("You picked Edit Timeoffs");
     		     break;
     		   case 3:
     		     System.out.println("You picked See Calendar");
     		     break;
     		   default:
     		     System.out.println("Unrecognized option");
     	   }
        }
       }
