import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/*
 * Write a program to calculate the difference between two dates in number of days. 
 * The dates are entered at two consecutive lines in format day-month-year. 
 * Days are in range [1…31]. Months are in range [1…12]. Years are in range [1900…2100].
 */

public class Class_07_DaysBetweenTwoDates {
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
		LocalDate date1 = LocalDate.parse(console.nextLine(), formatter);
		LocalDate date2 = LocalDate.parse(console.nextLine(), formatter);
		long days = ChronoUnit.DAYS.between(date1, date2);
		System.out.println(days);
		console.close();
	}
}
