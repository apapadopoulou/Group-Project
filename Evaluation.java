import java.util.Date; //Used to get the Time.
import java.util.ArrayList;
import java.sql.*;

public class Evaluation {
	
	/*
	 * Basic method which is called to evaluate a Task.
	 * Checks if the task is for single-employee or a group task and calls the corresponding
	 * moethod for evaluating the task.
	 */
	public static double evaluate(Task task) {
		double score = 0.0;
		if (!task.isGroupTask()) { //Checks if a task is group task or not.
			score = evalSingleTask(task); //Calls method for evaluating single-employee Tasks.
		} else {
			score = evalGroupTask(task); //Calls method for evaluating group Tasks.
		}
		return score;
	}
	
	public static double evalSingleTask(Task task) {
		
	}
	
	public static double evalGroupTask(Task task) {
		
	}
	/*
	 *Method responsible for retrieving past evaluations of employee's performance on his tasks.
	 *Returns an ArrayLIst of type Double which contains all of an employee's previous evaluations. 
	 */
	public static ArrayList<Double> getEvalHistory(String id) {
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
			rs = stmt.executeQuery("SELECT evaluation FROM JEvaluations WHERE empID=" + id );
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
	
	/*
	 * Method to calculate the difference between completion date and due date in percentage.
	 * Returns the percentage difference between total time to complete the task and remaining time to Due Date.
	 */
	public static double calculateDateDiff(Date startDate, Date dueDate, Date completionDate) {
		long startDiff = dueDate.getTime() - startDate.getTime(); //Calculates the difference between DueDate and startDate in milliseconds.
		long startDiffMins = startDiff / (60 * 1000) % 60; //Calculates the difference between dueDate and startDate in minutes.
		
		long completionDiff = completionDate.getTime() - dueDate.getTime();
		long completionDiffMins =completionDiff / (60 * 1000) % 60;
		
		double percentageDiff = completionDiffMins / startDiffMins; // Calculates the percentage difference between total time to complete the task and completion time.
		return percentageDiff; //Returns the percentage difference.
	}
}
