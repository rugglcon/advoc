import java.util.*;
import java.io.*;

public class Triangles {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("advoc_in_3.txt"));
		int possible = 0;
		int pos2 = 0;
		while(sc.hasNextLine()) {
			String t = sc.nextLine();
			possible += addRowSides(t);
		}
		sc.close();
		System.out.println(possible);
		Scanner scan = new Scanner(new File("advoc_in_3.txt"));
		while(scan.hasNextLine()) {
			String line1 = scan.nextLine();
			String line2 = scan.nextLine();
			String line3 = scan.nextLine();
			pos2 += addColumnSides(line1, line2, line3);
		}
		scan.close();
		System.out.println(pos2);
	}

	public static int addColumnSides(String line1, String line2, String line3) {
		Scanner s1 = new Scanner(line1);
		Scanner s2 = new Scanner(line2);
		Scanner s3 = new Scanner(line3);
		int t1s1 = s1.nextInt();
		int t1s2 = s2.nextInt();
		int t1s3 = s3.nextInt();
		int t2s1 = s1.nextInt();
		int t2s2 = s2.nextInt();
		int t2s3 = s3.nextInt();
		int t3s1 = s1.nextInt();
		int t3s2 = s2.nextInt();
		int t3s3 = s3.nextInt();
		int num = 0;
		num += addSides(t1s1, t1s2, t1s3);
		num += addSides(t2s1, t2s2, t2s3);
		num += addSides(t3s1, t3s2, t3s3);

		return num;
	}

	public static int addSides(int s1, int s2, int s3) {
		boolean pos = false;
		pos = ((s1 + s2) > s3);
		if(!pos) {
			return 0;
		}
		pos = ((s1 + s3) > s2);
		if(!pos) {
			return 0;
		}
		pos = ((s3 + s2) > s1);
		if(!pos) {
			return 0;
		}
		return 1;
	}

	public static int addRowSides(String line) {
		Scanner sides = new Scanner(line);
		int side1 = 0, side2 = 0, side3 = 0;
		while(sides.hasNextInt()) {
			side1 = sides.nextInt();
			side2 = sides.nextInt();
			side3 = sides.nextInt();
		}
		sides.close();
		return addSides(side1, side2, side3);
	}
}
