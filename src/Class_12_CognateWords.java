import java.util.HashSet;
import java.util.Scanner;

public class Class_12_CognateWords {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		String input = console.nextLine();
		String[] words = input.split("[^A-z]+");
		HashSet<String> h = new HashSet<String>();
		for(int i=0; i<words.length; i++){
			for(int j=0; j<words.length; j++){
				for(int k=0; k<words.length; k++){
					if(i!=j && i!=k && j!=k){
						String concatWord = words[i]+words[j];
						if(concatWord.equals(words[k])){
							String str = new String();
							str = String.format("%s|%s=%s", words[i], words[j],words[k]);
							h.add(str);
						}
					}
				}
			}
		}
		console.close();
		if(h.isEmpty()){
			System.out.println("No");
		}else{
			for(String s:h){
				System.out.println(s);
			}
		}
	}

}