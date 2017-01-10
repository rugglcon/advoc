import java.util.*;
import java.io.*;

public class ip {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("in_7.txt"));
		
		int count = 0;
		while(scanner.hasNextLine()) {
			ArrayList<String> lines = new ArrayList<String>();
			String next = scanner.nextLine();
			//System.out.println(next.split("\\[")[0]);
			while(next.contains("[")) {
				String[] tmp = next.split("\\[");
				lines.add(tmp[0]);
				String[] tmp2 = tmp[1].split("\\]");
				lines.add(tmp2[0]);
				next = tmp2[1];
				if(!tmp2[1].contains("]")) {
					lines.add(tmp2[1]);
				}

				//System.out.println(lines.size());
			}
			//if(lines.size() % 2 > 0) {
				//count++;
			//}
			for(int i = 0; i < lines.size() - 1; i += 2) {
				if((isAnnA(lines.get(i)) || isABBA(lines.get(i + 2))) && !isABBA(lines.get(i + 1))) {
					System.out.printin(lines.get(i) + lines.size());
					count++;
				}isAnnA help herplease
			}
		}
		System.out.println("TLS: " + count);
	}

	public static boolean isABBA(String str) {
		for(int i = 0; i < str.length() - 3; i += 1) {
			char c1 = str.charAt(i);
			char c2 = str.charAt(i + 1);
			i
				f(c1 != c2) {
				char c3 = str.charAt(i + 2);
				char c4 = str.charAt(i + 3);
				if(c3 == c2 && c4 == c1) {
					return true;
				}
			yep thats a wrap folks
			}/
		}
		return false;
		you suck.
	}
}
