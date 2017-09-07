package koreatech1010;
import java.util.*;
class Pair{
	int num;
	int cnt;
	public Pair(int num, int cnt){
		this.num = num;
		this.cnt = cnt;
	}
}
public class Main {
	public static boolean[] isNotSoSoo;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue q = new LinkedList();
		q.add(new Pair(2, 1));
		q.add(new Pair(3, 1));
		q.add(new Pair(5, 1));
		q.add(new Pair(7, 1));
		while(!q.isEmpty()){
			Pair pair = (Pair)q.poll();
			if(pair.cnt == n){
				System.out.println(pair.num);
			}
			int[] di = {1, 3, 7, 9};
			for(int i = 0; i < 4; i++){
				int temp = pair.num * 10 + di[i];
				if(isSoSoo(temp)){
					q.add(new Pair(temp, pair.cnt + 1));
				}
			}
		}
	}
	
	public static boolean isSoSoo(int n){
		for(int i = 2; i * i < n; i++){
			if(n%i == 0){
				return false;
			}
		}
		
		return true;
	}

}
