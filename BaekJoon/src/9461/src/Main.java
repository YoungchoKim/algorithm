import java.util.*;
import java.io.*;
public class Main {
	public static int N;
	public static long[] dp;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0){
			N = Integer.parseInt(br.readLine());
			dp = new long[N + 1];
			System.out.println(go(N));
		}
	}
	public static long go(int n){
		if(dp[n] > 0){
			return dp[n];
		}
		if(n == 1){
			dp[n] = 1;
		}
		else if(n == 2){
			dp[n] = 1;
		}
		else if(n == 3){
			dp[n] = 1;
		}
		else if(n ==4){
			dp[n] = 2;
		}
		else if(n == 5){
			dp[n] = 2;
		}
		else{
			dp[n] = go(n-1) + go(n-5);
		}
		return dp[n];
	}

}
