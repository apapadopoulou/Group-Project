package gr.aueb.dmst.ProgrammingII.BusyB.BusyB;
/**
 * 
 * @author BusyB
 *
 */

public class PersonalisedCalendar {
    /**
     * This method checks if a year is leap
     * @param year
     * @return leap
     */
	public static boolean leapYear(int year) {
		boolean leap = false;
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					leap = true;
				}
			} else {
				leap = true;
			}
		}
		return leap;
	}
}