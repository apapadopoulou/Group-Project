import java.util.ArrayList;

public class TopManager extends Employee{
  private ArrayList <MiddleManager> managingManagers = new ArrayList <MiddleManager>();
  public TopManager( String name, String surname, int telephone, String email, Department department){
    super(name, surname, telephone, email, department);
  }
@Override
public String getJobTitle() {
	// TODO Auto-generated method stub
	return null;
}
public ArrayList <MiddleManager> getManagingManagers() {
	return managingManagers;
}
public void setManagingManagers(ArrayList <MiddleManager> managingManagers) {
	this.managingManagers = managingManagers;
}
}
