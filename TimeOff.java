import java.util.Date;
 public class TimeOff {
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
