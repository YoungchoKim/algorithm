import java.util.*;
public class Main {
	public static int dp[];
	public static int[] array;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		array = new int[n];
		dp = new int[n];
		for(int i = 0; i < n; i++){
			array[i] = sc.nextInt();
		}
		for(int i = 0; i < n; i++){
			go(i);
		}
		int max = 0;
		for(int i = 0; i < n; i++){
			max = Math.max(dp[i], max);
		}
		System.out.println(max);
		
	}
	public static int go(int n){
		if(dp[n] > 0){
			return dp[n];
		}
		if(n == 0){
			dp[0] = 1;
			return dp[n];
		}
		else{
			dp[n] = 1;
			for(int i = 1; i<= n; i++){
				if(array[n] < array[n-i]){
					dp[n] = Math.max(dp[n], dp[n-i] + 1);
				}
			}
		}
		return dp[n];
	}

}
