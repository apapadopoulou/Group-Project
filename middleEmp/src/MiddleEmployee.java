import java.util.ArrayList;
import java.util.Scanner;
public class MiddleManager extends Employee {
	private ArrayList <Department> managingDepartments = new ArrayList <Department>();
	public MiddleManager(String name, String surname, String telephone, String email, Department department int id) {
		super(name, surname, telephone, email, department, id);
		System.out.println("Insert manager's department.");
		Scanner sc = new Scanner(System.in);
		String nameOfDepartment = sc.nextLine();
		for (int i=0; i<departments.size(); i++) {
			if (department.get(i).getName().equals(nameOfDepartment)) {
				managingDepartments.add(departments.get(i));
			} else {
				System.out.println("The department you inserted doesn't exist.");
			}
		}
		/* do {
			System.out.println("Is there ")
		} */
	}
}
}
