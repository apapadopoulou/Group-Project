import javax.swing.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
/**
 * 
 * @author BusyB
 *
 */

public class PersonalisedCalendar {
    private Day[][] calendar;
    public PersonalisedCalendar() {
        for (int month = 0; month <= 11; month++) {
            if (month <= 6 && month != 1) {
                if (month % 2 == 1) {
                    calendar[month] = new Day[31];
                } else if (month % 2 == 0) {
                    calendar[month] = new Day[30];
                } else if (month == 1) {
                    calendar[month] = new Day[29];
                } else {
                    if (month % 2 == 1) {
                        calendar[month] = new Day[30];
                    } else if (month % 2 == 0) {
                        calendar[month] = new Day[31];
                    }
               }
           }
       }
    }

    /**
     * This method returns the daily program of the employee
     * for the date given
     * @param d
     * @return calendar[month - 1][dayD - 1].getDailyProgram()
     */
     public ArrayList<Program> todaysProgram(Date d) {
        LocalDate localDate = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();
        int dayD = localDate.getDayOfMonth();
        return calendar[month - 1][dayD - 1].getDailyProgram();
    }
    /*public void addToCalendar (Program p) {
        Date d = p.getDate();
        LocalDate localDate = d.toInstant().atZone(ZoneId.
        systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();
        int dayD = localDate.getDayOfMonth();
        calendar[month - 1][dayD - 1] = day;
    }
    */

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
/**
* End of PersonalisedCalendar class
*/