package gr.aueb.dmst.ProgrammingII.BusyB.BusyB;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountTest {
	private Account a;

	@Test
	public void testSearchAccountByEmail() {
		String email = "metaxas99@gmail.com";
		BasicEmployee e = new BasicEmployee("Bryan", "Cranston", "6969696969", "brcr@gmail.com", "25/05/1956", 1);
		Account acc = new Account(e);
		DBcon.loadDepartments();
		DBcon.loadBasicEmployees();
	    DBcon.loadMiddleManagers();
		DBcon.loadAccounts();
		Account actual = Account.searchAccountByEmail(email);
		boolean ans = true;
		boolean val = actual.equals(acc);
		assertEquals(ans, val);
	}

	@Test
	public void testTypeOfEmployee() {
		BasicEmployee empl = new BasicEmployee("John", "Cranston", "6969696969", "brcr@gmail.com", "25/05/1956", 1);
		DBcon.loadDepartments();
		DBcon.loadBasicEmployees();
	    DBcon.loadMiddleManagers();
		DBcon.loadAccounts();
		
		int actual = a.typeOfEmployee(empl);
		int expected = 1;
		assertEquals(expected, actual);
	}

	
}
