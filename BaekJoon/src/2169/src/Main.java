import java.util.*;
import java.io.*;

public class Main {

	public static int[][] mMap;
	public static boolean[][] mVisited;
	public static int R, C;
	public static long mResult;
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		mMap = new int[R][C];
		mVisited = new boolean[R][C];
		for(int i = 0; i < R; i++){
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < C; j++){
				mMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0, mMap[0][0]);
		System.out.println(mResult);
	}
	
	public static void dfs(int r, int c, long sum){
		
		if(r ==R -1 && c == C-1){
			if(mResult < sum){
				mResult = sum;
				return;
			}
		}

		int[] dx = {-1, 1, 0};
		int[] dy = {0, 0, 1};
		
		for(int i = 0; i < 3; i++){
			int nextR = r + dy[i];
			int nextC = c + dx[i];
			
			if(nextR < 0 || nextR >= R || nextC < 0 || nextC >=C
					|| mVisited[nextR][nextC]){
				continue;
			}
			
			else{
				
				mVisited[nextR][nextC] = true;
				dfs(nextR, nextC, sum + mMap[nextR][nextC]);
				mVisited[nextR][nextC] = false;
			}
				
		}
	}

}