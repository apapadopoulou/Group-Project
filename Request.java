import java.util.ArrayList;

public class Request {
    private boolean accepted;
    private String date;
    private String comments;
    private int days;
    private String desc;
    private String type;
    private String empId;
    public static ArrayList<Request> vacRequests = new ArrayList<Request>();
   
    public Request(String date, int days, String desc, String empId) {
    	accepted = false;
	this.date = date;
	this.days = days;
	this.desc = desc;
	this.empId = empId;
	vacRequests.add(this);	
    }
    
    public String getComments(){
        return comments;
    }
    public void setComments(String comments){
        this.comments = comments;
    }

    public String getType() {
	return type;
    }

	public void setType(String type) {
		this.type = type;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public static ArrayList<Request> getVacRequests() {
		return vacRequests;
	}

	public static void setVacRequests(ArrayList<Request> vacRequests) {
		Request.vacRequests = vacRequests;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}	
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
