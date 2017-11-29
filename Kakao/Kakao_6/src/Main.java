
public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] sticker = {6, 5, 11, 3, 9, 2, 10, 14};
		System.out.println(s.solution(sticker));
	}

}

class Solution {
	int[] dp1, dp2, dp3;
	public int solution(int sticker[]) {
		int answer = 0;
		int N = sticker.length;
		if(3 >= N){
			if(N == 1){
				return sticker[0];
			}
			else if(N == 2){
				return Math.max(sticker[0], sticker[1]);
			}
			else{
				return Math.max(sticker[0], Math.max(sticker[1], sticker[2]));
			}
		}
		dp1 = new int[N];
		dp2 = new int[N];
		dp3 = new int[N];
		
		dp1[0] = sticker[0];
		dp1[1] = sticker[1];
		dp1[2] = dp1[0] + sticker[2];
		for(int i = 3; i < N; i++){
			dp1[i] = Math.max(dp1[i-3], dp1[i-2]) + sticker[i];
		}
		answer = Math.max(answer, Math.max(dp1[N-2], dp1[N-3]));
		
		
		int temp = sticker[0];
		sticker[0] = sticker[1];
		sticker[1] = sticker[2];
		sticker[2] = sticker[3];
		
		dp2[0] = sticker[0];
		dp2[1] = sticker[1];
		dp2[2] = dp2[0] + sticker[2];
		for(int i = 3; i < N; i++){
			if(i < N-1){
				sticker[i] = sticker[i+1];
			}
			else if(i == N-1){
				sticker[i] = temp;
			}
			dp2[i] = Math.max(dp2[i-3], dp2[i-2]) + sticker[i];
		}
		answer = Math.max(answer, Math.max(dp2[N-2], dp2[N-3]));
		
		
		temp = sticker[0];
		sticker[0] = sticker[1];
		sticker[1] = sticker[2];
		sticker[2] = sticker[3];
		
		dp3[0] = sticker[0];
		dp3[1] = sticker[1];
		dp3[2] = dp3[0] + sticker[2];
		
		for(int i = 3; i < N; i++){
			if(i < N-1){
				sticker[i] = sticker[i+1];
			}
			else if(i == N-1){
				sticker[i] = temp;
			}
			dp3[i] = Math.max(dp3[i-3], dp3[i-2]) + sticker[i];
		}
		answer = Math.max(answer, Math.max(dp3[N-2], dp3[N-3]));
		
		
		return answer;
	}
}
