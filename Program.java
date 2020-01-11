import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/*This class creates Event and Task objects.*/
public abstract class Program {
	Calendar c;
	private int programID;
	public static int  counter = 1;
	private String date;
	public static ArrayList<Program> allPrograms = new ArrayList<Program>();
	
	public Program(String empId) {
		programID = counter++;
		allPrograms.add(this);
	}
	
	public Program(ArrayList<String> empIds) {
		programID = counter++;
		allPrograms.add(this);
	}
	
	public Program(String empId, int id) {
		this.programID = id;
		counter = programID + 1;
		allPrograms.add(this);
	}
	
	public Program(ArrayList<String> empIds, int id) {
		this.programID = id;
		counter = programID + 1;
		allPrograms.add(this);
	}
	
	/*current_date = calendar.get(Calendar.DATE)+"/"+calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.YEAR); na to tsekaroume an xreiazetai kapou*/
	public void setDate(String date) {
		this.date=date;
	}
	public String getDate() {
		return date;
	}

	public int getProgramID() {
		return programID;
	}
}
