import javax.swing.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ArrayList;

public class PersonalisedCalendar /*extends Calendar*/ {
//<<<<<<< HEAD
	private Day day;
	private Task task;
	private Event event;
	
//=======
//>>>>>>> 6f433bbb41971139c51b0a2734ab286dfd389aa2
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
			/*  This loop displaying if an employee has a task or event */ 
			/* By searching every cell of the list */
			/* If the name of the employee exists, it's shown */
			/* name is username of the employee */
			for (int i = 0; i < dailyProgram.size();i++) {
				if (dailyProgram.contains(name)) {
					 System.out.println(dailyProgram.get(i)); 		
				} else {
					 System.out.println("None");
				} 		
			}				
		}
		/* Main method that assigns a personalised calendar to a user and displays it */
		public static void main (String [] args) {
				PersonalisedCalendar c = new PersonalisedCalendar();
				c.displayCalendar();

		}
		}


