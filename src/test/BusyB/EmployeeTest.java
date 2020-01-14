package gr.aueb.dmst.ProgrammingII.BusyB.BusyB;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeTest {

	@Test
	public void testSearchEmployeeById() {
		
	}

	@Test
	public void testSearchEmployeeByName2() {
		BasicEmployee jim = new BasicEmployee("Jim", "Georgiou", "6950495849", "shsh@gmail.com", "23/02/2017", 1);
		String name = "Jim";
		Employee given = Employee.searchEmployeeByName2(name);
		boolean ans = true;
		boolean val = given.equals(jim);
		assertEquals(ans, val);
	}

}
