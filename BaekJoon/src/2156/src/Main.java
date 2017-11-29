import java.util.*;
public class Main {
	public static int[] mMap;
	public static long[] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		mMap = new int[N + 1];
		dp = new long[N + 1];
		for(int i = 1; i < N + 1; i++){
			mMap[i] = sc.nextInt();
		}
		long result = go(N);
	
		System.out.println(result);
		
	}
	public static long go(int n){
		if(dp[n] > 0){
			return dp[n];
		}
		if(n == 0){
			dp[n] = 0;
		}
		else if(n == 1){
			dp[n] = mMap[1];
		}
		else if (n == 2){
			dp[n] = go(n-1) + mMap[n];
		}
		else{
			dp[n] = Math.max(go(n-1), go(n-2) + mMap[n]);
			dp[n] = Math.max(dp[n], go(n-3) + mMap[n-1] + mMap[n]);
		}
		
		return dp[n];
	}

}
