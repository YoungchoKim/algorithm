
public class Main1216 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s2 = new Solution();
//		int[] s = {1, 2, 3};
		int[] s = {3, -1, 0, 4};
		System.out.println(s2.solution(s));
		
	}
	static class Solution {
		  public int solution(int[] s) {
		      int size = s.length;
	    	  int cnt = 0;
	    	  boolean increase = true;
		      
	    	  for(int i = 0; i < size - 1; i++) {
	    		  int num1 = s[i];
	    		  int num2 = s[i + 1];

	    		  if(increase) {
	    			  if(num1 < num2) {
	    				  
	    			  }
	    			  else {
	    				  cnt++;
	    				  continue;
	    			  }
	    		  }
	    		  else {
	    			if(num1 > num2) {
	    				
	    			}
	    			else {
	    				cnt++;
	    				continue;
	    			}
	    		  }
	    		  increase = !increase;
	    	  }
		      
		      
		      return cnt;
		  }
	}
}
