//import java.util.*;		//bfs
//public class Main {
//	public static int N;
//	public static int[] mVisited;
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt();
//		mVisited = new int[N + 1];
//		Queue<Integer> q = new LinkedList<Integer>();
//		q.add(N);
//		mVisited[N] = 0;
//		
//		while(!q.isEmpty()){
//			int n = q.poll();
//			if(n <= 1){
//				System.out.println(mVisited[1]);
//				return;
//			}
//			if(mVisited[n-1] == 0){
//				q.add(n-1);
//				mVisited[n-1] = mVisited[n] + 1;
//			}
//			
//			if(n % 3 == 0 && mVisited[n/3] ==0){
//				q.add(n/3);
//				mVisited[n/3] = mVisited[n] + 1;
//			}
//			if(n % 2 == 0 && mVisited[n/2] ==0){
//				q.add(n/2);
//				mVisited[n/2] = mVisited[n] + 1;
//			}
//		}
//		
//	}
//}


//
//import java.util.*;				// top down
//public class Main {
//	public static int N;
//	public static int[] dp;
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt();
//		dp = new int[N + 1];
//		
//		System.out.println(go(N));
//	}
//	public static int go(int n){	// top down
//		if(n == 1){
//			return 0;
//		}
//		if(dp[n] > 0){
//			return dp[n];
//		}
//		
//		dp[n] = go(n-1) + 1;
//		
//		if(n %3 == 0){
//			int temp = go(n/3) + 1;
//			if(temp < dp[n]){
//				dp[n] = temp;
//			}
//		}
//		
//		if(n %2 == 0){
//			int temp = go(n/2) + 1;
//			if(temp < dp[n]){
//				dp[n] = temp;
//			}
//		}
//		
//		return dp[n];
//	}
//	
//}




import java.util.*;				// bottom up
public class Main {
	public static int N;
	public static int[] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new int[N + 1];
		dp[1] = 0;
		for(int i = 2; i <= N; i++){
			dp[i] = dp[i - 1] + 1;
			if(i%3 == 0){
				int temp = dp[i/3] + 1;
				if(temp < dp[i]){
					dp[i] = temp;
				}
			}
			if(i % 2 == 0){
				int temp = dp[i/2] + 1;
				if(temp < dp[i]){
					dp[i] = temp;
				}
			}
		}
		System.out.println(dp[N]);
	}
}
