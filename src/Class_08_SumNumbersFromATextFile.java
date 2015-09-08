import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/*
 * Write a program to read a text file "Input.txt" holding a sequence of integer numbers, 
 * each at a separate line. Print the sum of the numbers at the console. 
 * Ensure you close correctly the file in case of exception or in case of normal execution.
 *  In case of exception (e.g. the file is missing), print "Error" as a result.
 */

//NOTE: file "Input.txt" is located at project's root folder


public class Class_08_SumNumbersFromATextFile {
	
	public static void main(String[] args) {
		Stream<String> lines = null ;
		try {
			lines = Files.lines(Paths.get("./Input.txt"), Charset.defaultCharset());
			int sum = lines.mapToInt(Integer::parseInt).sum();
			System.out.println(sum);
		} catch (IOException ex) {
			System.out.println("Error opening file");
		} catch (NumberFormatException ex){
			System.out.println("Invalid number format");
		}finally{
			if(lines != null){
				lines.close();
			}
			
		}
	}
}
