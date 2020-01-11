import java.util.ArrayList;
/**
 * 
 * @author BusyB
 *
 */
public class Request {
    private boolean accepted;
    private String date;
    private String comments;
    private int days;
    private String desc;
    private String type;
    private String empId;
    public static ArrayList<Request> vacRequests = new ArrayList<Request>();
   /**
    * Constructor of class Request
    * @param date
    * @param days
    * @param desc
    * @param empId
    */
    public Request(String date, int days, String desc, String empId) {
    	accepted = false;
	this.date = date;
	this.days = days;
	this.desc = desc;
	this.empId = empId;
	vacRequests.add(this);	
    }
    
    /**
     * Method that gets the comments
     * @return comments
     */
    public String getComments(){
        return comments;
    }
    /**
     * Method that sets the comments
     * @param comments
     */
    public void setComments(String comments){
        this.comments = comments;
    }

    /**
     * Method that returns the type
     * @return type
     */
    public String getType() {
	return type;
    }

    /**
     * Method that sets the type
     * @param type
     */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Method that gets the empId
	 * @return empId
	 */
	public String getEmpId() {
		return empId;
	}

	/**
	 * Method that sets the empID
	 * @param empId
	 */
	public void setEmpId(String empId) {
		this.empId = empId;
	}

	/**
	 * Method that gets vacRequests
	 * @return vacRequests
	 */
	public static ArrayList<Request> getVacRequests() {
		return vacRequests;
	}

	/**
	 * Method that sets the vacRequests
	 * @param vacRequests
	 */
	public static void setVacRequests(ArrayList<Request> vacRequests) {
		Request.vacRequests = vacRequests;
	}

	/**
	 * Method that gets the date
	 * @return date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Method that sets the date
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Method that gets the days
	 * @return days
	 */
	public int getDays() {
		return days;
	}

	/**
	 * Method that sets the days
	 * @param days
	 */
	public void setDays(int days) {
		this.days = days;
	}

	/**
	 * Method that gets the description
	 * @return desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * Method that sets the decription
	 * @param desc
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}	
	/**
	 * Method that searches a request by its empId
	 * @param empId
	 * @return getVacRequests().get(i) or null
	 */
	public static Request searchRequest(String empId) {
		for (int i = 0; i < getVacRequests().size(); i++) {
			if (getVacRequests().get(i).getEmpId().equals(empId))
				return getVacRequests().get(i);
		}
		return null;
	}

	
	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

}
