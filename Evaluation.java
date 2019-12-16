import java.util.Date; //Used to get the Time.g
import java.util.ArrayList;
import java.sql.*;

public class Evaluation {
	
	/*URL of database with username and password.*/
	public static String url ="jdbc:sqlserver://sqlserver.dmst.aueb.gr:1433;" + 
			"databaseName=DB56;user=G556;password=939wd5890;";
	public static final double IMPORTANCE_RATE = 0.8;
	public static final double STARTING_EVAL = 10.0;
	static final double EVAL_BONUS = 0.4;
	static final double PERFORMANCE_DIFF_RATE = 0.1; //Final variable used to calculate if the task score has had an increase at least as big as this one compared to the average scores.
	/*
	 * Basic method which is called to evaluate a Task.
	 * Checks if the task is for single-employee or a group task and calls the corresponding
	 * moethod for evaluating the task.
	 */
	public static void evaluate(Task task) {
		if (!task.isGroupTask()) { //Checks if a task is group task or not.
			double score = 0.0;
			score = evalSingleTask(task); //Calls method for evaluating single-employee Tasks.
			saveToDb(task, score);
			task.setTaskScore(score);
		} else {
			double[] scores = new double[task.getEmpIDs().size()];
			scores = evalGroupTask(task); //Calls method for evaluating group Tasks.
			for (int i =0; i < task.getEmpIDs().size(); i++) {
				saveToDb(task, scores[i]);
			}
			task.setTaskScore(scores);
		}
	}
	
