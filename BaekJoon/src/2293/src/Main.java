import java.io.*;
import java.util.*;
public class Main {
	public static int N, K;
	public static int[] value;
	public static int[] dp;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		value = new int[N];
		dp = new int[K + 1];
		for(int i = 0; i < N; i++){
			value[i] = Integer.parseInt(br.readLine());
		}

		
		Arrays.sort(value);
		
		System.out.println(go(N-1));
		for(int i = 0; i < K ; i++){
			System.out.print("  " + dp[i]);
		}
	}
	public static int go(int n){
		if(n <= 0){
			return 0;
		}
		if(dp[n] > 0){
			return dp[n];
		}
		if(value[0] == n){
			dp[n] = 1;
			return 1;
		}
		for(int i = 0; i < N; i++){
			dp[i] += go(i - value[n]);
		}	
		return dp[n];
	}
}
