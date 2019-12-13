import java.util.Calendar;
import java.util.ArrayList;
import java.sql.*;

public class Evaluation {
	public static double evaluate(BasicEmployee emp, Task task) { // WIP!!!!!!
		
		return 0.0;
	}
	
	public static double evaluate(ArrayList<Employee> group, GroupTask task) { // WIP!!!!!!!!
		
		return 0.0;
	}
	
	public static ArrayList<Double> getEvalHistory(String empid) {
		ArrayList<Double> evalHistory = new ArrayList<Double>();
		/*URL of database with username and password.*/
		String url ="jdbc:sqlserver://sqlserver.dmst.aueb.gr:1433;" + 
				"databaseName=DB56;user=G556;password=939wd5890;";
		/*Connection type object to make the connection.*/
		Connection dbcon;
		/*Statement type object that contains the statement we will send to the server.*/
		Statement stmt;
		/*Try block for trying to find the correct Driver to make the DB connection.*/
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		/*Catch block if an exception occurs and the specified driver is not found.*/
		} catch (java.lang.ClassNotFoundException e) {
			System.out.print("test: ");
			System.out.println(e.getMessage());
		}
		/*Try block for making the DB connection and executing the given statement.*/
		try {
			ResultSet rs;
			/*Makes the actual connection with the server.*/
			dbcon = DriverManager.getConnection(url);
			/*Creates the statement*/
			stmt = dbcon.createStatement();
			/*Executes the given query that returns the History of Evaluations for the particular BasicEmployee using his ID.*/
			rs = stmt.executeQuery("SELECT evaluation FROM JEvaluations WHERE empID=" + empid );
			/*Does a loop for every row it finds.*/
			while (rs.next()) {
				double evaluation = rs.getDouble("evaluation");//Returns the evalutaion value from this row.
				evalHistory.add(evaluation);// Adds the evaluation value to the ArrayList.
				System.out.println("check if its correct!!");//Used for testing.
			}
			rs.close(); //Closes the ResultSet resource.
			stmt.close(); //Closes the Statement resource.
			dbcon.close(); //Closes the DataBase conenction resource.
		/*Catch block if an exception occurs while making the connection and executing the statement.*/
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
		return evalHistory; // Returns the ArrayList.
	}
}


