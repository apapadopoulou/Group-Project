import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;

/**
 *@author BusyB 
 */

public class Day {
  private ArrayList<Program> dailyProgram = new ArrayList<Program>();
  private Date date;
  public Day(Date d) {
    date = d;
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
  */
  public void setDailyProgram(ArrayList<Program> dailyProgram) {
    this.dailyProgram = dailyProgram;
  }

/**
 *Gets the date.
 *@return date 
 */
  public Date getDate() {
    return date;
 }

/**
 *Sets the date.
 */
  public void setDate(Date date) {
	this.date = date;
  }

  /** public void displayDay(LocalDate date) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy");
    System.out.println(date.format(formatter));
  }
  String[] options = {"Task", "Event"};*/
 
  private void addToDailyProgram(Program p) {
    dailyProgram.add(p);
  }
}
/** 
*End of Day class.
*/