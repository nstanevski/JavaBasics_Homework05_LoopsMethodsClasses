import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * In most Poker games, the "full house" hand is defined as three cards 
 * of the same face + two cards of the same face, other than the first, 
 * regardless of the card's suits. The cards faces are 
 * "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" and "A". 
 * The card suits are "♣", "♦", "♥" and "♠". 
 * Write a program to generate and print all full houses and print their number.
 */

// Note: it takes some time (e.g. 4-5 minutes) for this program to finish

public class Class_03_FullHouse {
	
	private static List<String[]> fullHouseHands = new ArrayList<String[]>();

	public static void main(String[] args) {
		String[] faces = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K","A"};
		String[] suits = {"♣", "♦", "♥","♠"};
		
		//generate a deck of 52 cards
		List<String> deck52 = new ArrayList<String>();
		for (String face:faces){
			for(String suit:suits){
				deck52.add(face+suit);
			}
		}
		for(int i=0; i<52; i++){
			for(int j=0; j<52; j++){
				for(int k=0; k<52; k++){
					for(int l=0; l<52; l++){
						for(int m=0; m<52; m++){
							if(i !=j && i!=k && i!=l && i!=m && j!=k && j!=l && j!=m && k!=l && k!=m && l!=m){
								String[] hand = {deck52.get(i), deck52.get(j),deck52.get(k), deck52.get(l), deck52.get(m)};
								
								if(isFullHouse(hand)){
									if(fullHouseHands.isEmpty() || !containsHand(hand)){
										fullHouseHands.add(hand);
										
									}
								}
							}
							
						}
						
					}
					
				}
				
			}	
		}
		
		//print the hand and total number of full house hands
		for(String[] fullHouseHand: fullHouseHands){
			System.out.println(Arrays.toString(fullHouseHand));
		}

		System.out.println(fullHouseHands.size() + " full houses");

	}

	/*
	 * Checks whether an array of hands already contans 
	 * a hand specified by 'hand' parameter
	 */
	private static boolean containsHand(String[] hand) {
		for(String[] fullHouseHand: fullHouseHands){
			List<String> l = Arrays.asList(fullHouseHand);
			if(l.contains(hand[0]) && l.contains(hand[1]) && l.contains(hand[2]) 
				&& l.contains(hand[3]) && l.contains(hand[4])){
				return true;
			}
		}
		return false;
	}

	/*
	 * Checks whether a hand is fullHouse, i.e 3 cards from the same face
	 * another 2 cards from another face.
	 */
	private static boolean isFullHouse(String[] hand) {
		
		Map <String, Integer> faceCount = new HashMap<String, Integer>();
		
		for(int i=0; i<hand.length; i++){
			String card = hand[i];
			String cardFace = getCardFace(card);
			if(faceCount.containsKey(cardFace)){
				faceCount.put(cardFace, faceCount.get(cardFace)+1);
			}else{
				faceCount.put(cardFace, 1);
			}	
		}
		
		Collection<Integer> values = faceCount.values();
		if(values.size() == 2 && values.contains(new Integer(3))){
			return true;
		}
		
		return false;
	}
	
	private static String getCardFace(String card){
		return card.substring(0, card.length()-1);
	}

}
