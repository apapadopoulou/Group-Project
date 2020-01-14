package gr.aueb.dmst.ProgrammingII.BusyB.BusyB;

import junit.framework.TestCase;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.SimpleDateFormat;

public class EvaluationTest extends TestCase {

	public void testCalculateDateDiff() {
		
		try{
			
			String s1 = "25/11/2019";
			
			String s2 = "30/11/2019";
			
			String s3 = "29/11/2019";
			
			double output = Evaluation.calculateDateDiff(s1, s2, s3);
			assertEquals(0.2, output);
			}catch (ParseException e) {
				e.printStackTrace();
			}
		
			}
	
	/*public void testCalcTimeScoreA() {
		double output = Evaluation.calcTimeScoreA(0.6, 2.0);
		assertEquals(10.0, output);
	}
	
	public void testCalcTimeScoreB() {
		double output = Evaluation.calcTimeScoreB(0.3, 4.0);
		assertEquals(5.8, output);
	}
	
	public void testCalcTimeScoreC() {
		double output = Evaluation.calcTimeScoreC(0.5, 7.0);
		assertEquals(3.1, output);
	}
	
	public void testCalcTimeScoreD() {
		double output = Evaluation.calcTimeScoreD(0.4, 6.0);
		assertEquals(0.4, output);
	}
	public void testCalculateTimeScore() {
		double output = Evaluation.calculateTimeScore(0.3, 4.0);
		assertEquals(5.8, output);
	}
	public void testAddTimeScore() {
		double output = Evaluation.addTimeScore(6.0, 0.4);
		assertEquals(3.28, output);
	}*/
	
	}


