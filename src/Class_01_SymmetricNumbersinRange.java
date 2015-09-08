import java.util.Scanner;

/*
 * Write a program to generate and print all symmetric numbers in given range [start…end]
 * (0 ≤ start ≤ end ≤ 999). A number is symmetric if its digits are symmetric toward 
 * its middle. For example, the numbers 101, 33, 989 and 5 are symmetric, 
 * but 102, 34 and 997 are not symmetric.
 */

public class Class_01_SymmetricNumbersinRange {
	
	private static boolean isSymmetric(String str){
		for(int chIndex = 0; chIndex<= str.length()/2; chIndex++){
			if(str.charAt(chIndex) != str.charAt(str.length()-1-chIndex)){
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int start = console.nextInt();
		int end = console.nextInt();
		for(int num = start; num<= end; num++){
			String numString = Integer.toString(num);
			if(isSymmetric(numString)){
				System.out.println(numString);
			}
		}
		console.close();
	}

}
