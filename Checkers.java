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

	// for class Account
		   		public static void main(String[] args) 
		    { 
		        //input variables
				String email = "panos1606@gmail.com"; 
		        String firstName = "Panos";
		        String lastName = "Papasotiriou";		
		        String phoneNo = "2109613432";
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
		    } 
	}  
	