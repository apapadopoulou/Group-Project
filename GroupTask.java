import java.util.Date;
import java.util.ArrayList;

public class GroupTask extends Task {
	private ArrayList <Employee> group = new ArrayList <Employee>();
	
	public GroupTask(Date duedate, String desc, int stages, int importance, int difficulty, ArrayList<String> empIDs) {
		super(duedate, desc, parts, importance, difficulty);
		this.group = group;
	}
	public ArrayList <Employee> getGroup() {
		return group;
	}
	public void setGroup(ArrayList <Employee> group) {
		this.group = group;
	}
	
}
