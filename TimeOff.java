import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.ParseException;
 public class TimeOff {
	 private String oldDate;
	 
	
	 public TimeOff(String oldDate, int days) {
	 //Given Date in String format
		 	this.oldDate = oldDate;
		 	System.out.println("Starting day is: "+oldDate);
			//Specifying date format that matches the given date
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
