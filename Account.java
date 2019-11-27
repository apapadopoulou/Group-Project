import java.util.Scanner;

import project.Employee;

import java.util.ArrayList;
public class Account {
 private String department;
 private String name;
 private String surname;
 private int telephone;
 private String email;
 private String id;
 private String password;
 private static ArrayList<Account> accounts = new ArrayList<Account>();

 /* Account's constructor */

 public Account(Employee e) {
	 department = e.getDepartmentName();
	 name = e.getName();
	 surname = e.getSurname();
	 telephone = e.getTelephone();
	 email = e.getEmail();
	 id = e.getId();
	 password = Checkers.ValidPassword();
	 accounts.add(this); /*Account object entered on accounts ArrayList*/

	 /*
	 if (isValidEmail(email))
         System.out.print("Valid Email");
     else
         System.out.print("Invalid Email");
         System.out.print("Please retype your Email");
     if (isValidFirstName(firstName))
         System.out.print("Valid First Name");
     else
         System.out.print("Invalid First Name");
     	System.out.print("Please retype your First Name");
     if (isValidLastName(lastName))
         System.out.print("Valid Last Name");
     else
         System.out.print("Invalid Last Name");
    		System.out.print("Please retype your Last Name");
     if (isValidPhoneNumber(phoneNo))
         System.out.print("Valid Phone Number");
     else
         System.out.print("Invalid Phone number");
     	System.out.print("Please retype your Phone Number");
 */

 }

 /* This method searches Employees' accounts by their email*/

 public Account searchAccountByEmail(String email) {
 	boolean exists = false;
 	for(int i=0;i<this.accounts.size();i++) {
 		if (this.accounts.get(i).getEmail()==email) {
 			exists=true;
 			break;
 		}
 		if(exists==true) {
 			return this.accounts;
 		}else {
 			System.out.println("The email you entered does not relate to an existing account");
 			return null;
 		}
 	}
 }

 public boolean Login() {
	boolean success=false;
	System.out.println("Welcome!");
	System.out.println("Please insert your email");
	Scanner sc = new Scanner(System.in);
	String email=sc.nextLine();
	System.out.println("Please insert your password");
	String password = sc.nextLine();
	if (password==searchAccountByEmail(email).getPassword()) {
		success=true;
	}
	return success;
 }
}
