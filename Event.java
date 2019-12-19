import java.time.LocalTime;
import java.util.ArrayList;

public class Event extends Program {
	private String title;
	private String date;
	private LocalTime time;
	ArrayList<Employee> listOfEmployeesInThisEvent = new ArrayList<Employee>();

	public Event(String title, String date, LocalTime time) {
		this.title = title;
		do {
			if (Checkers.isValidTitle(title))
				System.out.println("Valid Title");
			else
				System.out.println("Invalid Title; Insert a new one");
		} while (Checkers.isValidTitle(title));
		this.date = date;
		this.setTime(time);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

}
