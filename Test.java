import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;

public class Test {
	public static void main(String args []) {
		DBcon.deleteTables();
		DBcon.createTables();
		//DBcon.loadBasicEmployees();
		Department dep0 = new Department("Sales");
		Department dep1 = new Department("Sales");
		Department dep2 = new Department("Sales");
		Department dep3 = new Department("Sales");
		
		Employee emp0 = new BasicEmployee("vasilis", "Xifaras", "6942796775", "alcabilone@gmail.com", "25/07/2000", 1);
		Employee emp1 = new BasicEmployee("Tasos", "Xifaras", "6942796775", "alcabilone@gmail.com", "25/07/2000", 1);
		Employee emp2 = new BasicEmployee("Aggeliki", "Xifaras", "6942796775", "alcabilone@gmail.com", "25/07/2000", 1);
		Employee emp3 = new BasicEmployee("Giorgos", "Xifaras", "6942796775", "alcabilone@gmail.com", "25/07/2000", 1);
	}
 } 
