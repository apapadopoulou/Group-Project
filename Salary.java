
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class Salary {
	private double amount;
	public Salary (Date birthdate, double amount) {
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = new Date();
		Instant instant = date.toInstant();
		LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate(); //Converts current date from Date to LocalDate
		Instant instant1 = birthdate.toInstant();
		LocalDate localDate1 = instant1.atZone(defaultZoneId).toLocalDate(); //Converts birthdate from Date to LocalDate
		int age = Period.between(localDate, localDate1).getYears(); //Calculates the age of the employee given the current date and the birthdate
		Scanner sc = new Scanner(System.in);
		System.out.println("Is the employee married? Type Y for yes and N for no");
		String answer = sc.nextLine();
		if (age > 25) {
			if (amount < 586.08 && answer.equals("N")) {
				System.out.println("The salary for non married employees over 25 years old must be at least 586.08 euros");
				System.out.println("Please enter a corresponding amount");
				this.amount = sc.nextDouble();
			} else if (amount < 644.68 && answer.equals("Y")) {
				System.out.println("The salary for married employees over 25 years old must be at least 644.68 euros");
				System.out.println("Please enter a corresponding amount");
				this.amount = sc.nextDouble();
			} else {
				this.amount = amount;
			} 
		} else {
			if (amount < 510.95) {
				System.out.println("The salary for employees not over 25 years old must be at least 510.95 euros");
				System.out.println("Please enter a corresponding amount");
				this.amount = sc.nextDouble();
			} else {
				this.amount = amount;
			}
			
		} //Checks if the amount given is within the limits of the minimum salary
		sc.close();
	}
	

}
