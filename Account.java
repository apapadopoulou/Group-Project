import java.util.ArrayList;
import java.util.Random;

/**
* The Account class creates an account for each employee.
* Each account is created based on the employee's email and password.
* Each account is added to an ArrayList called accounts.
* @author BusyB
*/
public class Account {
    /**This field represents the employee who owns the account.*/
    private Employee employee;
    /**This field represents the email used to sign in.*/
    private String email;
    /**This field represents the password used to sign in.*/
    private String password;
    /**All the existing accounts are saved in this list.*/
    public static ArrayList<Account> accounts = new ArrayList<Account>();
    /**This field can only have the values of 0 or 1
     * The value is 0 when the employee uses the default password
     * and 1 when the password is modified.*/
    private int hasDefaultPass;
    /**
     * Basic constructor for class Account.
     * @param emp
     */
    public Account(Employee emp) {
        hasDefaultPass = 0;
        employee = emp;
        email = employee.getEmail();
        password = passwordGenerator();
        accounts.add(this);
        DBcon.saveAccount(this);
    }
    /**
     * Database constructor for class Account.
     * This constructor is used to create Account objects saved in the Database.
     *@param empId
     *@param password
     *@param hasDefaultPass
     */
    public Account(String empId, String password, int hasDefaultPass) {
        this.hasDefaultPass = hasDefaultPass;
        employee = Employee.searchEmployeeById(empId);
        email = employee.getEmail();
        this.password = password;
        accounts.add(this);
    }
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
      *Sets the password field. The hasDefaultPass field turns to 1.
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
    		if (accounts.get(i).getEmail().equals(email)
    				&& accounts.get(i).getPassword().equals(password)) {
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
            if (BasicEmployee.isHREmployee(be)) {
                return 2;
            } else {
                return 1;
            }
        } else if (emp instanceof MiddleManager) {
        	MiddleManager midman = (MiddleManager) emp;
            if (MiddleManager.managingHR(midman)) {
                return 4;
            } else {
                return 3;
            }
        } else {
            return 5;
        }
    }
    /**
     * This method generates a random password.
     * @return password
     */
    public static String passwordGenerator() {
        String password = "";
        String capitalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallChars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*_=+-/.?<>)";
        String values = capitalChars + smallChars
                + numbers + symbols;
        int passLength = 8;
        Random ran = new Random();
        char[] psw = new char[passLength];
        for (int i = 0; i < passLength; i++) {
            psw[i]  = values.charAt(ran.nextInt(values.length()));
        }
        for (int i = 0; i < passLength; i++) {
            password += psw[i];
        }
        return password;
    }
}