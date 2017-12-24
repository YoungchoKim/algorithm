import java.util.*;
public class Main1242 {
	private static int N, M, K;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt() - 1;
		
		ArrayList list = new ArrayList();
		
		for(int i = 0; i < N; i++) {
			list.add(i);
		}
		int index = M - 1;
		int cnt = 1;
		while((int)list.get(index) != K) {
			list.remove(index);
			N--;
			index = (index + M - 1) % N;
			cnt++;
		}
		System.out.println(cnt);	
	}
}