	public static double evalSingleTask(Task task) {
		ArrayList<Double> evalHistory = getEvalHistory(task.getEmpID());
		double evalSum= 0.0;
		for (int i = 0; i < evalHistory.size(); i++) {
			evalSum += evalHistory.get(i); //Adds the score for every previous evaluation.
		}
		double evalAvg;
		if (evalHistory.size() != 0) {
			evalAvg = evalSum / evalHistory.size(); //Calculates the average score of all the evaluations.
		}	else {
			evalAvg = STARTING_EVAL;
		}
		double percentageDiff = calculateDateDiff(task.getStartDate(), task.getDueDate(),task.getCompletionDate() );
		double timeScore;
		double taskLevel = task.getDifficulty() * (1 - IMPORTANCE_RATE) + task.getImportance() * IMPORTANCE_RATE; //Calculates the Task level based on the difficulty and importance. 
		if (taskLevel > 7.0) {
			double timeDiffRate = taskLevel / 10;
			if (percentageDiff >= (timeDiffRate - 0.1 * timeDiffRate)) {
				timeScore = 10.0;
			} else if (percentageDiff >= (timeDiffRate - 0.2 * timeDiffRate)) {
				timeScore = 9.5;
			} else if (percentageDiff >= (timeDiffRate - 0.3 * timeDiffRate)) {
				timeScore = 8.2;
			} else if (percentageDiff >= (timeDiffRate - 0.4 * timeDiffRate)) {
				timeScore = 7.8;
			} else if (percentageDiff >= (timeDiffRate - 0.5 * timeDiffRate)) {
				timeScore = 7.3;
			} else if (percentageDiff >= (timeDiffRate - 0.6 * timeDiffRate)) {
				timeScore = 6.8;
			} else if (percentageDiff >= (timeDiffRate - 0.7 * timeDiffRate)) {
				timeScore = 6.5;
			} else if (percentageDiff >= (timeDiffRate - 0.8 * timeDiffRate)) {
				timeScore = 6.2;
			} else if (percentageDiff >= (timeDiffRate - 0.9 * timeDiffRate)) {
				timeScore = 5.6;
			} else if (percentageDiff >= (timeDiffRate - 0.95 * timeDiffRate)) {
				timeScore = 4.3;
			} else if (percentageDiff < 0.0) {
				timeScore = 0.0;
			} else {
				timeScore = 3.0;
			}
		} else if (taskLevel > 5.5){
			double timeDiffRate = (taskLevel / 10) + 0.1;
			if (percentageDiff >= (timeDiffRate - 0.1 * timeDiffRate)) {
				timeScore = 10.0;
			} else if (percentageDiff >= (timeDiffRate - 0.2 * timeDiffRate)) {
				timeScore = 7.5;
			} else if (percentageDiff >= (timeDiffRate - 0.3 * timeDiffRate)) {
				timeScore = 6.5;
			} else if (percentageDiff >= (timeDiffRate - 0.4 * timeDiffRate)) {
				timeScore = 5.8;
			} else if (percentageDiff >= (timeDiffRate - 0.5 * timeDiffRate)) {
				timeScore = 4.4;
			} else if (percentageDiff >= (timeDiffRate - 0.6 * timeDiffRate)) {
				timeScore = 3.1;
			} else if (percentageDiff >= (timeDiffRate - 0.7 * timeDiffRate)) {
				timeScore = 2.6;
			} else if (percentageDiff >= (timeDiffRate - 0.8 * timeDiffRate)) {
				timeScore = 1.9;
			} else if (percentageDiff >= (timeDiffRate - 0.9 * timeDiffRate)) {
				timeScore = 1.8;
			} else if (percentageDiff < 0.0){
				timeScore = 0.0;
			} else {
				timeScore = 1.5;
			}
		} else if (taskLevel > 4.5){
			double timeDiffRate = (taskLevel / 10) + 0.3;
			if (percentageDiff >= (timeDiffRate - 0.1 * timeDiffRate)) {
				timeScore = 10.0;
			} else if (percentageDiff >= (timeDiffRate - 0.2 * timeDiffRate)) {
				timeScore = 7.5;
			} else if (percentageDiff >= (timeDiffRate - 0.3 * timeDiffRate)) {
				timeScore = 6.0;
			} else if (percentageDiff >= (timeDiffRate - 0.4 * timeDiffRate)) {
				timeScore = 5.1;
			} else if (percentageDiff >= (timeDiffRate - 0.5 * timeDiffRate)) {
				timeScore = 3.1;
			} else if (percentageDiff >= (timeDiffRate - 0.6 * timeDiffRate)) {
				timeScore = 1.1;
			} else if (percentageDiff >= (timeDiffRate - 0.7 * timeDiffRate)) {
				timeScore = 0.4;
			} else if (percentageDiff >= (timeDiffRate - 0.8 * timeDiffRate)) {
				timeScore = 0.2;
			} else if (percentageDiff >= (timeDiffRate - 0.9 * timeDiffRate)) {
				timeScore = 0.15;
			} else if (percentageDiff < 0.0){
				timeScore = 0.0;
			} else {
				timeScore = 0.1;
			}
		} else {
			double timeDiffRate = (taskLevel / 10) + 0.45;
			if (percentageDiff >= timeDiffRate) {
				timeScore = 10.0;
			}else if (percentageDiff >= (timeDiffRate - 0.05 * timeDiffRate)) {
				timeScore = 8.7;
			} else if (percentageDiff >= (timeDiffRate - 0.1 * timeDiffRate)) {
				timeScore = 6.4;
			} else if (percentageDiff >= (timeDiffRate - 0.2 * timeDiffRate)) {
				timeScore = 4.6;
			} else if (percentageDiff >= (timeDiffRate - 0.3 * timeDiffRate)) {
				timeScore = 3.4;
			} else if (percentageDiff >= (timeDiffRate - 0.4 * timeDiffRate)) {
				timeScore = 2.0;
			} else if (percentageDiff >= (timeDiffRate - 0.5 * timeDiffRate)) {
				timeScore = 0.8;
			} else if (percentageDiff >= (timeDiffRate - 0.6 * timeDiffRate)) {
				timeScore = 0.5;
			} else if (percentageDiff >= (timeDiffRate - 0.7 * timeDiffRate)) {
				timeScore = 0.4;
			} else if (percentageDiff >= (timeDiffRate - 0.8 * timeDiffRate)) {
				timeScore = 0.3;
			} else if (percentageDiff >= (timeDiffRate - 0.9 * timeDiffRate)) {
				timeScore = 0.2;
			} else if (percentageDiff < 0.0){
				timeScore = 0.0;
			} else {
				timeScore = 0.1;
			}
		}
		double scoreNow;
		if (taskLevel > 7.0) {
			scoreNow = 10 - ((10 - timeScore ) * (taskLevel / 10) + 0.05);
		} else if (taskLevel > 5.5) {
			scoreNow = 10 - ((10 - timeScore ) * ((taskLevel / 10) + 0.1));
		} else if (taskLevel > 4.5) {
			scoreNow = 10 - ((10 - timeScore ) * ((taskLevel / 10) + 0.15));
		} else {
			scoreNow = 10 - ((10 - timeScore ) * ((taskLevel / 10) + 0.2));
		}
		double finalScore; //Variable for the final score.
		if (scoreNow > (evalAvg + (scoreNow * PERFORMANCE_DIFF_RATE))) { //Checks if the score is increased by at least the given percentage when compared to the average score.
			if (scoreNow <= (10.0 - EVAL_BONUS)) {
				finalScore = scoreNow + EVAL_BONUS;
			} else if (scoreNow <= (10.0 - (EVAL_BONUS / 2))) {
				finalScore = scoreNow + (EVAL_BONUS / 2);
			} else {
				finalScore = scoreNow;
			}
		} else {
			finalScore = scoreNow;
		}
		return finalScore; //REturns the final score.
	}
	
