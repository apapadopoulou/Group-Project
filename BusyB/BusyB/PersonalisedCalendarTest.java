package gr.aueb.dmst.ProgrammingII.BusyB.BusyB;

import junit.framework.TestCase;

public class PersonalisedCalendarTest extends TestCase {

	public void testLeapYear() {
		boolean ans = true;
		boolean val;
		int year = 2008;
		
		val = PersonalisedCalendar.leapYear(year);
		assertEquals(ans, val);
	}
	
	 public void testAddToCalendar() {
	        .add("Banana");
	        assertEquals("Adding 1 more fruit to list", 4, lstTest.size());
	    }

}
