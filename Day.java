import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;

/**
 *@author BusyB 
 */

public class Day {
	public static int counter = 1;
	private String empID;
	private int dayID;
  private ArrayList<Program> dailyProgram = new ArrayList<Program>();
  private String date;
  private String d;
	private String mon;
	private String y;
	private static final String[] days 
	=	{"01", "02", "03", "04", "05", 
          "06", "07", "08", "09", "10", 
          "11", "12", "13", "14", "15", 
          "16", "17", "18", "19", "20", 
          "21", "22", "23", "24", "25", 
          "26", "27", "28", "29", "30", 
          "31"};
	 private static final String months[] 
		        = { "01", "02", "03", "04", 
		            "05", "06", "07", "08", 
		            "09", "10", "11", "12" }; 
	 private static final String years[] 
		        = { "2020", "2021", "2022", "2023", 
		            "2024", "2025", "2026", "2027", 
		            "2028", "2029", "2030", "2031", 
		            "2032", "2033", "2034", "2035", 
		            }; 
  public Day(String date, String empID) {
	dayID = counter++;
	this.empID = empID;
    String givenDay = date.substring(0, 2);
    String givenMonth = date.substring(3, 5);
    String givenYear = date.substring(6);
    try {
    for (int i =0; i < days.length; i++) {
    	if (givenDay.equals(days[i])) {
    		d = givenDay;
    	}
    	else {
    		throw new Exception();
    	}
    }
    for (int i =0; i < months.length; i++) {
    	if (givenMonth.equals(months[i])) {
    		mon = givenMonth;
    	}
    	else {
    		throw new Exception();
    	}
    }
    for (int i =0; i < years.length; i++) {
    	if (givenYear.equals(years[i])) {
    		y = givenYear;
    	}
    	else {
    		throw new Exception();
    	}
    }
    this.date = date;
    } catch (Exception ex) {
    	date = null;
    }
    DBcon.saveDay(this);
  }
  
  /**
   * Database constructor for class Day.
   * Used to create Day objects loaded from the database.
   */
  public Day(String date, String empID, int dayID) {
		this.dayID = dayID;
		counter = dayID + 1;
		this.empID = empID;
	    String givenDay = date.substring(0, 2);
	    String givenMonth = date.substring(3, 5);
	    String givenYear = date.substring(6);
	    try {
	    for (int i =0; i < days.length; i++) {
	    	if (givenDay.equals(days[i])) {
	    		d = givenDay;
	    	}
	    	else {
	    		throw new Exception();
	    	}
	    }
	    for (int i =0; i < months.length; i++) {
	    	if (givenMonth.equals(months[i])) {
	    		mon = givenMonth;
	    	}
	    	else {
	    		throw new Exception();
	    	}
	    }
	    for (int i =0; i < years.length; i++) {
	    	if (givenYear.equals(years[i])) {
	    		y = givenYear;
	    	}
	    	else {
	    		throw new Exception();
	    	}
	    }
	    this.date = date;
	    } catch (Exception ex) {
	    	date = null;
	    }
	  }
/**
 *Gets the daily program.
 *@return daily program
 */
  public ArrayList<Program> getDailyProgram() {
   	return dailyProgram;
  }
 /**
  *Sets the daily program.
  *@param dailyProgram
  */
 	public void setDailyProgram(ArrayList<Program> dailyProgram) {
 		this.dailyProgram = dailyProgram;
 		//DBcon.setDailyProgram(ArrayList<Program> dailyProgram); TODO!!
    }
  
 /**
  *Adds to daily program.
  * @param p
  */
  private void addToDailyProgram(Program p) {
    dailyProgram.add(p);
  }
  /**
   *Gets the date.
   *@return date 
   */
public String getDate() {
	return date;
}
/**
 *Sets the date.
 *@param date 
 */
public void setDate(String date) {
	this.date = date;
}
/**
 *Gets the day.
 *@return d 
 */

	public int getID() {
		return dayID;
	}
	
	public String getEmpID() {
		return empID;
	}
	
public String getD() {
	return d;
}
/**
 *Sets the day.
 *@param d 
 */
public void setD(String d) {
	this.d = d;
}
/**
 *Gets the month.
 *@return mon 
 */
public String getMon() {
	return mon;
}
/**
 *Sets the month.
 *@param mon 
 */
public void setMon(String mon) {
	this.mon = mon;
}
/**
 * Gets the year.
 * @return y
 */
public String getY() {
	return y;
}
/**
 * Sets the year.
 * @param y
 */
public void setY(String y) {
	this.y = y;
}
}
//End of Day class.
