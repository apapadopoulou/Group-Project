import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


/**
 * This class creates Event and Task objects
 * @author BusyB
 *
 */
public abstract class Program {
	Calendar c;
	private int programID;
	public static int  counter = 1;
	private String date;
	public static ArrayList<Program> allPrograms = new ArrayList<Program>();
	/**
	 * Constructor with empId as a parameter
	 * @param empId
	 */
	public Program(String empId) {
		programID = counter++;
		allPrograms.add(this);
	}
	
	/**
	 * Constructor with empIds arraylist as a parameter
	 * @param empIds
	 */
	public Program(ArrayList<String> empIds) {
		programID = counter++;
		allPrograms.add(this);
	}
	
	/**
	 * Constructor with empId and id as parameters
	 * @param empId
	 * @param id
	 */
	public Program(String empId, int id) {
		this.programID = id;
		counter = programID + 1;
		allPrograms.add(this);
	}
	
	/**
	 * Constructor with arraylist empIds and id as parameters
	 * @param empIds
	 * @param id
	 */
	public Program(ArrayList<String> empIds, int id) {
		this.programID = id;
		counter = programID + 1;
		allPrograms.add(this);
	}
	
	/*current_date = calendar.get(Calendar.DATE)+"/"+calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.YEAR); na to tsekaroume an xreiazetai kapou*/
	/**
	 * Method that sets a date
	 * @param date
	 */
	public void setDate(String date) {
		this.date=date;
	}
	/**
	 * Method that gets a date
	 * @return date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Method that gets a programID
	 * @return programID
	 */
	public int getProgramID() {
		return programID;
	}
}
