import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/*This class creates Event and Task objects.*/
public abstract class Program {
	Calendar c;
	private String date;
	public static ArrayList<Program> allPrograms = new ArrayList<Program>();
	public Program() {}
	/*current_date = calendar.get(Calendar.DATE)+"/"+calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.YEAR); na to tsekaroume an xreiazetai kapou*/
	public void setDate(String date) {
		this.date=date;
	}
	public String getDate() {
		return date;
	}
}