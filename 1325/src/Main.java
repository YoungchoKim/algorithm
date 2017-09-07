import java.io.*;
import java.util.*;

class Pair{
	int num;
	int cnt;
	public Pair(int num, int cnt){
		this.cnt = cnt;
		this.num = num;
	}
}

public class Main {
	public static int N, M;
	public static boolean[][] mMap;
	public static int mMaxValue;
	public static LinkedList mResult = new LinkedList();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		mMap = new boolean[N + 1][N + 1];
		LinkedList[] list = new LinkedList[N + 1];
		
		
		for(int i = 0; i < M; i++){
			
			st = new StringTokenizer(br.readLine(), " ");
			int dist = Integer.parseInt(st.nextToken());
			int src = Integer.parseInt(st.nextToken());
			if(list[src] == null){
				list[src] = new LinkedList();
			}
			list[src].add(dist);
		}
		Queue q = new LinkedList();
		for(int i = 1; i <= N; i++){
			boolean[] visited = new boolean[N + 1];
			if(list[i] != null){
				q.add(new Pair(i, 1));
				visited[i] = true;
				int cnt = 1;
				while(!q.isEmpty()){
					Pair pair = (Pair)q.poll();
					
					if(mMaxValue < pair.cnt){
						mResult.clear();
						mResult.add(i);
						mMaxValue = pair.cnt;
					}
					else if(mMaxValue == pair.cnt){
						mResult.add(i);
					}
					
					
					if(list[pair.num] != null){
						for(int j= 0 ; j < list[pair.num].size(); j++){
							int next = (int)list[pair.num].get(j);
							if(!visited[next]){
								cnt++;
								q.add(new Pair(next, cnt));
								visited[next] = true;
							}
							
						}
					}
					
					
				}
			}
		}
		for(int i = 0; i < mResult.size(); i++){
			System.out.print(mResult.get(i) + " ");
		}
		
	}
}
