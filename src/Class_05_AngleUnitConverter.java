import java.util.Locale;
import java.util.Scanner;

/*
 * Write a method to convert from degrees to radians. Write a method to convert 
 * from radians to degrees. You are given a number n and n queries for conversion. 
 * Each conversion query will consist of a number + space + measure. 
 * Measures are "deg" and "rad". Convert all radians to degrees and all degrees 
 * to radians. Print the results as n lines, each holding a number + space + measure. 
 * Format all numbers with 6 digit after the decimal point. 
 */

public class Class_05_AngleUnitConverter {

	public static void main(String[] args) {
		Locale.setDefault(Locale.ROOT);
		Scanner console = new Scanner(System.in);
		int numCalc = console.nextInt();
		for(int i=0; i<numCalc; i++){
			Double value = console.nextDouble();
			String unit = console.nextLine().toLowerCase().trim();
			double newVal = unit.equals("rad" )?value*180.0/Math.PI:value*Math.PI/180.0;
			System.out.format("%.6f\n", newVal);
		}
		console.close();
	}
}
