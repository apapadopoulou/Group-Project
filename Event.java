import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Event extends Program implements Comparable<Event>{
    private String title;
    private String description;
    private String date;
    private String time;
    private ArrayList<Employee> employeesInEvent = new ArrayList<Employee>();
    private String type;
    
    /**
     * Basic Constructor for class Event.
     * Used to create new Events.
     */
    public Event(String title, String date, String time, String description, String type, ArrayList<Employee> employees) {
    	super();
    	this.title = title;
       	this.description = description;
       	this.type = type;
       	employeesInEvent = employees;
    	this.date = date;
    	this.time= time;
    	DBcon.saveEvent(this);
    	for (int i = 0; i < employees.size(); i++) {
    		DBcon.AssignToEvent(getProgramID(), employees.get(i).getID());
    	}
    }
    
    /**
     * Database constructor for class Event.
     * Used to create new Events that are loaded from the database.
     */
    public Event(String title, String date, String time, String description, String type, int eventID, ArrayList<String> empIDs) {
		super(eventID);
    	this.title = title;
        this.description = description;
        this.type = type;
        for (int i = 0; i < empIDs.size(); i++) {
        	employeesInEvent.add(Employee.searchEmployeeById(empIDs.get(i)));
        }
		this.date = date;
		this.time= time;
		DBcon.saveEvent(this);
    }
    
    public void addEvent () {
      for (int i = 1; i < employeesInEvent.size(); i++) {
        
      }
    }

  @Override
  public String toString() {
    return "date:" + date + ", time:" + time + ", title:" + title + ", description:" + description;
  }
  
  public String toStringWithoutDesc() {
      return "date:" + date + ", time:" + time + ", title:" + title;
  }
  
  public String getDesc() {
    return description;
  }

  public void setDesc(String description) {
    this.description = description;
    DBcon.updateEventVar("description", description, getProgramID());
  }

  public String getEventDate() {
    return date;
  }

  public void setEventDate(String date) {
    this.date = date;
    DBcon.updateEventVar("EventDate", date, getProgramID());
  }

  public ArrayList<Employee> getEmployeesInEvent() {
    return employeesInEvent;
  }

  public void setEmployeesInEvent(ArrayList<Employee> employeesInEvent) {
    this.employeesInEvent = employeesInEvent;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
    DBcon.updateEventVar("type", type, getProgramID());
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
    DBcon.updateEventVar("title", title, getProgramID());
  }

  public String getEventTime() {
    return time;
  }

  public void setEventTime(String time) {
    this.time = time;
    DBcon.updateEventVar("EventTime", time, getProgramID());
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
