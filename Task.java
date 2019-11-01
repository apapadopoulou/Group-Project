import java.util.Date;
public abstract class Task {
	private Date dueDate;
	private boolean done;
	public Task(Date dueDate) {
		this.dueDate = dueDate;
		done = false;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public boolean getStatus() {
		return done;
	}
	public void setStatus(boolean status) {
		done = status;
	}
	public abstract void newTask();
}
