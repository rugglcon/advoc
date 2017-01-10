import java.util.*;
import java.io.*;

public class rect {
	public static void main(String[] args) throws FileNotFoundException {
		char[][] map = new char[6][50];
		for(char[] row : map) {
			for(int i = 0; i < row.length; i++) {
				row[i] = ' ';
			}
		}
		Scanner scanner = new Scanner(new File("in_8.txt"));
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			Scanner tmp = new Scanner(line);
			switch(tmp.next()) {
				case "rect":
					//make new rectangle
					String[] dims = tmp.next().split("x");
					makeRect(dims, map);
					break;
				case "rotate":
					//rotate
					rotate(tmp, map);
					break;
			}
		}
		int count = 0; 
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 50; j++) {
				System.out.print(map[i][j]);
				if(map[i][j] == '#') {
					count++;
				}
			}
			System.out.println();
		}
		System.out.println(count);
	}

	public static char[][] rotate(Scanner line, char[][] map) {
		int pixels = 0;
		char[][] tmp_map = new char[6][50];
		for(int in = 0; in < 6; in++) {
			for(int out = 0; out < 50; out++) {
				tmp_map[in][out] = map[in][out];
			}
		}
		switch(line.next()) {
			case "row":
				String tmp = line.next();
				int row = Integer.parseInt(tmp.substring(2));
				line.next();
				pixels = Integer.parseInt(line.next());
				char[] r = map[row];
				char[] copy = Arrays.copyOf(r, r.length);
				for(int x = 0; x < 50; x++) {
					int newLoc = x + pixels;
					if(newLoc > 49) {
						newLoc -= 50;
					}
					r[newLoc] = copy[x];
				}
				break;
			case "column":
				String tmp2 = line.next();
				char[] cop = new char[6];
				int col = Integer.parseInt(tmp2.substring(2));
				line.next();
				pixels = Integer.parseInt(line.next());
				for(int y = 0; y < 6; y++) {
					cop[y] = map[y][col];
				}
				for(int m = 0; m < 6; m++) {
					int newLoc = m + pixels;
					if(newLoc > 5) {
						newLoc -= 6;
					}
					map[newLoc][col] = cop[m];
				}
				break;
		}
		return tmp_map;
	}

	public static void makeRect(String[] dims, char[][] map) {
		int width = Integer.parseInt(dims[0]);
		int height = Integer.parseInt(dims[1]);
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				map[i][j] = '#';
			}
		}
	}
}
