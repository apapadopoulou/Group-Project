import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;

public class Test {
	public static void main(String args []) {
		/*
		DBcon.deleteTables();
		DBcon.createTables();

		Department dep0 = new Department("Sales");
		Department dep1 = new Department("Sales");
		Department dep2 = new Department("Sales");
		Department dep3 = new Department("Sales");
		
		Employee emp0 = new BasicEmployee("vasilis", "Xifaras", "6942796775", "alcabilone@gmail.com", "25/07/2000", 1);
		Employee emp1 = new BasicEmployee("Tasos", "yesaras", "6942796775", "alcabilone@gmail.com", "25/07/2000", 2);
		Employee emp2 = new BasicEmployee("Aggeliki", "Xifaras", "6942796775", "alcabilone@gmail.com", "25/07/2000", 3);
		Employee emp3 = new BasicEmployee("Giorgos", "Xifaras", "6942796775", "alcabilone@gmail.com", "25/07/2000", 4);
		
		Employee emp4 = new MiddleManager("Katerina", "wefsq", "6942796775", "alcabilone@gmail.com", "05/07/1998");
		Employee emp5 = new MiddleManager("Orestis", "dwuqdqw", "6942796775", "alcabilone@gmail.com", "25/07/2000");
		Employee emp6 = new MiddleManager("Antonis", "pakas", "6942796775", "alcabilone@gmail.com", "25/07/2000");
		Employee emp7 = new MiddleManager("Maria", "georgiou", "6942796775", "alcabilone@gmail.com", "25/07/2000");
		
		Account acc0 = new Account (emp0);
		Account acc1 = new Account (emp1);
		Account acc2 = new Account (emp2);
		Account acc3 = new Account (emp3);
		Account acc4 = new Account (emp4);
		Account acc5 = new Account (emp5);
		Account acc6 = new Account (emp6);
		Account acc7 = new Account (emp7); */
		
		DBcon.loadDepartments();
		System.out.println("Succesfully Loaded Departments.");
		DBcon.loadBasicEmployees();
		System.out.println("Succesfully Loaded Basic Employees.");
		DBcon.loadMiddleManagers();
		System.out.println("Succesfully Loaded Middle Managers.");
		DBcon.loadAccounts();
		System.out.println("Succesfully Loaded Accounts."); 
	}
 } 
