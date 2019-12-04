/*This class creates Event and Task objects.*/
public abstract class Program {
	Calendar calendar = new Calendar.getInstance();
	private String date;
	/*current_date = calendar.get(Calendar.DATE)+"/"+calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.YEAR); na to tsekaroume an xreiazetai kapou*/
	public void setDate(String date) {
		this.date=date;
	}
	public String getDate() {
		return date;
	}
}
