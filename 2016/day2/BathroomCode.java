import java.util.*;
import java.io.*;

public class BathroomCode {
	public static void main(String[] args) throws FileNotFoundException, 
				 IOException {
		partOne();
		partTwo();
	}

	public static void partTwo() throws FileNotFoundException, IOException {
		System.out.println("Part Two:");
		Scanner reader = new Scanner(new File("advoc_in_2.txt"));
		char[][] keypad = {
			{'0','0','1','0','0'},
			{'0','2','3','4','0'},
			{'5','6','7','8','9'},
			{'0','A','B','C','0'},
			{'0','0','D','0','0'}
		};
		int v = 2, h = 0;
		while(reader.hasNextLine()) {
			String instructions = reader.nextLine();
			for(int i = 0; i < instructions.length(); i++) {
				char dir = instructions.charAt(i);
				switch(dir) {
					case 'U':
						v -= 1;
						if(v > -1) {
							if(keypad[v][h] != '0') {
								break;
							} else {
								while(keypad[v][h] == '0') {
									v += 1;
								}
								break;
							}
						} else {
							v = 0;
							break;
						}
					case 'D':
						v += 1;
						if(v < 5) {
							if(keypad[v][h] != '0') {
								break;
							} else {
								while(keypad[v][h] == '0') {
									v -= 1;
								}
								break;
							}
						} else {
							v = 4;
							break;
						}
					case 'R':
						h += 1;
						if(h < 5) {
							if(keypad[v][h] != '0') {
								break;
							} else {
								while(keypad[v][h] == '0') {
									h -= 1;
								}
								break;
							}
						} else {
							h = 4;
							break;
						}
					case 'L':
						h -= 1;
						if(h > -1) {
							if(keypad[v][h] != '0') {
								break;
							} else {
								while(keypad[v][h] == '0') {
									h += 1;
								}
								break;
							}
						} else {
							h = 0;
							break;
						}
				}
			}
			System.out.print(keypad[v][h]);
		}
		reader.close();
	}

	public static void partOne() throws FileNotFoundException, IOException {
		System.out.println("Part One:");
		Scanner reader = new Scanner(new File("advoc_in_2.txt"));
		int[][] keypad = new int[3][3];
		int num = 1;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				keypad[i][j] = num;
				num++;
			}
		}

		int v = 1, h = 1;
		while(reader.hasNextLine()) {
			String instructions = reader.nextLine();
			for(int i = 0; i < instructions.length(); i++) {
				char dir = instructions.charAt(i);
				switch(dir) {
					case 'U':
						v -= 1;
						if(v > -1) {
							break;
						} else {
							v = 0;
							break;
						}
					case 'D':
						v += 1;
						if(v < 3) {
							break;
						} else {
							v = 2;
							break;
						}
					case 'R':
						h += 1;
						if(h < 3) {
							break;
						} else {
							h = 2;
							break;
						}
					case 'L':
						h -= 1;
						if(h > -1) {
							break;
						} else {
							h = 0;
							break;
						}
				}
			}
			System.out.print(keypad[v][h]);
		}
		reader.close();
	}

}
