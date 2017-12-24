import java.util.*;
public class Main4963 {

	private static int[][] mMap;
	private static int R;
	private static int C;
	private static int mResult;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();
		R = sc.nextInt();
		
		
		while(!(R == 0 && C == 0)) {
			mMap = new int[R][C];
			for(int r = 0; r < R; r++) {
				for(int c = 0; c < C; c++) {
					mMap[r][c] = sc.nextInt();
				}
			}
			boolean[][] visited = new boolean[R][C];
			for(int r = 0; r < R ;r++) {
				for(int c = 0; c < C; c++) {
					if(mMap[r][c] > 0 && !visited[r][c]) {
						mResult++;
						fill(r, c, visited);
						
					}
				}
			}
			
			System.out.println(mResult);
			mResult = 0;
			C = sc.nextInt();
			R = sc.nextInt();
						
		}
	
	}
	public static void fill(int r, int c, boolean[][] visited){
		if(r < 0 || r >= R || c < 0 || c >= C || visited[r][c] || mMap[r][c] == 0) {
			return;
		}
		visited[r][c] = true;
		fill(r + 1, c, visited);
		fill(r - 1, c, visited);
		fill(r, c + 1, visited);
		fill(r, c - 1, visited);
		fill(r + 1, c + 1, visited);
		fill(r + 1, c - 1, visited);
		fill(r - 1, c + 1, visited);
		fill(r - 1, c - 1, visited);
	}

}
