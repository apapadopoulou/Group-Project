import java.util.Date; //Used to get the Time.
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Class Evaluation 
 * This class is responsible for evaluating employee performance on a given task.
 * After the evaluation is done and the score calculated , the results get sent to the server for storage.
 * 
 * @author BusyB
 */
public class Evaluation {
	
	public static final double IMPORTANCE_RATE = 0.8;
	public static final double STARTING_EVAL = 10.0;
	static final double EVAL_BONUS = 0.4;
	static final double PERFORMANCE_DIFF_RATE = 0.1; //Final variable used to calculate if the task score has had an increase at least as big as this one compared to the average scores.
	/*
	 * Basic method which is called to evaluate a Task.
	 * Checks if the task is for single-employee or a group task and calls the corresponding
	 * method for evaluating the task.
	 */
	/**
	 * Evaluates a task by using by calling and using DBcon's methods
	 * @param task
	 */
	public static void evaluate(Task task) {
		//Checks if a task is group task or not.
		if (!task.getIsGroupTask()) {
			double score = 0.0;
			//Calls method for evaluating single-employee Tasks.
			score = evalSingleTask(task);
			//Saves the result of the evaluation on the database.
			DBcon.saveEvaluation(task.getProgramID(), task.getEmpID(), score);
			task.setScore(score);
		} else {
			double[] scores = new double[task.getEmpIDs().size()];
			//Calls method for evaluating group Tasks.
			scores = evalGroupTask(task);
			task.setScores(scores);
			for (int i =0; i < task.getEmpIDs().size(); i++) {
				//Saves the result of the evaluation on the database.
				DBcon.saveEvaluation(task.getProgramID(), task.getEmpIDs().get(i), scores[i]);
			}
		}
	}
	
