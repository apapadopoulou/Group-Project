import java.util.Scanner;
import java.util.regex.Pattern;

public class Checkers {
	// validate email
		public static boolean isValidEmail(String email)
		{
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
		// This method validate first name
		public static boolean isValidFirstName( String firstName ) {
	      return firstName.matches( "[A-Z][a-z]*" );
	   }
	   // This method validate last name
	   public static boolean isValidLastName( String lastName ) {
	      return lastName.matches( "[A-Z][a-z]*" );
	   }

	   //This method validate phone number with specific ways
	   private static boolean isValidPhoneNumber(String phoneNo) {
			//validate phone numbers of format "1234567890"
			if (phoneNo.matches("\\d{10}"))
				return true;
			//validating phone number with -, . or spaces for example 210-96-13-432
			else if(phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"))
				return true;
			else
				return false;
	   }
			public static String ValidPassword() {
			      //Input from user
			      String password;
			      Scanner input = new Scanner(System.in);
			      System.out.printf("Please create your password:\n");
			      password = input.nextLine();

			      //Checking password length
			      while( (password.length() < 6) || (password.length() > 15) )
			      {
			         System.out.print("This password must be between 6 and 15 characters. Try again: ");
			         password = input.nextLine();
			      }
			      //Confirming if passwords match
			      String password2;
			      System.out.print("\nPlease type your password again to confirm: ");
			      password2 = input.nextLine();

			      while( !password2.equals(password) )
			      {
			         System.out.print("Those passwords do not match. Try again: ");
			         password2 = input.nextLine();
			      }
			      return password;

			   }
			   //This method validate the event title (speficic titles) 
			   public static boolean isValidTitle(String title) {
				   return title == "appointment" || title == "meeting" || title == "main event";
			   }
	   }


