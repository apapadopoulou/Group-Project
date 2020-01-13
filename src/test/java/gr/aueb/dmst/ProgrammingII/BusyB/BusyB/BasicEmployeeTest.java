package gr.aueb.dmst.ProgrammingII.BusyB.BusyB;

import static org.junit.Assert.*;

import org.junit.Test;

public class BasicEmployeeTest {
	Department dep = new Department("HR");
	BasicEmployee b;
	private BasicEmployee emp = new BasicEmployee("George", "Mastras", "6987875628", "abc@gmail.com", "19/03/1963", 2);

	@Test
	public void testHREmployee() {
		
		String name = "George";
		DBcon.loadDepartments();
		DBcon.loadBasicEmployees();
	    DBcon.loadMiddleManagers();
		DBcon.loadAccounts();
		boolean actual = BasicEmployee.HREmployee(name);
		boolean expected = true;
		assertEquals(expected, actual);
	
	}

	@Test
	public void testSearchEmployeeByName2() {
		BasicEmployee george = new BasicEmployee("George", "Georgiou", "6950495849", "shsh@gmail.com", "23/02/2017", 1);
		String name = "George";
		DBcon.loadDepartments();
		DBcon.loadBasicEmployees();
	    DBcon.loadMiddleManagers();
		DBcon.loadAccounts();
		BasicEmployee given = b.searchEmployeeByName2(name);
		boolean ans = true;
		boolean val = given.equals(george);
		assertEquals(ans, val);
		
	}
	
	
}
