import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[][] board = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 1, 0 } };
//		int[][] board ={{0, 0, 1, 1}, {1, 1, 1, 1}};
		System.out.println(s.solution(board));
	}

}

class Pair {
	int r;
	int c;
	int cnt;

	public Pair(int r, int c, int cnt) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}

class Solution {
	int[][] dp;
	public int solution(int[][] board) {
		int answer = 0;
		
		int R = board.length;
		int C = board[0].length;
		dp = new int[R + 1][C + 1];
		
		for(int i = 1; i <= R; i++){
			for(int j = 1; j <= C; j++){
				if(board[i-1][j-1] == 1){
					dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
				}
				if(answer < dp[i][j]){
					answer = dp[i][j];
				}
			}
		}
		
		
		return answer * answer;
	}
}