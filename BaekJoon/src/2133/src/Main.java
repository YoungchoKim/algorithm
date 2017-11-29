import java.util.Scanner;

public class Main {
	public static int N;
	public static long[] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new long[N + 1];
		System.out.println(go(N));
	}
	public static long go(int n){
		
		if(dp[n] > 0 || n%2 != 0){
			return dp[n];
		}
		if(n == 0){
			dp[n] = 1;
	
		}
		else if(n == 2){
			dp[n] = 3;
		}
		else{
			dp[n] = go(n-2) *3;
			for(int i = n-4; i >= 0; i-=2){
				dp[n] += go(i) * 2;
			}
		}
		
		
		return dp[n];
	}
}
