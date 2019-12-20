import javax.swing.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
				// hi
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
		/* name is username of the employee 
		for (int i = 0; i < calendar[monthdailyProgram.size(); i++) {
			if (dailyProgram.contains(name)) {
				System.out.println(dailyProgram.get(i));
			} else {
				System.out.println("None");
			}
		}
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

