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
	   public static boolean isValidPhoneNumber(String phoneNo) {
			//validate phone numbers of format "1234567890"
			if (phoneNo.matches("\\d{10}"))
				return true;
			//validating phone number with -, . or spaces for example 210-96-13-432
			else if(phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"))
				return true;
			else
				return false;
	   }
		public static boolean isValidPassword(String password) {
			  //Checking password length
			  while( (password.length() >= 6) || (password.length() <= 15) ) {
				  return true;
			  }else {
				  return false;
			  }
		}
		//This method validate the event title (speficic titles) 
		public static boolean isValidType(String type) {
			return type == "appointment" || type == "meeting" || type == "main event";
		}
}


