import java.util.ArrayList;

public class TopManager extends Employee{
<<<<<<< HEAD
	//private ArrayList <MiddleManager> managingManagers = new ArrayList <MiddleManager>();
	public static ArrayList <TopManager> topManagers = new ArrayList <TopManager>();
  
	public TopManager( String name, String surname, String phonenumber, String email, String birthdate){
		super(name, surname, phonenumber, email, birthdate, null, 0);
		/*the id is constructed using the first two letters of the manager's name, the first two letters of the managers's surname
		 * and the number of top managers that already exist */
		String id = name.substring(1,2) + surname.substring(1,2) + String.valueOf(topManagers.size());
		setID(id);
		topManagers.add(this);
		employees.add(this);
	}
	
	public TopManager( String name, String surname, String phonenumber, String email, String birthdate, String id, double salary){
		super(name, surname, phonenumber, email, birthdate, id, salary);
		topManagers.add(this);
		employees.add(this);
	}
=======
  //private ArrayList <MiddleManager> managingManagers = new ArrayList <MiddleManager>();
  public static ArrayList <TopManager> topManagers = new ArrayList <TopManager>();
  public TopManager( String name, String surname, String phonenumber, String email, Date birthdate){
    super(name, surname, phonenumber, email, birthdate, id);
    /*the id is constructed using the first two letters of the manager's name, the first two letters of the managers's surname
     * and the number of top managers that already exist */
    id = name.substring(1,2) + surname.substring(1,2) + String.valueOf(topManagers.size());
    this.setID(id);
    topManagers.add(this);
    employees.add(this);
}
>>>>>>> d238654e364f3a5c7d14a6648e51a24bba1d4a6c
}