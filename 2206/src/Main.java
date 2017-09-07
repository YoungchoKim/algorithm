import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Pair{
	int c;
	int r;
	int cnt;
	int wall;	// 0 : false 1: true
	public Pair(int r, int c, int cnt, int wall){
		this.r = r;
		this.c = c;
		this.cnt = cnt;
		this.wall = wall;
	}
}
public class Main {
	public static int R, C;
	public static int mMap[][];
	public static boolean mVisited[][][];
	public static int mMin;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		mMin = Integer.MAX_VALUE;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		mMap = new int[R][C];
		mVisited = new boolean[R][C][2];
		for(int i = 0; i < R; i++){
			String s = br.readLine();
			for(int j = 0; j < C; j++){
				mMap[i][j] = s.charAt(j) - '0';
			}
		}
		mVisited[0][0][0] = true;
		Queue<Pair> q = new LinkedList();
		
		q.add(new Pair(0, 0,1, 0));
		while(!q.isEmpty()){
			Pair pair = q.poll();
			if(pair.r == R-1 && pair.c == C -1){
				if(mMin > pair.cnt){
					mMin = pair.cnt;
				}
				q.clear();
			}
			
			int dx[] = {1, -1, 0, 0};
			int dy[] = {0, 0, 1, -1};
			for(int i = 0; i < 4; i++){
				int nextC = pair.c + dx[i];
				int nextR = pair.r + dy[i];
				
				if(nextC < 0 || nextC >= C || nextR < 0 || nextR >= R 
						|| mVisited[nextR][nextC][pair.wall] == true){
					continue;
				}
				if(mMap[nextR][nextC] == 0){
					q.add(new Pair(nextR, nextC,pair.cnt + 1, pair.wall ));
					mVisited[nextR][nextC][pair.wall] = true;
				}
				if(pair.wall == 0 && mMap[nextR][nextC] == 1){
					q.add(new Pair(nextR, nextC,pair.cnt + 1, 1));
					mVisited[nextR][nextC][1] = true;
					
				}
				
			}
	
		}
		
		if(mMin != Integer.MAX_VALUE){
			System.out.println(mMin);
		}
		else{
			System.out.println(-1);
		}
		
	}
}
