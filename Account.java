import java.util.Scanner;
import javax.swing.JFrame;
//import project.Employee;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class Account {
	private Employee employee;
	private static String email;
	private static String password;
	private static ArrayList<Account> accounts = new ArrayList<Account>();
	 	/* Account's constructor */

	public Account(Employee e) {
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
 	}
 	*/
 	
 	public static void main(String [] args) {
 		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginWindow().setVisible(true);
            }
        });
 	}

 	/* This method generates Employee's password */
<<<<<<< HEAD
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
=======
 	/*public static String passwordGenerator() {
		PasswordGenerator gen = new PasswordGenerator();
		CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
		CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
		lowerCaseRule.setNumberOfCharacters(1);

		CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
		CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
		upperCaseRule.setNumberOfCharacters(1);

		CharacterData digitChars = EnglishCharacterData.Digit;
		CharacterRule digitRule = new CharacterRule(digitChars);
		digitRule.setNumberOfCharacters(1);

		CharacterData specialChars = new CharacterData() {
			public String getErrorCode() {
				return ERROR_CODE;
			}

		    public String getCharacters() {
		            return "!@#$%^&*()_+";
		    }
		};
		CharacterRule splCharRule = new CharacterRule(specialChars);
		splCharRule.setNumberOfCharacters(1);

		String password = gen.generatePassword(8, splCharRule, lowerCaseRule,
		   upperCaseRule, digitRule);
        return password;
	}*/
>>>>>>> 31c2b6cd9de51d99d5fec38515775f814d1be611
}
