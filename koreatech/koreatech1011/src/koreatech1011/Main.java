package koreatech1011;

import java.util.*;
public class Main {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		
		while(t-- > 0){
			int N = sc.nextInt();
			int[] arrays = new int[N + 1];
			int[] dp = new int[N + 1];
			
			if(N == 0){
				System.out.println(0);
				continue;
			}
			
			for(int i = 1; i <= N; i++){
				arrays[i] = sc.nextInt(); 
			}
			if(N < 3){
				System.out.println(0);
				continue;
			}

			
			dp[1] = arrays[1];
			dp[2] = arrays[2];
			dp[3] = arrays[3];
			
			for(int i = 4; i <= N; i++){
				dp[i] = Math.min(dp[i-1], Math.min(dp[i-2], dp[i-3])) + arrays[i];
			}
			
			
			int result = Math.min(dp[N], Math.min(dp[N-1], dp[N-2]));
			System.out.println(result);	
			
		}
				
	}
}
