import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Task extends Program implements Comparable<Task> {
	private Date dueDate;
	private boolean done;
	private int parts;
	private int levelOfImportance;  /*The level of importance should be between 1 to 10*/ 
	
	public Task(Date dueDate, int parts, int levelOfImportance) {
		super();
		this.dueDate = dueDate;
		done = false;
		this.parts = parts;
		this.levelOfImportance = levelOfImportance;
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

	public void setStatus(boolean done) {
		this.done = done;
	}

	public int getParts() {
		return parts;
	}

	public void setParts(int parts) {
		this.parts = parts;
	}

	public int getLevelOfImportance() {
		return levelOfImportance;
	}

	public void setLevelOfImportance(int levelOfImportance) {
		this.levelOfImportance = levelOfImportance;
	}

	/*Method newTask creates a new task, using the Task class constructor. An option is also offered, in case
	you need to create a group task.*/
	public void newTask() { 
		Scanner sc = new Scanner(System.in);
		System.out.println("You are about to create a Task.");
		System.out.println("Please insert due date:/n Note: Due date should be inserted according to the format dd-mm-yyy!");
		String inputDate = sc.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate dueDate = LocalDate.parse(inputDate);
		System.out.println("Please insert level of importance for this task:");
		int levelOfImportance = sc.nextInt();
	} 
	/*Method calculating the difference between two dates*/
	public int difference(firstDate, secondDate) {
		System.out.print("Insert first date: ");
		Scanner s = new Scanner(System.in);
	    String[] insert1 = new String[3];
	    while (s.hasNext()) {
	    	int i = 0;
	        insert1[i] = s.next();
	        if (!s.hasNext()) {
	        	s.close();
	        	break;
            }
            i++;
	    }
	    System.out.print("Insert second date: ");
	    Scanner t = new Scanner(System.in);
	    String[] insert2 = new String[3];

	    while (t.hasNext()) {
	    	int i = 0;
	    	insert2[i] = t.next();
	    	if (!t.hasNext()) {
	    		t.close();
	    		break;
	    	}
	    	i++;
	    }
        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(insert1[0]));
        cal.set(Calendar.MONTH, Integer.parseInt(insert1[1]));
        cal.set(Calendar.YEAR, Integer.parseInt(insert1[2]));
        Date firstDate = cal.getTime();

        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(insert2[0]));
        cal.set(Calendar.MONTH, Integer.parseInt(insert2[1]));
        cal.set(Calendar.YEAR, Integer.parseInt(insert2[2]));
        Date secondDate = cal.getTime();


        long diff = secondDate.getTime() - firstDate.getTime();


        System.out.println ("Days: " + diff / 1000 / 60 / 60 / 24);
	}
  
	/*This method lets the user choose in how many parts the task should be devided.*/
	public void taskSegmentation() {
		System.out.println("In how many parts should the task be devided?");
        Scanner sc = new Scanner(System.in);
        parts = sc.hasNextInt();
        this.parts = parts;
        Date[] partdates = new Date[parts];
        for (int i = 0; i < parts; i++) {
        	System.out.println("which is the date until which the part : "+i+1+" needs to be completed? Please insert the date according according to the formt dd-mm-yyy.");
            String dt = sc.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate dueDate = LocalDate.parse(dt);
            partdates[i] = dt;
        }
	}
	
	@Override
	public int compareTo(Task task) {
		return this.getLevelOfImportance().compareTo(task.getLevelOfImportance());
	}
	
	/*Method sorting tasks from most important to least important*/
	public static ArrayList<Task> sort_Tasks_By_LevelOfImportance (ArrayList<Task> task){
		Collections.sort(task);
		return task;
	}
	
	@Override
	public Date compareTo(Task task) {
		return this.getDueDate().compareTo(task.getDueDate());
	}
	
	/*Method sorting tasks by DueDate*/
	public static ArrayList<Task> sort_Tasks_By_Due_Date(ArrayList<Task> task){
	    Collections.sort(task);
	    return task;
	}
}