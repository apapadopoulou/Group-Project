import java.util.Scanner;

import javafx.concurrent.Task;

import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;

public class Test {
	public static void main(String args []) {
		//DBcon.loadData();
		
		DBcon.deleteTables();
		DBcon.createTables();
		
		Department dep0 = new Department("Admin");
		Department dep2 = new Department("HR");
		Department dep3 = new Department("R&D");
		
		BasicEmployee emp0 = new BasicEmployee("vasilis", "Xifaras", "6942796775", "alcabilone@gmail.com", "25/07/2000", 1, 3222);
		BasicEmployee emp1 = new BasicEmployee("Tasos", "yesaras", "6942796775", "wizard@gmail.com", "25/07/2000", 1, 700);
		BasicEmployee emp2 = new BasicEmployee("Aggeliki", "Xifaras", "6942796775", "sousou@gmail.com", "25/07/2000", 1, 1200);
		BasicEmployee emp3 = new BasicEmployee("Giorgos", "Yesman", "6942796775", "puperfish@gmail.com", "25/07/2000", 1, 4000);
		BasicEmployee emp4 = new BasicEmployee("Konstas", "Xifaras", "6942796775", "yonk@gmail.com", "25/07/2000", 2, 3222);
		BasicEmployee emp5 = new BasicEmployee("Maria", "yesaras", "6942796775", "erbil@gmail.com", "25/07/2000", 2, 700);
		BasicEmployee emp6 = new BasicEmployee("Aliki", "Xifaras", "6942796775", "strawberry@gmail.com", "25/07/2000", 2, 1200);
		BasicEmployee emp7 = new BasicEmployee("Thanos", "Xifaras", "6942796775", "alcapone@gmail.com", "25/07/2000", 2, 4000);
		BasicEmployee emp8 = new BasicEmployee("Panagiota", "Xifaras", "6942796775", "mekong@gmail.com", "25/07/2000", 2, 3222);
		BasicEmployee emp9 = new BasicEmployee("Christos", "yesaras", "6942796775", "christos@gmail.com", "25/07/2000", 2, 700);
		BasicEmployee emp10 = new BasicEmployee("Sismane", "Xifaras", "6942796775", "gman227@gmail.com", "25/07/2000", 1, 1200);
		BasicEmployee emp11 = new BasicEmployee("Kostas", "Atheridis", "6942796775", "arcane@gmail.com", "25/07/2000", 1, 4000);
		ArrayList<Department> list = new ArrayList<Department>();
		list.add(dep2);
		MiddleManager emp12 = new MiddleManager("Katerina", "wefsq", "6942796775", "trebela@gmail.com", "05/07/1998", 32322);
		emp12.setManagingDepartments(list);
		MiddleManager emp13 = new MiddleManager("Orestis", "dwuqdqw", "6942796775", "orestis@gmail.com", "25/07/2000", 4345);
		MiddleManager emp14 = new MiddleManager("Antonis", "pakas", "6942796775", "kfc@gmail.com", "25/07/2000", 2000);
		list.clear();
		list.add(dep3);
		emp14.setManagingDepartments(list);
		
		emp14.setCalendar(Day.createCalendar(emp6.getID(), "13/01/2020"));
		MiddleManager emp15 = new MiddleManager("Maria", "georgiou", "6942796775", "replica@gmail.com", "25/07/2000", 2300);
	
		//emp15.setManagingDepartments(list);
		
		TopManager emp16 = new TopManager("Tasos", "yesaras", "6942796775", "tasos@gmail.com", "25/07/2000", 22332);
		TopManager emp17 = new TopManager("Mpampis", "yesaras", "6942796775", "babis@gmail.com", "25/07/2000", 30000);
		
		Request reg = new Request("30/10/2020", 3, "i want to take a time off pls!", emp14.getID());
		emp5.setCalendar(Day.createCalendar(emp5.getID(), "13/01/2020"));
		Task task1 = new Task("23/02/2020", "29/02/2020", "New simple task asda", 5, 8, emp14.getID());
		Task task2 = new Task("22/01/2020", "03/02/2020", "New simple task adqwdw", 2, 4, emp14.getID());
		Task task3 = new Task("27/01/2020", "03/02/2020", "New simple task adqwdw", 5, 9, emp14.getID());
		Task task4 = new Task("23/02/2020", "29/02/2020", "New sqdqmple task asda", 2, 6, emp14.getID());
		Task task5 = new Task("27/01/2020", "04/02/2020", "Newdqwle task adqwdw", 4, 8, emp14.getID());
		Task task6 = new Task("28/01/2020", "05/02/2020", "New simple task adqwdw", 5, 7, emp14.getID());
		
		ArrayList<String> emps = new ArrayList<String>();
		emps.add(emp14.getID());
		emps.add(emp5.getID());
		Event evnt = new Event("General Meeting", "15/01/2020", "18:00", "general meeitng for every employee","Meeting", emps );
		
		System.out.println(emp6.getCalendar().get(0).getDailyProgram().size());
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
