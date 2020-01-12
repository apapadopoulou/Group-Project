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
	/**
	 * d field represents a day
	 */
	private String d;
	/**
	 * mon field represents a month
	 */
	private String mon;
	/**
	 * y field represents a year
	 */
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
	 /**
	  * Constructor for class Day
	  * @param date
	  * @param empID
	  */
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
  }
/**
 *Returns the daily program.
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
    }
 /**
  *Adds to daily program.
  * @param p
  */
  private void addToDailyProgram(Program p) {
    dailyProgram.add(p);
  }
  /**
   *Returns the date field.
   *@return date 
   */
  public String getDate() {
	  return date;
  }
  /**
   *Sets the date field.
   *@param date 
   */
  public void setDate(String date) {
	  this.date = date;
  }
  /**
   *Gets the dayID field.
   *@return dayID
   */
  public int getID() {
	  return dayID;
  }
  /**
   * Returns the empID field
   * @return empID
   */
  public String getEmpID() {
	  return empID;
  }
  /**
   * Returns the d field
   * @return d
   */
  public String getD() {
	  return d;
  }
  /**
   *Sets the d field.
   *@param d 
   */
  public void setD(String d) {
	  this.d = d;
  }
  /**
   *Returns the mon field.
   *@return mon 
   */
  public String getMon() {
	 return mon;
  }
  /**
   *Sets the mon field.
   *@param mon 
   */
  public void setMon(String mon) {
	  this.mon = mon;
  }
  /**
   * Returns the y field.
   * @return y
   */
  public String getY() {
	  return y;
  }
  /**
   * Sets the y field.
   * @param y
   */
  public void setY(String y) {
	  this.y = y;
  }
  /**
   * Checks if a year is leap
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
  /**
   * Checks if a date is valid
   * @param date
   * @return true or false
   */
  public static boolean validDate(String date){
	  int day = Integer.parseInt(date.substring(0, 2));
	  int month = Integer.parseInt(date.substring(3, 5));
	  int year = Integer.parseInt(date.substring(6));
	  if(day > 28 && month == 2){
		  if (Day.leapYear(year))
			  return false;
		  else {
			  if (day > 29)
				  return false;
		  }    
	  } else if (day > 30){
		  if (month == 4 || month == 6 || month == 9 || month == 11){
			  return false;
		  }
	  	}
	  return true;    
  }
 
}
/**
 * End of Day class
 */
