import java.util.*;
public class Main14889 {
	static int N;
	static int[][] mMap;
	static boolean[] visited;
	static int mSum;
	static int mResult = Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		mMap = new int[N][N];
		visited = new boolean[N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				mMap[i][j] = sc.nextInt();
				mSum += mMap[i][j];
			}
		}
		check(0, 0);
		System.out.println(mResult);
	}
	
	public static void check(int cnt, int totalCnt) {
		if(totalCnt >= N || cnt == N/2) {
			if(cnt == N/2) {
				int sum1 = 0;
				int sum2 = 0;
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						if(visited[i] && visited[j]) {
							sum1 += mMap[i][j];
						}
						else if(!visited[i] && !visited[j]) {
							sum2 += mMap[i][j];
						}
					}
				}
				mResult = Math.min(mResult, Math.abs(sum1 - sum2));
			}
			return;
		}
		visited[totalCnt] = true;
		check(cnt + 1, totalCnt + 1);
		visited[totalCnt] = false;
		check(cnt, totalCnt + 1);	
	}

}
