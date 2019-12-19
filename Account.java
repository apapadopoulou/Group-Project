import java.util.Scanner;
import javax.swing.JFrame;
//import project.Employee;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class Account {
	private Employee employee;
	private String email;
	private String password;
	private static ArrayList<Account> accounts = new ArrayList<Account>();
        private int a;
	 	/* Account's constructor */

	public Account(Employee e) {
         a = 0;
	 this.employee = e;
	 this.email = e.getEmail();
	 password = Checkers.ValidPassword();
	 accounts.add(this); /*Account object entered on accounts ArrayList*/
 	
	 	/*
	 	if (isValidEmail(email))
         	System.out.print("Valid Email");
     	else {
         	System.out.print("Invalid Email");
         	System.out.print("Please retype your Email");
		}
     	if (isValidFirstName(firstName))
         	System.out.print("Valid First Name");
     	else {
         	System.out.print("Invalid First Name");
     		System.out.print("Please retype your First Name");
		}
     	if (isValidLastName(lastName))
         	System.out.print("Valid Last Name");
     	else {
         	System.out.print("Invalid Last Name");
    		System.out.print("Please retype your Last Name");
		}
     	if (isValidPhoneNumber(phoneNo))
         	System.out.print("Valid Phone Number");
     	else {
         	System.out.print("Invalid Phone number");
     		System.out.print("Please retype your Phone Number");
		}
 		*/

	}

 	/* This method searches Employees' accounts by their email*/
        public int getA() {
            return a;
        }
        public void setA (int a){
            this.a = a;
        }
 	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static Account searchAccountByEmail(String email) {
 		boolean exists = false;
 		
 		for(int i = 0; i < accounts.size();) {
 			if (accounts.get(i).email.equals(email)) {
 				exists = true;
 				break;
 			}
 			if (exists == true) {
 				return accounts.get(i);
 			} 
 		}
 		return null;
 	}

 	/*This method checks if the password and the email of the input
 	   are equal to the password and the email of the user.*/
 	/*public static boolean login() {
 		boolean success=false;
 		//System.out.println("Welcome!");
 		Scanner sc = new Scanner(System.in);
 		try {
 		System.out.println("Please insert your email");
 		String email = sc.nextLine();
 		}catch(InputMismatchException e) {
 			System.out.println("Please enter your email");
 		}
 		try{
 			System.out.println("Please insert your password");
 			String password = sc.nextLine();
 		}catch(InputMismatchException e) {
 			System.out.println("Please enter your password");
 		}
 		if (password.equals
 				(searchAccountByEmail(email).password)) {
 			success = true;
 		}
 		sc.close();
 		return success;
 	}*/
 	
 	public static void main(String [] args) {
 		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginWindow().setVisible(true);
            }
        });
 	}
        public int typeOfEmployee(Employee e){
            if (e instanceof BasicEmployee){
                return 1;
            } else if(e instanceof MiddleManager){
                return 2;
            } else 
                return 3;    
                    
        }
               
 	/* This method generates Employee's password */
 	public static char[] passwordGenerator() {
 		String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
        String Small_chars = "abcdefghijklmnopqrstuvwxyz"; 
        String numbers = "0123456789"; 
        String symbols = "!@#$%^&*_=+-/.?<>)"; 
        String values = Capital_chars + Small_chars + 
                        numbers + symbols; 
  
        // Using random method 
        Random ran = new Random(); 
        char[] password = new char[8]; 
  
        for (int i = 0; i < 8; i++) { 
            // Use of charAt() method : to get character value 
            // Use of nextInt() as it is scanning the value as int 
            password[i] = 
              values.charAt(ran.nextInt(values.length())); 
  
        } 
        return password; 
	}
}
