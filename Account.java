public class Account {
 private String department;
 private String name;
 private String surname;
 private int telephone;
 private String email;
 private String id;
 private String password;
 
 public Account(Employee e) {
	 department = e.getDepartment();
	 name = e.getName();
	 surname = e.getSurname();
	 telephone = e.getTelephone();
	 email = e.getEmail();
	 id = e.getId();
	 password = Checkers.ValidPassword();
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
 */ }  
 }
