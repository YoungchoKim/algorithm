import java.util.*;
public class Main2573 {
	private static int R, C;
	private static int[][] mMap;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		mMap = new int[R][C];
		Queue<Pair> q = new LinkedList<Pair>();
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				mMap[r][c] = sc.nextInt();
				if(mMap[r][c] > 0) {
					q.add(new Pair(r, c));
				}
			}
		}
		
		int[][] map1 = new int[R][C];
		int[][] map2 = new int[R][C];
		
		for(int r = 0; r < R; r++) {
			System.arraycopy(mMap[r], 0, map1[r], 0, C);
			System.arraycopy(mMap[r], 0, map2[r], 0, C);
		}
	
		
		Queue<Pair> q2 = new LinkedList<Pair>();
		int h = 1;
		while(!q.isEmpty()) {		
			while(!q.isEmpty()) {
				Pair pair = q.poll();
				int cnt = check(pair.r, pair.c, map1);
				if( cnt > 0) {
					map2[pair.r][pair.c] -= cnt;
					
					if(map2[pair.r][pair.c] > 0) {
						q2.add(pair);
					}
					else {
						map2[pair.r][pair.c] = 0;
					}
				}
				else {
					q2.add(pair);
				}
			}
			
			for(int r = 0; r < R; r++) {
				System.arraycopy(map2[r], 0, map1[r], 0, C);
			}
			while(!q2.isEmpty()) {
				q.add(q2.poll());
			}
			
			
			boolean[][] visited = new boolean[R][C];
			int cnt = 0;
			for(int r = 0; r < R; r++) {
				for(int c = 0; c< C; c++) {
					if(map2[r][c] > 0 && !visited[r][c]) {
						cnt++;
						if(cnt > 1) {
							System.out.println(h);
							
							return;
						}
						fill(r, c, visited, map2);
					}
				}
			}
			h++;
		}
		
		System.out.println(0);
		
		sc.close();
	}
	public static int check(int r, int c, int[][] map) {
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		int cnt = 0;
		for(int i = 0; i < 4; i++) {
			int nextR = r + dy[i];
			int nextC = c + dx[i];
			if(nextR < 0 || nextR >= R || nextC < 0 || nextC >= C || map[nextR][nextC] > 0) {
				continue;
			}
			cnt++;
		}
		
		
		return cnt;
	}
	public static void fill(int r, int c, boolean[][] visited, int[][] map) {
		if(r < 0 || r >=R || c < 0 || c >= C || visited[r][c] || map[r][c] == 0) {
			return;
		}
		visited[r][c] = true;
		fill(r + 1, c, visited, map);
		fill(r - 1, c, visited, map);
		fill(r, c + 1, visited, map);
		fill(r, c - 1, visited, map);
	}
	public static class Pair{
		int r;
		int c;
		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
