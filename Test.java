import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;

public class Test {
	public static void main(String args []) throws Exception {
		DBcon.deleteTables();
		DBcon.tableCreation();
		//DBcon.loadBasicEmployees();
		//System.out.println("Loaded BASIC EMPLOYEES");
		String birthDate = "25/07/2000";
		DBcon.loadDepartments();
		Department dep = new Department("Accounting");
		//System.out.println("Created DEPARTMENT");
		Employee emp = new BasicEmployee("vasilis", "Xifaras", "6942796775", "alcabilone@gmail.com", birthDate, 1, 900.0);
		Employee emp2 = new BasicEmployee("yeyey", "cdaaras", "6942796775", "alcabilone@gmail.com", birthDate, 1, 1500);
		Employee emp3 = new BasicEmployee("Giorgos", "sismane", "6942796775", "alcabilone@gmail.com", birthDate, 1, 2300.34);
		Employee emp4 = new BasicEmployee("92jh", "f4ifaras", "6942796775", "alcabilone@gmail.com", birthDate, 1, 675.35);
		
		Employee manager1 = new MiddleManager("yey1eylis", "Xifaras", "6942796775", "alcabilone@gmail.com", birthDate, 3500);
		Employee manager2 = new MiddleManager("yey1eylis", "papathanasiou", "6942796775", "alcabilone@gmail.com", birthDate, 5000);
		
		Account admin = new Account(emp);
		Account admin2 = new Account(manager1);
		Account admin3 = new Account(emp3);
	}
 } 
