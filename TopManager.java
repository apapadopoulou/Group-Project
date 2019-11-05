public class TopManager extends Employee{
	private ArrayList <MiddleManager> managingManagers = new ArrayList <MiddleManager>();
	public Top_Manager( String name, String surname, String password, String telephone, String email, Department department){
		super(name, surname, password, telephone, email, department);
	}
}