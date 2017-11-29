import java.util.*;
import java.io.*;

public class Main {
	public static String mStr;
	public static int mSize;
	public static int[] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		mStr = br.readLine();
		mSize = mStr.length();
		
		dp = new int[mSize];
		if(mStr.charAt(0) >= '1' && mStr.charAt(0) <= '9'){
			dp[0] = 1;
		}
		if(mSize > 1){
			if(mStr.charAt(1) >= '1' && mStr.charAt(1) <= '9'){
				dp[1] = dp[0];
			}
		
			int temp = Integer.parseInt(mStr.substring(0, 2));

			if( temp >= 10 && temp <= 26){
				dp[1] += 1;
			}
		}
		
		
		
		for(int i = 2; i < mSize; i++){
			if(mStr.charAt(i) >= '1' && mStr.charAt(i) <= '9'){
				dp[i] = dp[i-1]% 1000000;
			}
			int number = Integer.parseInt(mStr.substring(i-1, i+1));
			if(number >= 10 && number <= 26){
				dp[i] = (dp[i] + dp[i-2]) % 1000000;
				
			}
		}
		
		System.out.println(dp[mSize - 1] % 1000000);
	}

}
