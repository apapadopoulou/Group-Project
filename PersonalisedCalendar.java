import javax.swing.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

public class PersonalisedCalendar /* extends Calendar */ {

	private Day day;
	private Task task;
	private Event event;

	/*
	 * Creating a 2X2 table named calendar of type Day and containing every day of
	 * the year
	 */
	private Day[][] calendar = new Day[12][];

	/*
	 * PersonalisedCalendar method inputs the specific amount of days each month has
	 */
	public PersonalisedCalendar() {
		for (int month = 0; month <= 11; month++) {
			if (month <= 6 & month != 1) {
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
	

	/* displayCalendar method which prints the calendar on the screen 
	public void displayCalendar() {
		for (int month = 0; month <= 11; month++) {
			JFrame f = new JFrame("Month");
			f.setBounds(month, calendar[month].length, 4, 5);
			f.setVisible(true);
		}
		/* This loop displaying if an employee has a task or event */
		/* By searching every cell of the list */
		/* If the name of the employee exists, it's shown */

		/* name is username of the employee */
		/*for (int i = 0; i < calendar[i].dailyProgram.size(); i++) {
=======
		/* name is username of the employee 
		for (int i = 0; i < calendar[monthdailyProgram.size(); i++) {
>>>>>>> 7747656e7db2b98f3212638f7d969fbc7f4c5c12
			if (dailyProgram.contains(name)) {
				System.out.println(dailyProgram.get(i));
			}else {
				System.out.println("None");
			}
		}*/
	}
        /** This method returns the daily program of the employee for the date given*/
    public ArrayList <Program> today (Date d) {
    	LocalDate localDate = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    	int month = localDate.getMonthValue();
    	int dayD = localDate.getDayOfMonth();
    	return calendar[month - 1][dayD - 1].getDailyProgram();
    }
    public void addToCalendar (Program p) {
        Date d = p.getDate();
        LocalDate localDate = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();
    	int dayD = localDate.getDayOfMonth();
        calendar[month - 1][dayD - 1] = day; 
               
    }
    	
    
    	
    
    
    
    
    
	/* Main method that assigns a personalised calendar to a user and displays it */

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
	/* This method checks if the year is leap */
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

