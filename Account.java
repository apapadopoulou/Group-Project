import java.util.Scanner;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

/**
*The Account class creates an account for each employee.
*Each account is created based on the email and the password.
*Each account is added to an ArrayList called accounts.
*@author BusyB
*/
public class Account {

    private Employee employee;
    private String email;
    private String password;
    private static ArrayList<Account> accounts = new ArrayList<Account>();
    private int hasDefaultPass;
}    
    
    /**
     * Basic constructor for class Account.
     * Use ONLY this constructor to create new Accounts.
     * 
     * @param e
     */
    public Account(Employee e) {
        hasDefaultPass = 0;
        this.employee = e;
        this.email = e.getEmail();
        password = passwordGenerator();
         /**
          * Account object entered on accounts ArrayList.
          */ 
        
        accounts.add(this);
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
        Employee e = Employee.searchEmployeeById(empId);
        this.employee = e;
        this.email = e.getEmail();
        password = passwordGenerator();
         /**
          *Account object entered on accounts ArrayList.
          */
        accounts.add(this);
    }

    /**
     *Getters and Setters.
     */
    public int getHasDefaultPass() {
        return hasDefaultPass;
    }

    public void setHasDefaultPass(int a) {
        this.hasDefaultPass = a;
    }
  
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
   /**
     *This method searches Employees' accounts by their email.
    */
    
    public static Account searchAccountByEmail(String email) {
        boolean exists = false;

        for (int i = 0; i < accounts.size();) {
            if (accounts.get(i).email.equals(email)) {
                exists = true;
                break;
            }
            if (exists == true) {
                return accounts.get(i);
            }
        }
        return null;
    }

    /*This method checks if the password and the email of the input
     are equal to the password and the email of the user.*/
    /*public static boolean login() {
     boolean success=false;
     //System.out.println("Welcome!");
     Scanner sc = new Scanner(System.in);
     try {
     System.out.println("Please insert your email");
     String email = sc.nextLine();
     }catch(InputMismatchException e) {
     System.out.println("Please enter your email");
     }
     try{
     System.out.println("Please insert your password");
     char password = sc.next().charAt(0);
     }catch(InputMismatchException e) {
     System.out.println("Please enter your password");
     }
     searchAccountByEmail(new Account().email);
     if (password.equals(new Account().password)) {
     success = true;
     }
     sc.close();
     return success;
     }*/
    /**
     * Start of main method.
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginWindow().setVisible(true);
            }
        }
    }
    /** This method returns 1 if the employee is a BasicEmployee, 2 if the 
    * employee is a BasicEmployee who works in HR department, 3 if the employee
    * is a MiddleManager, 4 if the employee is a MiddleManager who works in the 
    * HR department and 5 if the employee is a TopManager.
    */
    public int typeOfEmployee(Employee e) {
        if (e instanceof BasicEmployee) {
            if (BasicEmployee.HREmployee(e.getName()) == true)
                return 2;
            else if (BasicEmployee.HREmployee(e.getSurname()) == true)
                return 2;
            else
                return 1;
        } else if (e instanceof MiddleManager) {
            if (MiddleManager.HREmployee(e.getName()) == true)
                return 4;
            else if (MiddleManager.HREmployee(e.getSurname()) == true)
                return 4;
            else 
                return 3;
        } else {
            return 5;
        }

    }

    /**
     *  This method generates Employee's password.
     */
    public static String passwordGenerator() {
        String password = null;
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*_=+-/.?<>)";
        String values = Capital_chars + Small_chars
                + numbers + symbols;

        /** 
         * Using Random method.
         */
        Random ran = new Random();
        char[] psw = new char[8];

        for (int i = 0; i < 8; i++) {
            /**
             * Use of charAt() method : to get character value.
             */
        	
            /**
             * Use of nextInt() as it is scanning the value as int.
             */
            psw[i]  = values.charAt(ran.nextInt(values.length()));

        }
        for (int i = 0; i < 8; i++) {
            password += psw[i];
        }
        return password;
    }
}
/** 
 * End of Account class.
 */
