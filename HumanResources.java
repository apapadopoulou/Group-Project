import java.util.ArrayList;
import java.util.Scanner;
public class HumanResources {
	private String email;
	private double salary;
	private String name;
	private String surname;
	public static ArrayList <HumanResources> employees = new ArrayList<HumanResources>();
    /*Constructor for class HumanResources*/
    public HumanResources(String email, double salary, String name, String surname) {
		this.email = email;
		this.salary = salary;
		this.name = name;
		this.surname = surname;
    }
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	 public void setName(String name) {
		 this.name = name;
	 }
	 public String getName() {
		 return name;
	 }
	 public void setSurname(String surname) {
		 this.surname = surname;
	 }
	 public String getSurname() {
		 return surname;
	 }

    public void setSalary(double salary) {
			this.salary = salary;
	}
    public double getSalary() {
		return salary;
    }
/*Using for loop in order to find out if the employee is a HR Director and to display the salary of the current employee*/
       for (counter = 0; counter <= employees.size(); counter++) {
        if (email.contains("HR")) {
            System.out.println("The Keyword :HR: is found. The connected user is a HR Director!");
        } else {
            System.out.println("The Keyword :HR: is not found. The connected user is not a HR Director!");
        }
          System.out.println("The salary of the current employee is:" + salary);
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
	   switch (sc.nextInt()) {
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