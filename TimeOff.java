import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.ParseException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
/**Class TimeOff
 *  Class that handles timeOffs for employes
 * 
 * by Panos, Sarantos , Vasilis
 */
 public class TimeOff {
	 private String oldDate;
	 static String absolutePath = "C:\\Users\\Bill\\Desktop\\ΔΕΤ\\Java Προγραμματισμός 2\\Ομαδική εργασια HR\\src\\TimeOff.txt";
	 
	 public TimeOff(String oldDate, int days) {
	 //Given Date in String format
		 	this.oldDate = oldDate;
		 	System.out.println("Starting day is: "+oldDate);
			//Specifying date format that matches the given date
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Calendar c = Calendar.getInstance();
			try{
			   //Setting the date to the given date
			   c.setTime(sdf.parse(oldDate));
			}catch(ParseException e){
				e.printStackTrace();
			 }
			   
			//Number of Days to add
			c.add(Calendar.DAY_OF_MONTH, days);  
			//Date after adding the days to the given date
			String newDate = sdf.format(c.getTime());  
			//Displaying the new Date after addition of Days
			System.out.println("Ending day is: "+newDate);
	 }
	 
	 //Checks if employee can have the specific day off//
	 public static boolean check(Employee emp, String date) {
		 
		 return true;
	 } 
	 
	 //Adds a day off (one day ONLY)//
	 public static void addTimeOff(Employee emp, String date) {
		 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Calendar c = Calendar.getInstance();
			try{
			   //Setting the date to the given date
			   c.setTime(sdf.parse(date));
			}catch(ParseException e){
				e.printStackTrace();
			 }
	 }
	 
	 //Adds time off (ANY number of days)//
	 public static void addTimeOff(Employee emp, String date, int days) {
		 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Calendar c = Calendar.getInstance();
			try{
			   //Setting the date to the given date
			   c.setTime(sdf.parse(date));
			}catch(ParseException e){
				e.printStackTrace();
			 }
			   
			//Number of Days to add
			c.add(Calendar.DAY_OF_MONTH, days);  
			//Date after adding the days to the given date
			String newDate = sdf.format(c.getTime());
	 }
	 //Returns String status of employees timeOffs and remaining timeOffs//
	 public static String status(Employee emp) {
		 try(FileWriter writer = new FileWriter(absolutePath)) {
		     String fileContent = "This is a sample text.";
		     writer.write(fileContent);
		     writer.write(fileContent);
		     writer.write("\n123213123421");
		     writer.write("\n312412dsafe");
		 } catch (IOException e) {
			 System.out.println("laio2");
		     // exception handling
		 }

		 // read the content from file
		 try(FileReader reader = new FileReader(absolutePath)) {
		     int ch = reader.read();
		     while(ch != -1) {
		         System.out.print((char)ch);
		         ch = reader.read();
		     }
		 } catch (FileNotFoundException b) {
			 System.err.print("File not Found: "+ b);
		     // exception handling
		 } catch (IOException c) {
			 System.err.print("IO excpetion: "+ c);
		     // exception handling
		 }
		 return "υευ";
	 }		
	 //Removes a day Off(one day ONLY)//
	 public static void removeTimeOff(Employee emp, String date) {}
	 //Removes a TimeOff(ANY number of days)//
	 public static void removeTimeOff(Employee emp, String date, int days) {}
	 // write the content in file 
 }
 

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 /* 2nd way 
  	import java.time.LocalDate;
   	public class TimeOff {
   	public TimeOff(int days){
   	//Adding one Day to the current date
       LocalDate newDate =  LocalDate.now().plusDays(days);
       System.out.println("The end date is: "+newDate);
   	}
  }
  */
 	/* previous class
	  private Date enddate;
    private Date startdate;
    private Date timeperiod;

    public TimeOff(Date enddate, Date startdate, Date timeperiod, int days) {
        this.enddate = enddate;
        this.startdate = startdate;
        this.timeperiod = timeperiod;
        boolean timeoff;
        int differencedays = (int) ( (startdate.getTime() - enddate.getTime())
                 / (1000 * 60 * 60 * 24) ); //Days
        if (differencedays > days) {
		   timeoff = false;
        } else {
		   timeoff = true;
	}


    }
   
 }
 */
