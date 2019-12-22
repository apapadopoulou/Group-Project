import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

public class Test {
	public static void main(String args []) {
		DBcon.tableCreation();
		DBcon.loadBasicEmployees();
		//System.out.println("Loaded BASIC EMPLOYEES");
		Date birthDate = new Date();
		Department dep = new Department("Sales");
		System.out.println("Created DEPARTMENT");
		Employee emp = new BasicEmployee("vasilis", "Xifaras", "6942796775", "alcabilone@gmail.com", birthDate, 1);
		System.out.println("Created BASIC EMPLOYEE");
	}
 } 
