import java.util.ArrayList;
public class Test {
	public static void main(String args []) {
		ArrayList <Employee> list = new ArrayList <Employee>();
		Department dep1 = new Department("de[ne",list);
		Employee emp1 = new HR_consultant("yeyey","perkas","bigoz",dep1);
		System.out.println(emp1.getId());
		System.out.println(emp1.getJobTitle());
		HR_consultant emp2 = new HR_consultant("vasilis","xifaras","342bigozdqqwqdq",dep1);
		System.out.println(emp2.getId());
		System.out.println(emp2.getJobTitle());
		System.out.println(emp1.toString());
		System.out.println(emp2.toString());
		
	}
}
