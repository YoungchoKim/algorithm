import java.io.*;
import java.util.*;
public class Main4179 {
	private static int R;
	private static int C;
	private static boolean[][] mVisited;
	private static boolean[][] mWall;
	private static int[][] mFire;
	private static int[][] mMemo;
	private static int mResult = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		mWall = new boolean[R][C];
		mFire = new int[R][C];
		mVisited = new boolean[R][C];
		mMemo = new int[R][C];
		
		for(int r = 0; r < R ; r++) {
			Arrays.fill(mFire[r], Integer.MAX_VALUE);
			Arrays.fill(mMemo[r], Integer.MAX_VALUE);
		}
		Pair start = null;
		Queue q = new LinkedList();
		for(int r = 0; r < R; r++) {
			String s = br.readLine();
			for(int c = 0; c < C; c++) {
				if(s.charAt(c) == '#') {
					mWall[r][c] = true;
				}
				else if(s.charAt(c) == 'F') {
					q.add(new Pair(r, c));
					mFire[r][c] = 1;
				}
				else if(s.charAt(c) == 'J') {
					start = new Pair(r, c);
				}
			}
		}
		
		while(!q.isEmpty()) {
			Pair pair = (Pair)q.poll();
			int dx[] = {0, 0, 1, -1};
			int dy[] = {1, -1, 0, 0};
			for(int i = 0; i < 4; i++) {
				int nextR = pair.r + dy[i];
				int nextC = pair.c + dx[i];
				if(nextR < 0 || nextR >= R || nextC < 0 || nextC >= C
						|| mWall[nextR][nextC] || mFire[nextR][nextC] < Integer.MAX_VALUE) {
					continue;
				}
				mFire[nextR][nextC] = mFire[pair.r][pair.c] + 1;
				q.add(new Pair(nextR, nextC));
		
			}
		}
//		for(int i = 0; i < R; i++) {
//			for(int j = 0; j < C; j++) {
//				System.out.print(mFire[i][j] + " ");
//			}System.out.println();
//		}
		
		go(start.r, start.c, 0);
		System.out.println(mResult == Integer.MAX_VALUE ? "IMPOSSIBLE" : mResult + 1);
		
		
	}
	public static void go(int r, int c, int cnt) {
		if(r < 0 || r >= R || c < 0 || c >= C || mWall[r][c] || mFire[r][c] <= cnt + 1 || mVisited[r][c]) {
			return;
		}
		if(cnt >= mResult || mMemo[r][c] <= cnt) {
			return;
		}
		if(r == 0 || r == R - 1 || c == 0 || c == C - 1) {
			mResult = Math.min(mResult, cnt);
			return;
		}
		mMemo[r][c] = cnt;
		mVisited[r][c] = true;
		
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		for(int i = 0; i < 4; i++) {
			go(r + dy[i], c + dx[i], cnt + 1);
		}
		mVisited[r][c] = false;
		
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
