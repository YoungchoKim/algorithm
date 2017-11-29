/**
 * 실수: 단어조각이 완성할 문자열보다 길이가 긴 경우 생각하지 못함
 * string.substring 메소드인데 string.sequence 메소드로 잘못된 자동완성
 * 단어조각에 완성할 문자열이 있을 경우 생각하지 못함. (시작하자마자 완성인 경우)
 * 시간초과 문제 해결해야함.
 * 
 * @author cho
 *
 */

import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
//		String[] strs = {"ba", "na", "n", "a"};
//		String[] strs = {"app", "ap", "p", "l", "e", "ple", "pp"};
		String[] strs = {"ab", "abc", "abcd", "abcde", "abcdef"};
		String t = "ab";
		System.out.println(s.solution(strs, t));
	}

}
class Solution {
	public int solution(String[] strs, String t) {
		int N = strs.length;
		Queue q = new LinkedList();
		Arrays.sort(strs, new Comparator<String>(){

			@Override
			public int compare(String arg0, String arg1) {
				if(arg0.length() > arg1.length()){
					return -1;
				}
				else if (arg0.length() == arg1.length()){
					return 0;
				}
				
				// TODO Auto-generated method stub
				return 1;
			}
			
		});
		for(int i = 0;  i < N; i++){
			int n = strs[i].length();
			if(t.length() >= n && strs[i].equals(t.substring(0, n))){
				q.add(new Pair(strs[i], 1));	
			}
		}
		while(!q.isEmpty()){
			Pair pair = (Pair)q.poll();
			if(pair.s.equals(t)){
				return pair.cnt;
			}
			for(int j = 0; j < N; j++){
				String s = pair.s + strs[j];
				if(s.length() > t.length()){
					continue;
				}
				else if(s.length() == t.length()){
					if(s.equals(t)){
						return pair.cnt + 1;
					}
					else{
						continue;
					}
				}
				else if(s.equals(t.substring(0, s.length()))){
					q.add(new Pair(s, pair.cnt + 1));
				}
			}
		}
		return -1;
	}

}
class Pair{
	String s;
	int cnt;
	public Pair(String s, int cnt){
		this.s = s;
		this.cnt = cnt;
	}
}