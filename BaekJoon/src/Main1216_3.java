
public class Main1216_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	class Solution {
	    public int solution(String s) {
	        int size = s.length();
	        for(int i = 1; i < size/2 + 1; i++) {
	        	String str1 = s.substring(0, i);
	        	for(int j =i; j < size; j += i) {
	        		String str2 = s.substring(j, j + i);
	        		if(!str1.equals(str2)) {
	        			break;
	        		}
	        		else if(j == size - i) {
	        			return i;
	        		}
	        	}
	        }
	        
	        return size;
	    }
	}
	public static void check(int cnt,int start, int end, String s) {
		int size = s.length();
		if(cnt >= size) {
			return;
		}
		if(start == 0) {
			return;
		}
		String str1 = s.substring(0, cnt + 1);
		String str2 = s.substring(start,end);
	}
}
