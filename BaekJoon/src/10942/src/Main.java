import java.io.*;
import java.util.*;
public class Main {
	public static int[][] dp;
	public static int[] array;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n;
	
		n = Integer.parseInt(br.readLine());
		dp = new int[n][n];
		
		for(int i = 0; i < n ; i++){
			for(int j = 0; j < n ; j++){
				dp[i][j] = -1;
			}
		}
		array = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++){
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		int s, e;

		for(int i = 0; i < n; i++){
			dp[i][i] = 1;
			
			if(i >= n-1){
				continue;
			}
			else if(array[i + 1] == array[i] ){
				dp[i][i+1] = 1;
			}
			else{
				dp[i][i+1] = 0;
			}
		}
		for(int k = 2; k < n ; k++){
			for(int j = 0; j < n-k; j++ ){
				if(dp[j+1][j+k-1] == 1){
					if(array[j] == array[j + k]){
						dp[j][j+k] =	1;
								
					}
					else{
						dp[j][j+k] =	0;	
					}
				}
				else{
					dp[j][j+k] =	0;
				}
				
			}
		}
	
		for(int i = 0; i < m; i++){
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());	
			System.out.println(dp[s - 1][e - 1]);
		}
	}
	public static int go(int s, int e){


		
		
	return dp[s][e];
	}
	
	
//	public static int go(int s, int e){
//		if(dp[s][e] > 0 ){
//			return dp[s][e];
//		}
//		
//		if(s == e ){
//			dp[s][e] = 1;
//			return dp[s][e];
//		}
//		if(s + 1 == e){
//			if(array[s] == array[e]){
//				dp[s][e] = 1;
//			}
//			else{
//				dp[s][e] = 0;
//			}
//			return dp[s][e];
//		}
//	
//		
//		if( array[s] == array[e]){
//			dp[s][e] = go( s + 1, e -1);
//		}
//		else{
//			dp[s][e] = 0;
//		}
//		
//		
//		return dp[s][e];
//	}
	
}                                                                        
