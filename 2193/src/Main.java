import java.util.*;
import java.io.*;
class DP{
	long zero;
	long one;
	
	public DP(long zero, long one){
		this.zero = zero;
		this.one = one;
	}
	public void setData(long zero, long one){
		this.zero = zero;
		this.one = one;
	}
}
public class Main {
	public static int N;
	public static DP[] dp;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dp = new DP[N + 1];
		for(int i = 1; i < N+1; i++){
			dp[i] = new DP(0L, 0L);
		}
		DP result = go(N);
		System.out.println(result.one + result.zero);
	}
	
	public static DP go(int n){
		if(dp[n].zero > 0 || dp[n].one > 0){
			return dp[n];
		}
		if(n == 1){
			dp[n].setData(0L, 1L);
		}
		else{
			dp[n].setData(go(n-1).one + go(n-1).zero, go(n-1).zero);
		}
		return dp[n];
	}

}
