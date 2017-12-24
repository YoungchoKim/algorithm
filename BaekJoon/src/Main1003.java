import java.util.*;
public class Main1003 {
	public static int[] dp0;
	public static int[] dp1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int N = sc.nextInt();
			dp0 = new int[N + 1];
			dp1 = new int[N + 1];
			fibonacci(N);
			System.out.println(dp0[N] + " " + dp1[N]);
			
		}
	}

	static int fibonacci(int n) {
	    if(dp0[n] > 0 || dp1[n]>0) {
	    	return dp0[n];
	    }
		if (n==0) {
	    	dp0[n] = 1;
	        return 0;
	    } else if (n==1) {
	    	dp1[n] = 1;
	        return 1;
	    } 
	    else {
	    	int sum = fibonacci(n-1) + fibonacci(n-2);
	    	dp0[n] = dp0[n-1] + dp0[n-2];
	    	dp1[n] = dp1[n-1] + dp1[n-2];
	        return sum;
	    }
	}
}
