import java.util.ArrayList;
import java.util.Date;

public class Event extends Program {
    private String title;
    private String description;
    private Date date;
    private static int counter = 1;
    private String time;
    ArrayList<Employee> listOfEmployeesInThisEvent = new ArrayList<Employee>();
    private int eventCode;
    private int type;
    public Event(String title, Date date, String time,
    		String description, int type) {
		this.title = title;
        this.description = description;
        this.type = type;
		/*do {
			if (Checkers.isValidType(type))
				System.out.println("Valid Title");
			else
		System.out.println("Invalid Title! Insert a new one");
		} while (Checkers.isValidTitle(title));*/
		this.date = date;
		this.setTime(time);
		this.eventCode = counter++;
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
