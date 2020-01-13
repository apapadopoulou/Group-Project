package gr.aueb.dmst.ProgrammingII.BusyB.BusyB;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
/**
 * 
 * @author BusyB
 *
 */

public class Event extends Program implements Comparable<Event>{
    private String title;
    private String description;
    private String date;
    private String time;
    private ArrayList<String> empIDsInEvent = new ArrayList<String>();
    private String type;
    
    /**
     * Basic Constructor for class Event.
     * Used to create new Events.
     * @param title
     * @param date
     * @param time
     * @param description
     * @param type
     * @param empIDs
     */
    public Event(String title, String date, String time, String description, String type, ArrayList<String> empIDs) {
    	super(empIDs);
    	this.title = title;
       	this.description = description;
       	this.type = type;
       	empIDsInEvent = empIDs;
    	this.date = date;
    	this.time= time;
    	DBcon.saveEvent(this);
    	for (int i = 0; i < empIDs.size(); i++) {
    		Employee.searchEmployeeById(empIDs.get(i)).updateDailyProgram(this);
    		DBcon.AssignToEvent(getProgramID(), empIDs.get(i));
    	}
    }
    
    /**
     * Database constructor for class Event.
     * Used to create new Events that are loaded from the database.
     * @param title
     * @param date
     * @param time
     * @param description
     * @param type
     * @param eventID
     * @param empIDs
     */
    public Event(String title, String date, String time, String description, String type, int eventID, ArrayList<String> empIDs) {
		super(empIDs, eventID);
    	this.title = title;
        this.description = description;
        this.type = type;
        empIDsInEvent = empIDs;
		this.date = date;
		this.time= time;
    }
    
    public void addEvent () {
      for (int i = 1; i < empIDsInEvent.size(); i++) {
        
      }
    }
  /**
   * toString method returning the date in this format
   * @return "Date:" + date + ", Time:" + time + ", Title:" + title + ", Description:" + description
   */
  @Override
  public String toString() {
    return "Date:" + date + ", Time:" + time + ", Title:" + title + ", Description:" + description;
  }
  
  /**
   * toString returning the date in a format that contains the type
   * @return "Date:" + date + ", Time:" + time + ", Title:" + title + ", Description:" + description + ", Type:" + type
   */
  public String toStringWithType() {
      return "Date:" + date + ", Time:" + time + ", Title:" + title + ", Description:" + description + ", Type:" + type;
  }
  
  /**
   * Returns an event's description
   * @return description
   */
  public String getDesc() {
    return description;
  }
  
  /**
   * Sets the description and updates an event with this description
   * @param description
   */
  public void setDesc(String description) {
    this.description = description;
    DBcon.updateEventVar("description", description, getProgramID());
  }

  /**
   * Returns an event's date
   * @return date
   */
  public String getEventDate() {
    return date;
  }

  /**
   * Sets the event date and updates an event with this date
   * @param date
   */
  public void setEventDate(String date) {
    this.date = date;
    DBcon.updateEventVar("EventDate", date, getProgramID());
  }

  /**
   * Returns the EmpIDsInEvent field
   * @return empIDsInEvent
   */
  public ArrayList<String> getEmpIDsInEvent() {
    return empIDsInEvent;
  }

  /**
   * Sets the EmpIDsInEvent field
   * @param employeesInEvent
   */
  public void setEmpIDsInEvent(ArrayList<String> employeesInEvent) {
    this.empIDsInEvent = employeesInEvent;
  }

  /**
   * Returns the type field
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * Sets the type field
   * @param type
   */
  public void setType(String type) {
    this.type = type;
    DBcon.updateEventVar("type", type, getProgramID());
  }

  /**
   * Returns the title field
   * @return title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Sets the title field and updates the event with this title
   * @param title
   */
  public void setTitle(String title) {
    this.title = title;
    DBcon.updateEventVar("title", title, getProgramID());
  }

  /**
   * Returns the time field
   * @return time
   */
  public String getEventTime() {
    return time;
  }

  /**
   * Sets the time field
   * @param time
   */
  public void setEventTime(String time) {
    this.time = time;
    DBcon.updateEventVar("EventTime", time, getProgramID());
  }
  
  /**
   * Returns the list of Events
   * @param calendar
   * @return eventsList
   */
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
/**
 * End of Event class
*/