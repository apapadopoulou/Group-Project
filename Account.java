import java.util.Scanner;
<<<<<<< HEAD
=======
import javax.swing.JFrame;
//import project.Employee;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
>>>>>>> e6fd30b94f4b801f5470cdeb833771a6f88b4d76
import java.util.ArrayList;

public class Account {
	private Employee employee;
	private String email;
	private String password;
	private static ArrayList<Account> accounts = new ArrayList<Account>();
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
	 this.employee = e;
	 this.email = e.getEmail();
	 password = Checkers.ValidPassword();
	 accounts.add(this); /*Account object entered on accounts ArrayList*/
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

 	public Account searchAccountByEmail(String email) {
 		boolean exists = false;
 		
 		for(int i = 0; i < accounts.size();) {
 			if (accounts.get(i).email == email) {
 				exists = true;
 				break;
 			}
 			if (exists == true) {
 				return accounts.get(i);
 			} else {
=======
 		for(int i=0;i<this.accounts.size();i++) {
 			if (this.accounts.get(i).getEmail()==email) {
 				exists=true;
 				break;
 			}
 			if(exists==true) {
 				return this.accounts;
 			}else {
>>>>>>> e6fd30b94f4b801f5470cdeb833771a6f88b4d76
 				System.out.println("The email you entered does not relate to an existing account");
 				return null;
 			}
 		}
 		return null;
 	}
<<<<<<< HEAD
 	/*This method checks if the password and the email of the input 
 	 * are equal to the password and the email of the user.*/
 	public boolean login() {
 		boolean success = false;
 		System.out.println("Welcome!");
=======
 	/*This method checks if the password and the email of the input
 	   are equal to the password and the email of the user.*/
 	public static boolean login() {
 		boolean success=false;
 		//System.out.println("Welcome!");
>>>>>>> e6fd30b94f4b801f5470cdeb833771a6f88b4d76
 		System.out.println("Please insert your email");
 		Scanner sc = new Scanner(System.in);
 			String email = sc.nextLine();
 			System.out.println("Please insert your password");
 			String password = sc.nextLine();
 			if (password.equals(searchAccountByEmail(email).password)) {
 				success = true;
 			}
 			sc.close();
 			return success;
 	}
 	public static void firstScreen() {
 		JFrame jf = new JFrame ("Welcome!");
 		jf.setBounds(0, 0, 800, 600);
 		System.out.println("Please login into your account: ");
 		login();
 		jf.setVisible(true);
 		//Tried to create the login window but failed

 	}
 	//public static void main(String [] args) {
 	//	firstScreen();
 	//}

 	/* This method generates Employee's password */
 	public static string passwordGenerator() {
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
	}
}
