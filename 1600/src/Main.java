import java.util.*;
import java.io.*;
class Pair{
	int r;
	int c;
	int k;
	int cnt;
	public Pair(int r, int c, int k, int cnt){
		this.r = r;
		this.c = c;
		this.k = k;
		this.cnt = cnt;
	}
}
public class Main {
	public static int K, C, R;
	public static int[][] mMap;
	public static boolean[][][] mVisited;
	public static int mMinResult;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		mVisited = new boolean[K + 1][R][C];
		mMap = new int[R][C];
		mMinResult = Integer.MAX_VALUE;
		for(int r = 0; r < R; r++){
			st = new StringTokenizer(br.readLine(), " ");
			for(int c = 0; c < C; c++){
				mMap[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Pair> q = new LinkedList();
		q.add(new Pair(0, 0, 0, 0));
		mVisited[0][0][0] = true;
		while(!q.isEmpty()){
			Pair pair = q.poll();
//			System.out.println("pair.r:" + pair.r + " Pair.c:" + pair.c + 
//					" pair.cnt:" + pair.cnt + " pair.k:" + pair.k);
			int[] dx={-2, -1, 1, 2, 2, 1, -1, -2, 0, 0, 1, -1};	// 0~7 : 말
			int[] dy={-1, -2, -2, -1, 1, 2, 2, 1, 1, -1, 0, 0};	// 8~11: 상하좌우
			if(pair.r == R -1 && pair.c == C -1){
				if(mMinResult > pair.cnt){
					mMinResult = pair.cnt;
				}
			}
			
			
			for(int i = 0; i < 12; i++){
				int nextR = pair.r + dy[i];
				int nextC = pair.c + dx[i];
				
				if(nextR <0 || nextR >= R || nextC < 0 || nextC >=C || mMap[nextR][nextC] == 1){
					continue;
				}
				if(i < 8){	//말 이동
					if(pair.k >= K || mVisited[pair.k + 1][nextR][nextC]){	// 이미 k번 이동한 경우
						continue;
					}
					q.add(new Pair(nextR, nextC, pair.k + 1, pair.cnt + 1));
					mVisited[pair.k + 1][nextR][nextC] = true;
				}
				else{	//상하좌우
					if( mVisited[pair.k][nextR][nextC]){	//이미 방문한 경우
						continue;
					}
					q.add(new Pair(nextR, nextC, pair.k, pair.cnt+1));
					mVisited[pair.k][nextR][nextC] = true;
				}
			}
			
		}
		
		if(mMinResult < Integer.MAX_VALUE){
			System.out.println(mMinResult);
		}
		else{
			System.out.println(-1);
		}
	}

}
