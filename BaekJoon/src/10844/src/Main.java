import java.util.*;
public class Main {
	public static int N;
	public static long[][] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new long[N + 1][10];
		
		long[][] result = go(N);
		long sum = 0;
		for(int i = 0; i < 10; i++){
			sum += result[N][i];
			
		}
		System.out.println(sum %= 1000000000L);
	}
	public static long[][] go(int n){
		for(int i = 0; i < 10; i++){
			if(dp[n][i] > 0){
				return dp;
			}
			
		}
		if(n == 1){
			dp[n][0] = 0;
			for(int i = 1; i < 10; i++){
				dp[n][i] = 1;
			}
		}
		else{
			for(int i = 0; i < 10; i++){
				if(i >= 1 && i < 9){
					long[][] temp = go(n-1);
					dp[n][i] = (temp[n-1][i-1] + temp[n-1][i+1]) % 1000000000L;
				}
				else if(i == 0){
					long[][] temp = go(n-1);
					dp[n][i] = temp[n-1][i+1] % 1000000000L;
				}
				else if(i == 9){
					long[][] temp = go(n-1);
					dp[n][i] = temp[n-1][i-1] % 1000000000L;
				}
			}
		}
		
		
		return dp;
	}

}
