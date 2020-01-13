package gr.aueb.dmst.ProgrammingII.BusyB.BusyB;

import static org.junit.Assert.*;


import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class DepartmentTest {

	private BasicEmployee given;
	private Employee actual;
	private Department dep = new Department("Accounting");
	private Department d;
	private Department depa;
	private Department de;
	BasicEmployee or = new BasicEmployee("Orestis", "Metaxas", "6951923071", "metaxas99@gmail.com", "03/09/1999", 1);
	
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
	}

	


	

	@Test
	public void testAddEmployee() {
		DBcon.loadDepartments();
		DBcon.loadBasicEmployees();
	    DBcon.loadMiddleManagers();
		DBcon.loadAccounts();
		int size = de.getEmployeesOfDepartment().size();
		BasicEmployee bob = new BasicEmployee("Bob", "Odenkirk", "6957483929", "abd@gmail.com", "27/01/1987", 1);
		de.addEmployee(bob);
		assertEquals(size, de.getEmployeesOfDepartment().size()); 
		
	}

	@Test
	public void testSearchEmployeeByID() {
		
		BasicEmployee exp = new BasicEmployee("Sarantos", "Moraitis", "6951923071", "praetorians12345@gmail.com", "09/10/1999", 2);
		DBcon.loadDepartments();
		DBcon.loadBasicEmployees();
	    DBcon.loadMiddleManagers();
		DBcon.loadAccounts();
		String id = exp.getID();
		actual = depa.searchEmployeeById(id);
		boolean ans = true;
		boolean val = actual.equals(exp);
		
		assertEquals(ans, val);
	
	}

	@Test
	public void testSearchEmployeeByName() {
		
		BasicEmployee expected = new BasicEmployee("Orestis", "Metaxas", "6951923071", "metaxas99@gmail.com", "03/09/1999", 1);
		DBcon.loadDepartments();
		DBcon.loadBasicEmployees();
	    DBcon.loadMiddleManagers();
		DBcon.loadAccounts();
		String name = "Orestis";
		given = d.searchEmployeeByName(name);
		boolean ans = true;
		boolean val = given.equals(expected);
		
		assertEquals(ans, val);
		
		
		
		
	}

	@Test
	public void testDeleteEmployeeByName() {
		String name = "Manos";
		
		
		BasicEmployee manos = new BasicEmployee("Manos", "Voul", "6987588658", "metaxas98@gmail.com", "15/02/1986", 1);
		
		int size = de.getEmployeesOfDepartment().size();
		DBcon.loadBasicEmployees();
		DBcon.loadDepartments();
		DBcon.loadMiddleManagers();
		DBcon.loadAccounts();
		de.deleteEmployeeByName(name);
		assertEquals(size-1, de.getEmployeesOfDepartment().size());
		
	}

	@Test
	public void testDeleteEmployeeById() {
		
		
		
		BasicEmployee manos = new BasicEmployee("Manos", "Voul", "6987588658", "metaxas98@gmail.com", "15/02/1986", 1);
		
		String id = manos.getID();
		
		int size = de.getEmployeesOfDepartment().size();
		DBcon.loadBasicEmployees();
		DBcon.loadDepartments();
		DBcon.loadMiddleManagers();
		DBcon.loadAccounts();
		de.deleteEmployeeById(id);
		assertEquals(size-1, de.getEmployeesOfDepartment().size());
	}
	
	@Test
	public void testSearchDepartmentById() {
		int id = 1;
		Department actual = de.searchDepartmentById(id);
		Department expected = new Department("Accounting");
		boolean ans = true;
		boolean val = expected.equals(actual);
		assertEquals(ans, val);
		
	}
	
	

}
