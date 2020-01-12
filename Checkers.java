import java.util.regex.Pattern;
/**
 * Checkers class checks if the user data is valid.
 * Performs first name, last name, phone number, password and event title check.
 *@author BusyB 
 */
public class Checkers {
	/**
	 *This method checks if the given email is valid. 
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
	 *This method checks if the given first name is valid.
	 *@param firstName 
	 *@return firstName.matches("[A-Z][a-z]*")
	 */
	public static boolean isValidFirstName( String firstName ) {
		return firstName.matches( "[A-Z][a-z]*" );
	}
	   
	/**
	 *This method checks if the last name is valid.
	 *@param lastName 
	 *@return lastName.matches("[A-Z][a-z]*")
	 */
	public static boolean isValidLastName( String lastName ) {
		return lastName.matches( "[A-Z][a-z]*" );
	}

	/**
	 *This method checks if the given phone number is valid.
	 *@param phoneNo 
	 *@return true or false 
	 */
	public static boolean isValidPhoneNumber(String phoneNo) {
		if (phoneNo.matches("\\d{10}")) {
			return true;
		} else if(phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 *This method checks if the given password is valid.
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
	 *This method checks the given event title,
	 * which should be equal to one of the four event types the application supports.
	 *@param type 
	 *@return type 
	 */
	public static boolean isValidType(String type) {
		return type == "appointment" || type == "meeting" || type == "main event" || type == "reminder";
	}
}
 
 /**
  * End of Checkers class
  */
 


