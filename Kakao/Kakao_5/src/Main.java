import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution s = new Solution();
		int[][] land = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
		System.out.println(s.solution(land));
	}

}

class Solution {
	public int[][] dp;
	int solution(int[][] land) {
		int answer = 0;
		int R = land.length;
		int C = land[0].length;
		dp = new int[R][C];
		dp[0][0] = land[0][0];
		dp[0][1] = land[0][1];
		dp[0][2] = land[0][2];
		dp[0][3] = land[0][3];
		
		for(int r = 1; r < R; r++){
			for(int c = 0; c < C; c++){
				for(int i = 0; i < 4; i++){
					if( i != c){
						dp[r][c] = Math.max(dp[r-1][i]+ land[r][c], dp[r][c]);
					}
				}
			}
		}

		for(int i = 0; i < 4; i++){
			//System.out.print(" " + dp[R-1][i]);
			answer = Math.max(answer, dp[R-1][i]);
		}
		
		return answer;
	}
}
