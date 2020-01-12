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
    private int requestID;
    public static int counter = 1;
    public static ArrayList<Request> vacRequests = new ArrayList<Request>();
   /**
    * Basic constructor of class Request.
    * Used to create new Request objects.
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
    	requestID = counter++;
    	vacRequests.add(this);
    	DBcon.saveRequest(this);
    }
    
    /**
     * Dastabase constructor of class Request.
     * Used to create Request objects that are loaded from the database.
     * @param date
     * @param days
     * @param desc
     * @param empId
     */
     public Request(String date, int days, String desc, String empId, int accepted, int requestID) {
    	 if (accepted == 0) {
    		 this.accepted = false; 
    	 } else if (accepted == 1) {
    		 this.accepted = true;
    	 }
    	 this.date = date;
    	 this.days = days;
    	 this.desc = desc;
    	 this.empId = empId;
    	 requestID = counter++;
    	 vacRequests.add(this);
    	 DBcon.saveRequest(this);
     }
    
     public int getRequestID(){
    	 return requestID;
     }
     
    /**
     *Returns the accepted field
     * @return accepted
     */
    public boolean isAccepted(){
        return accepted;
    }
    /**
     * Sets the accepted field
     * @param accepted
     */
    public void setAccepted(boolean accepted){
        this.accepted = accepted;
    }
    /**
     * Returns the comments field
     * @return
     */
    public String getComments(){
        return comments;
    }
    /**
     * Sets the comments field
     * @param comments
     */
    public void setComments(String comments){
        this.comments = comments;
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
	}

	/**
	 * Returns the empId field
	 * @return empId
	 */
	public String getEmpId() {
		return empId;
	}

	/**
	 * Sets the empID field
	 * @param empId
	 */
	public void setEmpId(String empId) {
		this.empId = empId;
	}

	/**
	 * Returns the vacRequests field
	 * @return vacRequests
	 */
	public static ArrayList<Request> getVacRequests() {
		return vacRequests;
	}

	/**
	 * Sets the vacRequests field
	 * @param vacRequests
	 */
	public static void setVacRequests(ArrayList<Request> vacRequests) {
		Request.vacRequests = vacRequests;
	}

	/**
	 * Returns the date field
	 * @return date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Sets the date field
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Returns the days field
	 * @return days
	 */
	public int getDays() {
		return days;
	}

	/**
	 * Sets the days field
	 * @param days
	 */
	public void setDays(int days) {
		this.days = days;
	}

	/**
	 * Returns the desc field
	 * @return desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * Sets the desc field
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
}
/**
 * End of Request class
*/