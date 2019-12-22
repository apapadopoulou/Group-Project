import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Scanner;
import java.util.ArrayList;

public class Task extends Program {
	
	private Date startDate;
	private Date dueDate;
	private Date completionDate;
	private String desc;
	private boolean done;
	private boolean isGroupTask;
	private int parts;
	private int importance; //Importance of a task should be between 1 and 10.
	private int difficulty; //Difficulty of a task should be between 1 and 10.
	private String empid; //Employee ID for single-employee Tasks.
	private ArrayList<String> empids; //Employee IDs ArrayList for Group Tasks. 
	public int counter=0; //Needed to create the Task IDs. 
	private int id;
	private double score;
	private double[] scores;
  
  /*
   *Constructor for single-employee task.
   */
	public Task(Date startDate, Date dueDate, String desc, int parts, int importance, int difficulty, String empid) {
		super();
		this.desc = desc;
		this.startDate = startDate;
		this.dueDate = dueDate;
		done = false;
		isGroupTask = false;
		this.parts = parts;
		this.importance = importance;
		this.difficulty = difficulty;
		this.empid = empid;
		this.id = counter++; //Needed for the DataBase. 
	}
  
  /*
   *Constructor for multi-employee group task. 
   */
	public Task(Date startDate, Date dueDate, String desc, int parts, int importance, int difficulty, ArrayList<String> empids) {
		super();
		this.desc = desc;
		this.startDate = startDate;
		this.dueDate = dueDate;
		done = false;
		isGroupTask = true;
		this.parts = parts;
		this.importance = importance;
		this.difficulty = difficulty;
		this.empids = empids;
		this.id = counter++; //Needed for the DataBase. 
    }
  
	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getStartDate() {
		return startDate;
	}
  
	public void setStartDate(Date date) {
		this.startDate = date;
	}

	public Date getCompletionDate() {
		return completionDate;
	}
	public boolean getStatus() {
		return done;
	}

	public void setStatus(boolean done) { //Used to indicate when a task is completed
		completionDate = new Date();
		this.done = done;
    
	}
  
	public String getEmpID() {
		return empid;
	}
  
	public ArrayList<String> getEmpIDs() {
		return empids;
	}

	public int getParts() {
		return parts;
	}

	public void setParts(int parts) {
		this.parts = parts;
	}

	public int getImportance() {
		return importance;
	}

	public void setImportance(int weight) {
		this.importance = importance;
	}
  
	public void setTaskScore(double score) {
		this.score = score;
	}
  
	public int getDifficulty() {
		return difficulty;
	}
	public void setTaskScore(double [] score) {
		this.scores = scores;
	}

	public boolean isGroupTask() {
		return isGroupTask;
	}
  
	public int getTaskID() {
		return id;  
	}
	
	/*Method newTask creates a new task, using the Task class constructor. An option is also offered, in case
  	you need to create a group task.*/
	/*public void newTask() { 
    Scanner sc = new Scanner(System.in);
    System.out.println("You are about to create a Task.");
    do {
    	try {
    		System.out.println("Please insert due date:/n Note: Due date should be inserted according to the format dd-mm-yyy!");
    		String inputDate = sc.nextLine();
    	}catch(InputMismatchException e) {
    		System.out.println("Please insert due date correctly!/n Note: Due date should be inserted according to the format dd-mm-yyy!")
    	}
    }while(inputDate !instanceof String );
    	input.nextLine();
    	
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate dueDate = LocalDate.parse(inputDate);
    do{
    	try {
   
    		System.out.println("Please insert level of importance for this task:");
    		int weight = sc.nextInt();
    }catch (InputMismatchException e) {
    	System.out.println("Please insert level of importance for this task again")
    }
    }while(weight !instanceof Integer);
  } */
  
  /*This method lets the user choose in how many parts the task should be devided.*/
 /* public void taskSegmentation() {
    System.out.println("In how many parts should the task be devided?");
        Scanner sc = new Scanner(System.in);
        try {
            parts = sc.nextInt();
            this.parts = parts;
            Date[] partdates = new Date[parts];
            for (int i = 0; i < parts; i++) {
                System.out.println("which is the date until which the part : " + i + 1 + " needs to be completed? Please insert the date according to the formt dd-mm-yyy.");
                String dt = sc.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate dueDate = LocalDate.parse(dt);
                partdates[i] = dt;
            }
        } catch(InputMismatchException e1) {}
  }*/
}
