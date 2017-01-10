import java.util.*;
import java.io.*;

public class decode {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("in_6.txt"));

		ArrayList<String> lines = new ArrayList<String>();
		while(scanner.hasNextLine()) {
			lines.add(scanner.nextLine());
		}
		String d = "";
		String c = "";
		for(int i = 0; i < lines.get(0).length(); i++) {
			c += parseColumnOne(lines, i);
		}
		for(int i = 0; i < lines.get(0).length(); i++) {
			d += parseColumnTwo(lines, i);
		}
		System.out.println(c);
		System.out.println(d);
	}

	public static String parseColumnTwo(ArrayList<String> lines, int col) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char[] alphabet = {
			'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p',
			'q','r','s','t','u','v','w','x','y','z'
		};

		for(int i = 0; i < lines.size(); i++) {
			String w = lines.get(i);
			char c = w.charAt(col);
			if(map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		
		int min = 200;
		Character top = '!';
		for(int j = 0; j < alphabet.length; j++) {
			if(map.containsKey(alphabet[j])) {
				if(map.get(alphabet[j]) < min) {
					min = map.get(alphabet[j]);
					top = alphabet[j];
				}
			}
		}
		return top.toString();
	}

	public static String parseColumnOne(ArrayList<String> lines, int col) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char[] alphabet = {
			'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p',
			'q','r','s','t','u','v','w','x','y','z'
		};

		for(int i = 0; i < lines.size(); i++) {
			String w = lines.get(i);
			char c = w.charAt(col);
			if(map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		
		int max = 0;
		Character top = '!';
		for(int j = 0; j < alphabet.length; j++) {
			if(map.containsKey(alphabet[j])) {
				if(map.get(alphabet[j]) > max) {
					max = map.get(alphabet[j]);
					top = alphabet[j];
				}
			}
		}
		return top.toString();
	}
}
