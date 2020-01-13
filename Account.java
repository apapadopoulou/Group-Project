import java.util.Scanner;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

/**
* The Account class creates an account for each employee.
* Each account is created based on his/her email and password.
* Each account is added to an ArrayList called accounts.
* @author BusyB
*/
public class Account {

    private Employee employee;
    private String email;
    private String password;
    public static ArrayList<Account> accounts = new ArrayList<Account>();
    private int hasDefaultPass;   
    
    /**
     * Basic constructor for class Account.
     * Use ONLY this constructor to create new Accounts.
     * 
     * @param emp
     */
    public Account(Employee emp) {
        hasDefaultPass = 0;
        employee = emp;
        email = employee.getEmail();
        password = passwordGenerator();
        accounts.add(this); //Account object entered on accounts ArrayList.
        DBcon.saveAccount(this);
    }

    /**
     * Database constructor for class Account.
     * This constructor is used to create Account objects saved in the Database.
     * 
     *@param empId
     *@param password
     *@param hasDefaultPass
     */
    public Account(String empId, String password, int hasDefaultPass) {
        this.hasDefaultPass = hasDefaultPass;
        employee = Employee.searchEmployeeById(empId);
        email = employee.getEmail();
        this.password = password;
        accounts.add(this); //Account object entered on accounts ArrayList.
    }

    
     //Getters and Setters.
     
    
    /** 
     * Returns the hasDefaultPass field.
     *@return hasDefaultPass  
     */
    public int getHasDefaultPass() {
        return hasDefaultPass;
    }
    
    
     /**
      *Sets the setHasDefaultPass field.
      *@param dp 
      */
     

    public void setHasDefaultPass(int dp) {
        hasDefaultPass = dp;
        DBcon.updateAccountVar("hasDefaultPass", dp, getEmployee().getID());
    }
    
    /**
     *Returns the employee field.
     *@return employee
     */
  
    public Employee getEmployee() {
        return employee;
    }
    
    
     /**
      *Sets the employee field.
      *@param employee
      */
    

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    /**
     *Returns the email field.
     *@return email
     */

    public String getEmail() {
        return email;
    }
    
    
     /**
      *Sets the email field.
      *@param email 
      */
     

    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     *Returns the password field.
     *@return password
     */

    public String getPassword() {
        return password;
    }
    
    
     /**
      *Sets the password field.
      *@param password
      */
     

    public void setPassword(String password) {
        this.password = password;
        System.out.println(password + ": new pass");
        DBcon.updateAccountVar("password", password, getEmployee().getID());
        setHasDefaultPass(1);
    }
   
   /**
     *This method searches employees' accounts by their email.
     *@param email
     *@return acc
    */ 
    public static Account searchAccountByEmail(String email) {
    	Account acc = null;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getEmail().equals(email)) {
            	 acc = accounts.get(i);
            }
        }
        return acc;
    }
    
    public static Account searchAccountByEmployee(Employee emp) {
    	Account acc = null;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getEmployee().equals(emp)) {
            	 acc = accounts.get(i);
            }
        }
        return acc;
    }
    
    /**
     *This method is used to check the credentials(email and password).
     *@param email
     *@param password
     *@return acc 
     */
    public static Account checkCredentials(String email, String password) {
    	Account acc = null;
    	for (int i = 0; i < accounts.size(); i++) {
    		if (accounts.get(i).getEmail().equals(email) && accounts.get(i).getPassword().equals(password)) {
    			acc = accounts.get(i);
    		}
    	}
    	return acc;
    }
    
    /**
     *This method is used to check the credentials(Employee and password).
     *@param emp
     *@param password
     *@return acc 
     */
    public static Account checkCredentials(Employee emp, String password) {
    	Account acc = null;
    	for (int i = 0; i < accounts.size(); i++) {
    		if (searchAccountByEmployee(emp).getPassword().equals(password)) {
    			acc = accounts.get(i);
    		}
    	}
    	return acc;
    }
     
    /** This method returns 1 if the employee is a BasicEmployee, 2 if the 
    * employee is a BasicEmployee who works in HR department, 3 if the employee
    * is a MiddleManager, 4 if the employee is a MiddleManager who works in the 
    * HR department and 5 if the employee is a TopManager.
    * @param emp
    * @return 1 or 2 or 3 or 4 or 5
    */
    public static int typeOfEmployee(Employee emp) {
        if (emp instanceof BasicEmployee) {
        	BasicEmployee be = (BasicEmployee) emp;
            if (BasicEmployee.isHREmployee(be) == true) {
                return 2;
            } else {
                return 1;
            }
        } else if (emp instanceof MiddleManager) {
        	MiddleManager midman = (MiddleManager) emp;
            if (MiddleManager.managingHR(midman) == true) {
                return 4;
            } else {
                return 3;
            }
        } else {
            return 5;
        }
    }

    
     
   
    /**
     * This method generates a random password
     * @return password
     */
    public static String passwordGenerator() {
        String password = "";
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*_=+-/.?<>)";
        String values = Capital_chars + Small_chars
                + numbers + symbols;
          //Using Random method.
        Random ran = new Random();
        char[] psw = new char[8];

        for (int i = 0; i < 8; i++) {
            
              //Use of charAt() method : to get character value.
             //Use of nextInt() as it is scanning the value as int.
             
            psw[i]  = values.charAt(ran.nextInt(values.length()));

        }
        for (int i = 0; i < 8; i++) {
            password += psw[i];
        }
        return password;
    }
}
 
 /**
  * End of Account class
*/