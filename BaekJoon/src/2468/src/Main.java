import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
public class Main {
	public static int N;
	public static int[][] mMap;
	public static int[][] mVisited;
	public static int[][] mCopyMap;
	public static int mResult;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		mMap = new int[N][N];
		mVisited = new int[N][N];
		int heightMin = Integer.MAX_VALUE;
		int heightMax = 0;
		StringTokenizer st;
		for(int r = 0; r < N; r++){
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < N; c++){
				mMap[r][c] = Integer.parseInt(st.nextToken());
				if(heightMin > mMap[r][c]){
					heightMin = mMap[r][c];
				}
				else if(heightMax < mMap[r][c]){
					heightMax = mMap[r][c];
				}
			}
		}		
		//System.out.println(heightMin +" " + heightMax);
		
		for(int i = heightMin - 1; i <= heightMax; i++){
			int cnt = 0;
			for(int j = 0; j < N; j++){
				Arrays.fill(mVisited[j], 0);
			}
			for(int r = 0; r < N; r++){
				for (int c = 0; c < N; c++){
					if(mVisited[r][c] == 0 && mMap[r][c] > i){	//방문하지 않았고, i높이 이하가 아닌 경우
						fill(r, c, ++cnt, i);
						
					}
					//System.out.print(" " + mVisited[r][c]);
				}//System.out.println();
			}//System.out.println();
			
			if(mResult < cnt){
				mResult = cnt;
			}
		}
		System.out.println(mResult);
	}
	public static void fill(int r, int c, int cnt, int height){
		if(r < 0 || r >= N || c < 0 || c >= N || mVisited[r][c] > 0 || mMap[r][c] <= height){
			return;
		}
		mVisited[r][c] = cnt;
		fill(r + 1, c, cnt, height);
		fill(r - 1, c, cnt, height);
		fill(r, c + 1, cnt, height);
		fill(r, c - 1, cnt, height);
	}

}
