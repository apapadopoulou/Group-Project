import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;

public class Test {
	public static void main(String args []) {
		
		DBcon.deleteTables();
		DBcon.createTables();
		
		Department dep0 = new Department("Sales");
		Department dep1 = new Department("Accounting");
		Department dep2 = new Department("IT");
		Department dep3 = new Department("R&D");
		
		Employee emp0 = new BasicEmployee("vasilis", "Xifaras", "6942796775", "alcabilone@gmail.com", "25/07/2000", 1);
		Employee emp1 = new BasicEmployee("Tasos", "yesaras", "6942796775", "alcabilone@gmail.com", "25/07/2000", 2);
		Employee emp2 = new BasicEmployee("Aggeliki", "Xifaras", "6942796775", "alcabilone@gmail.com", "25/07/2000", 3);
		Employee emp3 = new BasicEmployee("Giorgos", "Xifaras", "6942796775", "alcabilone@gmail.com", "25/07/2000", 4);
		
		Employee emp4 = new MiddleManager("Katerina", "wefsq", "6942796775", "alcabilone@gmail.com", "05/07/1998");
		Employee emp5 = new MiddleManager("Orestis", "dwuqdqw", "6942796775", "alcabilone@gmail.com", "25/07/2000");
		Employee emp6 = new MiddleManager("Antonis", "pakas", "6942796775", "alcabilone@gmail.com", "25/07/2000");
		Employee emp7 = new MiddleManager("Maria", "georgiou", "6942796775", "alcabilone@gmail.com", "25/07/2000");
		
		Employee emp8 = new TopManager("Tasos", "yesaras", "6942796775", "tasos@gmail.com", "25/07/2000");
		Employee emp9 = new TopManager("Mpampis", "yesaras", "6942796775", "alcabilone@gmail.com", "25/07/2000");
		//Sosto mexri edw!
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
