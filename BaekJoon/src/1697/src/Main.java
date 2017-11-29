import java.io.*;
import java.util.*;
class Pair{
	int n;
	int cnt;
	public Pair(int n, int cnt){
		this.n = n;
		this.cnt = cnt;
	}
}
public class Main {
	public static int N, K;
	public static boolean[] mVisited;
	public static int mSize;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		mSize = 2 * (K + N) + 1;
		mVisited = new boolean[mSize];
		
		Queue q = new LinkedList();
		q.add(new Pair(N, 0));
		mVisited[N] = true;
		
		
		
		while(!q.isEmpty()){
			Pair pair = (Pair)q.poll();
			if(pair.n == K){						//¸ñÀûÁö
				System.out.println(pair.cnt);
			}	
		
			if(pair.n + 1 < mSize && !mVisited[pair.n + 1]){		// X + 1
				mVisited[pair.n + 1] = true;
				q.add(new Pair(pair.n + 1, pair.cnt + 1));
			}
			if(pair.n -1 >= 0 && !mVisited[pair.n - 1]){		// X - 1
				mVisited[pair.n -1] = true;
				q.add(new Pair(pair.n - 1, pair.cnt + 1));
			}
			if(pair.n * 2 < mSize && !mVisited[pair.n * 2]){	// X * 2
				mVisited[pair.n * 2] = true;
				q.add(new Pair(pair.n * 2, pair.cnt + 1));
			}
			
		}
	}
}
