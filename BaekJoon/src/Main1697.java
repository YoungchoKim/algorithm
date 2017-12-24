import java.util.*;
public class Main1697 {
	public static int N, K;
	public static int mResult = Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		boolean[] visited = new boolean[200001];
		Queue q = new LinkedList();
		q.add(new Pair(N, 0));
		visited[N] = true;
		while(!q.isEmpty()) {
			Pair pair = (Pair)q.poll();
			if(pair.n == K) {
				System.out.println(pair.cnt);
				return;
			}
			
			if(pair.n < 100000 && !visited[pair.n + 1]) {
				visited[pair.n + 1] = true;
				q.add(new Pair(pair.n + 1, pair.cnt + 1));
			}
			if(pair.n > 0 && !visited[pair.n - 1]) {
				visited[pair.n - 1] = true;
				q.add(new Pair(pair.n - 1, pair.cnt + 1));
			}
			if(2 * pair.n < 200000 && !visited[2 * pair.n]) {
				visited[ 2* pair.n] = true;
				q.add(new Pair(2 * pair.n, pair.cnt + 1));
			}
			
		}
	}
	static class Pair{
		int n;
		int cnt;
		public Pair(int n, int cnt) {
			this.n = n;
			this.cnt = cnt;
		}
	}
	
}
