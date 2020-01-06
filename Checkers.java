import java.util.regex.Pattern;
/**
 * Checkers class checks if the user data is valid.
 * Performs first name, last name, phone number, password and event title check.
 *@author BusyB 
 */
public class Checkers {
	/**
	 *This method validates email. 
	 *@param email
	 *@return pat.matcher(email).matches() or false
	 */
	public static boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
                           + "[a-zA-Z0-9_+&*-]+)*@" 
                           + "(?:[a-zA-Z0-9-]+\\.)+[a-z" 
                           + "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null) {
			return false;
		} else {
			return pat.matcher(email).matches();
		}
    }
  
	/** 
	 *This method validates first name.
	 *@param firstName 
	 *@return firstName.matches("[A-Z][a-z]*")
	 */
	public static boolean isValidFirstName( String firstName ) {
		return firstName.matches( "[A-Z][a-z]*" );
	}
	   
	/**
	 *This method validates last name.
	 *@param lastName 
	 *@return lastName.matches("[A-Z][a-z]*")
	 */
	public static boolean isValidLastName( String lastName ) {
		return lastName.matches( "[A-Z][a-z]*" );
	}

	/**
	 *This method validates phone number with specific ways.
	 *@param phoneNo 
	 *@return true or false 
	 */
	public static boolean isValidPhoneNumber(String phoneNo) {
		
		 //Validate phone numbers of format "1234567890".
		
		if (phoneNo.matches("\\d{10}")) {
			return true;
			
			 //validating phone number with -, . or spaces for example 210-96-13-432.
			 
		} else if(phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 *This method validates password.
	 *@param password
	 *@return true or false 
	 */
	public static boolean isValidPassword(String password) {
		
		 //Checking password length. 
		 
		 
		if ((password.length() >= 6) && (password.length() <= 15)) {
			return true;
		} else {
			return false;
		}
	}
		
	/**
	 *This method validates the event title (speficic titles).
	 *@param type 
	 *@return type 
	 */
	public static boolean isValidType(String type) {
		return type == "appointment" || type == "meeting" || type == "main event";
	}
}
 
 //End of Checkers class. 
 


