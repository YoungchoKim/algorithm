import java.util.*;
public class Main {
	public static int N;
	public static int[][] mMap;
	public static boolean[][] mVisited;
	public static long dp[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		N = Integer.parseInt(sc.nextLine());
		
		mMap = new int[N][N];
		mVisited = new boolean[N][N];
		dp = new long[N][N];
		for(int i = 0; i < N; i++){ 
			st = new StringTokenizer(sc.nextLine(), " ");
			for(int j = 0; j < N; j++){
				mMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		mVisited[0][0] = true;
		long result = dfs(0, 0);
		
		System.out.println(result);

	}
	public static long dfs(int r, int c){
		if(dp[r][c] > 0){
			return dp[r][c];
		}
		
		long cnt = 0L;
		int dx[] = {mMap[r][c], 0};
		int dy[] = {0, mMap[r][c]};
		if(r == N-1 && c == N-1){
			
			return 1;
		}
		for(int i = 0; i < 2; i++){
			int nextR = r + dy[i];
			int nextC = c + dx[i];
			if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= N
					|| mVisited[nextR][nextC]){
				continue;
			}
			mVisited[nextR][nextC] = true;
			cnt += dfs(nextR, nextC);
			mVisited[nextR][nextC] = false;
			
		}
		dp[r][c] = cnt;
		return cnt;
	}

}
