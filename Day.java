import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.*;

public class Day {
	private ArrayList <Program> dailyProgram = new ArrayList <Program>();
	private LocalDate date;
	
	public Day() {
		this.date = LocalDate.now();
	}
	public void displayDay(LocalDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy");
  	  	System.out.println(date.format(formatter));
	}
	String[] options = {"Task", "Event"};
	private void addToProgram() {
		String showInputDialog = JOptionPane.showInputDialog("What do you want to add to the daily program?", options);
		System.out.print(showInputDialog);
	}
	public static void main (String [] args) {
		Day test = new Day();
		test.addToProgram();
	}
}

