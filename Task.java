import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Task extends Program implements Comparable<Task>{

	private String startDate;
	private String dueDate;
	private String completionDate;
	private String desc;
	private boolean done;
	private boolean isGroupTask;
	private int importance; //Importance of a task should be between 1 and 10.
	private int difficulty; //Difficulty of a task should be between 1 and 10.
	private String empId; //Employee ID for single-employee Tasks.
	private ArrayList<String> empIds; //Employee IDs ArrayList for Group Tasks.
	private double score;
	private double[] scores;
	public static ArrayList<Task> tasks = new ArrayList<Task>();
  
  /**
   *Constructor for single-employee task.
   */
	public Task(String startDate, String dueDate, String desc, int importance, int difficulty, String empId) {
		super();
		this.desc = desc;
		this.startDate = startDate;
		this.dueDate = dueDate;
		done = false;
		isGroupTask = false;
		this.importance = importance;
		this.difficulty = difficulty;
		this.empId = empId;
		tasks.add(this);
		DBcon.saveTask(this);
		DBcon.AssignToTask(getProgramID(), empId);
	}
	
	/**
	 * Database Constructor for single employee Tasks.
	 * Used to load Task objects from Database.
	 */
	public Task(int taskID, String startDate, String dueDate, String completionDate, String desc, int importance, int difficulty, String empId) {
		super(taskID);
		this.desc = desc;
		this.startDate = startDate;
		this.dueDate = dueDate;
		this.completionDate = completionDate;
		if (completionDate == null) {
			done = false;
		} else {
			done = true;
		}
		isGroupTask = false;
		this.importance = importance;
		this.difficulty = difficulty;
		this.empId = empId;
		tasks.add(this);
	}
  
  /**
   *Basic Constructor for multi-employee group task. 
   */
	public Task(String startDate, String dueDate, String desc, int importance, int difficulty, ArrayList<String> empIds) {
		super();
		this.desc = desc;
		this.startDate = startDate;
		this.dueDate = dueDate;
		done = false;
		isGroupTask = true;
		this.importance = importance;
		this.difficulty = difficulty;
		this.empIds = empIds;
		tasks.add(this);
		DBcon.saveTask(this);
		for (int i = 0; i < empIds.size(); i++) {
			DBcon.AssignToTask(getProgramID(), empIds.get(i));
		}
	}
	
	/**
	 * Database constructor for group Tasks.
	 * Used to load multi-employee Tasks from the Database.
	 */
	public Task(int taskID, String startDate, String dueDate, String completionDate, String desc, int importance, int difficulty, ArrayList<String> empIds) {
		super(taskID);
		this.desc = desc;
		this.startDate = startDate;
		this.dueDate = dueDate;
		this.completionDate = completionDate;
		if (completionDate == null) {
			done = false;
		} else {
			done = true;
		}
		isGroupTask = true;
		this.importance = importance;
		this.difficulty = difficulty;
		this.empIds = empIds;
		tasks.add(this);
	}
	
	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
		DBcon.updateTaskVar("dueDate", dueDate, getProgramID());
	}

	public String getStartDate() {
		return startDate;
	}
  
	public void setStartDate(String date) {
		this.startDate = date;
		DBcon.updateTaskVar("startDate", date, getProgramID());
	}

	public String getCompletionDate() {
		return completionDate;
	}
	public boolean getStatus() {
		return done;
	}

	//Used to indicate when a task is completed.
	public void setStatus(boolean done) {
		this.done = done;
		if (done) {
			Date compDate = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");  
			setCompletionDate(formatter.format(compDate));
		}
	}
  
	public String getEmpID() {
		return empId;
	}
  
	public ArrayList<String> getEmpIDs() {
		return empIds;
	}
	
	public boolean getIsGroupTask() {
		return isGroupTask;
	}
	
	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
		DBcon.updateTaskVar("completionDate", completionDate, getProgramID());
	}

	public void setDesc(String desc) {
		this.desc = desc;
		DBcon.updateTaskVar("description", desc, getProgramID());
	}

	public void setImportance(int importance) {
		this.importance = importance;
		DBcon.updateTaskVar("importance", importance, getProgramID());
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
		DBcon.updateTaskVar("difficulty", difficulty, getProgramID());
	}

	public int getImportance() {
		return importance;
	}

	public String getDesc() {
		return desc;
	}

	public int getDifficulty() {
		return difficulty;
	}

    @Override
    public int compareTo(Task o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static ArrayList<Task> onlyTasksList(ArrayList<Program> calendar){
	ArrayList<Task> tasksList = new ArrayList<Task>();
            for (int i = 0; i < calendar.size(); i++) {
                if (calendar.get(i) instanceof Task) {
                    tasksList.add((Task) calendar.get(i));			 
		}             
	}
	return tasksList;
    }
    static Comparator<Task> taskCompByDueDate = new Comparator<Task>() {
        @Override
        public int compare(Task t1, Task t2) {
            return t1.getDueDate().compareTo(t2.getDueDate());
        }        
    };
    static Comparator<Task> taskCompByImp = new Comparator<Task>() {
    	@Override
    	public int compare(Task t1, Task t2) {
    		return t2.getImportance() - t1.getImportance();
    	}
    };
    static Comparator<Task> taskCompByDesc = new Comparator<Task>() {
    	@Override
    	public int compare(Task t1, Task t2) {
    		return t2.getDesc().compareTo(t1.getDesc());
    	}
    };
    
    public static ArrayList<Task> sortByDate(ArrayList<Task> taskList){
    	Collections.sort(taskList, taskCompByDueDate);
    	return taskList;
    }
    
    public static ArrayList<Task> sortByImp(ArrayList<Task> taskList){
    	Collections.sort(taskList, taskCompByImp);
    	return taskList;
    }
    public static ArrayList<Task> sortByDesc(ArrayList<Task> taskList){
    	Collections.sort(taskList, taskCompByDesc);
    	return taskList;
    }
	public String toStringEvaluatedTask() {
		return "Due Date=" + dueDate + ", Description=" + desc + ", Importance=" + importance + ", Difficulty="
				+ difficulty;
	}
	public String toStringSimpleTask() {
		return "Due Date=" + dueDate + ", Description=" + desc;
	}

}
