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
		// validate last name
		public static boolean isValidFirstName( String firstName ) {
	      return firstName.matches( "[A-Z][a-z]*" );
	   }
	   // validate last name
	   public static boolean isValidLastName( String lastName ) {
	      return lastName.matches( "[A-Z][a-z]*" );
	   }
	
	   // validate phone number
	   private static boolean isValidPhoneNumber(String phoneNo) {
			//validate phone numbers of format "1234567890"
			if (phoneNo.matches("\\d{10}")) return true;
			//validating phone number with -, . or spaces
			else if(phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;
			else return false;
	   }


	