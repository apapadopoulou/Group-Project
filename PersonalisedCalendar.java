import javax.swing.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ArrayList;

public class PersonalisedCalendar /*extends Calendar*/ {
	private Day day;
	private Task task;
	private Event event;
	/*Creating constructor */
	public PersonalisedCalendar(Day day, Task task, Event event) {
		this.day = day;
		this.task = task;
		this.event = event;
	}
	/* Creating a 2X2 table named calendar of type Day and containing every day of the year*/
	private Day [] [] calendar = new Day [12][]; 
	/* PersonalisedCalendar method inputs the specific amount of days each month has */
	public PersonalisedCalendar() {
      for (int month = 0; month <= 11; month++) {
	  			if (month <= 6 & month != 1){
	  			  if (month%2 == 1) {
	  				calendar[month] =new  Day [31];
	  			  } else if (month%2 == 0) {
	  				calendar[month] = new Day [30];
	  			 } else if (month == 1){
	  				 calendar[month] = new Day [29];
	  			 } else {
	  			    if (month%2 == 1) {
	  						calendar[month] = new Day [30];
	  				} else if (month%2 == 0) {
	  						calendar[month] = new Day [31];
	  				}
	  			 }
	  			  //hi
	  			}
		   }
	   }
	/* displayCalendar method which prints the calendar on the screen */
		public void displayCalendar() {
						for (int month = 0; month <= 11; month++) {
							JFrame f = new JFrame("Month");
							f.setBounds(month, calendar[month].length, 4, 5);
							f.setVisible(true);
						}
						 /* This way connect three classes (Day,Task,Event) in order to display the calendar */
						Scanner p = new Scanner(System.in);
						int lev = p.nextInt();
						String title = p.nextLine();
						String date = p.nextLine();
						Day d = new Day();
						Task t = new Task(getDueDate() , lev);
						Event e = new Event(title , date);
						PersonalisedCalendar pc = new PersonalisedCalendar(d, t, e); 
						
		}
		/* Main method that assigns a personalised calendar to a user and displays it */
		public static void main (String [] args) {
				PersonalisedCalendar c = new PersonalisedCalendar();
				c.displayCalendar();

		}
		}


