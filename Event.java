import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class Event extends Program {
	private String title;
        private String description;
	/* private String date; */
        private static int counter = 1;
	private LocalTime time;
	ArrayList<Employee> listOfEmployeesInThisEvent = new ArrayList<Employee>();
	private String Event_code; /* needed for the DB */
	public Event(String title, Date date, LocalTime time, String description) {
		this.title = title;
                /*this.description = description;
		do {
			if (Checkers.isValidTitle(title))
				System.out.println("Valid Title");
			else
				System.out.println("Invalid Title; Insert a new one");
		} while (Checkers.isValidTitle(title));*/
		this.date = date;
		this.setTime(time);
		this.Event_code = String.valueOf(counter++) + title.substring(1, 2); /* needed fot the Database*/
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
