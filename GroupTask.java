import java.util.Date;
import java.util.ArrayList;
public class GroupTask extends Task {
	private ArrayList <Employee> group = new ArrayList <Employee>();
	public GroupTask(Date duedate, int parts, int levelOfImportance, ArrayList<Employee> group) {
		super(duedate, parts, levelOfImportance);
		this.setGroup(group);
	}
	public ArrayList <Employee> getGroup() {
		return group;
	}
	public void setGroup(ArrayList <Employee> group) {
		this.group = group;
	}
}
