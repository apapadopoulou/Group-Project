package gr.aueb.dmst.ProgrammingII.BusyB.BusyB;

import java.util.ArrayList;
import java.util.Date;

public class Event extends Program {
    private String title;
    private String description;
    private String date;
    private static int counter = 1;
    private String time;
    private ArrayList<Employee> listOfEmployeesInThisEvent = new ArrayList<Employee>();
    private int eventCode;
    private String type;
    public Event(String title, String date, String time,
    		String description, String type, ArrayList<Employee> employees) {
		this.title = title;
        this.description = description;
        this.type = type;
		listOfEmployeesInThisEvent = employees;
		this.date = date;
		this.setTime(time);
		this.eventCode = counter++;
    }
    public void addEvent () {
    	for (int i = 1; i < listOfEmployeesInThisEvent.size(); i++) {
    		
    	}
    }

	@Override
	public String toString() {
		return "title:" + title + "description:" + description + ", date:" + date + ", time:" + time;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    @Override
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public ArrayList<Employee> getListOfEmployeesInThisEvent() {
		return listOfEmployeesInThisEvent;
	}

	public void setListOfEmployeesInThisEvent(ArrayList<Employee> listOfEmployeesInThisEvent) {
		this.listOfEmployeesInThisEvent = listOfEmployeesInThisEvent;
	}

	public int getEventCode() {
		return eventCode;
	}

	public void setEventCode(int eventCode) {
		this.eventCode = eventCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
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