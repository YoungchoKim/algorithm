import java.util.*;
public class Main {
	public static int N;
	public static int[] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new int[N + 1];
		
		System.out.println(go(N));
	}
	
	public static int go(int n){
		
		if(n == 1){
			return 1;
		}
		
		if(n == 0){
			return 1;
		}
		
		if(n < 0){
			return 0;
		}
		
		if(dp[n] > 0){
			return dp[n];
		}
		
		if(n%2 == 0){
			dp[n] = go(n-2) * 2;
		}
		
		else{
			dp[n] = go(n-1) *((n/2) + 1);
		}	
		
		return dp[n];
	}
}
