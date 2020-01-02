import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/*This class creates Event and Task objects.*/
public abstract class Program {
    private Calendar c;
    protected Date date;
    public static ArrayList<Program> allPrograms = new ArrayList<Program>();
    public Program() {
     /*current_date = calendar.get(Calendar.DATE)+"/"
      * +calendar.get(Calendar.MONTH)
     * +"/"+calendar.get(Calendar.YEAR); na to tsekaroume an xreiazetai kapou*/
    }
    public void setDate(Date date) {
      this.date = date;
    }
    public Date getDate() {
      return date;
    }
}
