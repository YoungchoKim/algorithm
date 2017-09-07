
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int n = 987;
		System.out.println(s.solution(n));
	}

}
class Solution {
	public int solution(int n) {
		int answer = 0;
		
		while(n != 0){
			answer += n%10;
			n = n/10;
		}
		
		return answer;
	}
}
