package gr.aueb.dmst.ProgrammingII.BusyB.BusyB;

import static org.junit.Assert.*;

import org.junit.Test;

public class MiddleManagerTest {

	@Test
	public void testHREmployee() {
		DBcon.loadDepartments();
		DBcon.loadBasicEmployees();
	    DBcon.loadMiddleManagers();
		DBcon.loadAccounts();
		String name = "Alekos";
		MiddleManager alekos = new MiddleManager("Alekos", "Peris", "2102102101", "alper@gmail.com", "23/11/1987");
		boolean ans = true;
		boolean val = MiddleManager.HREmployee(name);
		assertEquals(ans, val);
	}

	@Test
	public void testSearchMiddleManager() {
		DBcon.loadDepartments();
		DBcon.loadBasicEmployees();
	    DBcon.loadMiddleManagers();
		DBcon.loadAccounts();
		String name = "Dimitris";
		MiddleManager Dim = new MiddleManager("Dimitris", "Kourmpelis", "2106719201", "jimkour@gmail.com", "14/12/1976");
		MiddleManager given = MiddleManager.searchMiddleManager(name);
		boolean ans = true;
		boolean val = given.equals(Dim);
		assertEquals(ans, val);
	}

	@Test
	public void testSearchMiddleManagerById() {
		MiddleManager mm = new MiddleManager("Giorgos", "Aggelopoulos", "6951923071", "praetorians12345@gmail.com", "09/10/1999");
		DBcon.loadDepartments();
		DBcon.loadBasicEmployees();
	    DBcon.loadMiddleManagers();
		DBcon.loadAccounts();
		String id = mm.getID();
		MiddleManager actual = MiddleManager.searchMiddleManagerById(id);
		boolean ans = true;
		boolean val = actual.equals(mm);
		
		assertEquals(ans, val);
	}

}
