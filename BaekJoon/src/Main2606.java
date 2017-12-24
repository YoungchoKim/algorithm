import java.util.*;
public class Main2606 {
	private static int N;
	private static int comCount;
	private static boolean[][] mMap;
	private static int mResult;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		comCount = sc.nextInt();
		mMap = new boolean[N + 1][N + 1];
		for(int i = 0; i < comCount; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			mMap[r][c] = true;
			mMap[c][r] = true;
		}
		boolean[] visited = new boolean[N + 1];
		for(int i = 2; i <= N; i++) {
			if(mMap[1][i]) {
				visited[1] = true;
				go(1, i, visited);
			}
		}
		System.out.println(mResult);
	}
	
	public static void go(int start, int end, boolean[] visited) {
		if(start < 1 || start > N || end < 1 || end > N 
				|| visited[end] || !mMap[start][end]) {
			return;
		}
		mResult++;
		
		visited[end] = true;
		
		for(int i = 1; i <= N; i++) {
			go(end, i, visited);
		}
		
	}

}
