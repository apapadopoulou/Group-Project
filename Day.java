import java.util.ArrayList;
import javax.swing.*;
import java.util.Calendar;
import java.util.Date;
public class Day {
  private ArrayList <Program> dailyProgram = new ArrayList <Program>();
  public Day() {
	  LocalDate date = LocalDate.now();

  }
  public void displayDay(LocalDate date) {
	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy");
  	  System.out.println(date.format(formatter));
}
private void addToProgram() {
	Object options = {"Task", "Event"};
	JOptionPane.showInputDialog("What do you want to add to the daily program?",possibilities);
}
/*public static void main (String [] args) {
	Day test = new Day();
	test.addToProgram();
}*/
}