	public static double[] evalGroupTask(Task task) {
		double [] evalAvg = new double [task.getEmpIDs().size()]; 
		for (int j = 0; j < task.getEmpIDs().size(); j++) {
			ArrayList<Double> evalHistory = getEvalHistory(task.getEmpIDs().get(j));
			double evalSum= 0.0;
			for (int i = 0; i < evalHistory.size(); i++) {
				evalSum += evalHistory.get(i); //Adds the score for every previous evaluation.
			}
			if (evalHistory.size() != 0) {
				evalAvg[j] = evalSum / evalHistory.size(); //Calculates the average score of all the evaluations.
			}	else {
				evalAvg[j] = STARTING_EVAL;
			}
		}
		double percentageDiff = calculateDateDiff(task.getStartDate(), task.getDueDate(),task.getCompletionDate() );
		double timeScore = 10.0;
		double taskLevel = task.getDifficulty() * (1 - IMPORTANCE_RATE) + task.getImportance() * IMPORTANCE_RATE; //Calculates the Task level based on the difficulty and importance. 
		if (taskLevel > 7.0) {
			double timeDiffRate = taskLevel / 10;
			if (percentageDiff >= (timeDiffRate - 0.1 * timeDiffRate)) {
				timeScore = 10.0;
			} else if (percentageDiff >= (timeDiffRate - 0.2 * timeDiffRate)) {
				timeScore = 9.5;
			} else if (percentageDiff >= (timeDiffRate - 0.3 * timeDiffRate)) {
				timeScore = 8.2;
			} else if (percentageDiff >= (timeDiffRate - 0.4 * timeDiffRate)) {
				timeScore = 7.8;
			} else if (percentageDiff >= (timeDiffRate - 0.5 * timeDiffRate)) {
				timeScore = 7.3;
			} else if (percentageDiff >= (timeDiffRate - 0.6 * timeDiffRate)) {
				timeScore = 6.8;
			} else if (percentageDiff >= (timeDiffRate - 0.7 * timeDiffRate)) {
				timeScore = 6.5;
			} else if (percentageDiff >= (timeDiffRate - 0.8 * timeDiffRate)) {
				timeScore = 6.2;
			} else if (percentageDiff >= (timeDiffRate - 0.9 * timeDiffRate)) {
				timeScore = 5.6;
			} else if (percentageDiff >= (timeDiffRate - 0.95 * timeDiffRate)) {
				timeScore = 4.3;
			} else if (percentageDiff < 0.0) {
				timeScore = 0.0;
			} else {
				timeScore = 3.0;
			}
		} else if (taskLevel > 5.5){
			double timeDiffRate = (taskLevel / 10) + 0.1;
			if (percentageDiff >= (timeDiffRate - 0.1 * timeDiffRate)) {
				timeScore = 10.0;
			} else if (percentageDiff >= (timeDiffRate - 0.2 * timeDiffRate)) {
				timeScore = 7.5;
			} else if (percentageDiff >= (timeDiffRate - 0.3 * timeDiffRate)) {
				timeScore = 6.5;
			} else if (percentageDiff >= (timeDiffRate - 0.4 * timeDiffRate)) {
				timeScore = 5.8;
			} else if (percentageDiff >= (timeDiffRate - 0.5 * timeDiffRate)) {
				timeScore = 4.4;
			} else if (percentageDiff >= (timeDiffRate - 0.6 * timeDiffRate)) {
				timeScore = 3.1;
			} else if (percentageDiff >= (timeDiffRate - 0.7 * timeDiffRate)) {
				timeScore = 2.6;
			} else if (percentageDiff >= (timeDiffRate - 0.8 * timeDiffRate)) {
				timeScore = 1.9;
			} else if (percentageDiff >= (timeDiffRate - 0.9 * timeDiffRate)) {
				timeScore = 1.8;
			} else if (percentageDiff < 0.0){
				timeScore = 0.0;
			} else {
				timeScore = 1.5;
			}
		} else if (taskLevel > 4.5){
			double timeDiffRate = (taskLevel / 10) + 0.3;
			if (percentageDiff >= (timeDiffRate - 0.1 * timeDiffRate)) {
				timeScore = 10.0;
			} else if (percentageDiff >= (timeDiffRate - 0.2 * timeDiffRate)) {
				timeScore = 7.5;
			} else if (percentageDiff >= (timeDiffRate - 0.3 * timeDiffRate)) {
				timeScore = 6.0;
			} else if (percentageDiff >= (timeDiffRate - 0.4 * timeDiffRate)) {
				timeScore = 5.1;
			} else if (percentageDiff >= (timeDiffRate - 0.5 * timeDiffRate)) {
				timeScore = 3.1;
			} else if (percentageDiff >= (timeDiffRate - 0.6 * timeDiffRate)) {
				timeScore = 1.1;
			} else if (percentageDiff >= (timeDiffRate - 0.7 * timeDiffRate)) {
				timeScore = 0.4;
			} else if (percentageDiff >= (timeDiffRate - 0.8 * timeDiffRate)) {
				timeScore = 0.2;
			} else if (percentageDiff >= (timeDiffRate - 0.9 * timeDiffRate)) {
				timeScore = 0.15;
			} else if (percentageDiff < 0.0){
				timeScore = 0.0;
			} else {
				timeScore = 0.1;
			}
		} else {
			double timeDiffRate = (taskLevel / 10) + 0.45;
			if (percentageDiff >= timeDiffRate) {
				timeScore = 10.0;
			}else if (percentageDiff >= (timeDiffRate - 0.05 * timeDiffRate)) {
				timeScore = 8.7;
			} else if (percentageDiff >= (timeDiffRate - 0.1 * timeDiffRate)) {
				timeScore = 6.4;
			} else if (percentageDiff >= (timeDiffRate - 0.2 * timeDiffRate)) {
				timeScore = 4.6;
			} else if (percentageDiff >= (timeDiffRate - 0.3 * timeDiffRate)) {
				timeScore = 3.4;
			} else if (percentageDiff >= (timeDiffRate - 0.4 * timeDiffRate)) {
				timeScore = 2.0;
			} else if (percentageDiff >= (timeDiffRate - 0.5 * timeDiffRate)) {
				timeScore = 0.8;
			} else if (percentageDiff >= (timeDiffRate - 0.6 * timeDiffRate)) {
				timeScore = 0.5;
			} else if (percentageDiff >= (timeDiffRate - 0.7 * timeDiffRate)) {
				timeScore = 0.4;
			} else if (percentageDiff >= (timeDiffRate - 0.8 * timeDiffRate)) {
				timeScore = 0.3;
			} else if (percentageDiff >= (timeDiffRate - 0.9 * timeDiffRate)) {
				timeScore = 0.2;
			} else if (percentageDiff < 0.0){
				timeScore = 0.0;
			} else {
				timeScore = 0.1;
			}
		}
		double scoreNow = 10.0;
		if (taskLevel > 7.0) {
			scoreNow = 10 - ((10 - timeScore ) * (taskLevel / 10) + 0.05);
		} else if (taskLevel > 5.5) {
			scoreNow = 10 - ((10 - timeScore ) * ((taskLevel / 10) + 0.1));
		} else if (taskLevel > 4.5) {
			scoreNow = 10 - ((10 - timeScore ) * ((taskLevel / 10) + 0.15));
		} else {
			scoreNow = 10 - ((10 - timeScore ) * ((taskLevel / 10) + 0.2));
		}
		double finalScore[]= new double [task.getEmpIDs().size()]; //Variable for the final score.
		for (int j = 0; j < task.getEmpIDs().size(); j++) {
		if (scoreNow > (evalAvg[j] + (scoreNow * PERFORMANCE_DIFF_RATE))) { //Checks if the score is increased by at least the given percentage when compared to the average score.
			if (scoreNow <= (10.0 - EVAL_BONUS)) {
				finalScore[j] = scoreNow + EVAL_BONUS;
			} else if (scoreNow <= (10.0 - (EVAL_BONUS / 2))) {
				finalScore[j] = scoreNow + (EVAL_BONUS / 2);
			} else {
				finalScore[j] = scoreNow;
			}
			} else {
				finalScore[j] = scoreNow;
			}
		}
		return finalScore;
	}

	/*
	 * Method to calculate the difference between completion date and due date in percentage.
	 * Returns the percentage difference between total time to complete the task and remaining time to Due Date.
	 */
	public static double calculateDateDiff(Date startDate, Date dueDate, Date completionDate) {
		long startDiff = dueDate.getTime() - startDate.getTime(); //Calculates the difference between DueDate and startDate in milliseconds.
		long startDiffMins = startDiff / (60 * 1000) % 60; //Calculates the difference between dueDate and startDate in minutes.
		
		long completionDiff = dueDate.getTime() - completionDate.getTime();
		long completionDiffMins =completionDiff / (60 * 1000) % 60;
		
		double percentageDiff = completionDiffMins / startDiffMins; // Calculates the percentage difference between total time to complete the task and completion time.
		return percentageDiff; //Returns the percentage difference.
	}
}
