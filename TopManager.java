import java.util.ArrayList;

public class TopManager extends Employee{
	/**
	 * This class is rensponsible for creating Top Manager Objects.
	 * 
	 */

	//private ArrayList <MiddleManager> managingManagers = new ArrayList <MiddleManager>();
	public static ArrayList <TopManager> topManagers = new ArrayList <TopManager>();
	
	/**
	 * Basic constructor for Top Managers.
	 * Used to create new Top Manager objects.
	 *
	 */
	public TopManager( String name, String surname, String phonenumber, String email, String birthdate, double salary){
		super(name, surname, phonenumber, email, birthdate, null, salary);
		/*the id is constructed using the first two letters of the manager's name, the first two letters of the managers's surname
		 * and the number of top managers that already exist */
		String id = name.substring(0,1) + surname.substring(0,2) + String.valueOf(topManagers.size());
		setID(id);
		topManagers.add(this);
		employees.add(this);
		DBcon.saveTopManager(this);
		Account acc = new Account(this);
	}
	
	/**
	 * Database constructor for Top Managers.
	 * Used to create Top Manager objects after they are loaded from the Database.
	 */
	public TopManager( String name, String surname, String phonenumber, String email, String birthdate, String id, double salary){
		super(name, surname, phonenumber, email, birthdate, id, salary);
		topManagers.add(this);
		employees.add(this);
	}
	 public static TopManager searchTopManager(String name) {
	    	for (int i = 0; i < topManagers.size(); i++) {
		      if (topManagers.get(i).getNameSurname().equals(name)) {
		        return topManagers.get(i);
		      } else if (topManagers.get(i).getSurname().equals(name)) {
		        return topManagers.get(i);
		      }
			}
	    	return null;
	    }

}