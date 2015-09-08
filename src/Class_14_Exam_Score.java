import java.util.Collection;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;


public class Class_14_Exam_Score {

	public static void main(String[] args) {
		Locale.setDefault(Locale.ROOT);
		Scanner console = new Scanner(System.in);
		for(int i=0; i<3; i++){
			console.nextLine();
		}
		TreeMap<Integer,TreeMap<String, Double>> scoresMap 
			= new TreeMap<Integer,TreeMap<String, Double>>();
		//build the treemap:
		String line = console.nextLine().trim();
		while(!line.startsWith("-")){
			String[] items = line.split("\\|");
			String name = items[1].trim();
			Integer score = Integer.parseInt(items[2].trim());
			Double grade = Double.parseDouble(items[3].trim());
			if(!scoresMap.containsKey(score)){
				scoresMap.put(score, new TreeMap<String, Double>());
			}
			scoresMap.get(score).put(name, grade);
			line = console.nextLine();
		}
		//print the result:
		for(Integer score: scoresMap.keySet()){
			TreeMap<String, Double> scoreUsers = scoresMap.get(score);
			Set<String> scoreNames = scoreUsers.keySet();
			Collection<Double> grades = scoreUsers.values();
			double avgGrade = grades.stream().mapToDouble(g->g).average().getAsDouble();
			System.out.format("%d -> %s; avg=%.2f\n", score, scoreNames, avgGrade);
		}
		console.close();
	}
}
