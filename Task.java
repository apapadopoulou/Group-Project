import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Task extends Program {

	
	private String startDate;
	private String dueDate;
	private String completionDate;
	private String desc;
	private boolean done;
	private boolean isGroupTask;
	private int parts;
	private int importance; //Importance of a task should be between 1 and 10.
	private int difficulty; //Difficulty of a task should be between 1 and 10.
	private String empId; //Employee ID for single-employee Tasks.
	private ArrayList<String> empIds; //Employee IDs ArrayList for Group Tasks. 
	public static int counter = 1; //Needed to create the Task IDs. 
	private int id;
	private double score;
	private double[] scores;
  
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
		this.parts = parts;
		this.importance = importance;
		this.difficulty = difficulty;
		this.empId = empId;
		this.id = counter++; //Needed for the DataBase. 
		DBcon.saveTask(this);
		DBcon.AssignToTask(id, empId);
	}
	
	/**
	 * Database Constructor for single employee Tasks.
	 * Used to load Task objects from Database.
	 */
	public Task(int taskID, String startDate, String dueDate, String completionDate, String desc, int importance, int difficulty, String empId) {
		super();
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
		this.parts = parts;
		this.importance = importance;
		this.difficulty = difficulty;
		this.empId = empId;
		this.id = taskID; //Needed for the DataBase.
		counter = id + 1;
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
		this.id = counter++; //Needed for the DataBase.
		DBcon.saveTask(this);
		for (int i = 0; i < empIds.size(); i++) {
			DBcon.AssignToTask(id, empIds.get(i));
		}
	}
	
	/**
	 * Database constructor for group Tasks.
	 * Used to load multi-employee Tasks from the Database.
	 */
	public Task(int taskID, String startDate, String dueDate, String completionDate, String desc, int importance, int difficulty, ArrayList<String> empIds) {
		super();
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
		this.parts = parts;
		this.importance = importance;
		this.difficulty = difficulty;
		this.empIds = empIds;
		this.id = taskID; //Needed for the DataBase.
		counter = id + 1;
	}
	
	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getStartDate() {
		return startDate;
	}
  
	public void setStartDate(String date) {
		this.startDate = date;
	}

	public String getCompletionDate() {
		return completionDate;
	}
	public boolean getStatus() {
		return done;
	}

	//Used to indicate when a task is completed.
	public void setStatus(boolean done) {
		Date compDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");  
		completionDate = formatter.format(compDate);
		this.done = done;
    
	}
  
	public String getEmpID() {
		return empId;
	}
  
	public ArrayList<String> getEmpIDs() {
		return empIds;
	}
	/*Method newTask creates a new task, using the Task class constructor.
	 * An option is also offered, in case you need to create a group task.*/
	/*public void newTask() {
    Scanner sc = new Scanner(System.in);
    System.out.println("You are about to create a Task.");
    do {
    	try {
    		System.out.println("Please insert due date:/n Note:"
    	+ "Due date should be inserted according to the format dd-mm-yyy!");
    		String inputDate = sc.nextLine();
    	}catch(InputMismatchException e) {
    		System.out.println("Please insert due date correctly!/n Note:"
    	+ "Due date should be inserted according to the format dd-mm-yyy!")
    	}
    }while(inputDate !instanceof String );
    	input.nextLine();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate dueDate = LocalDate.parse(inputDate);
    do{
    	try {
    		System.out.println("Please insert level of"
    		+ "importance for this task:");
    		int weight = sc.nextInt();
    }catch (InputMismatchException e) {
    	System.out.println("Please insert level of importance for"
    	+ "this task again")
    }
    }while(weight !instanceof Integer);
  } */
  /*This method lets the user choose in how many parts the task
   * should be devided.*/
 /* public void taskSegmentation() {
    System.out.println("In how many parts should the task be devided?");
        Scanner sc = new Scanner(System.in);
        try {
            parts = sc.nextInt();
            this.parts = parts;
            Date[] partdates = new Date[parts];
            for (int i = 0; i < parts; i++) {
                System.out.println("which is the date until which the part :
                + " " + i + 1 + " needs to be completed? Please insert the date"
                + "according to the formt dd-mm-yyy.");
                String dt = sc.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate dueDate = LocalDate.parse(dt);
                partdates[i] = dt;
            }
        } catch(InputMismatchException e1) {}
  }*/

	public int getTaskID() {
		return id;
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
}
