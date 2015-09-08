import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.Stream;

/*
 * Create a class Product to hold products, which have name (string) and 
 * price (decimal number). Read from a text file named "Input.txt" a list of products. 
 * Each product will be in format name + space + price. You should hold the products 
 * in objects of class Product. Sort the products by price and write them in 
 * format price + space + name in a file named "Output.txt". 
 * Ensure you close correctly all used resources
 */

public class Class_09_ListOfProducts {
	
	private static ArrayList<Product> products = new ArrayList<Product>();
	
	private static void procLine(String line){
		String[] items = line.split("\\s+");
		products.add(new Product(items[0], new BigDecimal(items[1])));
	}

	public static void main(String[] args) {
		Locale.setDefault(Locale.ROOT);
		Stream<String> lines = null;

		try {
			//read input
			lines = Files.lines(Paths.get("./InputProducts.txt"), Charset.defaultCharset());
			lines.forEach(line->procLine(line));
			//process and write output to the console
			products.stream()
				.sorted((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()))
				.map(p -> p.getPrice() + " " +p.getName())
				.forEach(p -> System.out.println(p));
			} catch (IOException ex) {
				System.out.println("Error opening input file");
			}finally{
				if (lines != null){
					lines.close();
				}
			}
		}
}
