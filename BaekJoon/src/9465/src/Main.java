import java.util.*;
import java.io.*;
public class Main {
	public static int N;
	public static int[][] mMap;
	public static long[][] dp;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int T;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		while(T-- > 0){
			N = Integer.parseInt(br.readLine());
			mMap = new int[2][N + 1];
			dp = new long[3][N + 1];
			StringTokenizer st;
			for(int i = 0; i < 2; i++){
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 1; j < N + 1; j++){
					mMap[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			long[][] result = go(N);
			long temp = Math.max(result[0][N], result[1][N]);
			temp = Math.max(temp, result[2][N]);
			System.out.println(temp);


			for(int i = 0; i < 3; i++){
				Arrays.fill(dp[i], 0);	
			}
			
		}
	}
	// 0: x  1:O   2: x   
	//    x    x      O
	public static long[][] go(int n){
		for(int i = 0; i < 3; i++){
			if(dp[i][n] > 0){
				return dp;
			}
		}
		
		if(n == 1){
			dp[0][n] = 0;
			dp[1][n] = mMap[0][1];
			dp[2][n] = mMap[1][1];
		}
		else{
			long[][] temp = go(n-1);
			dp[0][n] = Math.max(temp[0][n-1], temp[1][n-1]);
			dp[0][n] = Math.max(dp[0][n], temp[2][n-1]);
			dp[1][n] = Math.max(temp[0][n-1], temp[2][n-1]) + mMap[0][n];
			dp[2][n] = Math.max(temp[1][n-1], temp[0][n-1]) + mMap[1][n];
		}
		return dp;
	}

}
