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
	public static int R;
	public static int C;
	public static boolean mVisited[];
	public static char mMap[][];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		mVisited = new boolean[26];
		mMap = new char[R][C];
		for(int i = 0; i < R; i ++){
			String s = br.readLine();
			for(int j = 0; j < C; j++){
				mMap[i][j] = s.charAt(j);
			}
		}
		mVisited[mMap[0][0] - 'A'] = true;
		int result = dfs(new Pair(0, 0, 1));
		System.out.println(result);
		
	}
	public static int dfs(Pair pair){
		int dx[] = {1, -1, 0, 0};
		int dy[] = {0, 0, 1, -1};
		int count = pair.cnt;
		for(int i = 0; i < 4; i++){
			int nextR = pair.r + dy[i];
			int nextC = pair.c + dx[i];
			if(nextR < 0 || nextR >= R || nextC < 0 || nextC >= C
					|| mVisited[mMap[nextR][nextC] - 'A'] == true){
				continue;
			}
			mVisited[mMap[nextR][nextC] - 'A'] = true;
			count = Math.max(count, dfs(new Pair(nextR, nextC, pair.cnt+1)));
			mVisited[mMap[nextR][nextC] - 'A'] = false;
		}
		
		return count;
	}

}