	/**
	 * Evaluates a singleTask and returns its finalScore
	 * @param task
	 * @return finalScore
	 */
	public static double evalSingleTask(Task task) {
		double evalAvg = DBcon.getEvalAverage(task.getEmpID());
		if (evalAvg == 0.0) {
			evalAvg = STARTING_EVAL;
		} 
		double percentageDiff = -1;
		//Calculates the percentage difference between the completion date of the task and the total available time to complete the task.
		try {
			percentageDiff = calculateDateDiff(task.getStartDate(), task.getDueDate(),task.getCompletionDate() );
		} catch (ParseException pex) {
			pex.getMessage();
		}
		//Calculates the Task level based on the difficulty and importance. 
		double taskLevel = task.getDifficulty() * (1 - IMPORTANCE_RATE) + task.getImportance() * IMPORTANCE_RATE; 
		//Calls the calculateTimeScore method which calculates and the returns the score of the task based on the remaining time to due date.
		double timeScore = calculateTimeScore(percentageDiff, taskLevel);
		//Calls the addTimeScore method which calculates and returns the score including the time score.
		double scoreNow = addTimeScore(taskLevel, timeScore);
		//Variable for the final score.
		double finalScore;
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
	/**
	 * Evaluates a group task and returns its final score
	 * @param task
	 * @return finalScore
	 */
	public static double[] evalGroupTask(Task task) {
		double[] evalAvg = new double [task.getEmpIDs().size()]; 
		for (int j = 0; j < task.getEmpIDs().size(); j++) {
			evalAvg[j] = DBcon.getEvalAverage(task.getEmpIDs().get(j));
			if (evalAvg[j] == 0) {
				evalAvg[j] = STARTING_EVAL;
			}
		}
		double percentageDiff = -1;
			try {
				//Calculates the percentage difference between the completion date of the task and the total available time to complete the task.
				percentageDiff = calculateDateDiff(task.getStartDate(), task.getDueDate(),task.getCompletionDate() );
			} catch (ParseException pex) {
				pex.getMessage();
			}
		//Calculates the Task level based on the difficulty and importance. 
		double taskLevel = task.getDifficulty() * (1 - IMPORTANCE_RATE) + task.getImportance() * IMPORTANCE_RATE; 
		//Calls the calculateTimeScore method which calculates and the returns the score of the task based on the remaining time to due date.
		double timeScore = calculateTimeScore(percentageDiff, taskLevel);
		//Calls the addTimeScore method which calculates and returns the score including the time score.
		double scoreNow = addTimeScore(taskLevel, timeScore);
		
		double finalScore[] = new double [task.getEmpIDs().size()]; //Variable for the final score.
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
	
	/**
	 * Calculates a score based on the time the task was completed and the task level;
	 */
	public static double calculateTimeScore(double percentageDiff, double taskLevel) {
		double timeScore = 10;
	if (taskLevel > 7) {
		timeScore = calcTimeScoreA(percentageDiff, taskLevel);
	} else if (taskLevel > 5.5){
		timeScore = calcTimeScoreB(percentageDiff, taskLevel);
	} else if (taskLevel > 4.5){
		timeScore = calcTimeScoreC(percentageDiff, taskLevel);
	} else {
		timeScore = calcTimeScoreD(percentageDiff, taskLevel);
	}
		return timeScore;
	}
	
	/**
	 * Calculates a score based on the time the task was completed and the task level using a certain way of calculating the timeDiffRate
	 * @param percentageDiff
	 * @param taskLevel
	 * @return timeScore
	 */
	public static double calcTimeScoreA(double percentageDiff, double taskLevel) {
		double timeScore;
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
		return timeScore;
	}
	
	/**
	 * Calculates a score based on the time the task was completed and the task level using a certain way of calculating the timeDiffRate
	 * @param percentageDiff
	 * @param taskLevel
	 * @return timeScore
	 */
	public static double calcTimeScoreB(double percentageDiff, double taskLevel) {
		double timeScore;
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
		return timeScore;
	}
	
	/**
	 * Calculates a score based on the time the task was completed and the task level using a certain way of calculating the timeDiffRate
	 * @param percentageDiff
	 * @param taskLevel
	 * @return timeScore
	 */
	public static double calcTimeScoreC(double percentageDiff, double taskLevel) {
		double timeScore;
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
		return timeScore;
	}
	
	/**
	 * Calculates a score based on the time the task was completed and the task level using a certain way of calculating the timeDiffRate
	 * @param percentageDiff
	 * @param taskLevel
	 * @return timeScore
	 */
	public static double calcTimeScoreD(double percentageDiff, double taskLevel) {
		double timeScore;
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
		return timeScore;
	}
	
	/**
	 * Uses the timeScore variable that has been calculated to find the scoreNow variable
	 * @param taskLevel
	 * @param timeScore
	 * @return scoreNow
	 */
	public static double addTimeScore(double taskLevel, double timeScore) {
		double scoreNow = 10.0;
		if (taskLevel > 7.0) {
			scoreNow = 10 - ((10 - timeScore ) * ((taskLevel / 10) + 0.05));
		} else if (taskLevel > 5.5) {
			scoreNow = 10 - ((10 - timeScore ) * ((taskLevel / 10) + 0.1));
		} else if (taskLevel > 4.5) {
			scoreNow = 10 - ((10 - timeScore ) * ((taskLevel / 10) + 0.15));
		} else {
			scoreNow = 10 - ((10 - timeScore ) * ((taskLevel / 10) + 0.2));
		}
		return scoreNow;
	}
	
	/**
	 * Method to calculate the difference between completion date and due date in percentage.
	 * Returns the percentage difference between total time to complete the task and remaining time to Due Date.
	 * @param stDate
	 * @param dDate
	 * @param comDate
	 * @return
	 * @throws ParseException
	 */
	public static double calculateDateDiff(String stDate, String dDate, String comDate) throws ParseException {
		double percentageDiff = -1;
		try {
			Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(stDate);
			Date dueDate = new SimpleDateFormat("dd/MM/yyyy").parse(dDate);
			Date completionDate = new SimpleDateFormat("dd/MM/yyyy").parse(comDate);
			//Calculates the difference between DueDate and startDate in milliseconds.
			long startDiff = dueDate.getTime() - startDate.getTime();
			//Calculates the difference between dueDate and startDate in minutes.
			long startDiffMins = startDiff / (60 * 1000) % 60;
			//Calculates the difference between the completion date and the due date.
			long completionDiff = dueDate.getTime() - completionDate.getTime();
			//Calculates the completion time difference in minutes.
			long completionDiffMins =completionDiff / (60 * 1000) % 60;
			// Calculates the percentage difference between total time to complete the task and completion time.
			percentageDiff = (double)completionDiffMins / startDiffMins;
			//Returns the percentage difference.
			return percentageDiff;
		} catch (ParseException ex) {
			System.out.println("Parse Exception: " + ex.getMessage());
		}
		return percentageDiff;
	}
}
/**
 * End of Evaluation class
*/