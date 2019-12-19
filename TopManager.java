import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class TopManager extends Employee{
  private ArrayList <MiddleManager> managingManagers = new ArrayList <MiddleManager>();
  public static ArrayList <TopManager> topManagers = new ArrayList <TopManager>();
  public TopManager( String name, String surname, String phonenumber, String email, Date birthdate){
    super(name, surname, phonenumber, email, birthdate);
    /*the id is constructed using the first two letters of the manager's name, the first two letters of the managers's surname
     * and the number of top managers that already exist */
    id = name.substring(1,2) + surname.substring(1,2) + String.valueOf(topManagers.size());
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