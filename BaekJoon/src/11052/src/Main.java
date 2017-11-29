import java.util.*;
public class Main {
	public static int N;
	public static int[] dp;
	public static int[] p;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		dp = new int[N + 1];
		p = new int[N + 1];
		
		for(int i = 1; i < N + 1; i++){
			p[i] = sc.nextInt();
		}
		System.out.println(go(N));
		
	}

	public static int go(int n){
		if(dp[n] > 0){
			return dp[n];
		}
		if(n == 1){
			return p[1];
		}
		
		int max = 0;
		for(int i = 1; i < n/2+1; i++){
			max = Math.max(max, go(n-i) + go(i));
		}
		
		if(p[n] > max){
			dp[n] = p[n];
		}
		else{
			dp[n] = max;
		}
		
		return dp[n];
	}
}
