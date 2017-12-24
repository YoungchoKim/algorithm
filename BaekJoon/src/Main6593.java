import java.util.*;
import java.io.*;
public class Main6593 {
	private static int L, R, C;
	private static char[][][] mMap;
	private static boolean[][][] mVisited;
	private static int[][][] mCheck;
	private static int INF = 1234567890;
	private static int mResult = INF;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			int startL=0, startR=0, startC=0;
			if(L == 0 && R == 0 && C == 0) {
				break;
			}
			mMap = new char[L][R][C];
			mVisited = new boolean[L][R][C];
			mCheck = new int[L][R][C];
			
			for(int l = 0; l < L; l++) {
				for(int r = 0; r < R; r++) {
					Arrays.fill(mCheck[l][r], INF);
					String s = br.readLine();
					for(int c = 0; c < C; c++) {
						mMap[l][r][c] = s.charAt(c);
						if(mMap[l][r][c] == 'S') {
							startL = l;
							startR = r;
							startC = c;
						}
					}
				}
				br.readLine();
			}
			go(startL, startR, startC, 0);
			System.out.println((mResult == INF) ? "Trapped!" : "Escaped in "+mResult +" minute(s).");
			mResult = INF;
		}
	}
	public static void go(int l, int r, int c, int cnt) {
		if(l < 0 || l >= L || r < 0 || r >= R || c < 0 || c >= C 
				|| mMap[l][r][c] == '#' || mVisited[l][r][c]) {
			return;
		}
		if(cnt >= mResult) {
			return;
		}
		if(mMap[l][r][c] == 'E') {
			mResult = Math.min(mResult, cnt);
			return;
		}
		if(cnt >= mCheck[l][r][c]) {
			return;
		}
		
		int dx[] = {1, 0, 0, -1, 0, 0};
		int dy[] = {0, 1, 0, 0, -1, 0};
		int dz[] = {0, 0, 1, 0, 0, -1};
		int min = INF;
		mVisited[l][r][c] = true;
		mCheck[l][r][c] = cnt;
		for(int i = 0; i < 6; i++) {
			go(l + dz[i], r + dy[i], c + dx[i], cnt + 1);
		}
		mVisited[l][r][c] = false;
	}
	

}
