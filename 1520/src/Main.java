import java.io.*;
import java.util.*;

public class Main {
	public static int[][] mMap;
	public static int R, C;
	public static int[][] dp;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			mMap = new int[R][C];
			dp = new int[R][C];
			for(int i =0 ;i < R; i++){
				Arrays.fill(dp[i], -1);
			}
			for(int r = 0; r < R; r++){
				st = new StringTokenizer(br.readLine(), " ");
				for(int c = 0; c < C; c++){
					mMap[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println(dfs(0, 0));
		
	}
	public static int dfs(int r, int c){
		if(dp[r][c] >= 0){
			return dp[r][c];
		}
		if(r == R-1 && c == C-1){
			return 1;
		}
		
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		dp[r][c] = 0;
		for(int i = 0; i < 4; i++){
			int nextR = r + dy[i];
			int nextC = c + dx[i];
			if(nextR <0 || nextR >= R || nextC < 0 || nextC>=C){
				continue;
			}
			
			if(mMap[nextR][nextC] < mMap[r][c]){
				dp[r][c] += dfs(nextR, nextC);
			}	
		}
		for(int i = 0; i < R; i++){
		for(int j = 0; j < C; j++){
				System.out.print(" " + dp[i][j]);
			}System.out.println();
		}System.out.println();
		return dp[r][c];
	}
}
