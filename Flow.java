import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
 /* Class Flow manages the main flow of the application and
  * supports data entry and first connection to the database." */
public class Flow {
public static void dataEntry() {
		Scanner sc = new Scanner(System.in);
	    String dname;
	    String name;
	    String surname;
	    String email;
	    String phoneNumber;
	    String inputDate;
	    Department dep;
	    do {
	        System.out.println("Insert name of Department. In case you have inserted all the Departments, please type done.");
	        dname = sc.next();
	        if (dname != "done") {
	            dep = new Department(dname);
	            System.out.println("Department created with id: " + dep.getId());
	            System.out.println("It's time to insert the Employees of the department!");
	            System.out.println("When you are done, please type done.");
	            System.out.println("Name: ");
	            name = sc.next();
	            while(name != "done") {
	            	boolean run = true;
	            	while (run) {
	            	 System.out.println("Surname: ");
	            	 surname = sc.next();
	            	 System.out.println("Email: ");
	            	 email = sc.next();
	            	 System.out.println("Phonenumber: ");
	            	 phoneNumber = sc.next();
	            	 System.out.println("Date of Birth: ");
	            	 inputDate = sc.nextLine();
	            	 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	            	 LocalDate birthDate = LocalDate.parse(inputDate);
	            	 Employee emp = new BasicEmployee(name, surname, email, phoneNumber, birthDate, dep);
	            	}
	            }
	            
	        }
	    } while (dname != "done");
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
	public void dataInputScreen() {
		
	}
}
