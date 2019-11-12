import javax.swing.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ArrayList;

public class PersonalisedCalendar /*extends Calendar*/ {
	private Day [] [] calendar = new Day [12][];
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
	  			}
		   }
	   }
		public void displayCalendar() {
						for (int month = 0; month <= 11; month++) {
							JFrame f = new JFrame("Month");
							f.setBounds(month, calendar[month].length, 4, 5);
							f.setVisible(true);
						}
				}
		public static void main (String [] args) {
				PersonalisedCalendar c = new PersonalisedCalendar();
				c.displayCalendar();

		}
	 }


