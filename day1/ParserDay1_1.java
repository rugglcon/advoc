import java.util.*;
import java.awt.*;
import java.io.*;

public class ParserDay1_1 {
	
	public static void main(String[] args) {
		int deg = 0;
		int x = 0, y = 0;
		LinkedList<String> set = new LinkedList<String>();
		for(int i = 0; i < args.length; i++) {
			String move = args[i];
			deg += move.substring(0, 1).equals("R") ? (90) : (-90);
			int steps = 0;
			if(move.charAt(move.length() - 1) == ',') {
				steps = Integer.parseInt(move.substring(1, move.length() - 1));
			} else {
				steps = Integer.parseInt(move.substring(1, move.length()));
			}
			switch(deg % 360) {
				case 0:
					y += steps;
					break;
				case 90:
				case -270:
					x += steps;
					break;
				case 180:
				case -180:
					y -= steps;
					break;
				case 270:
				case -90:
					x -= steps;
					break;
			}
			if(set.contains(move)) {
				System.out.println("found match " + move);
				printEnd(x, y);
				return;
			}
			set.add(move);
		}
		printEnd(x, y);
	}
	public static void printEnd(int x, int y) {
		int away = Math.abs(x) + Math.abs(y);
		System.out.println(away);
	}
}
