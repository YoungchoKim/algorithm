import java.util.*;
public class Main {
	public static int N;
	public static int T;
	public static int[] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		while(T-- > 0){
			N = sc.nextInt();
			dp = new int[N + 1];
			System.out.println(go(N));
			
			for(int i = 0; i < N + 1 ; i++){
				dp[i] = 0;
			}
		}
		
		
		
	}

	public static int go(int n){
		if(dp[n] > 0){
			return dp[n];
		}
		if(n == 1){
			return 1;
		}
		if(n == 2){
			return 2;
		}
		if(n == 3){
			return 4;
		}
		if(n <= 0){
			return 0;
		}
		
		dp[n] = go(n-1) + go(n-2) + go(n-3);
		
		
		return dp[n];
	}
}
