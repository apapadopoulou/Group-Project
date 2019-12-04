import java.util.ArrayList;
import java.util.Scanner;
import project.Employee;
/*class HumanResources*/
public class HumanResources {
    /*parameters for class HumanResources*/
	private double salary;
	private String department;
	private String name;
	private String surname;
	private int telephone;
	private String email;
	private String id;
	private String password;
	private static ArrayList<HumanResources> hr = new ArrayList<HumanResources>();
    HumanResources hr1 = new HumanResources();

    /*Constructor for class HumanResources*/
    public HumanResources(Employee emp) {
		salary = emp.getSalary();
		department = emp.getDepartmentName();
	      name = emp.getName();
		surname = emp.getSurname();
		telephone = emp.getTelephone();
		email = emp.getEmail();
		id = emp.getId();
		password = Checkers.ValidPassword();
	    hr.add(this);
    }


/*Using for loop in order to find out if the employee is a HR Director and to display the salary of the current employee*/
       for (counter = 0; counter < hr.size(); counter++) {
        hr1.login();/*Calling method login() from Account class*/
        if (department == "HR") {
            System.out.println("The Keyword :HR: is found. The connected user is a HR Director!");
        } else {
            System.out.println("The Keyword :HR: is not found. The connected user is not a HR Director!");
        }
          System.out.println("The salary of the current employee is:" + salary); /*Display the salary of the current connected user*/
       }

/*Creating method to display the menu to the employee*/
   public static void Display_Menu() {
	   System.out.println("1) Edit Salaries\n 2) Edit Timeoffs \n 3) See Calendar");
	   System.out.print( "Selection:");
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
   public static void main(String[] args) {
	   Menu1(); /*Calling method Menu1*/
   }
}

