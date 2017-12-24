import java.util.*;
public class Main14620 {
	private static int N;
	private static int[][] mMap;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		mMap = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				mMap[i][j] = sc.nextInt();
			}
		}
		boolean[][] visited = new boolean[N][N];
		int min = Integer.MAX_VALUE;
		for(int r1 = 1; r1 < N - 1; r1++) {
			for(int c1 = 1; c1 < N - 1; c1++) {
				int sum1 = check(r1, c1, true, visited);
				if(sum1 >= 0) {
					for(int r2 = r1; r2 < N - 1; r2++) {
						for(int c2 = 1; c2 < N - 1; c2++) {
							int sum2 = check(r2, c2, true, visited);
							if(sum2 >= 0) {
								for(int r3 = r2; r3 < N - 1; r3++) {
									for(int c3 = 1; c3 < N - 1; c3++) {
										int sum3 = check(r3, c3, true, visited);
										if(sum3 >= 0) {
											min = Math.min(min, sum1 + sum2 + sum3);
											check(r3, c3, false, visited);
										}
									}
								}
								check(r2, c2, false, visited);
							}
						}
					}
					
					check(r1, c1, false, visited);
				}
			}
		}
		
		System.out.println(min);
		
		
	}
	public static int check(int r, int c, boolean value, boolean[][] visited) {
		int[] dy = {0, 0, 1, -1};
		int[] dx = {1, -1, 0, 0};
		
		for(int i = 0; i < 4; i++) {	//规氢眉农
			int nextR = r + dy[i];
			int nextC = c + dx[i];
			if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= N || visited[nextR][nextC] == value) {
				return -1;
			}
		}
		int sum = mMap[r][c];
		visited[r][c] = value;
		for(int i = 0; i < 4; i++) {	//规氢眉农
			int nextR = r + dy[i];
			int nextC = c + dx[i];
			visited[nextR][nextC] = value;
			sum += mMap[nextR][nextC];
		}
		
		return sum;
	}

}
