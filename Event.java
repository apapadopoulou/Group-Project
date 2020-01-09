import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Event extends Program implements Comparable<Event>{
    private String title;
    private String description;
    private String date;
    private static int counter = 1;
    private String time;
    private ArrayList<Employee> employeesInEvent = new ArrayList<Employee>();
    private int eventID;
    private String type;
    
    /**
     * Basic Constructor for class Event.
     * Used to create new Events.
     */
    public Event(String title, String date, String time, String description, String type, ArrayList<Employee> employees) {
		this.title = title;
        this.description = description;
        this.type = type;
		employeesInEvent = employees;
		this.date = date;
		this.time= time;
		eventID = counter++;
		DBcon.saveEvent(this);
		//DBcon.saveEmployesInEvent(employeesInEvent);
    }
    public void addEvent () {
    	for (int i = 1; i < employeesInEvent.size(); i++) {
    		
    	}
    }

	@Override
	public String toString() {
		return "title:" + title + "description:" + description + ", date:" + date + ", time:" + time;
	}
	public String getDesc() {
		return description;
	}

	public void setDesc(String description) {
		this.description = description;
		DBcon.updateEventVar("description", description, eventID);
	}

	public String getEventDate() {
		return date;
	}

	public void setEventDate(String date) {
		this.date = date;
		DBcon.updateEventVar("EventDate", date, eventID);
	}

	public ArrayList<Employee> getEmployeesInEvent() {
		return employeesInEvent;
	}

	public void setEmployeesInEvent(ArrayList<Employee> employeesInEvent) {
		this.employeesInEvent = employeesInEvent;
	}

	public int getEventID() {
		return eventID;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
		DBcon.updateEventVar("type", type, eventID);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		DBcon.updateEventVar("title", title, eventID);
	}

	public String getEventTime() {
		return time;
	}

	public void setEventTime(String time) {
		this.time = time;
		DBcon.updateEventVar("EventTime", time, eventID);
	}
        public static ArrayList<Event> onlyEventsList(ArrayList<Program> calendar){
	ArrayList<Event> eventsList = new ArrayList<Event>();
            for (int i = 0; i < calendar.size(); i++) {
                if (calendar.get(i) instanceof Event) {
                    eventsList.add((Event) calendar.get(i));			 
		}             
	}
	return eventsList;
    }
    static Comparator<Event> eventCompByTime = new Comparator<Event>() {
        
        public int compare(Event e1, Event e2) {
            return e2.getEventTime().compareTo(e1.getEventTime());
        }        
    };
    public static ArrayList<Event> sortByTime(ArrayList<Event> eventList){
    	Collections.sort(eventList, eventCompByTime);
    	return eventList;
    }
    @Override
    public int compareTo(Event o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
