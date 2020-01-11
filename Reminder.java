/**
 * 
 * @author BusyB
 *
 */
public class Reminder extends Program {
    private String time;
    private String description;
    /**
     * Method that gets the time
     * @return time
     */
    public String getTime() {
      return time;
    }

    /**
     * Method that sets the time
     * @param time
     */
    public void setTime(String time) {
      this.time = time;
    }

    /**
     * Method that gets the description
     * @return description
     */
    public String getDescription() {
      return description;
    }

    /**
     * Method that sets the description
     * @param description
     */
    public void setDescription(String description) {
      this.description = description;
    }
}
