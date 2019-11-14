import java.util.ArrayList;
public class Day {
  private ArrayList <Program> dailyProgram = new ArrayList <Program>();
  public Day() {
	  LocalDate date = LocalDate.now();


  }
  public void displayDay(LocalDate date) {
	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy");
  	  System.out.println(date.format(formatter));
}
