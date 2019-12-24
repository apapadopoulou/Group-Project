
import java.util.Scanner;
import javax.swing.JFrame;
//import project.Employee;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class Account {

    private Employee employee;
    private String email;
    private String password;
    private static ArrayList<Account> accounts = new ArrayList<Account>();
    private int hasDefaultPass;
    
    /*
     * Basic constructor for class Account.
     * Use ONLY this constructor to create new Accounts.
     */
    public Account(Employee e) {
        hasDefaultPass = 0;
        this.employee = e;
        this.email = e.getEmail();
        password = passwordGenerator();
        accounts.add(this); /*Account object entered on accounts ArrayList*/
        DBcon.saveAccount(this);
    }

    /*
     * Database constructor for class Account.
     * This constructor is used to create Account objects saved in the Database.
     */
    public Account(String empId, String password, int hasDefaultPass) {
        this.hasDefaultPass = hasDefaultPass;
        Employee e = Employee.searchEmployeeById(empId);
        this.employee = e;
        this.email = e.getEmail();
        password = passwordGenerator();
        accounts.add(this); /*Account object entered on accounts ArrayList*/
    }

    /* This method searches Employees' accounts by their email*/
    public int getHasDefaultPass() {
        return hasDefaultPass;
    }

    public void setHasDefaultPass(int a) {
        this.hasDefaultPass = a;
    }

    public Account() {
        // TODO Auto-generated constructor stub
    }

    /* This method searches Employees' accounts by their email*/
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
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginWindow().setVisible(true);
            }
        });
    }
    /* This method return 1 if the employee is a BasicEmployee, 2 if the 
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

    /* This method generates Employee's password */
    public static String passwordGenerator() {
        String password = null;
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*_=+-/.?<>)";
        String values = Capital_chars + Small_chars
                + numbers + symbols;

        // Using random method
        Random ran = new Random();
        char[] psw = new char[8];

        for (int i = 0; i < 8; i++) {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int
            psw[i]
                    = values.charAt(ran.nextInt(values.length()));

        }
        for (int i = 0; i < 8; i++) {
            password += psw[i];
        }
        return password;
    }
}
