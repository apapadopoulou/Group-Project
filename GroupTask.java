import java.util.Date;
import java.util.ArrayList;

public class GroupTask extends Task {
	private ArrayList <Employee> group = new ArrayList <Employee>();
	
	public GroupTask(Date duedate, String desc, int stages, int weight, ArrayList<Employee> group) {
		super(duedate, desc, parts, weight);
		this.group = group;
	}
	public ArrayList <Employee> getGroup() {
		return group;
	}
	public void setGroup(ArrayList <Employee> group) {
		this.group = group;
	}
	
}
