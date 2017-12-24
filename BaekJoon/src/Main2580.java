import java.util.*;
public class Main2580 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[9][9];
		Queue q = new LinkedList();

		int[] row = new int[9];
		int[] col = new int[9];
		int[] square = new int[9];
		Arrays.fill(row, 9);
		Arrays.fill(col, 9);
		Arrays.fill(square, 9);

		for(int r = 0; r < 9; r++) {
			for(int c = 0; c < 9; c++) {
				map[r][c] = sc.nextInt();
				if(map[r][c] == 0) {
					q.add(new Pair(r, c));
					row[r]--;
					col[c]--;
					int index = 3*(r/3) + c/3;
					square[index]--;
				}
			}
		}
		
		while(!q.isEmpty()) {
			Pair pair = (Pair)q.poll();
			int squareIdx = 3 *(pair.r/3)+pair.c/3;
			int sum = 0;
			if(row[pair.r]== 8) {
				for(int i = 0; i < 9; i++) {
					sum += map[pair.r][i];
				}
				map[pair.r][pair.c] = 45 - sum;
				row[pair.r]++;
				col[pair.c]++;
				square[squareIdx]++;
			}
			else if(col[pair.c] == 8) {
				for(int i = 0; i < 9; i++) {
					sum += map[i][pair.c];
				}
				map[pair.r][pair.c] = 45 - sum;
				row[pair.r]++;
				col[pair.c]++;
				square[squareIdx]++;
			}
			else if(square[squareIdx]== 8) {
				int idxR = (pair.r/3) * 3;
				int idxC = (pair.c/3) * 3;
				for(int i = idxR; i < idxR +3; i++) {
					for(int j = idxC; j < idxC +3; j++) {	
						sum += map[i][j];
					}
				}
				map[pair.r][pair.c] = 45 - sum;
				row[pair.r]++;
				col[pair.c]++;
				square[squareIdx]++;
			}
			else {
				q.add(pair);
			}
			
		}
		for(int r = 0; r < 9; r++) {
			for(int c = 0; c < 9 ; c ++) {
				System.out.print(map[r][c] + " "); 
			}System.out.println();
		}
		for(int i = 0; i < 9; i++) {
			System.out.print(row[i]);
		}System.out.println();
		for(int i = 0; i < 9; i++) {
			System.out.print(col[i]);
		}System.out.println();
		for(int i = 0; i < 9; i++) {
			System.out.print(square[i]);
		}
	}
	static class Pair{
		int r;
		int c;
		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
