import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class TopManager extends Employee{
  private ArrayList <MiddleManager> managingManagers = new ArrayList <MiddleManager>();
  private ArrayList <String> namesOfManagingManagers = new ArrayList <String>();
  public static ArrayList <TopManager> topManagers = new ArrayList <TopManager>();
  public TopManager( String name, String surname, int telephone, String email,Date birthdate, String id){
    super(name, surname, telephone, email, birthdate);
    /*the id is constructed using the first two letters of the manager's name, the first two letters of the managers's surname
     * and the number of top managers that already exist */
    id = name.substring(1,2) + surname.substring(1,2) + String.valueOf(topManagers.size());
    for(int i = 1; i < MiddleManager.middleManagers.size(); i++) {
    	MiddleManager.searchMiddleManagerById(String.valueOf(i)).toString();
    }
    //Constructs the list with the managing managers
    System.out.println("Type the ids of the managers you are responsible for");
    System.out.println("Press enter after each id entry");
    System.out.println("Press 0 and Enter if you're done");
    Scanner input = new Scanner(System.in);
    int md_id = input.nextInt();
    while (md_id != 0) {
    	if (md_id > MiddleManager.middleManagers.size() || md_id < 0 ) {
    		System.out.println("Wrong input. Please enter another id");
    		md_id = input.nextInt();
    		continue;
      	}
    	managingManagers.add(MiddleManager.searchMiddleManagerById(String.valueOf(md_id)));
    	namesOfManagingManagers.add(MiddleManager.searchMiddleManagerById(String.valueOf(md_id)).getName());
    }
    input.close();
    System.out.println("The managing managers have been saved");
    topManagers.add(this);
    employees.add(this);
}

public ArrayList <MiddleManager> getManagingManagers() {
	return managingManagers;
}
public void setManagingManagers(ArrayList <MiddleManager> managingManagers) {
	this.managingManagers = managingManagers;
}
}