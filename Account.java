public class Account {
 private Department department;
 private String name;
 private String surname;
 private String telephone;
 private String email;
 private String password;
 private int id;
 public Account(Employee e) {
	 department = e.getDepartment();
	 name = e.getName();
	 surname = e.getSurname();
	 telephone = e.getTelephone();
	 email = e.getEmail();
	 password = e.getPassword();
	 id = e.getId();
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
