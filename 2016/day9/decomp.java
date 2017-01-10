import java.util.*;
import java.io.*;

public class decomp {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("./in_9.txt"));
		int count = 0;
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			count += part1(line).length();
		}
		System.out.println(count);
	}

	public static String part1(String line) {
		
		return null;
	}
}
