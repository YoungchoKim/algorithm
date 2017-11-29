import java.util.*;
public class Main {
	public static int N;
	public static int[] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp= new int[N + 1];
		
		System.out.println(go(N));
	}
	public static int go(int n){
		if(dp[n] > 0){
			return dp[n];
		}
		if(n <=0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		if(n == 2){
			return 3;
		}
		
		
		dp[n] = (go(n-1) + 2 * go(n-2))% 10007;
		
		return dp[n];
	}

}
