import java.io.*;
import java.util.*;
public class Main {
	public static int R, C;
	public static int[][] mMap;
	public static long[][] dp;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		mMap = new int[R+1][C + 1];
		dp = new long[R + 1][C + 1];
		
		for(int r = 1; r <=R; r++ ){
			st = new StringTokenizer(br.readLine(), " ");
			for(int c = 1; c <=C; c++){
				mMap[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int r = 1; r <=R; r++ ){
			for(int c = 1; c <=C; c++){
				dp[r][c] = Math.max(Math.max(dp[r-1][c-1], dp[r-1][c]), dp[r][c-1]) + mMap[r][c];
				
			}
		}
		System.out.println(dp[R][C]);
		
		
	}

}
