import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;

public class Test {
	public static void main(String args []) {
		
		DBcon.deleteTables();
		DBcon.createTables();
		
		Department dep0 = new Department("Admin");
		Department dep1 = new Department("HR");
		Department dep2 = new Department("IT");
		Department dep3 = new Department("R&D");
		
		BasicEmployee emp0 = new BasicEmployee("vasilis", "Xifaras", "6942796775", "alcabilone@gmail.com", "25/07/2000", 1, 3222);
		BasicEmployee emp1 = new BasicEmployee("Tasos", "yesaras", "6942796775", "alcabilone@gmail.com", "25/07/2000", 2, 700);
		BasicEmployee emp2 = new BasicEmployee("Aggeliki", "Xifaras", "6942796775", "alcabilone@gmail.com", "25/07/2000", 3, 1200);
		BasicEmployee emp3 = new BasicEmployee("Giorgos", "Xifaras", "6942796775", "alcabilone@gmail.com", "25/07/2000", 3, 4000);
		
		MiddleManager emp4 = new MiddleManager("Katerina", "wefsq", "6942796775", "alcabilone@gmail.com", "05/07/1998", 32322);
		emp4.setManagingDepartment(1);
		MiddleManager emp5 = new MiddleManager("Orestis", "dwuqdqw", "6942796775", "alcabilone@gmail.com", "25/07/2000", 4345);
		MiddleManager emp6 = new MiddleManager("Antonis", "pakas", "6942796775", "alcabilone@gmail.com", "25/07/2000", 2000);
		MiddleManager emp7 = new MiddleManager("Maria", "georgiou", "6942796775", "alcabilone@gmail.com", "25/07/2000", 2300);
		ArrayList<Department> deps = new ArrayList<Department>();
		deps.add(dep2);
		deps.add(dep3);
		emp7.setManagingDepartments(deps);
		
		TopManager emp8 = new TopManager("Tasos", "yesaras", "6942796775", "tasos@gmail.com", "25/07/2000", 22332);
		TopManager emp9 = new TopManager("Mpampis", "yesaras", "6942796775", "alcabilone@gmail.com", "25/07/2000", 30000);
		
		Request reg = new Request("30/10/2020", 3, "i want to take a time off pls!", emp5.getID());
		//Sosto mexri edw!
		/*
		ArrayList<String> empids = new ArrayList<String>();
		empids.add("atef0");
		empids.add("4ioif0");
		Task task1 = new Task("23/02/1993", "29/02/1993", "New simple task asda", 5, 8, "1asif0");
		Task task2 = new Task("27/11/2013", "03/12/2013", "New simple task adqwdw", 2, 4, "rewu1");
		Task task3 = new Task("27/11/2013", "03/12/2013", "New simple task adqwdw", 5, 9, empids);
		
		ArrayList<Employee> list = new ArrayList<Employee>();
		list.add(emp3);
		list.add(emp5);
		list.add(emp8);
		//Employee emp8 = new TopManager("Tasos", "yesaras", "6942796775", "tasos@gmail.com", "25/07/2000");
		
		Event event = new Event("Conference", "03/10/2013", "22:35:00", "This is a basic conference for all board members", "2", list);
		/*for (int i = 0; i < Account.accounts.size(); i++ ) {
			System.out.println(Account.accounts.size() + ", " + Account.accounts.get(i));
		}*/
	}
 } 
