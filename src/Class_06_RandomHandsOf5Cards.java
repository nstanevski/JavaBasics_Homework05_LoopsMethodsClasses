import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
 * Write a program to generate n random hands of 5 different cards form 
 * a standard suit of 52 cards.
 */

public class Class_06_RandomHandsOf5Cards {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int numHands = console.nextInt();
		String[] faces = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K","A"};
		String[] suits = {"♣", "♦", "♥","♠"};
		Random rand = new Random();
		console.close();
		
		//generate a deck of 52 cards
		List<String> deck52 = new ArrayList<String>();
		for (String face:faces){
			for(String suit:suits){
				deck52.add(face+suit);
			}
		}
		//generate random hands and remove cards already choosen
		for(int handNum=0; handNum<numHands; handNum++){
			for(int cardNum=0; cardNum<5; cardNum++){
				int randomIndex = rand.nextInt(deck52.size());
				System.out.print(deck52.get(randomIndex) + " ");
				deck52.remove(randomIndex);
			}
			System.out.println("");
		}
	}
}
