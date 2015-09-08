import java.util.Scanner;

/*
 * Write a program to generate and print all 3-letter words consisting of given set
 *  of characters. For example if we have the characters 'a' and 'b', 
 *  all possible words will be "aaa", "aab", "aba", "abb", "baa", "bab", "bba" and "bbb". 
 *  The input characters are given as string at the first line of the input. 
 *  Input characters are unique (there are no repeating characters).
 */

public class Class_02_Generate3LetterWords {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		char[] charArray = console.nextLine().trim().toCharArray();
		for(int i=0; i<charArray.length; i++){
			for(int j=0; j<charArray.length; j++){
				for(int k=0; k<charArray.length; k++){
					System.out.print(charArray[i]);
					System.out.print(charArray[j]);
					System.out.print(charArray[k]);
					System.out.print(" ");
				}
			}
		}
		console.close();

	}

}
