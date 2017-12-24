import java.util.*;
public class Main1216_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s1 = new Solution();
		int N = 7;
		int[][] relation = {{1,2},{2,5},{2,6},{1,3},{1,4},{3,7}};
		String[] dirname = {"root","abcd","cs","hello","etc","hello","solution"};
		
		System.out.println(s1.solution(N, relation, dirname));
	}
	static class Solution{
		int[] nameLength;
		int max;
		public int solution(int N, int[][] relation, String[] dirname) {
	        nameLength = new int[N];
	        int[] resultLength = new int[N];
	        Arrays.fill(resultLength, 0);
	        for(int i = 0; i < N; i++ ) {
	        	nameLength[i] = dirname[i].length();
	        }
	        LinkedList[] value = new LinkedList[N];
	        for(int i = 0; i < N - 1; i++) {
	        	value[relation[i][0] -1] = new LinkedList();
	        	for(int j = 0; j < 2; j++) {
	        		value[relation[i][0] -1].add(relation[i][1] - 1);
	        	}
	        }
	        
	        go(0, value, nameLength[0]);
	        return max;
	    }
		public void go(int cnt, LinkedList[] list, int sum) {
			
			if(list[cnt] == null) {
				max = Math.max(max, sum + nameLength[cnt] + 1);
				return;
			}
			for(int i = 0; i < list[cnt].size(); i++) {
				int idx = (int)list[cnt].get(i);
				go(idx, list, sum + nameLength[idx] + 1);
			}
			return;
		}
		
	}

}
