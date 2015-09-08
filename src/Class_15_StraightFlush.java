import java.util.Arrays;
import java.util.Scanner;

public class Class_15_StraightFlush {
	
	private static String faces[] = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		String[] hand = console.nextLine().trim().split(",\\s+");
		console.close();
				
		if(hand.length<5){
			System.out.println("No Straight Flushes");
			return;
		}
		boolean found = false;
		for(String card:hand){
			String face = getCardFace(card);
			String suite = getCardSuite(card);
			int faceId = face2faceId(face);
			if(faceId>8){
				continue;//no straight flush can start from J,Q,K or A
			}
			String nextCard1 = new String(faceId2face(faceId+1)+suite);
			String nextCard2 = new String(faceId2face(faceId+2)+suite);
			String nextCard3 = new String(faceId2face(faceId+3)+suite);
			String nextCard4 = new String(faceId2face(faceId+4)+suite);
			if(handHasCard(hand, nextCard1) && handHasCard(hand, nextCard2)	&& handHasCard(hand, nextCard3) && handHasCard(hand, nextCard4)){
				System.out.format("[%s, %s, %s, %s, %s]\n",card, nextCard1, nextCard2, nextCard3, nextCard4);
				found = true;
			}
			
		}
		if(!found){
			System.out.println("No Straight Flushes");
		}
	}
	
	private static boolean handHasCard(String[] hand, String card) {
		if(Arrays.asList(hand).indexOf(card)>=0){
			return true;
		}
		return false;
	}

	private static String getCardFace(String card){
		return card.substring(0, card.length()-1);
	}
	
	private static String getCardSuite(String card){
		return card.substring(card.length()-1);
	}
	
	private static int face2faceId(String face){
		return Arrays.asList(faces).indexOf(face);
	}
	
	private static String faceId2face(int faceId){
		return faces[faceId];
	}	
}
