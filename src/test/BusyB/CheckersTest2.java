package gr.aueb.dmst.ProgrammingII.BusyB.BusyB;

import junit.framework.TestCase;

public class CheckersTest2 extends TestCase {

	public void testIsValidEmail() {
		boolean ans = true;
		boolean val;
		String email = "metaxas99@gmail.com";
		
		val = Checkers.isValidEmail(email);
		assertEquals(ans, val);
	}
	
	public void testIsValidFirstName() {
		boolean ans = true;
		boolean val;
		String firstName = "Orestis";
		
		val = Checkers.isValidFirstName(firstName);
		assertEquals(ans, val);
	}
	
	public void testIsValidLastName() {
		boolean ans = true;
		boolean val;
		String lastName = "Metaxas";
		
		val = Checkers.isValidLastName(lastName);
		assertEquals(ans, val);
	}
	
	public void testisValidPassword() {
		boolean ans = true;
		boolean val;
		String password = "orestis";
		
		val = Checkers.isValidPassword(password);
		assertEquals(ans, val);
	}
	
	public void testIsValidType() {
		boolean ans = true;
		boolean val;
		String type = "main event";
		
		val = Checkers.isValidType(type);
		assertEquals(ans, val);
	}
	
	
	


}