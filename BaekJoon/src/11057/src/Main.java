import java.util.*;
public class Main {
	public static int N;
	public static int[][] DP;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		DP = new int[N + 1][10];
		
		int[][] result = go(N);
		int sum = 0;
		for(int i = 0; i < 10; i++){
			sum += result[N][i];
			sum %= 10007;
		}
		System.out.println(sum);
	}

	public static int[][] go(int n){
		for(int i = 0; i < 10; i++){
			if(DP[n][i] > 0){
				return DP;
			}
		}
		if(n == 1){
			for(int i = 0; i < 10; i++){
				DP[n][i] = 1;
			}
		}
		else{
			int temp[][] = go(n-1);
			for(int i =0; i < 10; i++){
				for(int j = 0; j < i+1; j++){
					DP[n][i] += temp[n-1][j];
					DP[n][i] %= 10007;
				}
			}
		}
		
		
		return DP;
	}
}
