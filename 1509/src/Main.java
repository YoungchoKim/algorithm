import java.io.*;
import java.util.*;
public class Main {
	public static boolean[][] dp;
	public static int[] d;
	public static int N;
	public static String mStr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		mStr = br.readLine();
		N = mStr.length();
		
		dp = new boolean[N][N];
		d = new int[N];
		for(int i = 0; i < N; i++){
			dp[i][i] = true;
			if((i + 1 < N) && mStr.charAt(i) == mStr.charAt(i+1)){
				dp[i][i + 1] = true;
			}
		}
		
		for(int i = 2; i < N; i++){
				for(int j = 0; j < N - i; j++){
					if(dp[j + 1][j + i - 1]){
						if(mStr.charAt(j) == mStr.charAt(j + i)){
							dp[j][j+i] = true;
						}
					}
				}
		}
		System.out.println(go(N-1) );
//		for(int i = 0; i < N; i++){
//			System.out.print( " " + d[i]);
//		}
	}
	public static int go(int e){
		if(e < 0 ){
			return 0;
		}
		if(d[e] > 0){
			return d[e];
		}
		if(e ==0){
			d[e] = 1;
			return d[e];
		}
		if(e == 1){
			if(mStr.charAt(0) == mStr.charAt(1)){
				d[e] = go(e-1);
			}
			else{
				d[e] = go(e-1) + 1;
			}
			return d[e];
		}

		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i <=e; i++){
			if(dp[e-i][e]){
				min = Math.min(min, go(e-i-1) + 1);
			}
		}
		d[e] = min;
		
		return d[e];
	}
}
