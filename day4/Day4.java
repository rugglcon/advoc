import java.util.*;
import java.io.*;

public class Day4 {
	static int getID(String s) {
		return Integer.parseInt(s.substring(0,s.indexOf("[")));
	}

	static String getCheckSum(String s) {
		return s.substring(s.indexOf("[") + 1, s.length()-1);
	}

	static char rot(int rotation, char c) {
		return (char) ((((c - 'a') + rotation ) % 26) + 'a');
	}

	public static void main(String[] args) throws FileNotFoundException {

		Scanner file = new Scanner(new File("advoc_in_4.txt"));
		List<String[]> input = new ArrayList<>();
		while(file.hasNextLine()) {
			input.add(file.nextLine().split("-"));
		}
		List<String[]> part2 = new ArrayList<>();
		int sum = 0;

		for (String[] each : input) {
			Map<Character, Integer> freq = new HashMap<>();
			
			// make frequency table
			for (int i = 0; i < each.length - 1; i++) {
				each[i].chars()
								.filter(x -> x != '-')
								.forEach(x -> freq.put((char) x, freq.getOrDefault((char) x, 0) + 1));
			}
			
			// get top 5 frequencies, sorted by character order and then frequency
			// and turn into string
			String top5 = freq.entrySet().stream()
						.sorted(Map.Entry.comparingByKey())
						.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
						.limit(5)
						.map(Map.Entry::getKey)
						.map(x -> Character.toString(x))
						.collect(Collectors.joining(""));

			String checkSum = getCheckSum(each[each.length - 1]);
			
			if (top5.equals(checkSum)) {
				sum += getID(each[each.length - 1]);
				
				// add to list (not dummy data)
				part2.add(each);
			}
		}
		System.out.println(sum);
		
		// decrypt data
		for (String[] each : part2) {
			String temp = "";
			for (int i = 0; i < each.length - 1; i++) {
				for (int j = 0; j < each[i].length(); j++) {
					temp += rot(getID(each[each.length - 1]), each[i].charAt(j));
				}
				temp += "-";
			}
			temp += each[each.length - 1];
			if (temp.startsWith("northpole-object-storage")) System.out.println(temp);
		}
	}
}
