import java.util.*;
import java.io.*;
class Pair{
	int r;
	int c;
	
	public Pair(int r, int c){
		this.r = r;
		this.c = c;
	}
}
public class Main {
	public static int[][] mMap;
	public static boolean[][] mVisited;
	public static int R, C;
	public static int mMaxSum;
	public static void main(String[] args) throws IOException {
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
		for(int r = 0; r < R; r++){
			for(int c = 0; c < C; c++){
				mVisited[r][c] = true;
				dfs(new Pair(r, c), mMap[r][c], 0);
				mVisited[r][c] = false;
				
				mMaxSum = Math.max(mMaxSum, aouoo(new Pair(r,c)));
			}
		}
		System.out.println(mMaxSum);
	}
	
	public static void dfs(Pair pair, int sum, int count){
		
		int[] dx={0, 0, 1, -1};
		int[] dy={1, -1, 0, 0};
		
		if(count == 3){
			if(mMaxSum < sum){
				mMaxSum = sum;
			}
			return ;
		}
		
		for(int i = 0; i< 4; i++){
			int nextR = pair.r + dy[i];
			int nextC = pair.c + dx[i];
			if(nextR <0 || nextR >= R || nextC < 0 || nextC >= C ||
					mVisited[nextR][nextC]){
				continue ;
			}
			mVisited[nextR][nextC] = true;
			dfs(new Pair(nextR, nextC), sum+ mMap[nextR][nextC], count+1);
			mVisited[nextR][nextC] = false;
		}
		
	}
	public static int aouoo(Pair pair){
		int sum = 0;
		if(pair.c + 1 < C && pair.r +2 <R){	// ㅏ 맨위 기준
			int temp = 0;
			temp += mMap[pair.r][pair.c];
			temp += mMap[pair.r+1][pair.c];
			temp += mMap[pair.r+1][pair.c+1];
			temp += mMap[pair.r+2][pair.c];
			if(temp > sum){
				sum = temp;
			}
		}
		if(pair.c - 1 >= 0 && pair.c +1 <C && pair.r +1 <R){	// ㅗ	맨위 기준
			int temp = 0;
			temp += mMap[pair.r][pair.c];
			temp += mMap[pair.r+1][pair.c-1];
			temp += mMap[pair.r+1][pair.c+1];
			temp += mMap[pair.r+1][pair.c];
			if(temp > sum){
				sum = temp;
			}
		}
		
		if(pair.c - 1 >= 0 && pair.r +2 <R){	// ㅓ맨 위 기준
			int temp = 0;
			temp += mMap[pair.r][pair.c];
			temp += mMap[pair.r+1][pair.c];
			temp += mMap[pair.r+1][pair.c-1];
			temp += mMap[pair.r+2][pair.c];
			if(temp > sum){
				sum = temp;
			}
		}
	
		if(pair.c + 2 <C && pair.r +1 <R){	//ㅜ 맨위 맨왼쪽 기준
			int temp = 0;
			temp += mMap[pair.r][pair.c];
			temp += mMap[pair.r][pair.c+1];
			temp += mMap[pair.r][pair.c+2];
			temp += mMap[pair.r+1][pair.c + 1];
			if(temp > sum){
				sum = temp;
			}
		}
		
		return sum;
		
	}

}
