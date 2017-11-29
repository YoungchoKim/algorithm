import java.io.*;
import java.util.*;
class Pair{
	int r;
	int c;
	int cnt;
	public Pair(int r, int c, int cnt){
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}
public class Main {
	public static int N;
	public static int[][] mMap;
	public static int[][] mVisited;
	public static int[][] dp;
	public static int mResult = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		mMap = new int[N][N];
		mVisited = new int[N][N];
		dp = new int[N][N];
		for(int i = 0; i < N; i++){
			Arrays.fill(mVisited[i], -1);
		}
		for(int r = 0 ; r < N; r++){
			String s = br.readLine();
			for(int c = 0; c < N; c++){
				mMap[r][c] = Integer.parseInt(s.substring(c, c+1));
				if(mMap[r][c] == 1){
					mMap[r][c] = 0;
				}
				else if(mMap[r][c] == 0){
					mMap[r][c] = 1;
				}
			}
		}
		mVisited[0][0] = 0;
		Queue q = new LinkedList();
		q.add(new Pair(0, 0, 0));
		while(!q.isEmpty()){
			Pair pair = (Pair)q.poll();
			int dx[] = {1, -1, 0, 0};
			int dy[] = {0, 0, 1, -1};
			if(pair.r == N -1 && pair.c == N-1){
				if(mResult > pair.cnt){
					mResult = pair.cnt;
				}
			}
			for(int i = 0; i < 4; i++){
				int nextR = pair.r + dx[i];
				int nextC = pair.c + dy[i];
				if(nextR < 0 || nextR >=N || nextC < 0 || nextC >= N || mVisited[nextR][nextC] >= mVisited[pair.r][pair.c]){
					continue;
				}
				if(mMap[nextR][nextC] == 0){
					q.add(new Pair(nextR, nextC, pair.cnt));
					mVisited[nextR][nextC]= mVisited[pair.r][pair.c];
				}
				else{
					q.add(new Pair(nextR, nextC, pair.cnt + 1));
					mVisited[nextR][nextC] = mVisited[pair.r][pair.c] + 1;
				}
				
			}
		}
		
		
		System.out.println(mResult);
		
	}

}
