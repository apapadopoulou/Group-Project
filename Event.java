public class Event extends Program{
	private String title;
	private String date;

	public Event(String title, String date) {
		this.title = title;
		do {
		if (Checkers.isValidTitle(title)) 
			System.out.println("Valid Title");
		else 
			System.out.println("Invalid Title; Insert a new one");
		} while (Checkers.isValidTitle(title));
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
