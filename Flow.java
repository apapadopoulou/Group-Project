import java.util.ArrayList;
import java.util.Scanner;

public class Flow {
public static void dataEntry() {
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
	    /* the user is going to insert all the middle managers*/
	    String mname;
	    String msurname;
	    String mtelephone;
	    String memail;
	    Int did;
	    ArrayList <Department> managingdeps = new ArrayList <Department>();
	    do {
	        System.out.println("Insert name of middle manager. In case you have inserted all the middle managers, please press enter");
	        mname = sc.nextLine();
	        if (mname != " ") {
	            do {
	                System.out.println("Now insert id of departments he manages. When there is no other department to insert, please press -1");
	                did = sc.nextInt();
	                if (did != -1) {
	                    for (Department d : Department.departments) {
	                        if (did = Department.departments.getId()) {
	                            managingdeps.add(d);
	                        }
	                    }
	                    System.out.println("Now insert surname, telephone and email for this middle manager in that order");
	                    msurname = sc.nextLine();
	                    mtelephone = sc.nextLine();
	                    memail = sc.nextLine();
	                    MiddleManager mm = new MiddleManager(mname, msurname, mtelephone, memail, managingdeps);
	                }
	            } while (did != 0);
	        }
	    } while (mname != " ");
	    /* the user is going to insert all the top managers */
	    String tname;
	    String tsurname;
	    String ttelephone;
	    String temail;
	    String depname;
	    Department dep;
	        do {
	            System.out.println("Insert name of top manager. In case you have inserted all the top managers, please press enter");
	            tname = sc.nextLine();
	            if (tname != " ") {
	                System.out.println("Now insert surname, telephone, email and department's name for this top manager in that order");
	                tsurname = sc.nextLine();
	                ttelephone = sc.nextLine();
	                temail = sc.nextLine();
	                depname = sc.nextLine();
	                for (Department d : Department.departments) {
	                    if (depname.equals(d.getName())) {
	                        dep = d;
	                    }
	                }
	                TopManager tm = new TopManager(tname, tsurname, ttelephone, temail, dep);
	            }
	        } while (tname != " ");
	}
}
