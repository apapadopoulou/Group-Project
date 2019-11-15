import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
public class Task extends Program{
	private Date dueDate;
	private boolean done;
	private int significance_level;  /*[1-10]*/ 
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
	public void newTask() {
	} 

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
	
	
public int parts() {
	System.out.println("In how many parts do you want to divide your work with");
	Scanner sc = new Scanner(System.in);
	parts=sc.hasNextInt();
	return parts;
}


}