//credit to MoW8192 on reddit for part 2
import java.util.*;
import java.io.*;

public class TraceDay1_2 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader(new File("advoc_in_1.txt")));
		String[] instructions = reader.readLine().split(", ");
		reader.close();

		int[] pos = new int[]{0, 0};
		int[] dir = new int[]{1, 0};

		HashSet<String> visited = new HashSet<String>();
		visited.add("(0,0)");
		int solution2 = -1;

		for(String instruction : instructions) {
			dir = instruction.charAt(0) == 'L' ? new int[]{-dir[1], dir[0]} : new int[]{dir[1], -dir[0]};
			int length = Integer.parseInt(instruction.substring(1));
			if(solution2 == -1) {
				for(int i = 1; i <= length; i++) {
					int[] nextPos = new int[]{pos[0] + i * dir[0], pos[1] + i * dir[1]};
					String nextPosString = "(" + nextPos[0] + "," + nextPos[1] + ")";
					if(visited.contains(nextPosString)) {
						solution2 = Math.abs(nextPos[0]) + Math.abs(nextPos[1]);
						break;
					}
					visited.add(nextPosString);
				}
			}
			pos = new int[]{pos[0] + length * dir[0], pos[1] + length * dir[1]};
		}
		int solution1 = Math.abs(pos[0]) + Math.abs(pos[1]);
		System.out.println("part1: " + solution1);
		System.out.println("part2: " + solution2);
	}
}
