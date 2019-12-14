
public class Admin {
	private int sigrating;
	private String fullname;
	private String department;
	public Admin(int sigrating, String fullname, String department) {
		this.sigrating = sigrating;
		this.fullname = fullname;
		this.department = department;
	}
	public int getSigrating() {
		return sigrating;
	}
	public void setSigrating(int sigrating) {
		this.sigrating = sigrating;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

}
