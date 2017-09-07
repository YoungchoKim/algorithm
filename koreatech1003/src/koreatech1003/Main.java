package koreatech1003;

import java.util.*;
public class Main {
	public static int N;
	public static int[] array;
	public static LinkedList<String> mList;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		array = new int[N];
		mList = new LinkedList();
		for(int i = 0; i < N; i++){
			array[i] = sc.nextInt();
		}
	
		System.out.println(dfs(0, 0, 0, ""));
	}
	public static int dfs(int i, int sum, int cnt, String s){
		
		if(cnt == 3){
			if(sum == 0){
				//System.out.println(s);
				String temp = new String(s);
				for(int index = 0; index < mList.size(); index++){
					String temp2 = mList.get(index);
					if(temp2.equals(temp)){
						return 0;
					}
				}
				mList.add(temp);
				return 1;
				
				
			}
			return 0;
		}
		if(i >= N){
			return 0;
		}
		int count = 0;
		count += dfs(i + 1, sum + array[i], cnt + 1, s +" " + array[i]);
		count += dfs(i + 1, sum, cnt, s);
		
		return count;
	}

}
