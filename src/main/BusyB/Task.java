package gr.aueb.dmst.ProgrammingII.BusyB.BusyB;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 *
 * @author BusyB
 *
 */
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
   * Constructor for single-employee task.
   * @param startDate
   * @param dueDate
   * @param desc
   * @param importance
   * @param difficulty
   * @param empId
   */
	public Task(String startDate, String dueDate, String desc, int importance, int difficulty, String empId) {
		super(empId);
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
		Employee.searchEmployeeById(empId).updateDailyProgram(this);
	}
	
	/**
	 * Database Constructor for single employee Tasks.
	 * Used to load Task objects from Database.
	 * @param taskID
	 * @param startDate
	 * @param dueDate
	 * @param completionDate
	 * @param desc
	 * @param importance
	 * @param difficulty
	 * @param empId
	 * @param score
	 */
	public Task(int taskID, String startDate, String dueDate, String completionDate, String desc, int importance, int difficulty, String empId, double score) {
		super(empId, taskID);
		this.desc = desc;
		this.startDate = startDate;
		this.dueDate = dueDate;
		this.completionDate = completionDate;
		done = false;
		isGroupTask = false;
		this.importance = importance;
		this.difficulty = difficulty;
		this.empId = empId;
		tasks.add(this);
	}
  
    /**
     * Basic Constructor for multi-employee group task.
     * @param startDate
     * @param dueDate
     * @param desc
     * @param importance
     * @param difficulty
     * @param empIds
     */
	public Task(String startDate, String dueDate, String desc, int importance, int difficulty, ArrayList<String> empIds) {
		super(empIds);
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
			Employee.searchEmployeeById(empIds.get(i)).updateDailyProgram(this);
		}
	}
	
	/**
	 * Database constructor for group Tasks.
	 * Used to load multi-employee Tasks from the Database.
	 * @param taskID
	 * @param startDate
	 * @param dueDate
	 * @param completionDate
	 * @param desc
	 * @param importance
	 * @param difficulty
	 * @param empIds
	 * @param scores
	 */
	public Task(int taskID, String startDate, String dueDate, String completionDate, String desc, int importance, int difficulty, ArrayList<String> empIds, double [] scores) {
		super(empIds, taskID);
		this.scores = scores;
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
	
	/**
	 * Returns the dueDate field
	 * @return dueDate
	 */
	public String getDueDate() {
		return dueDate;
	}

	/**
	 * Sets the dueDate field
	 * @param dueDate
	 */
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
		DBcon.updateTaskVar("dueDate", dueDate, getProgramID());
	}
	/**
	 * Returns the done field
	 * @return done
	 */
    
	/**
	 * Returns the startDate field
	 * @return startDate
	 */
	public String getStartDate() {
		return startDate;
	}
  
	/**
	 * Sets a startDate and updates the Task
	 * @param date
	 */
	public void setStartDate(String date) {
		this.startDate = date;
		DBcon.updateTaskVar("startDate", date, getProgramID());
	}

	/**
	 * Returns the completionDate field
	 * @return completionDate
	 */
	public String getCompletionDate() {
		return completionDate;
	}
	/**
	 * Returns the tsk's status by its done field
	 * @return done
	 */
	public boolean getStatus() {
		return done;
	}

	/**
	 * Used to indicate when a task is completed.
	 * @param done
	 */
	public void setStatus(boolean done) {
		this.done = done;
		if (done) {
			Date compDate = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");  
			setCompletionDate(formatter.format(compDate));
			Evaluation.evaluate(this);
		}
	}
  
	/**
	 * Returns the empId field
	 * @return empId
	 */
	public String getEmpID() {
		return empId;
	}
  
	/**
	 * Returns the empIds field
	 * @return empIds
	 */
	public ArrayList<String> getEmpIDs() {
		return empIds;
	}
	
	/**
	 * Method that checks and returns if a task is a groupTask
	 * @return isGroupTask
	 */
	public boolean getIsGroupTask() {
		return isGroupTask;
	}
	
	/**
	 * Sets the coompletionDate field and updates the task
	 * @param completionDate
	 */
	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
		DBcon.updateTaskVar("completionDate", completionDate, getProgramID());
	}

	/**
	 * Sets the desc field and updates the task
	 * @param desc
	 */
	public void setDesc(String desc) {
		this.desc = desc;
		DBcon.updateTaskVar("description", desc, getProgramID());
	}

	/**
	 * Sets the importance field and updates the task
	 * @param importance
	 */
	public void setImportance(int importance) {
		this.importance = importance;
		DBcon.updateTaskVar("importance", importance, getProgramID());
	}

	/**
	 * Sets the difficulty field and updates the task
	 * @param difficulty
	 */
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
		DBcon.updateTaskVar("difficulty", difficulty, getProgramID());
	}

	/**
	 * Returns the importance field
	 * @return importance
	 */
	public int getImportance() {
		return importance;
	}

	/**
	 * Returns the desc field
	 * @return desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * Returns the difficulty field
	 * @return difficulty
	 */
	public int getDifficulty() {
		return difficulty;
	}

	/**
	 * Sets the score field
	 * @param score
	 */
	public void setScore(double score) {
		this.score = score;
	}
	
	/**
	 * Returns the score field
	 * @return score 
	 */
	public double getScore() {
		return score;
	}
	
	/**
	 * Sets the scores field
	 * @param scores
	 */
	public void setScores(double [] scores) {
		this.scores = scores;
	}
	
	/**
	 * Returns the scores field
	 * @return scores
	 */
	public double [] getScores() {
		return scores;
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
		return "Due Date: " + dueDate + ", Description: " + desc;
	}
	public String toStringSimpleTask() {
		return "Due Date=" + dueDate + ", Description=" + desc;
	}
        
        public static Task searchTask (String task, ArrayList<Task> tasks){
            for (Task task1 : tasks) {
                if (task1.getImportance() == 0 && task1.getDifficulty() == 0) {
                    if (task1.toStringSimpleTask().equals(task)) {
                        return task1;
                    }
                } else {
                    if (task1.toStringEvaluatedTask().equals(task)) {
                        return task1;
                    }
                }
            }
            return null;
        }

}
/**
 * End of Task class
*/