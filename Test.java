import java.util.Scanner;
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
    /* the user is going to insert all the existig departments */
    Scanner sc = new Scanner(System.in);
    String dname;
    do {
        System.out.println("Insert name of Department. In case you have inserted all the Departments, please press enter.");
        dname = sc.nextLine();
        if (dname != " ") {
            Department dep = new Department(dname);
        }
    } while (dname != " ");
    /* the user is going to insert all the basic employees of his business*/
    System.out.println("It's time to insert datas about basic employees");
    String bname;
    String bsurname;
    String bemail;
    String btelephone;
    Int bdepid;
    Department bdep;
    do {
    System.out.println("Insert name of basic employee. In case you have inserted all the basic employees, please press enter");
    bname = sc.nextLine();
    if (bname != " ") {
        System.out.println("Now insert surname, telephone, email and name of his department in that order");
        bsurname = sc.nextLine();
        btelephone = sc.nextLine();
        bemail = sc.nextLine();
        bdepid = sc.nextInt();
        bdep = Department.searchDepartmentById(bdepid);
        BasicEmployee basemp = new BasicEmployee(bname, bsurname, btelephone, bemail, bdep);
    }
    } while (bname != " ");
    }
    }
