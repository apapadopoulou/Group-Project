import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;

public class Day {
  private ArrayList <Program> dailyProgram = new ArrayList <Program>();
  private Date date;
  public Day(Date d) {
    date = d;
  }
  
  
 public ArrayList<Program> getDailyProgram() {
	return dailyProgram;
}


public void setDailyProgram(ArrayList<Program> dailyProgram) {
	this.dailyProgram = dailyProgram;
}


public Date getDate() {
	return date;
}


public void setDate(Date date) {
	this.date = date;
}

/* public void displayDay(LocalDate date) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy");
        System.out.println(date.format(formatter));
  }
  String[] options = {"Task", "Event"};*/
  private void addToDailyProgram(Program p) {
      dailyProgram.add(p);      
  }
}

