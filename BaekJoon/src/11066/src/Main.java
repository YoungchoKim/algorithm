import java.util.*;
import java.io.*;

public class Main {
	public static int N;
	public static int[] array;
	public static int[] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0){
			N = Integer.parseInt(br.readLine());
			array = new int[N];
			dp = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int i = 0; i < N; i++){
				array[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(array);
			System.out.println(go(N-1));
			for(int i = 0; i < N; i++){
				System.out.print(" " + dp[i] );
			}System.out.println();
		}
	}
	public static int go(int n){
		if(dp[n] > 0)	{
			return dp[n];
		}
		if(n == 1){
			dp[1] = array[0] + array[1];
			return dp[n];
		}
		if(n == 2){
			dp[1] = array[0] + array[1];
			dp[n] = array[0] + (array[1] + array[2]) *2;
			dp[n] = Math.min(dp[n], (array[0] +array[1]) *2 + array[2]);
			dp[n] = Math.min(dp[n], (array[0] +array[2]) *2 + array[1]);
			return dp[n];
		}
		else{
			if(n%2 == 1){
				dp[n] = go(n-2) + (go(n-1) + array[n]) *2;
				
				dp[n] = Math.min(dp[n], (go(n-2) +go(n-1)) *2 + array[n]);
				dp[n] = Math.min(dp[n], (go(n-2) +array[n]) *2 + go(n-1));
				
			}
			else{
				dp[n] = go(n-1) + array[n];
				
			}
		}
		return dp[n];
	}

}
