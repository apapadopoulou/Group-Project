package gr.aueb.dmst.ProgrammingII.BusyB.BusyB;

import static org.junit.Assert.*;

import org.junit.Test;

public class DayTest {

	@Test
	public void testNextDate() {
		String starting_date = "31/12/2017";
		String expected  = "01/01/2018";
		String given = Day.nextDate(starting_date);
		assertEquals(expected, given);
	}
	@Test
	public void testLeapYear() {
		int year = 2024;
		boolean exp = true;
		boolean actual = Day.leapYear(year);
		assertEquals(exp, actual);
	}
	
	@Test
	public void testValidDate() {
		String date = "28/02/2017";
		boolean exp = true;
		boolean actual = Day.validDate(date);
		assertEquals(exp, actual);
	}

}
